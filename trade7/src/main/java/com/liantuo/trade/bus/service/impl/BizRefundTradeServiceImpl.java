package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.TradeRefundBizVO;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundExample;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.orm.service.TradeRefundService;

@Component(value = "refundTradeCreateServiceImpl")
public class BizRefundTradeServiceImpl implements BizTradeService<TradePacketReqRefundOfflineSettle, TradeRefundBizVO> {
    @Resource
    private TradeRefundService tradeRefundService;
    @Resource
    private TradePaymentService tradePaymentService;

    @Override
    public void create(TradeRefundBizVO trade) {
        // 插入的创建日期等是数据库自动生成的，需要再查询一遍取到数据库自动生成的数据
        TradeRefund refund = tradeRefundService.insertTradeRefund(trade.getRefund());
        trade.setRefund(refund);
    }

    @Override
    public void update(TradeRefundBizVO trade) {
        tradeRefundService.updateTradeRefund(trade.getRefund());
    }

    @Override
    public boolean checkDuplicate(TradePacketReqRefundOfflineSettle tradePacket) {
        TradeRefundExample example = new TradeRefundExample();
        example.createCriteria()
                .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
                .andOutTradeNoExtEqualTo(tradePacket.getBody().getOut_trade_no_ext());
        List<TradeRefund> result = this.tradeRefundService.queryTradeRefund(example);
        return !CollectionUtils.isEmpty(result);
    }

    @Override
    public TradeRefundBizVO queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
        TradePaymentExample example = new TradePaymentExample();
        example.createCriteria().andTradeNoEqualTo(originalTradeNo)
            .andFundPoolNoEqualTo(fund_pool_no)
            .andCoreMerchantNoEqualTo(core_merchant_no);
        List<TradePayment> list = tradePaymentService.queryExample(example);
        TradeRefundBizVO trade = new TradeRefundBizVO();
        if(!list.isEmpty()){
            trade.setPayment(list.get(0));
        }
        return trade;
    }

	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.service.BizTradeService#queryOriginalTrade(com.liantuo.trade.client.trade.packet.TradePacket)
	 */
	@Override
	public TradeRefundBizVO queryOriginalTrade(TradePacketReqRefundOfflineSettle tradePacket) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
