package com.liantuo.trade.dispatcher;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.liantuo.trade.bus.factory.template.TradeTemplateFactory;
import com.liantuo.trade.bus.process.Process;
import com.liantuo.trade.bus.template.impl.ATradeTemp;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyCommon;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspCommon;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.message.MessageBundleService;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.common.validate.ValidationUtil;

@Component(value = "tradeDispatcher")
public class TradeDispatcher implements Process {
    @Resource(name = "messageBundleServiceImpl")
    private MessageBundleService messageBundleService;

    @Resource(name = "tradeTemplateFactory")
    private TradeTemplateFactory templateFactory;

    @Override
    public TradePacket processHandle(String xml, ReqContext reqContext) throws Exception {
//        // FIXME 设置当前请求编号到 ThreadLocal 中，解决模板中交易码问题
//        messageBundleService.setRequestCode(reqContext.getBusHead().getRequest_code());
        
        /**模板工厂*/
        ATradeTemp<TradePacket, TradePacket, ?> tradeProcess = templateFactory.create(reqContext.getBusHead().getRequest_code());

        /**xml转Req*/
        TradePacket tradePacket = ObjectXmlUtil.unmarshal(xml, tradeProcess.getVoClass());

        /**业务参数校验*/
        TradePacket rsp = validateBizField(tradePacket);

        if (null == rsp) {
            /**交易协议对象*/
            reqContext.setBusHead(tradePacket.getBusHead());
        } else {
            return rsp;
        }

        return tradeProcess.execute(tradePacket, reqContext);
    }

    private TradePacket validateBizField(TradePacket tradePacket) {
        TradePacketRspCommon bizFieldValidateRsp = null;
        TradePacketRspBodyCommon body = null;

        String errorMsg = ValidationUtil.validateBodyRequired(tradePacket);
        if (StringUtils.isEmpty(errorMsg)) {
            errorMsg = ValidationUtil.validateBodyFormat(tradePacket);
            if (StringUtils.isEmpty(errorMsg)) {
                return null;
            } else {
                body = new TradePacketRspBodyCommon();
                body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
                body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
                body.setErr_code(messageBundleService.getCode("trade.validate.failure"));
                body.setErr_code_des(messageBundleService.getMessage("trade.validate.failure", new Object[]{errorMsg}));
            }
        } else {
            body = new TradePacketRspBodyCommon();
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            body.setErr_code(messageBundleService.getCode("trade.validate.failure"));
            body.setErr_code_des(messageBundleService.getMessage("trade.validate.failure", new Object[]{errorMsg}));
        }

        bizFieldValidateRsp = new TradePacketRspCommon();
        bizFieldValidateRsp.setBody(body);
        return bizFieldValidateRsp;
    }
}