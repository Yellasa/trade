package com.liantuo.trade.dispatcher;

import com.liantuo.trade.bus.factory.template.NotifyTemplateFactory;
import com.liantuo.trade.bus.process.NotifyProcess;
import com.liantuo.trade.bus.template.impl.ANotifyTemp;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.NotifyRspPacket;
import com.liantuo.trade.client.trade.packet.rsp.NotifyRspCommonPacket;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.message.MessageBundleService;
import com.liantuo.trade.common.util.trade.NotifyReqContext;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.common.validate.ValidationUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * 回调通知
 */
@Component(value = "notifyDispatcher")
public class NotifyDispatcher implements NotifyProcess{

    @Resource(name = "notifyTemplateFactory")
    private NotifyTemplateFactory notifyTemplateFactory;

    @Resource(name = "messageBundleServiceImpl")
    private MessageBundleService messageBundleService;
    
    @Override
    public NotifyRspPacket processHandle(String outReqXml, NotifyReqContext reqContext) throws Exception {
        // FIXME 设置当前请求编号到  ThreadLocal 中，解决模板中交易码问题
        messageBundleService.setRequestCode(reqContext.getBusHead().getService_name());
        
        // 获取模板
        ANotifyTemp<NotifyPacket, NotifyRspPacket, ?> temp = notifyTemplateFactory.create(reqContext.getBusHead().getService_name());
        // 报文解析
        NotifyPacket tradePacket = ObjectXmlUtil.unmarshal(outReqXml, temp.getVoClass());
        
        // 设置 通知 URL 后面的 trade_no 
        tradePacket.getBusHead().setTrade_no(reqContext.getBusHead().getTrade_no());
        tradePacket.getBusHead().setService_name(reqContext.getBusHead().getService_name());
        tradePacket.getBusHead().setVersion(reqContext.getBusHead().getVersion());
        
        
        // 业务数据校验
        NotifyRspPacket respPacket = validateBizField(tradePacket);
        if ( null == respPacket ) {
            reqContext.setBusHead(tradePacket.getBusHead());
        } else {
            return respPacket;
        }
        // 执行交易
        return temp.execute(tradePacket, reqContext);
        
    }

    /**
     * body数据校验
     * @param tradePacket
     * @return
     */
    private NotifyRspPacket validateBizField(NotifyPacket tradePacket) {
        NotifyRspCommonPacket bizFieldValidateRsp;
        NotifyPacketResultInfo body;

        String errorMsg = ValidationUtil.validateBodyRequired(tradePacket);

        if (StringUtils.isEmpty(errorMsg)) {
            errorMsg = ValidationUtil.validateBodyFormat(tradePacket);
            if (StringUtils.isEmpty(errorMsg)) {
                return null;
            } else {
                body = new NotifyPacketResultInfo();
                body.setResult_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
                body.setErr_code(messageBundleService.getCode("withdraw.validate.error"));
                body.setErr_code_des(messageBundleService.getMessage("withdraw.validate.error", new Object[]{errorMsg}));
            }
        } else {
            body = new NotifyPacketResultInfo();
            body.setResult_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            body.setErr_code(messageBundleService.getCode("withdraw.validate.error"));
            body.setErr_code_des(messageBundleService.getMessage("withdraw.validate.error", new Object[]{errorMsg}));
        }

        bizFieldValidateRsp = new NotifyRspCommonPacket();
        bizFieldValidateRsp.setBody(body);
        return bizFieldValidateRsp;
    }
}
