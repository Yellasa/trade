package com.liantuo.trade.bus.service;

import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;

import java.util.List;

/**
 * 单笔支付操作服务
 */
public interface SinglePaymentService {
	/**
	 * 创建支付充值成功交易记录
	 * @param tradeSinglePayment
	 * @return
	 * @throws Exception
	 */
	TradeSinglePayment createTradeForPayOfSuccess(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 * 创建等待支付交易
	 */
	TradeSinglePayment createForPayOfWait(TradeSinglePayment tradePayment) throws Exception;

	/**
	 * 创建等待入账充值交易
	 * @param tradeSinglePayment
	 * @return
	 * @throws Exception
	 */
	TradeSinglePayment createForEnterOfWait(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 * 充值成功 修改交易
	 * @param tradeSinglePayment
	 * @return
	 * @throws Exception
	 */
	TradeSinglePayment updateTradeSuccess(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 *  修改交易
	 * @param tradeSinglePayment
	 * @return
	 * @throws Exception
	 */
	TradeSinglePayment updateTrade(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 *
	 * @Description: 创建失败交易记录
	 * @param @param TradeSinglePayment
	 * @return TradeSinglePayment
	 * @throws
	 */

	TradeSinglePayment createTradeFailureRecode(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 * 充值失败 修改交易
	 * @param tradeSinglePayment
	 * @return
	 * @throws Exception
	 */
	TradeSinglePayment updateTradeFail(TradeSinglePayment tradeSinglePayment) throws Exception;


	/**
	 * 充值交易列表查询
	 * @param example
	 * @return
	 * @throws Exception
	 */
	List<TradeSinglePayment> queryByExample(TradeSinglePaymentExample example) ;

	TradeSinglePayment queryByTradeNo(String tradeNo);

	/**
	 *
	 * @Description: 创建外部支付失败交易记录
	 * @param @param TradeSinglePayment
	 * @return TradeSinglePayment
	 * @throws
	 */
	TradeSinglePayment createOuterTradeFailureRecode(TradeSinglePayment tradeSinglePayment) throws Exception;

	/**
	 *
	 * @Description: 查询总数
	 * @param @param example
	 * @param @return
	 * @date 2016-7-12
	 */
	int selectCountByExample(TradeSinglePaymentExample example);

	/**
	 *
	 * @Description: 查询结果
	 * @param @param example
	 * @param @return
	 * @return List<TradeRecharge>
	 * @date 2016-7-12
	 */
	List<TradeSinglePayment> pageQueryByExample(TradeSinglePaymentExample example);
}
