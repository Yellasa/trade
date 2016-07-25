package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;

import com.liantuo.trade.bus.process.TradePageQueryInterface;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService;
import com.liantuo.trade.bus.template.impl.v1_1.query.ATradePageQueryNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * 0001_001_999
 * v1.0
 */
@JobFlow(value = "0001_001_999", version = "1.0", template = ATradePageQueryNoPaymentTemp.class)
public class QueryByPagePaymentInnerProcess
        implements TradePageQueryInterface<TradePacketReqBodyPayPageDetails> {

    @Resource
    protected ExceptionService exceptionService;

    @Resource(name = "bizPaymentTradePageQueryServiceImpl")
    private BizTradePageQueryService bizTradePageQueryServ;

    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyPayPageDetails> tradeRquest) throws Exception {
        String errMsg;
        errMsg = TradeValidationUtil.validateRequest(tradeRquest, HEADR_EQUIRED_INNER, HEAD_FORMAT, "*");
        if (!StringUtils.isEmpty(errMsg)) {
            throw exceptionService.buildBusinessException("JY00010019991000100", BusinessException.class, new Object[]{errMsg});
        }
    }

    @Override
    public Object query(TradeRequest<TradePacketReqBodyPayPageDetails> tradeRquest, TradeResponse tradeResponse) throws Exception {
        return bizTradePageQueryServ.queryByPage(tradeRquest, tradeResponse);
    }

}
