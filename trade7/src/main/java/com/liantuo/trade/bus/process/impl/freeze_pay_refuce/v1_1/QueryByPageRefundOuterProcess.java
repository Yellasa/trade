package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1;

import com.liantuo.trade.bus.process.TradePageQueryInterface;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService;
import com.liantuo.trade.bus.template.impl.v1_1.query.ATradePageQueryNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 0001_002_998
 * v1.1
 */
@JobFlow(value = "0001_002_998", version = "1.1", template = ATradePageQueryNoPaymentTemp.class)
public class QueryByPageRefundOuterProcess
        implements TradePageQueryInterface<TradePacketReqBodyRefundPageDetails> {
	
	@Resource(name = "bizRefundTradePageQueryServiceImpl")
    private BizTradePageQueryService bizTradePageQueryServ;
    @Autowired
    protected ExceptionService exceptionService;
	
    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyRefundPageDetails> tradeRquest) throws Exception {
        String errMsg;
        errMsg = TradeValidationUtil.validateRequest(tradeRquest, HEADR_EQUIRED_OUTER, HEAD_FORMAT, "*");
        if (!StringUtils.isEmpty(errMsg)) {
            throw exceptionService.buildBusinessException("JY00010029981100100", BusinessException.class, errMsg);
        }
    }
    @Override
    public Object query(TradeRequest<TradePacketReqBodyRefundPageDetails> tradeRquest, TradeResponse tradeResponse) throws Exception {
        return bizTradePageQueryServ.queryByPage(tradeRquest, tradeResponse);
    }
}