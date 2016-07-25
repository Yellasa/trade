package com.liantuo.trade.client.trade;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.*;
import com.liantuo.trade.client.trade.packet.body.withdraw.*;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.*;
import com.liantuo.trade.client.trade.packet.req.withdraw.*;
import com.liantuo.trade.client.trade.packet.rsp.*;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.*;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.properties.PropertyUtil;
import com.liantuo.trade.common.util.sign.SignUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeClient {

    private static String url = "";

    private static String baseUrl = "";

    private static String key = "";

    private static RestTemplate restTemplate;

    static {
        url = PropertyUtil.getProperty("trade.host.ip", "/config/properties/servers.properties")
                + TradeConstants.TRADE_URL;
        baseUrl = PropertyUtil.getProperty("trade.host.ip", "/config/properties/servers.properties");
        key = PropertyUtil.getProperty("trade.key", "/config/properties/system.properties");

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        requestFactory.setReadTimeout(60000);

        restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate.setMessageConverters(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
    }

    /**
     * 成员提现-扣减
     *
     * @param singleWithdrawDeduct
     * @return
     */
    public static TradePacketRspSingleWithdrawDeduct singleWithdrawDeduct(TradePacketReqSingleWithdrawDeduct singleWithdrawDeduct) {
        if (singleWithdrawDeduct == null || singleWithdrawDeduct.getBusHead() == null || singleWithdrawDeduct.getBody() == null) {
            TradePacketRspSingleWithdrawDeduct rsp = new TradePacketRspSingleWithdrawDeduct();
            TradePacketRspBodySingleWithdrawDeduct body = new TradePacketRspBodySingleWithdrawDeduct();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (singleWithdrawDeduct != null && singleWithdrawDeduct.getBusHead() != null) {
                rsp.setBusHead(singleWithdrawDeduct.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(singleWithdrawDeduct, key, "utf-8");
        singleWithdrawDeduct.getBusHead().setSign(sign);
        String reqXml = singleWithdrawDeduct.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspSingleWithdrawDeduct rsp = TradePacket.unmarshal(rspXml, TradePacketRspSingleWithdrawDeduct.class);
        return rsp;
    }

    /**
     * 成员提现-出款
     *
     * @param singleWithdrawPay
     * @return
     */
    public static TradePacketRspSingleWithdrawPay singleWithdrawPay(TradePacketReqSingleWithdrawPay singleWithdrawPay) {
        if (singleWithdrawPay == null || singleWithdrawPay.getBusHead() == null || singleWithdrawPay.getBody() == null) {
            TradePacketRspSingleWithdrawPay rsp = new TradePacketRspSingleWithdrawPay();
            TradePacketRspBodySingleWithdrawPay body = new TradePacketRspBodySingleWithdrawPay();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (singleWithdrawPay != null && singleWithdrawPay.getBusHead() != null) {
                rsp.setBusHead(singleWithdrawPay.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(singleWithdrawPay, key, "utf-8");
        singleWithdrawPay.getBusHead().setSign(sign);
        String reqXml = singleWithdrawPay.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspSingleWithdrawPay rsp = TradePacket.unmarshal(rspXml, TradePacketRspSingleWithdrawPay.class);
        return rsp;
    }

    /**
     * 成员提现-查询出款结果
     *
     * @param payResultQuery
     * @return
     */
    public static TradePacketRspSingleWithdrawPayResultQuery singleWithdrawPayResultQuery(TradePacketReqSingleWithdrawPayResultQuery payResultQuery) {
        if (payResultQuery == null || payResultQuery.getBusHead() == null || payResultQuery.getBody() == null) {
            TradePacketRspSingleWithdrawPayResultQuery rsp = new TradePacketRspSingleWithdrawPayResultQuery();
            TradePacketRspBodySingleWithdrawPayResultQuery body = new TradePacketRspBodySingleWithdrawPayResultQuery();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (payResultQuery != null && payResultQuery.getBusHead() != null) {
                rsp.setBusHead(payResultQuery.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(payResultQuery, key, "utf-8");
        payResultQuery.getBusHead().setSign(sign);
        String reqXml = payResultQuery.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspSingleWithdrawPayResultQuery rsp = TradePacket.unmarshal(rspXml, TradePacketRspSingleWithdrawPayResultQuery.class);
        return rsp;
    }

    /**
     * 成员提现-退回
     *
     * @param singleWithdrawDeductRefund
     * @return
     */
    public static TradePacketRspSingleWithdrawDeductRefund singleWithdrawDeductRefund(TradePacketReqSingleWithdrawDeductRefund singleWithdrawDeductRefund) {
        if (singleWithdrawDeductRefund == null || singleWithdrawDeductRefund.getBusHead() == null || singleWithdrawDeductRefund.getBody() == null) {
            TradePacketRspSingleWithdrawDeductRefund rsp = new TradePacketRspSingleWithdrawDeductRefund();
            TradePacketRspBodySingleWithdrawDeductRefund body = new TradePacketRspBodySingleWithdrawDeductRefund();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (singleWithdrawDeductRefund != null && singleWithdrawDeductRefund.getBusHead() != null) {
                rsp.setBusHead(singleWithdrawDeductRefund.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(singleWithdrawDeductRefund, key, "utf-8");
        singleWithdrawDeductRefund.getBusHead().setSign(sign);
        String reqXml = singleWithdrawDeductRefund.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspSingleWithdrawDeductRefund rsp = TradePacket.unmarshal(rspXml, TradePacketRspSingleWithdrawDeductRefund.class);
        return rsp;
    }

    /**
     * 成员提现-交易列表查询
     *
     * @param singleWithdrawPageDetails
     * @return
     */
    public static TradePacketRspSingleWithdrawPageDetails singleWithdrawPageDetails(TradePacketReqSingleWithdrawPageDetails singleWithdrawPageDetails) {
        if (singleWithdrawPageDetails == null || singleWithdrawPageDetails.getBusHead() == null || singleWithdrawPageDetails.getBody() == null) {
            TradePacketRspSingleWithdrawPageDetails rsp = new TradePacketRspSingleWithdrawPageDetails();
            TradePacketRspBodySingleWithdrawPageDetails body = new TradePacketRspBodySingleWithdrawPageDetails();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (singleWithdrawPageDetails != null && singleWithdrawPageDetails.getBusHead() != null) {
                rsp.setBusHead(singleWithdrawPageDetails.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(singleWithdrawPageDetails, key, "utf-8");
        singleWithdrawPageDetails.getBusHead().setSign(sign);
        String reqXml = singleWithdrawPageDetails.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspSingleWithdrawPageDetails rsp = TradePacket.unmarshal(rspXml, TradePacketRspSingleWithdrawPageDetails.class);
        return rsp;
    }

    /**
     * 成员冻结
     *
     * @param merchantFreeze
     * @return
     */
    public static TradePacketRspMerchantFreeze merchantFreeze(TradePacketReqMerchantFreeze merchantFreeze) {
        if (merchantFreeze == null || merchantFreeze.getBusHead() == null || merchantFreeze.getBody() == null) {
            TradePacketRspMerchantFreeze rsp = new TradePacketRspMerchantFreeze();
            TradePacketRspBodyMerchantFreeze body = new TradePacketRspBodyMerchantFreeze();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (merchantFreeze != null && merchantFreeze.getBusHead() != null) {
                rsp.setBusHead(merchantFreeze.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(merchantFreeze, key, "utf-8");
        merchantFreeze.getBusHead().setSign(sign);
        String reqXml = merchantFreeze.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspMerchantFreeze rsp = TradePacket.unmarshal(rspXml, TradePacketRspMerchantFreeze.class);
        return rsp;
    }


    /**
     * 线下付款成功,剩余解冻
     *
     * @param FreezeOfflineSettle
     * @return
     */
    public static TradePacketRspUnFreezeOfflineSettle FreezeOfflineSettle(
            TradePacketReqUnFreezeOfflineSettle FreezeOfflineSettle) {
        if (FreezeOfflineSettle == null || FreezeOfflineSettle.getBusHead() == null || FreezeOfflineSettle.getBody() == null) {
            TradePacketRspUnFreezeOfflineSettle rsp = new TradePacketRspUnFreezeOfflineSettle();
            TradePacketRspBodyFreezeOfflineSettle body = new TradePacketRspBodyFreezeOfflineSettle();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (FreezeOfflineSettle != null && FreezeOfflineSettle.getBusHead() != null) {
                rsp.setBusHead(FreezeOfflineSettle.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(FreezeOfflineSettle, key, "utf-8");
        FreezeOfflineSettle.getBusHead().setSign(sign);
        String reqXml = FreezeOfflineSettle.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspUnFreezeOfflineSettle rsp = TradePacket.unmarshal(rspXml, TradePacketRspUnFreezeOfflineSettle.class);
        return rsp;
    }

    /**
     * 全额解冻
     *
     * @param fullUnFreeze
     * @return
     */
    public static TradePacketRspFullUnFreeze fullUnFreeze(TradePacketReqFullUnFreeze fullUnFreeze) {
        if (fullUnFreeze == null || fullUnFreeze.getBusHead() == null || fullUnFreeze.getBody() == null) {
            TradePacketRspFullUnFreeze rsp = new TradePacketRspFullUnFreeze();
            TradePacketRspBodyFullUnFreeze body = new TradePacketRspBodyFullUnFreeze();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (fullUnFreeze != null && fullUnFreeze.getBusHead() != null) {
                rsp.setBusHead(fullUnFreeze.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(fullUnFreeze, key, "utf-8");
        fullUnFreeze.getBusHead().setSign(sign);
        String reqXml = fullUnFreeze.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspFullUnFreeze rsp = TradePacket.unmarshal(rspXml, TradePacketRspFullUnFreeze.class);
        return rsp;
    }

    /**
     * CA付款成功,剩余解冻
     *
     * @param unFreezeOnlineSettle
     * @return
     */
    public static TradePacketRspUnFreezeOnlineSettle unFreezeOnlineSettle(
            TradePacketReqUnFreezeOnlineSettle unFreezeOnlineSettle) {
        if (unFreezeOnlineSettle == null || unFreezeOnlineSettle.getBusHead() == null || unFreezeOnlineSettle.getBody() == null) {
            TradePacketRspUnFreezeOnlineSettle rsp = new TradePacketRspUnFreezeOnlineSettle();
            TradePacketRspBodyUnFreezeOnlineSettle body = new TradePacketRspBodyUnFreezeOnlineSettle();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (unFreezeOnlineSettle != null && unFreezeOnlineSettle.getBusHead() != null) {
                rsp.setBusHead(unFreezeOnlineSettle.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(unFreezeOnlineSettle, key, "utf-8");
        unFreezeOnlineSettle.getBusHead().setSign(sign);
        String reqXml = unFreezeOnlineSettle.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspUnFreezeOnlineSettle rsp = TradePacket.unmarshal(rspXml, TradePacketRspUnFreezeOnlineSettle.class);
        return rsp;
    }

    /**
     * 交易列表查询 付款
     *
     * @param payPageDetails
     * @return
     */
    public static TradePacketRspPayPageDetails payPageDetails(TradePacketReqPayPageDetails payPageDetails) {
        if (payPageDetails == null || payPageDetails.getBusHead() == null || payPageDetails.getBody() == null) {
            TradePacketRspPayPageDetails rsp = new TradePacketRspPayPageDetails();
            TradePacketRspBodyPayPageDetails body = new TradePacketRspBodyPayPageDetails();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (payPageDetails != null && payPageDetails.getBusHead() != null) {
                rsp.setBusHead(payPageDetails.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(payPageDetails, key, "utf-8");
        payPageDetails.getBusHead().setSign(sign);
        String reqXml = payPageDetails.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspPayPageDetails rsp = TradePacket.unmarshal(rspXml, TradePacketRspPayPageDetails.class);
        return rsp;
    }

    /**
     * 线下付款退回
     *
     * @param refundOfflineSettle
     * @return
     */
    public static TradePacketRspRefundOfflineSettle refundOfflineSettle(
            TradePacketReqRefundOfflineSettle refundOfflineSettle) {
        if (refundOfflineSettle == null || refundOfflineSettle.getBusHead() == null || refundOfflineSettle.getBody() == null) {
            TradePacketRspRefundOfflineSettle rsp = new TradePacketRspRefundOfflineSettle();
            TradePacketRspBodyRefundOfflineSettle body = new TradePacketRspBodyRefundOfflineSettle();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (refundOfflineSettle != null && refundOfflineSettle.getBusHead() != null) {
                rsp.setBusHead(refundOfflineSettle.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(refundOfflineSettle, key, "utf-8");
        refundOfflineSettle.getBusHead().setSign(sign);
        String reqXml = refundOfflineSettle.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspRefundOfflineSettle rsp = TradePacket.unmarshal(rspXml, TradePacketRspRefundOfflineSettle.class);
        return rsp;
    }

    /**
     * 交易列表查询 退款
     *
     * @param refundPageDetails
     * @return
     */
    /**
     *
     */
    public static TradePacketRspRefundPageDetails refundPageDetails(TradePacketReqRefundPageDetails refundPageDetails) {
        if (refundPageDetails == null || refundPageDetails.getBusHead() == null || refundPageDetails.getBody() == null) {
            TradePacketRspRefundPageDetails rsp = new TradePacketRspRefundPageDetails();
            TradePacketRspBodyRefundPageDetails body = new TradePacketRspBodyRefundPageDetails();
            body.setErr_code(TradeConstants.CLINET_VALID_ERROR_CODE);
            body.setErr_code_des(TradeConstants.CLINET_VALID_ERROR_MESSAGE);
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            if (refundPageDetails != null && refundPageDetails.getBusHead() != null) {
                rsp.setBusHead(refundPageDetails.getBusHead());
            } else {
                TradePacketHead head = new TradePacketHead();
                rsp.setBusHead(head);
            }
            return rsp;
        }
        String sign = SignUtil.createSign(refundPageDetails, key, "utf-8");
        refundPageDetails.getBusHead().setSign(sign);
        String reqXml = refundPageDetails.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        String rspXml = requestAsHttpPOST(url, paras, "utf-8", 20000);
        TradePacketRspRefundPageDetails rsp = TradePacket.unmarshal(rspXml, TradePacketRspRefundPageDetails.class);
        return rsp;
    }

    public static String requestAsHttpPOST(String urlvalue, Map<String, String> paras, String charset, int timeCout) {
        HttpClient http = new HttpClient();
        HttpConnectionManagerParams managerParams = http.getHttpConnectionManager().getParams();
        managerParams.setConnectionTimeout(1000 * 10);
        managerParams.setSoTimeout(timeCout);
        PostMethod method = new PostMethod(urlvalue);
        method.getParams().setHttpElementCharset(charset);
        method.getParams().setContentCharset(charset);
        method.getParams().setCredentialCharset(charset);
        for (String key : paras.keySet()) {
            method.addParameter(key, paras.get(key));
        }
        String result = "";
        try {
            http.executeMethod(method);
        } catch (ConnectException ce) {
            TradePacketRspCommon rsp = new TradePacketRspCommon();
            TradePacketHead h = new TradePacketHead();
            rsp.setBusHead(h);
            TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
            body.setErr_code(TradeConstants.CLIENT_ERROR_CONNECT_TIMEOUT_CODE);
            body.setErr_code_des(TradeConstants.CLIENT_ERROR_CONNECT_TIMEOUT_MESSAGE);
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            return rsp.marshal();
        } catch (SocketTimeoutException se) {
            TradePacketRspCommon rsp = new TradePacketRspCommon();
            TradePacketHead h = new TradePacketHead();
            rsp.setBusHead(h);
            TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
            body.setErr_code(TradeConstants.CLIENT_ERROR_SOCKET_TIMEOUT_CODE);
            body.setErr_code_des(TradeConstants.CLIENT_ERROR_SOCKET_TIMEOUT_MESSAGE);
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            return rsp.marshal();
        } catch (Exception e) {
            TradePacketRspCommon rsp = new TradePacketRspCommon();
            TradePacketHead h = new TradePacketHead();
            rsp.setBusHead(h);
            TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
            body.setErr_code(TradeConstants.CLIENT_ERROR_SOCKET_TIMEOUT_CODE);
            body.setErr_code_des(e.getMessage());
            body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            rsp.setBody(body);
            return rsp.marshal();
        }

        try {
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static TradeResponse excute(TradeRequest<?> request) {
        String requestCode = request.getHead().getRequest_code();
        String version = request.getHead().getVersion();
        String requestXML = null;
        try {
            requestXML = request.marshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return restTemplate.postForObject(baseUrl + "/trade/api/service/{request_code}/{version}.in", requestXML, TradeResponse.class, requestCode, version);

    }

    public static TradeResponse query(TradeRequest<?> request) {
        String requestCode = request.getHead().getRequest_code();
        String version = request.getHead().getVersion();
        String requestXML = null;
        try {
            requestXML = request.marshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject(baseUrl + "/trade/api/service/{request_code}/{version}.in?requestXML={requestXML}", TradeResponse.class, requestCode, version, requestXML);
    }

	/*public static void setRestTemplate(RestTemplate restTemplate) {
        TradeClient.restTemplate = restTemplate;
	}*/
}