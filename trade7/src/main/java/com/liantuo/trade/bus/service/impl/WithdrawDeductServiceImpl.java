package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.vo.WithdrawDeductBizVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeduct;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.service.TradeWithdrawService;


/**
 * 提现
 */
@Service(value = "withdrawDeductServiceImpl")
public class WithdrawDeductServiceImpl implements BizTradeService<TradePacketReqSingleWithdrawDeduct, WithdrawDeductBizVo>{

    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    
    @Override
    public void create(WithdrawDeductBizVo trade) {
        tradeWithdrawService.insertTradeWithdraw(trade.getTradeWithdraw());
        //插入成功后,反查出用于去除数据库默认写入的值,如创建时间等
        trade.setTradeWithdraw(tradeWithdrawService.queryById(trade.getTradeWithdraw().getId()));
    }

    @Override
    public void update(WithdrawDeductBizVo trade) {
        tradeWithdrawService.updateTradeWithdrawById(trade.getTradeWithdraw());
    }

    @Override
    public boolean checkDuplicate(TradePacketReqSingleWithdrawDeduct tradePacket) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria()
                .andFundPoolNoEqualTo(tradePacket.getBusHead().getFund_pool_no())
                .andOutTradeNoExtEqualTo(tradePacket.getBody().getOut_trade_no_ext());
        List<TradeWithdraw> list = tradeWithdrawService.queryByExample(query);
        return !CollectionUtils.isEmpty(list);
    }

    @Override
    public WithdrawDeductBizVo queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no) {
        return null;
    }

    @Override
    public WithdrawDeductBizVo queryOriginalTrade(TradePacketReqSingleWithdrawDeduct tradePacket) {
        return null;
    }

}
