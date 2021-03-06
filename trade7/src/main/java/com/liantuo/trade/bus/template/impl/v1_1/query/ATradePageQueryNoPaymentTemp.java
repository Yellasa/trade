package com.liantuo.trade.bus.template.impl.v1_1.query;

import com.liantuo.trade.bus.process.TradePageQueryInterface;
import com.liantuo.trade.bus.template.AbstractTradeTemplate;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradeResponseBody;
import com.liantuo.trade.common.annotation.Template;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;

import java.util.List;

/**
 * 查询类模板，试用于998，999类交易
 *
 * @author dengchao
 */
@Template
public class ATradePageQueryNoPaymentTemp extends AbstractTradeTemplate<TradePageQueryInterface> {

    @Override
    public TradeResponse execute(TradeRequest<?> request) throws Exception {
        Object tradeDetails;

        TradeResponseBody responseBody = new TradeResponseBody();
        this.response = new TradeResponse();
        response.setBody(responseBody);

        try {
            process.formatValidate(request);
        } catch (Exception e) {
            e.printStackTrace();
            response = buildSystemExceptionResponse(e);
            return response;
        }

        try {
            tradeDetails = process.query(request, response);
            if (null == tradeDetails) {
                response.getBody().setTrade_details(null);
            } else {
                List list = (List) tradeDetails;
                if (0 == list.size()) {
                    response.getBody().setTrade_details(null);
                } else {
                    response.getBody().setTrade_details(ObjectJsonUtil.object2String(tradeDetails));
                }
            }
            responseBody.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            responseBody.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response = buildSystemExceptionResponse(e);
        }
        return response;
    }

}