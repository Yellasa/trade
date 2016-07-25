package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.WithdrawPayResultBizVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPayResultQuery;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.service.TradeWithdrawService;


/**
 * 提现
 */
@Service(value = "withdrawPaymentQueryServiceImpl")
public class WithdrawPaymentQueryServiceImpl implements BizTradeService<TradePacketReqSingleWithdrawPayResultQuery, WithdrawPayResultBizVo>{

    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    
    @Override
    public void create(WithdrawPayResultBizVo trade) {
    }

    @Override
    public void update(WithdrawPayResultBizVo trade) {
        tradeWithdrawService.updateTradeWithdrawById(trade.getTradeWithdraw());
    }

    @Override
    public boolean checkDuplicate(TradePacketReqSingleWithdrawPayResultQuery tradePacket) {
        return true;
    }

    @Override
    public WithdrawPayResultBizVo queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andTradeNoEqualTo(originalTradeNo);
        List<TradeWithdraw> list = tradeWithdrawService.queryByExample(query);
        if(list.size() == 1){
            WithdrawPayResultBizVo bizVo = new WithdrawPayResultBizVo();
            bizVo.setTradeWithdraw(list.get(0));
            return bizVo;
        }
        return null;
    }

    @Override
    public WithdrawPayResultBizVo queryOriginalTrade(TradePacketReqSingleWithdrawPayResultQuery tradePacket) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andTradeNoEqualTo(tradePacket.getBody().getTrade_no())
            .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
            .andCoreMerchantNoEqualTo(tradePacket.getBusHead().getCore_merchant_no());
        List<TradeWithdraw> list = tradeWithdrawService.queryByExample(query);
        if(list.size() == 1){
            WithdrawPayResultBizVo bizVo = new WithdrawPayResultBizVo();
            bizVo.setTradeWithdraw(list.get(0));
            return bizVo;
        }
        return null;
    }

}
