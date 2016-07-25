/**
 * 
 */
package com.liantuo.trade.orm.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestPacket;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.mapper.TradeNotifyPaymentLogMapper;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeNotifyPaymentLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.payment.util.tenpay.util.PropertyUtil;

/**
 * @ClassName:     TradeNotifyPaymentLogServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-2-2 下午1:10:22 
 */
@Service("tradeNotifyPaymentLogServiceImpl")
public class TradeNotifyPaymentLogServiceImpl implements TradeNotifyPaymentLogService {

	@Autowired
    private TradeNotifyPaymentLogMapper tradeNotifyPaymentLogMapper;
	
	@Resource(name = "idFactoryNotifyReqLogReqNo")
	private StepSequenceFactoryForSpdb idFactoryNotifyReqLogReqNo;
	
	@Override
    public void insertTradeNotifyPaymentLog(TradeNotifyPaymentLogWithBLOBs log) {
		tradeNotifyPaymentLogMapper.insertSelective(log);
    }

    @Override
    public void updateTradeNotifyPaymentLogById(TradeNotifyPaymentLogWithBLOBs log) {
    	tradeNotifyPaymentLogMapper.updateByPrimaryKeySelective(log);
    }

	public TradeNotifyPaymentLogWithBLOBs insertTradeNotifyPaymentLog(TradeNotifyRequestPacket tradeReq,String serviceName) {
		TradeNotifyPaymentLogWithBLOBs  log= new TradeNotifyPaymentLogWithBLOBs();
        // 交易请求编号
        log.setReqNo(TradeUtilCommon.getServiceCode(tradeReq.getTrade_req_no())+idFactoryNotifyReqLogReqNo.generate().toString());
        log.setTradeNo(tradeReq.getTrade_no());
        //调用日期时间
        log.setReqDateTime(new Date());
        // 请求报文
        log.setReqText(!StringUtils.isEmpty(tradeReq.getRequestXML()) ? tradeReq.getRequestXML() : tradeReq.toString());
        // 请求方IP地址  192.168.19.36
        log.setReqIp(!StringUtils.isEmpty(tradeReq.getIp()) ? tradeReq.getIp():  PropertyUtil.getProperty("payment.notify.host.ip", "/config/properties/servers.properties"));
        // 接口服务
        log.setServiceName(serviceName);
        // 接口版本号
        log.setPaymentVersion(tradeReq.getVersion());
        
        //支付中心渠道编号
        log.setPayChannel(tradeReq.getPay_channel());
        
        //支付中心接口ID
        log.setPaymentId(tradeReq.getPayment_req_no());
        //支付中心接口编号 (暂无值)
       // log.setTradeType(tradeReq.getTrade_req_no());
        
        tradeNotifyPaymentLogMapper.insertSelective(log);
		return log;
	}

    
	@Override
	public void updateTradeNotifyPaymentLog(Long id,String isSuccess, String errorCode, Date startTime) {
		TradeNotifyPaymentLogWithBLOBs  log= new TradeNotifyPaymentLogWithBLOBs();
		//id
		log.setId(id);
		 // 交易处理结果
        log.setResultCode(isSuccess);
        // 错误编码
        log.setErrCode(errorCode);
		//响应日期时间
		log.setResDateTime(new Date());
		//请求耗时
		log.setReqCostTime(Long.toString(log.getResDateTime().getTime() - startTime.getTime()));
		//通讯状态(若为通讯原因导致服务失败为F,其他情况为S)
		log.setReqStatus(TradeConstants.TRADE_SUCCESS);
		tradeNotifyPaymentLogMapper.updateByPrimaryKeySelective(log);
	}

}
