package com.liantuo.trade.bus.service;

import java.util.List;

import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefund;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundExample;

public interface SinglePaymentRefundService {
	/**
	 * @Title:创建退款成功交易记录
	 * @Description: 创建退款扣款成功交易记录 
	 * @param paymentRefund 退款扣款交易记录
	 * @return
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午10:52:22
	 */
	public TradeSinglePaymentRefund createInnerTradeForRefundOfSuccess(TradeSinglePaymentRefund paymentRefund) throws Exception;
	
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
	public TradeSinglePaymentRefund createInnerTradeForRefundOfFailure(TradeSinglePaymentRefund paymentRefund) throws Exception;

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
	public TradeSinglePaymentRefund createOuterTradeForRefundOfSuccess(TradeSinglePaymentRefund paymentRefund) throws Exception;
	/**
	 * @Title:创建退款扣帐失败交易记录 
	 * @Description: 创建退款扣帐失败交易记录
	 * @param paymentRefund
	 * @return
	 * @throws Exception
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午10:55:16
	 */
	public TradeSinglePaymentRefund createOuterTradeForRefundOfFailure(TradeSinglePaymentRefund paymentRefund) throws Exception;

	/**
	 * @Title:updateTradeSuccess 
	 * @Description: 修改退款成功交易记录
	 * @param paymentRefund
	 * @return
	 * @throws Exception
	 * @return:TradeSinglePaymentRefund
	 * @author:zoran.huang
	 * @date:2016年6月3日 上午11:07:10
	 */
	public TradeSinglePaymentRefund updateOuterTradePaymentRefundSuccess(TradeSinglePaymentRefund paymentRefund) throws Exception;
	
	public List<TradeSinglePaymentRefund> queryByExample(TradeSinglePaymentRefundExample example) throws Exception;
	
	/**
	 * @Title:queryByOutTradeNoExt 
	 * @Description: 根据交易发起方发起请求编号查询交易
	 * @param queryPaymentRefund
	 * @return
	 * @throws Exception
	 * @return:List<TradeSinglePaymentRefund>
	 * @author:zoran.huang
	 * @date:2016年6月6日 下午1:18:36
	 */
	public List<TradeSinglePaymentRefund> queryByOutTradeNoExt(TradeSinglePaymentRefund queryPaymentRefund) throws Exception;
}
