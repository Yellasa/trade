package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.WithdrawRefundBizVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeductRefund;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.service.TradeWithdrawService;


/**
 * 提现--退回
 */
@Service(value = "withdrawDeductRefundServiceImpl")
public class WithdrawDeductRefundServiceImpl implements BizTradeService<TradePacketReqSingleWithdrawDeductRefund, WithdrawRefundBizVo>{

    @Resource
    private TradeWithdrawService tradeWithdrawService;

    @Override
    public void create(WithdrawRefundBizVo trade) {
        
    }

    @Override
    public void update(WithdrawRefundBizVo trade) {
        tradeWithdrawService.updateTradeWithdrawById(trade.getTradeWithdraw());
    }

    @Override
    public boolean checkDuplicate(TradePacketReqSingleWithdrawDeductRefund tradePacket) {
        return false;
    }

    @Override
    public WithdrawRefundBizVo queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
        return null;
    }

    @Override
    public WithdrawRefundBizVo queryOriginalTrade(TradePacketReqSingleWithdrawDeductRefund tradePacket) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andTradeNoEqualTo(tradePacket.getBody().getTrade_no())
            .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
            .andCoreMerchantNoEqualTo(tradePacket.getBusHead().getCore_merchant_no());
        List<TradeWithdraw> list = tradeWithdrawService.queryByExample(query);
        if(list.size() == 1){
            WithdrawRefundBizVo bizVo = new WithdrawRefundBizVo();
            bizVo.setTradeWithdraw(list.get(0));
            return bizVo;
        }
        return null;
    }
    
}
