package com.liantuo.trade.common.util.trade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liantuo.deposit.innerclient.advanceaccount.vo.req.HttpConfig;
import com.liantuo.deposit.innerclient.advanceaccount.vo.req.PoolQueryInnerReq;
import com.liantuo.deposit.innerclient.advanceaccount.vo.rsp.PoolQueryInnerRsp;
import com.liantuo.deposit.innerclient.pool.PoolClient;
import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.exception.BusinessException;
import com.payment.util.tenpay.util.PropertyUtil;

/**
 * 交易公共校验类
 * @author yangting
 *2016年6月12日 下午4:58:10
 */
public class TradeCommonValidation {
	private static Logger logger = LoggerFactory.getLogger(TradeCommonValidation.class);
	/**
	 * 校验【核心商户编号】、【资金池编号】对应关系	
	 * 校验【核心商户编号】、【资金池编号】对应关系，若校验失败返回【失败】	
	 * 异常原因【核心商户编号与资金池编号不匹配】
	 * @param tradeRquest
	 * @param logable 日志是否可用
	 * @throws Exception
	 */
	public static void validateCoreMerchantNoAndFundPoolNo(TradeRequest<? extends TradeRequestBody> tradeRquest,boolean logable,BusinessException businessException)
			throws Exception {
		try {
			PoolQueryInnerReq req = new PoolQueryInnerReq();
			PoolQueryInnerRsp rsp = new PoolQueryInnerRsp();
			req.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
			req.setPoolNo(tradeRquest.getHead().getFund_pool_no());
			HttpConfig httpConfig = new HttpConfig();
			httpConfig.setHost(PropertyUtil.getProperty("trade.host.ip",
					"/config/properties/servers.properties"));
			httpConfig.setConnectionTimeout(100000);
			httpConfig.setSoTimeout(200000);
			httpConfig.setCharset("UTF-8");
			long start = System.currentTimeMillis();
			rsp = PoolClient.poolQuery(req, httpConfig);
			if(logable){
				logger.info("调用接口消耗【" + (System.currentTimeMillis() - start) + "】   --->" + rsp);
			}
			if(logable && rsp != null){
				logger.info(rsp.getSuccess() +"--->" + rsp.getRetCode());
			}
			
			if (rsp != null && "S".equals(rsp.getSuccess()) && "S".equals(rsp.getRetCode()) && rsp.getList() != null && rsp.getList().size() > 0) {
				logger.info("调用成功");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(logable){
				logger.error(e.getMessage(), e);
			}
		}
		throw businessException;
		
	}
	/**
	 * @Title:isPaymentResponseSuccess 
	 * @Description:获取支付链接 -判断请求支付中心是够成功
	 * @param paymentResponse
	 * @param errorCode
	 * @return:void
	 * @author:zoran.huang
	 * @date:2016年7月7日 下午3:29:22
	 */
	public static  void  isPaymentResponseSuccess(PaymentResponse paymentResponse,String errorCode) {
		BusinessException instance = null ;
		if(paymentResponse == null ){
			throw new BusinessException(errorCode, "支付中心相应数据为NUll");
		}
		String ret_code = paymentResponse.getZf_head().getRet_code();
		String err_code = paymentResponse.getZf_head().getErr_code();
		String err_code_des = paymentResponse.getZf_head().getErr_code_des();
		if(TradeConstants.ALIPAY_PAY_INFO_FAILURE.equals(ret_code)){
			if(TradeConstants.ALIPAY_PAY_INFO_CONNECT_TIME_OUT.equals(err_code) || TradeConstants.ALIPAY_PAY_INFO_PROCCESS_TIME_OUT.equals(err_code) || TradeConstants.ALIPAY_PAY_INFO_HTTP_ERROR.equals(err_code)){
				throw new BusinessException(errorCode, err_code_des);
			}
		}
	}
	
	/**
	 * @Title:isPaymentResponseSuccess 
	 * @Description:获取支付链接 -判断支付中心返回数据是够正确
	 * @param paymentResponse
	 * @param errorCode
	 * @return:void
	 * @author:zoran.huang
	 * @date:2016年7月7日 下午3:29:22
	 */
	public static  void  isPaymentResponseSuccess(PaymentResponse paymentResponse) {
		String ret_code = paymentResponse.getZf_head().getRet_code();
		String err_code = paymentResponse.getZf_head().getErr_code();
		String err_code_des = paymentResponse.getZf_head().getErr_code_des();
		if(TradeConstants.ALIPAY_PAY_INFO_FAILURE.equals(ret_code)) {
             throw new BusinessException(err_code, err_code_des);
        }
	}
}
