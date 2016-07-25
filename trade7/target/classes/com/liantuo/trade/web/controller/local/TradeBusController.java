package com.liantuo.trade.web.controller.local;

import com.ebill.framework.datatype.StringUtil;
import com.liantuo.trade.bus.process.Process;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyCommon;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyCommon;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqCommon;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqHead;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspCommon;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.message.MessageBundleService;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.util.xml.XmlUtil;
import com.liantuo.trade.common.validate.ValidationUtil;
import com.liantuo.trade.exception.BusinessCheckedException;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeReqLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * v1.0
 */
@Controller
@RequestMapping("/service")
public class TradeBusController {
    private final Log LOG4J = LogFactory.getLog("trade");

    @Resource(name = "tradeReqLogServiceImpl")
    private TradeReqLogService tradeRequestLogServ;
    @Resource(name = "messageBundleServiceImpl")
    private MessageBundleService mesgBundleServ;
    @Resource(name = "idFactoryTradeReqLogReqNo")
    private StepSequenceFactoryForSpdb idFactory;
    /*@Resource(name = "tradeProcessFactory")
    private TradeProcessFactory tradeProcessFactory;*/
    @Resource(name = "tradeDispatcher")
    private Process process;

    @RequestMapping(value = "/tx", method = RequestMethod.POST)
    public String excuteRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/xml;charset=utf-8");
        /**请求方IP地址获取*/
        String ip = getIp(request);
        /**请求报文检查*/
        String reqXml = request.getParameter("para").trim();
        if (!validaReqXML(reqXml)) {
            LOG4J.error("XML为空或格式不正确:\t" + reqXml + ",\tipaddress:\t" + ip);
            response.getWriter().write("不能读取交易报文");
            response.getWriter().flush();
            return null;
        }


        /**请求协议参数校验 start*/
        TradePacket tradeReq;
        tradeReq = TradePacket.unmarshal(reqXml, TradePacketReqHead.class);
        if (null == tradeReq || null == tradeReq.getBusHead()) {
            response.getWriter().write("交易报文解析失败，请按交易报文规范提交请求报文");
            response.getWriter().flush();
            return null;
        }
        
	    // FIXME 设置当前请求编号到 ThreadLocal 中，解决模板中交易码问题
        mesgBundleServ.setRequestCode(tradeReq.getBusHead().getRequest_code());
	      
        //交易协议参数非空校验
        String protocolRequiredValidRetMsg = ValidationUtil.validateRequired(tradeReq.getBusHead());
        if (!StringUtils.isEmpty(protocolRequiredValidRetMsg)) {
            buildRspXmlFailure(tradeReq, protocolRequiredValidRetMsg, response);
            return null;
        }
        //交易协议参数格式校验
        String protocolFormatValidate = ValidationUtil.validateFormat(tradeReq.getBusHead());
        if (!StringUtils.isEmpty(protocolFormatValidate)) {
            buildRspXmlFailure(tradeReq, protocolFormatValidate, response);
            return null;
        }
        /**请求协议参数校验 end*/


        /**写入请求日志*/
        Date startTime = new Date();
        TradeReqLogWithBLOBs tradeReqLog = null;
        if (!tradeReq.getBusHead().getRequest_code().endsWith("_998")) {
            tradeReqLog = saveTradeReqLog(tradeReq, reqXml, ip, startTime);
        }

        /**路由交易Process*/

        TradePacket tradeRsp = null;


        if (null == tradeRsp) {
            if (null == process) {
                tradeRsp = buildRspProcessNotFound(tradeReq.getBusHead());
            } else {
                /**交易处理*/
                try {
                    // 业务调用
                    ReqContext reqContext = new ReqContext();
                    reqContext.setReq(tradeReqLog);
                    reqContext.setBusHead(tradeReq.getBusHead());
                    tradeRsp = process.processHandle(reqXml, reqContext);
                } catch (BusinessCheckedException e) {
                    tradeRsp = buildRspXmlBusException(tradeReq, e);
                } catch (Exception e) {
                    tradeRsp = buildRspXmlException(tradeReq, e);
                } finally {
                    //组装响应报文头
                    tradeRsp.setBusHead(tradeReq.getBusHead());
                }
            }
        }

        String rspXml = "";
        if (null != tradeRsp) {
            rspXml = tradeRsp.marshal();
            this.responseWrite(rspXml, response);
        }
        /**更新请求日志*/
        if (!tradeReq.getBusHead().getRequest_code().endsWith("_998")) {
            updateTradeReqLogById(tradeReqLog.getId(),reqXml, rspXml, TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS, startTime);
        }

        return null;
    }

    private TradePacketRspCommon buildRspXmlException(TradePacket tradeReq, Exception e) {
        TradePacketRspCommon rsp = createTradeRsp(tradeReq);
        rsp.getBody().setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
        rsp.getBody().setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        rsp.getBody().setErr_code(this.mesgBundleServ.getCode("trade.biz.error"));
        rsp.getBody().setErr_code_des(e.getMessage());
        return rsp;
    }

    private TradePacketRspCommon createTradeRsp(TradePacket tradeReq) {
        TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
        TradePacketRspCommon rsp = new TradePacketRspCommon();
        rsp.setBody(body);
//        rsp.setBusHead(tradeReq.getBusHead());
        return rsp;
    }

    private TradePacketRspCommon buildRspXmlBusException(TradePacket tradeReq, BusinessCheckedException e) {
        TradePacketRspCommon rsp = createTradeRsp(tradeReq);
        rsp.getBody().setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
        rsp.getBody().setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        rsp.getBody().setErr_code(this.mesgBundleServ.getCode("trade.biz.error"));
        rsp.getBody().setErr_code_des(e.getMessage());
        return rsp;
    }

    private void responseWrite(String rspXml, HttpServletResponse response) {
        try {
            response.getWriter().write(rspXml);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildRspXmlFailure(TradePacket packet, String validateErrorMsg, HttpServletResponse response) {
        TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
        body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        body.setErr_code(this.mesgBundleServ.getCode("trade.validate.failure"));
        body.setErr_code_des(this.mesgBundleServ.getMessage("trade.validate.failure", new Object[]{validateErrorMsg}));
        TradePacketRspCommon rsp = new TradePacketRspCommon();
        rsp.setBody(body);
//        rsp.setBusHead(packet.getBusHead());
        this.responseWrite(rsp.marshal(), response);
    }

    private TradePacket buildRspProcessNotFound(TradePacketHead head) {
        TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
        body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        body.setErr_code(this.mesgBundleServ.getCode("trade.failure.process.not.found"));
        body.setErr_code_des(this.mesgBundleServ.getMessage("trade.failure.process.not.found", new Object[]{head.getVersion(), head.getRequest_code()}));
        TradePacketRspCommon rsp = new TradePacketRspCommon();
        rsp.setBody(body);
//        rsp.setBusHead(head);
        return rsp;
    }

    private void updateTradeReqLogById(Long logId, String reqXml,String rspXml, String status, Date startTime) {
        if (null == logId) {
            return;
        }
        try {
	        //回写trade_no,out_trade_no,out_trade_no_ext
	        String detail="";
			String out_trade_no="";
			String trade_no="";
			String out_trade_no_ext="";
			String partner_id="";
			String core_merchant_no="";
			String fund_pool_no="";
			
	        Element root = XmlUtil.getRootElement(rspXml,TradeConstants.ENCODING);
	        Element trade_details = root.element("body").element("trade_details");
	        
			if(null!=trade_details){
				detail=trade_details.getText();
			}
			if(!StringUtil.isEmpty(detail)){
				Map<String, Object> map = ObjectJsonUtil.string2Object(detail,Map.class);
				trade_no=(String)map.get("tradeNo");
				out_trade_no=(String)map.get("outTradeNo");
				out_trade_no_ext=(String)map.get("outTradeNoExt");
				partner_id=(String)map.get("partnerId");
				core_merchant_no=(String)map.get("coreMerchantNo");
				fund_pool_no=(String)map.get("fundPoolNo");
			}
			
			String result_code = root.element("body").element("is_success").getText();
			String err_code="";
			Element rootreq = XmlUtil.getRootElement(reqXml,TradeConstants.ENCODING);
			if(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE.equals(result_code)){
				err_code = root.element("body").element("err_code").getText();
				//如果返回失败，从请求报文中拿到输入参数进行长度判断并进行回填
				Element ele_trade_no=rootreq.element("body").element("trade_no");
				if(null!=ele_trade_no){
					if(ele_trade_no.getText().length()>64){
						trade_no="";
					}else{
						trade_no=ele_trade_no.getText();
					}
				}
				Element ele_out_trade_no=rootreq.element("body").element("out_trade_no");
				if(null!=ele_out_trade_no){
					if(ele_out_trade_no.getText().length()>64){
						out_trade_no="";
					}else{
						out_trade_no=ele_out_trade_no.getText();
					}
				}
				Element ele_out_trade_no_ext=rootreq.element("body").element("out_trade_no_ext");
				if(null!=ele_out_trade_no_ext){
					if(ele_out_trade_no_ext.getText().length()>64){
						out_trade_no_ext="";
					}else{
						out_trade_no_ext=ele_out_trade_no_ext.getText();
					}
				}
			}
			Element ele_partner_id=rootreq.element("head").element("partner_id");
			if(null!=ele_partner_id){
				if(ele_partner_id.getText().length()>32){
					partner_id="";
				}else{
					partner_id=ele_partner_id.getText();
				}
			}
			Element ele_core_merchant_no=rootreq.element("head").element("core_merchant_no");
			if(null!=ele_core_merchant_no){
				if(ele_core_merchant_no.getText().length()>32){
					core_merchant_no="";
				}else{
					core_merchant_no=ele_core_merchant_no.getText();
				}
			}
			Element ele_fund_pool_no=rootreq.element("head").element("fund_pool_no");
			if(null!=ele_fund_pool_no){
				if(ele_fund_pool_no.getText().length()>32){
					fund_pool_no="";
				}else{
					fund_pool_no=ele_fund_pool_no.getText();
				}
			}
			
	        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
	        log.setId(logId);
	        log.setResText(rspXml);
	        log.setReqStatus(status);
	        log.setResDateTime(new Date());
	        log.setReqCostTime(log.getResDateTime().getTime() - startTime.getTime());
	        if(!StringUtil.isEmpty(trade_no)){
	        	log.setTradeNo(trade_no);
	        }
	        if(!StringUtil.isEmpty(out_trade_no)){
	        	log.setOutTradeNo(out_trade_no);
	        }
	        if(!StringUtil.isEmpty(out_trade_no_ext)){
	        	log.setOutTradeNoExt(out_trade_no_ext);
	        }
	        if(!StringUtil.isEmpty(result_code)){
	        	log.setResultCode(result_code);
	        }
	        if(!StringUtil.isEmpty(err_code)){
	        	log.setErrCode(err_code);
	        }
	        if(!StringUtil.isEmpty(partner_id)){
	        	log.setPartnerId(partner_id);
	        }
	        if(!StringUtil.isEmpty(core_merchant_no)){
	        	log.setCoreMerchantNo(core_merchant_no);
	        }
	        if(!StringUtil.isEmpty(fund_pool_no)){
	        	log.setFundPoolNo(fund_pool_no);
	        }
	        tradeRequestLogServ.updateTradeRequestLog(log);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private TradeReqLogWithBLOBs saveTradeReqLog(TradePacket tradeReq, String xml, String ip, Date startTime) throws Exception {
        long start = System.currentTimeMillis();
        TradeReqLogWithBLOBs log = insertTradeReqLog(tradeReq, xml, ip, startTime);
        LOG4J.info("->>>创建log花费时间："+(System.currentTimeMillis()-start));
        tradeRequestLogServ.insertTradeRequestLog(log);
        LOG4J.info("->>>保存log共花费时间："+(System.currentTimeMillis()-start));
        return log;
    }

    private TradeReqLogWithBLOBs insertTradeReqLog(TradePacket tradeReq, String xml, String ip, Date startTime) throws Exception {
        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
        log.setReqDateTime(startTime);
//        log.setGmtCreated(new Date());
        log.setReqIp(ip);
        log.setReqText(xml);
        log.setReqNo(TradeUtilCommon.getServiceCode(tradeReq.getBusHead().getRequest_code())+idFactory.generate().toString());

        TradePacketReqCommon tradePacketReqCommon = (TradePacketReqCommon) TradePacketReqCommon.unmarshal(xml, TradePacketReqCommon.class);
        TradePacketReqBodyCommon body = tradePacketReqCommon.getBody();
        /**这6列全部改成输出时回填。
         * 输入时为了做到先写log记录，后进行正则校验。但是这6列有可能校验不通过，插表会包错，所以先不进行插入，update的时候再进行回填。
         * 
         */
//        if (null != body && !StringUtils.isEmpty(body.getOut_trade_no())) {
//            log.setOutTradeNo(body.getOut_trade_no());
//        }
//        if (null != body && !StringUtils.isEmpty(body.getOut_trade_no_ext())) {
//            log.setOutTradeNoExt(body.getOut_trade_no_ext());
//        }
//        if (null != body && !StringUtils.isEmpty(body.getTrade_no())) {
//            log.setTradeNo(body.getTrade_no());
//        }
//        log.setPartnerId(tradeReq.getBusHead().getPartner_id());
//        log.setCoreMerchantNo(tradeReq.getBusHead().getCore_merchant_no());
//        log.setFundPoolNo(tradeReq.getBusHead().getFund_pool_no());
        
        log.setServiceName(tradeReq.getBusHead().getRequest_code());
        log.setServiceCode(tradeReq.getBusHead().getRequest_code());

        return log;
    }

    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-real-ip");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 验证交易报文格式
     *
     * @param reqXml 交易报文
     * @return 验证结果
     * @throws DocumentException
     */
    private static boolean validaReqXML(String reqXml) {
        if (StringUtils.isEmpty(reqXml)) {
            return false;
        }
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            try {
				document = reader.read(new ByteArrayInputStream(new String(reqXml.getBytes(), "utf-8").getBytes()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (DocumentException e) {
            return false;
        }
        Element root = document.getRootElement();
        Element head = root.element("head");
        Element body = root.element("body");
        if (head == null || head.elements().size() == 0 || body == null /*|| body.elements().size() == 0*/) {
            return false;
        }
        return true;
    }


}
