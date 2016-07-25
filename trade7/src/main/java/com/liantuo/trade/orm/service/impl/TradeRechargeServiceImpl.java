package com.liantuo.trade.orm.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeRechargeMapper;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.orm.service.TradeRechargeService;
import com.liantuo.trade.spring.annotation.Page;

/**
 *
 * @author yangting
 *2016年5月11日 上午10:14:48
 */
@Service
public class TradeRechargeServiceImpl implements TradeRechargeService {
	private static Logger logger = LoggerFactory.getLogger(TradeRechargeServiceImpl.class);
	@Autowired
	private TradeRechargeMapper recharge_mapper;
	
	@Override
	public TradeRecharge createTradeForPayOfWait(TradeRecharge tradeRecharge) throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_WAIT_PAY);
		recharge_mapper.insertSelective(_tradeRecharge);
		return _tradeRecharge;
	}

	/* 更新交易记录，不变更交易状态
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#updateForPayOfWait(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge updateForPayOfWait(TradeRecharge tradeRecharge) throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		int count = recharge_mapper.updateByKeyVersionSelective(_tradeRecharge);
		if (count != 1) {
			logger.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeRecharge.getId(), tradeRecharge.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
		return _tradeRecharge;
	}
	
	/* 更新等待支付为等待入账充值交易
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#updateForEnterOfWait(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge updateForEnterOfWait(TradeRecharge tradeRecharge) throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setGmtRechargeWait(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_WAIT_ENTER);
		int count = recharge_mapper.updateByKeyVersionSelective(_tradeRecharge);
		if (count != 1) {
			logger.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeRecharge.getId(), tradeRecharge.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
		return _tradeRecharge;
	}

	/* 充值成功 修改交易
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#updateTradeSuccess(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge updateTradeSuccess(TradeRecharge tradeRecharge) throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setGmtRechargeSuccess(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_SUCCESS);
		_tradeRecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		int count = recharge_mapper.updateByKeyVersionSelective(_tradeRecharge);
		if (count != 1) {
			logger.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeRecharge.getId(), tradeRecharge.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
		return _tradeRecharge;
	}

	/* 充值失败 修改交易
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#updateTradeFail(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge updateTradeFail(TradeRecharge tradeRecharge) throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setGmtRechargeFail(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_PAY_FAIL);
		_tradeRecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		int count = recharge_mapper.updateByKeyVersionSelective(_tradeRecharge);
		if (count != 1) {
			logger.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeRecharge.getId(), tradeRecharge.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
		return _tradeRecharge;
	}

	@Override
	public TradeRecharge findTradeRecharge(TradeRechargeExample tradeRechargeExample)
			throws Exception {
		List<TradeRecharge> list = recharge_mapper.selectByExample(tradeRechargeExample);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<TradeRecharge> queryByExample(
			TradeRechargeExample tradeRechargeExample) {
		return recharge_mapper.selectByExampleWithBLOBs(tradeRechargeExample);
	}
	
	@Override
	public int selectCountByExample(TradeRechargeExample tradeRechargeExample){
		return recharge_mapper.selectCountByExample(tradeRechargeExample);
	}

	/* 创建失败交易记录
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#createTradeFailureRecode(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge createTradeFailureRecode(TradeRecharge tradeRecharge)
			throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_PAY_FAIL);
		_tradeRecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		recharge_mapper.insertSelective(_tradeRecharge);
		return _tradeRecharge;
	}


	/* 直接创建等待入账的充值交易 
	 * @see com.liantuo.trade.orm.service.TradeRechargeService#createForEnterOfWait(com.liantuo.trade.orm.pojo.TradeRecharge)
	 */
	@Override
	public TradeRecharge createForEnterOfWait(TradeRecharge tradeRecharge)
			throws Exception {
		TradeRecharge _tradeRecharge = tradeRecharge;
		_tradeRecharge.setGmtLatestModified(new Date());
		_tradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_WAIT_ENTER);//等待入账01
		_tradeRecharge.setGmtRechargeWait(new Date());
		recharge_mapper.insertSelective(_tradeRecharge);
		return _tradeRecharge;
	}
	
	@Override
	@Page
	public List<TradeRecharge> pageQueryByExample(TradeRechargeExample tradeRechargeExample,Paging page) {
		return recharge_mapper.pageQueryByExample(tradeRechargeExample);
	}

}
