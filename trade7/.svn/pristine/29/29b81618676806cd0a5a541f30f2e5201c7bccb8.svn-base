package com.liantuo.trade.bus.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.bus.service.SinglePaymentRefundService;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentRefundLogMapper;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentRefundMapper;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefund;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundExample;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundLog;
@Service
public class SinglePaymentRefundServiceImpl implements
		SinglePaymentRefundService {
	private static Logger logger = LoggerFactory.getLogger(SinglePaymentRefundServiceImpl.class);
	@Autowired
	private TradeSinglePaymentRefundMapper tradeSinglePaymentRefundMapper;
	@Autowired
	private TradeSinglePaymentRefundLogMapper tradeSinglePaymentRefundLogMapper;
	
	/**
	 * @Title:创建退款成功交易记录
	 * @Description: 创建退款扣款成功交易记录 
	 * @param paymentRefund 退款扣款交易记录
	 * @return
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午10:52:22
	 */
	@Override
	public TradeSinglePaymentRefund createInnerTradeForRefundOfSuccess(
			TradeSinglePaymentRefund paymentRefund) throws Exception {
		paymentRefund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_SUCCESS);; //交易状态 01:退款成功
		paymentRefund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_INNER);//交易组别,内部支付退款
		paymentRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态,已结束
		paymentRefund.setVersion(0); //交易版本
		tradeSinglePaymentRefundMapper.insertSelective(paymentRefund);
		paymentRefund = insertTradeLog(paymentRefund);
		return paymentRefund;
	}
	
	
	/**
	 * @Title:创建退款失败交易记录 
	 * @Description: 创建退款失败交易记录
	 * @param paymentRefund
	 * @return
	 * @throws Exception
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午10:55:16
	 */
	@Override
	public TradeSinglePaymentRefund createInnerTradeForRefundOfFailure(
			TradeSinglePaymentRefund paymentRefund) throws Exception {
		paymentRefund.setVersion(0); //交易版本
		paymentRefund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_FAIL);; //交易状态 02:退款失败 
		paymentRefund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_INNER);//交易组别,内部支付退款
		paymentRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态,已结束
		tradeSinglePaymentRefundMapper.insertSelective(paymentRefund);
		paymentRefund = insertTradeLog(paymentRefund);
		return paymentRefund;
	}
	
	/**
	 * @Title:createTradeForDebitOfSuccess 
	 * @Description: 创建退款扣帐成功交易记录 
	 * @param paymentRefund
	 * @return
	 * @throws Exception
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午11:03:16
	 */
	@Override
	public TradeSinglePaymentRefund createOuterTradeForRefundOfSuccess(
			TradeSinglePaymentRefund paymentRefund) throws Exception {
		paymentRefund.setVersion(0); //交易版本
		paymentRefund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_DEBIT_SUCCESS);; //交易状态 00:退款扣帐成功（等待退款结果） 
		paymentRefund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_OUTER);//交易组别,2外部付款退款扣帐
		paymentRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);//交易结束状态,未结束
		tradeSinglePaymentRefundMapper.insertSelective(paymentRefund);
		paymentRefund = insertTradeLog(paymentRefund);
		return paymentRefund;
	}

	@Override
	public TradeSinglePaymentRefund updateOuterTradePaymentRefundSuccess(
			TradeSinglePaymentRefund paymentRefund) throws Exception {
		paymentRefund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_SUCCESS);; //交易状态 01:退款成功
		paymentRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态,已结束
		paymentRefund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_OUTER);//交易组别,2外部付款退款扣帐
		int result = tradeSinglePaymentRefundMapper.updateByKeyVersionSelective(paymentRefund);
		if(result != 1){
			logger.error(String.format("乐观锁更新失败 id=%d, version=%d", paymentRefund.getId(), paymentRefund.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
		}
		paymentRefund = insertTradeLog(paymentRefund);
		return paymentRefund;
	}

	@Override
	public TradeSinglePaymentRefund createOuterTradeForRefundOfFailure(
			TradeSinglePaymentRefund paymentRefund) throws Exception {
		paymentRefund.setVersion(0); //交易版本
		paymentRefund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_FAIL);; //交易状态 02:退款失败 
		paymentRefund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_OUTER);//交易组别,2外部付款退款扣帐
		paymentRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态,已结束
		tradeSinglePaymentRefundMapper.insertSelective(paymentRefund);
		paymentRefund = insertTradeLog(paymentRefund);
		return paymentRefund;
	}
	/**
	 * @Title:insertTradeLog 
	 * @Description: 创建支付退回历史记录
	 * @param paymentRefund
	 * @return
	 * @throws Exception
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 下午3:01:12
	 */
	private TradeSinglePaymentRefund insertTradeLog(TradeSinglePaymentRefund paymentRefund) throws Exception{
		TradeSinglePaymentRefundLog paymentRefundLog = new TradeSinglePaymentRefundLog();
		TradeSinglePaymentRefundExample paymentRefundExample = new TradeSinglePaymentRefundExample();
		paymentRefundExample.createCriteria().andTradeNoEqualTo(paymentRefund.getTradeNo());
		paymentRefund = tradeSinglePaymentRefundMapper.selectByExample(paymentRefundExample).get(0);
		BeanUtils.copyProperties(paymentRefund, paymentRefundLog);
		paymentRefundLog.setId(null);
		tradeSinglePaymentRefundLogMapper.insertSelective(paymentRefundLog);
		return paymentRefund;
	}


	@Override
	public List<TradeSinglePaymentRefund> queryByExample(TradeSinglePaymentRefundExample example) throws Exception {
		List<TradeSinglePaymentRefund> list = tradeSinglePaymentRefundMapper.selectByExample(example);
		return list;
	}


	@Override
	public List<TradeSinglePaymentRefund> queryByOutTradeNoExt(
			TradeSinglePaymentRefund queryPaymentRefund) throws Exception {
		TradeSinglePaymentRefundExample example = new TradeSinglePaymentRefundExample();
		example.createCriteria().andOutTradeNoExtEqualTo(queryPaymentRefund.getOutTradeNoExt())
		.andFundPoolNoEqualTo(queryPaymentRefund.getFundPoolNo());
		List<TradeSinglePaymentRefund> list = tradeSinglePaymentRefundMapper.selectByExample(example);
		return list;
	}
}
