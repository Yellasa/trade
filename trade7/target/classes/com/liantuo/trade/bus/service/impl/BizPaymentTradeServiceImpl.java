package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.service.TradePaymentService;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.List;

@Component(value = "paymentTradeCreateServiceImpl")
public class BizPaymentTradeServiceImpl implements BizTradeService<TradePacketReqMerchantFreeze, TradePaymentBizVO> {
    @Resource
    private TradePaymentService tradePaymentService;

    @Override
    public void create(TradePaymentBizVO trade) {
        this.tradePaymentService.insertTradePayment(trade.getPayment());
        //插入成功后,反查出用于取出数据库默认写入的值,如创建时间等
        trade.setPayment(tradePaymentService.selectByPrimaryKey(trade.getPayment().getId()));
    }

    @Override
    public void update(TradePaymentBizVO trade) {
        tradePaymentService.updateTradePayment(trade.getPayment());
    }

    /* 
     * 校验交易发起方发起请求编号是否已存在
     * @see com.liantuo.trade.bus.service.BizTradeService#checkDuplicate(com.liantuo.trade.client.trade.packet.TradePacket)
     */
    @Override
    public boolean checkDuplicate(TradePacketReqMerchantFreeze tradePacket) {
        TradePaymentExample tradePaymentExample = new TradePaymentExample();
        tradePaymentExample.createCriteria()
                .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
                .andOutTradeNoExtEqualTo(tradePacket.getBody().getOut_trade_no_ext());
        List<TradePayment> list = tradePaymentService.queryExample(tradePaymentExample);
        return  !CollectionUtils.isEmpty(list);
    }

    @Override
    public TradePaymentBizVO queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
        TradePaymentExample example = new TradePaymentExample();
        example.createCriteria().andTradeNoEqualTo(originalTradeNo)
            .andFundPoolNoEqualTo(fund_pool_no)
            .andCoreMerchantNoEqualTo(core_merchant_no);
        List<TradePayment> list = (List<TradePayment>) tradePaymentService.queryExample(example);
        TradePaymentBizVO trade = null;
        if (!CollectionUtils.isEmpty(list)) {
            trade = new TradePaymentBizVO();
            trade.setPayment(list.get(0));
        }
        return trade;
    }

	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.service.BizTradeService#queryOriginalTrade(com.liantuo.trade.client.trade.packet.TradePacket)
	 */
	@Override
	public TradePaymentBizVO queryOriginalTrade(TradePacketReqMerchantFreeze tradePacket) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
