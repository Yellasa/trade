/**
 * 
 */
package com.liantuo.trade.bus.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.util.xml.XmlUtil;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeOutPaymentLogService;
import com.liantuo.trade.seqno.IdFactory;

/**
 * @ClassName:     TradeCallPaymentCenterLogServiceImpl.java
 * @Description:   TODO   交易系统调用支付中心需记录日志
 * 							只适应于支付返回交易或者交易调用支付的场景
 * @author user
 *
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-21 下午4:00:02 
 */
@Service("tradeCallPaymentCenterLogService")
public class TradeCallPaymentCenterLogServiceImpl {

	private final Log LOGGER = LogFactory.getLog(TradeCallPaymentCenterLogServiceImpl.class);
	
	@Resource
	private TradeOutPaymentLogService tradeOutPaymentLogService;
	
	@Resource(name = "idFactoryTradeOutPaymentLogNo")
	private IdFactory idFactoryTradeOutPaymentLogNo;
	
	
	/**
	 * 报文不等同于日志对象   后期需要修改
	 * @param xml
	 * @return
	 */
		 public TradeOutPaymentLogWithBLOBs createPaymentOutLog(TradeRequest request,String xml){
			 	if(!StringUtils.isEmpty(xml)){
//			 		PaymentRequest req = ObjectXmlUtil.unmarshal(xml, PaymentRequest.class);
			 		Element rootreq = XmlUtil.getRootElement(xml,TradeConstants.ENCODING);
			 		Element zf_head = rootreq.element("zf_head");
//			 		Element payment_request_element = rootreq.element("payment_request");
					String version=zf_head.element("version").getText();
					String trade_no=zf_head.element("trade_no").getText();
					String pay_channel=zf_head.element("pay_channel").getText();
					String trade_type=pay_channel.substring(pay_channel.lastIndexOf("_")+1, pay_channel.length());
					Element pay_transaction_id_e=zf_head.element("pay_transaction_id");
					String pay_transaction_id="";
					if(pay_transaction_id_e!=null){
						pay_transaction_id=zf_head.element("pay_transaction_id").getText();
					}
			 		TradeOutPaymentLogWithBLOBs log = new TradeOutPaymentLogWithBLOBs();
			 		log.setReqNo(getReqNo(request.getHead().getRequest_code()));
//			 		log.setTradeNo(req.getTrade_no());//从xml中获取交易编号
			 		log.setTradeNo(trade_no);//从xml中获取交易编号
			 		log.setPaymentVersion(version);
			 		log.setPayChannel(pay_channel);//支付中心三段码
			 		log.setTradeType(trade_type);//支付中心业务码：最后一段码
//			 		log.setTransactionId(req.getPay_transaction_id());//从xml获取身份编号
			 		log.setTransactionId(pay_transaction_id);//从xml获取身份编号
			 		log.setReqDateTime(new Date());
			 		log.setReqText(xml);
			 		tradeOutPaymentLogService.insertTradeOutPaymentLog(log);
			 		return log;
			 	}
			 	return new TradeOutPaymentLogWithBLOBs();
			 
		 }

	    public void updatePaymentOutLog(TradeOutPaymentLogWithBLOBs log, String xml){
	    	log.setResDateTime(new Date());
	        log.setReqCostTime(System.currentTimeMillis() - log.getReqDateTime().getTime()+"");
	      //如果返回失败，从请求报文中拿到输入参数进行长度判断并进行回填
	        Element rootreq = XmlUtil.getRootElement(xml,TradeConstants.ENCODING);
			Element zf_head = rootreq.element("zf_head");
			String status=zf_head.element("ret_code").getText();
	        if(xml != null){
	            log.setResText(xml);
	            log.setReqStatus(status);
	        }else{
	            log.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_FAILURE);
	        }
	        tradeOutPaymentLogService.updateTradeOutPaymentLog(log);
	    }
	    

	    private String getReqNo(String request_code){
	    	return TradeUtilCommon.getServiceCode(request_code)+idFactoryTradeOutPaymentLogNo.generate().toString();
	    }
}