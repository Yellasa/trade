/**
 * 
 */
package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.WithdrawAlipayPayBizVO;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPay;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfo;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfoExample;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.service.TradeTransactionidInfoService;
import com.liantuo.trade.orm.service.TradeWithdrawService;

/**
 * @ClassName:     WithdrawAlipayPayServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-1-25 下午4:02:41 
 */
@Service(value = "withdrawAlipayPayServiceImpl")
public class WithdrawAlipayPayServiceImpl implements BizTradeService<TradePacketReqSingleWithdrawPay, WithdrawAlipayPayBizVO>{

    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    @Resource
    private TradeTransactionidInfoService tradeTransactionidInfoService;

	/* 无用
	 * @see com.liantuo.trade.bus.service.BizTradeService#create(com.liantuo.trade.bus.vo.ATradeBizVO)
	 */
	@Override
	public void create(WithdrawAlipayPayBizVO trade) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.service.BizTradeService#update(com.liantuo.trade.bus.vo.ATradeBizVO)
	 */
	@Override
	public void update(WithdrawAlipayPayBizVO trade) {
		tradeWithdrawService.updateTradeWithdrawById(trade.getTradeWithdraw());
	}

	/* 校验transaction_id
	 * @see com.liantuo.trade.bus.service.BizTradeService#checkDuplicate(com.liantuo.trade.client.trade.packet.TradePacket)
	 */
	@Override
	public boolean checkDuplicate(TradePacketReqSingleWithdrawPay tradePacket) {
		TradeTransactionidInfoExample traninfo = new TradeTransactionidInfoExample();
		traninfo.createCriteria()
		.andCoreMerchantNoEqualTo(tradePacket.getBusHead().getCore_merchant_no())
		.andTransactionIdEqualTo(tradePacket.getBody().getPay_transaction_id())
		.andPayerAccountEqualTo(tradePacket.getBody().getPayer_account())
		.andPayerNameEqualTo(tradePacket.getBody().getPayer_name());
		List<TradeTransactionidInfo> list = tradeTransactionidInfoService.query(traninfo);
		return CollectionUtils.isEmpty(list);
	}

	/* 无用
	 * @see com.liantuo.trade.bus.service.BizTradeService#queryOriginalTrade(java.lang.String)
	 */
	@Override
	public WithdrawAlipayPayBizVO queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 查询原交易
	 * @see com.liantuo.trade.bus.service.BizTradeService#queryOriginalTrade(com.liantuo.trade.client.trade.packet.TradePacket)
	 */
	@Override
	public WithdrawAlipayPayBizVO queryOriginalTrade(TradePacketReqSingleWithdrawPay tradePacket) {
		TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andTradeNoEqualTo(tradePacket.getBody().getTrade_no())
            .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
            .andCoreMerchantNoEqualTo(tradePacket.getBusHead().getCore_merchant_no());
        List<TradeWithdraw> list = tradeWithdrawService.queryByExample(query);
        
        WithdrawAlipayPayBizVO trade = null;
        if (!CollectionUtils.isEmpty(list)) {
            trade = new WithdrawAlipayPayBizVO();
            trade.setTradeWithdraw(list.get(0));
        }
        return trade;
        
	}

}
