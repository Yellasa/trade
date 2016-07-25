package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.template.impl.ATradePageQueryTemp;
import com.liantuo.trade.bus.vo.TradePageQueryPaymentBizVO;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyPayPageDetails;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqPayPageDetails;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspPayPageDetails;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;

/**
 * 0001_001_998
 */
@Component(value = "queryByPagePaymenProcess")
public class QueryByPagePaymenProcess extends ATradePageQueryTemp<TradePacketReqPayPageDetails, TradePacketRspPayPageDetails, TradePageQueryPaymentBizVO> {

    @Override
    protected TradePacketRspPayPageDetails buildRsp(TradePageQueryPaymentBizVO trade, String code, String message) {
        TradePacketRspPayPageDetails rsp = new TradePacketRspPayPageDetails();
        TradePacketRspBodyPayPageDetails body=new TradePacketRspBodyPayPageDetails();
    	body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//通信标识
		if(TradeConstants.TRADE_SUCCESS.equals(code)){
			body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//业务处理成功
		}else{
			body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);//业务处理失败
			body.setErr_code(code);
			body.setErr_code_des(message);
		}
    	
		if(trade != null && null !=trade.getList()){
			String tradeDetails = null;
            try {
                tradeDetails = ObjectJsonUtil.object2String(trade.getList());
            } catch (Exception e) {
               this.logger(trade.getReqContext(), "", "", e);
            }
            body.setTrade_details(tradeDetails);
		}
		rsp.setBody(body);
	    return rsp;
    }
    
    /**
     * 交易列表查询
     */
    @Override
    protected TradePageQueryPaymentBizVO queryByPage(TradePacketReqPayPageDetails tradePacket) {
        TradePageQueryPaymentBizVO trade = new TradePageQueryPaymentBizVO();
        //TODO 查询条件装配
        return (TradePageQueryPaymentBizVO) getTradeService().queryByPage(tradePacket, trade);
    }
}
