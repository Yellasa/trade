package com.liantuo.trade.bus.process.impl.withdraw;

import com.liantuo.trade.bus.template.impl.ATradePageQueryTemp;
import com.liantuo.trade.bus.vo.WithdrawQueryBizVO;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawPageDetails;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

/**
 * 0002_001_998
 * v1.0
 */
@Component(value = "withdrawQueryByPageProcess")
public class WithdrawQueryByPageProcess extends ATradePageQueryTemp<TradePacketReqSingleWithdrawPageDetails, TradePacketRspSingleWithdrawPageDetails, WithdrawQueryBizVO> {

    @Override
    protected TradePacketRspSingleWithdrawPageDetails buildRsp(WithdrawQueryBizVO trade, String code, String message) {
        TradePacketRspSingleWithdrawPageDetails rsp = new TradePacketRspSingleWithdrawPageDetails();
        TradePacketRspBodySingleWithdrawPageDetails body = new TradePacketRspBodySingleWithdrawPageDetails();

        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//通信标识

        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//业务处理成功
        } else {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);//业务处理失败
            body.setErr_code(code);
            body.setErr_code_des(message);
        }

        body.setTrade_details(null);
        body.setResultCount("0");
        if (null != trade && CollectionUtils.isNotEmpty(trade.getList())) {
            body.setResultCount(trade.getResultCount());
            try {
                String tradeDetails = ObjectJsonUtil.object2String(trade.getList());
                body.setTrade_details(tradeDetails);
            } catch (Exception e) {
                this.logger(trade.getReqContext(), "", "", e);
            }
        }

        rsp.setBody(body);

        return rsp;
    }

    /**
     * 交易列表查询
     */
    @SuppressWarnings("unchecked")
    @Override
    protected WithdrawQueryBizVO queryByPage(TradePacketReqSingleWithdrawPageDetails tradePacket) {
        WithdrawQueryBizVO trade = new WithdrawQueryBizVO();
        return (WithdrawQueryBizVO) getTradeService().queryByPage(tradePacket, trade);
    }
}
