package com.liantuo.trade.orm.service.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.ebill.framework.datatype.StringUtil;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.common.util.xml.XmlUtil;
import com.liantuo.trade.orm.mapper.TradeReqLogMapper;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeReqLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;

/**
 * @作者 Jimmy
 * @日期 2015年12月15日 上午9:40:34
 * @最后修改人
 * @修改时间
 * @复审人
 */
@Service("tradeReqLogServiceImpl")
public class TradeReqLogServiceImpl implements TradeReqLogService {

    @Resource
    private TradeReqLogMapper tradeReqLogMapper;
    @Resource(name = "idFactoryTradeReqLogReqNo")
    private StepSequenceFactoryForSpdb idFactory;
    @Override
    public void insertTradeRequestLog(TradeReqLogWithBLOBs log) {
        tradeReqLogMapper.insertSelective(log);
    }

    @Override
    public void updateTradeRequestLog(TradeReqLogWithBLOBs log) {
        tradeReqLogMapper.updateByPrimaryKeySelective(log);
    }

    @Override
    public TradeReqLogWithBLOBs getTradeReqLog(Long id) {
        return tradeReqLogMapper.selectByPrimaryKey(id);
    }

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeReqLogService#insertTradeRequestLog(com.liantuo.trade.client.trade.packet.TradeRequest, java.lang.String, java.lang.String)
	 */
	@Override
	public TradeReqLogWithBLOBs insertTradeRequestLog(TradeRequest<?> tradeReq, String ip, String requestXML) {
		// TODO Auto-generated method stub
		Date startTime = new Date();
        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
        log.setReqDateTime(startTime);
//        log.setGmtCreated(new Date());
        log.setReqIp(ip);
        log.setReqText(requestXML);
        log.setReqNo(TradeUtilCommon.getServiceCode(tradeReq.getHead().getRequest_code())+idFactory.generate().toString());
//        TradeRequestBody body = tradeReq.getBody();
//        if (null != body && !StringUtils.isEmpty(body.getOut_trade_no())) {
//            log.setOutTradeNo(body.getOut_trade_no());
//        }
//        if (null != body && !StringUtils.isEmpty(body.getOut_trade_no_ext())) {
//            log.setOutTradeNoExt(body.getOut_trade_no_ext());
//        }
//        if (null != body && !StringUtils.isEmpty(body.getTrade_no())) {
//            log.setTradeNo(body.getTrade_no());
//        }
//        log.setPartnerId(tradeReq.getHead().getPartner_id());
//        log.setCoreMerchantNo(tradeReq.getHead().getCore_merchant_no());
//        log.setFundPoolNo(tradeReq.getHead().getFund_pool_no());
        log.setServiceName(tradeReq.getHead().getRequest_code());
        log.setServiceCode(tradeReq.getHead().getRequest_code());
        insertTradeRequestLog(log);
        return log;
	}

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeReqLogService#updateTradeReqLogById(java.lang.Long, com.liantuo.trade.client.trade.packet.TradeRequest, com.liantuo.trade.client.trade.packet.TradeResponse, java.util.Date)
	 */
	@Override
	public void updateTradeReqLogById(Long logId, String requestXml, TradeResponse tradeResponse, Date startTime) {
		// TODO Auto-generated method stub
		if (null == logId) {
            return;
        }
        try {
	        //回写trade_no,out_trade_no,out_trade_no_ext
			String out_trade_no="";
			String trade_no="";
			String out_trade_no_ext="";
			String partner_id="";
			String core_merchant_no="";
			String fund_pool_no="";

			String detail = tradeResponse.getBody().getTrade_details();
			if(!StringUtil.isEmpty(detail)){
				Map<String, Object> map = ObjectJsonUtil.string2Object(detail,Map.class);
				trade_no=(String)map.get("tradeNo");
				out_trade_no=(String)map.get("outTradeNo");
				out_trade_no_ext=(String)map.get("outTradeNoExt");
				partner_id=(String)map.get("partnerId");
				core_merchant_no=(String)map.get("coreMerchantNo");
				fund_pool_no=(String)map.get("fundPoolNo");
			}
			
			String result_code = tradeResponse.getBody().getIs_success();
			String err_code="";
			if(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE.equals(result_code)){
				err_code = tradeResponse.getBody().getErr_code();
				//如果返回失败，从请求报文中拿到输入参数进行长度判断并进行回填
				Element rootreq = XmlUtil.getRootElement(requestXml,TradeConstants.ENCODING);
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
			
			partner_id = tradeResponse.getHead().getPartner_id();
			if(partner_id ==null || partner_id.length()>32){
				partner_id="";
			}
			
			core_merchant_no = tradeResponse.getHead().getCore_merchant_no();
			if(core_merchant_no ==null || core_merchant_no.length()>32){
				core_merchant_no="";
			}
			
			fund_pool_no = tradeResponse.getHead().getFund_pool_no();
			if(fund_pool_no==null ||fund_pool_no.length()>32){
				fund_pool_no="";
			}
			
	        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
	        log.setId(logId);
	        log.setResText(ObjectXmlUtil.marshal(tradeResponse));
	        log.setReqStatus(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
	        Date nowTime = new Date();
	        log.setResDateTime(nowTime);
	        log.setReqCostTime(nowTime.getTime() - startTime.getTime());
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
	        updateTradeRequestLog(log);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
