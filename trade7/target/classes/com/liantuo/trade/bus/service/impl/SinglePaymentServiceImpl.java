package com.liantuo.trade.bus.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentLogMapper;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentMapper;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentLog;
import com.liantuo.trade.spring.annotation.Page;
@Service("singlePaymentServiceImpl")
public class SinglePaymentServiceImpl implements SinglePaymentService {
	private final Log LOG4J = LogFactory.getLog("trade");
	@Autowired
	private TradeSinglePaymentMapper paymentMapper;
	@Autowired
	private TradeSinglePaymentLogMapper paymentLogMapper;
	
	@Override
	public TradeSinglePayment createTradeForPayOfSuccess(TradeSinglePayment tradePayment)
			throws Exception {
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_SUCCESS);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_INNER );
		tradePayment.setVersion(0);
		Date date = new Date();
		tradePayment.setGmtCreated(date);
		tradePayment.setGmtModifiedLatest(date);
		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_OPEN);
		System.out.println(Thread.currentThread().getName() +"     "+ tradePayment.getTradeNo());
		paymentMapper.insertSelective(tradePayment);
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}

	private TradeSinglePayment insertTradeLog(TradeSinglePayment tradePayment) {
		TradeSinglePaymentExample example = new TradeSinglePaymentExample();
		example.createCriteria().andTradeNoEqualTo(tradePayment.getTradeNo());
		List<TradeSinglePayment> list = paymentMapper.selectByExample(example);
		TradeSinglePayment _tradePayment = new TradeSinglePayment();
		if(list != null){
			_tradePayment = list.get(0);
		}
		TradeSinglePaymentLog paymentLog = new TradeSinglePaymentLog();
		BeanUtils.copyProperties(_tradePayment, paymentLog);
		paymentLog.setId(null);
		paymentLogMapper.insertSelective(paymentLog);
		return _tradePayment;
	}

	/**
	 * 等地入账
	 */
	public TradeSinglePayment createForEnterOfWait(TradeSinglePayment tradePayment) throws Exception{
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_WAIT_ENTER);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
		tradePayment.setVersion(0);
		Date date = new Date();
		tradePayment.setGmtCreated(date);
		tradePayment.setGmtModifiedLatest(date);
		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_OPEN);
		paymentMapper.insertSelective(tradePayment);
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}
	
	/**
	 * 等待支付
	 */
	public TradeSinglePayment createForPayOfWait(TradeSinglePayment tradePayment) throws Exception{
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_WAIT_PAY);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
		tradePayment.setVersion(0);
		Date date = new Date();
		tradePayment.setGmtCreated(date);
		tradePayment.setGmtModifiedLatest(date);
		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_OPEN);
		paymentMapper.insertSelective(tradePayment);
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}

	@Override
	public TradeSinglePayment createTradeFailureRecode(
			TradeSinglePayment tradePayment) throws Exception {
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_PAY_FAIL);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_INNER );
		tradePayment.setVersion(0);
		Date date = new Date();
		tradePayment.setGmtCreated(date);
		tradePayment.setGmtModifiedLatest(date);
		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_END);
		paymentMapper.insertSelective(tradePayment);
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}
	
	@Override
	public TradeSinglePayment updateTradeFail(TradeSinglePayment tradePayment)
			throws Exception {
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_PAY_FAIL);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_END);
		tradePayment.setGmtModifiedLatest(new Date());
		int result = paymentMapper.updateByKeyVersionSelective(tradePayment);
		if(result != 1){
			LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", tradePayment.getId(), tradePayment.getVersion()));
			throw new BizRuntimeException("trade.status.update.error");
		}
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}

	@Override
	public TradeSinglePayment updateTradeSuccess(
			TradeSinglePayment tradePayment) throws Exception {
		tradePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradePayment.setStatus(TradeConstants.TRADE_PAYMENT_SUCCESS);
		tradePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
//		tradePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_END);
		tradePayment.setGmtModifiedLatest(new Date());
		int result = paymentMapper.updateByKeyVersionSelective(tradePayment);
		if(result != 1){
			LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", tradePayment.getId(), tradePayment.getVersion()));
			throw new BizRuntimeException("trade.status.update.error");
		}
		TradeSinglePayment _tradePayment = insertTradeLog(tradePayment);
		return _tradePayment;
	}

	@Override
	public List<TradeSinglePayment> queryByExample(
			TradeSinglePaymentExample example) {
		return paymentMapper.selectByExample(example);
	}

	@Override
	public TradeSinglePayment queryByTradeNo(String tradeNo) {
		TradeSinglePaymentExample example = new TradeSinglePaymentExample();
		example.createCriteria().andTradeNoEqualTo(tradeNo);
		List<TradeSinglePayment> list = paymentMapper.selectByExample(example);
		if(list != null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public TradeSinglePayment updateTrade(TradeSinglePayment tradeSinglePayment)
			throws Exception {
		tradeSinglePayment.setGmtModifiedLatest(new Date());
		int result = paymentMapper.updateByKeyVersionSelective(tradeSinglePayment);
		if(result != 1){
			LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeSinglePayment.getId(), tradeSinglePayment.getVersion()));
			throw new BizRuntimeException("trade.status.update.error");
		}
		TradeSinglePayment _tradePayment = insertTradeLog(tradeSinglePayment);
		return _tradePayment;
	}

	@Override
	public TradeSinglePayment createOuterTradeFailureRecode(TradeSinglePayment tradeSinglePayment) throws Exception {
		tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_PAY_FAIL);
		tradeSinglePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD );
		tradeSinglePayment.setVersion(0);
		Date date = new Date();
		tradeSinglePayment.setGmtCreated(date);
		tradeSinglePayment.setGmtModifiedLatest(date);
		tradeSinglePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_END);
		paymentMapper.insertSelective(tradeSinglePayment);
		TradeSinglePayment _tradePayment = insertTradeLog(tradeSinglePayment);
		return _tradePayment;
	}

	@Override
	@Page
	public List<TradeSinglePayment> pageQueryByExample(TradeSinglePaymentExample example) {
		return paymentMapper.selectByExample(example);
	}

	@Override
	public int selectCountByExample(TradeSinglePaymentExample example) {
		return paymentMapper.selectCountByExample(example);
	}

	

}
