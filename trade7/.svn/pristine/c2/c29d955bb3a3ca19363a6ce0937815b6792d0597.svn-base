package com.liantuo.trade.orm.service;

import java.util.List;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;

public interface TradeRechargeService {
	/**
	 * 创建等待支付充值交易
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public TradeRecharge createTradeForPayOfWait(TradeRecharge tradeRecharge) throws Exception;

	/**
	 * 更新等待支付为等待入账充值交易
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public TradeRecharge updateForEnterOfWait(TradeRecharge tradeRecharge) throws Exception;
	
	/**
	 * 
	 * @Description: 更新交易记录，不变更交易状态
	 * @param @param tradeRecharge
	 * @param @return
	 * @param @throws Exception   
	 * @return TradeRecharge  
	 * @throws
	 * @author zzd
	 * @date 2016-5-4
	 */
	public TradeRecharge updateForPayOfWait(TradeRecharge tradeRecharge) throws Exception;
	/**
	 * 
	 * @Description: 创建失败交易记录
	 * @param @param tradeRecharge
	 * @param @return
	 * @param @throws Exception   
	 * @return TradeRecharge  
	 * @throws
	 * @author zzd
	 * @date 2016-4-27
	 */
	public TradeRecharge createTradeFailureRecode(TradeRecharge tradeRecharge) throws Exception;
	
	
	/**
	 * 充值成功 修改交易
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public TradeRecharge updateTradeSuccess(TradeRecharge tradeRecharge) throws Exception;
	
	/**
	 * 充值失败 修改交易
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public TradeRecharge updateTradeFail(TradeRecharge tradeRecharge) throws Exception;
	
	/**
	 * 查询交易是否存在
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public TradeRecharge findTradeRecharge(TradeRechargeExample tradeRechargeExample) throws Exception;
	
	/**
	 * 充值交易列表查询
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	List<TradeRecharge> queryByExample(TradeRechargeExample example) ;
	
	/**
	 * 充值交易列表总记录数
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	public int selectCountByExample(TradeRechargeExample tradeRechargeExample);
	/**
	 * 
	 * @Title:createForEnterOfWait 
	 * @Description:直接创建等待入账的充值交易 
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 * @return:TradeRecharge
	 * @author:zoran.huang
	 * @date:2016年4月29日 上午9:17:04
	 */
	public TradeRecharge createForEnterOfWait(TradeRecharge tradeRecharge) throws Exception;

	
	/**
	 * 充值交易列表查询-分页
	 * @param tradeRecharge
	 * @return
	 * @throws Exception
	 */
	List<TradeRecharge> pageQueryByExample(TradeRechargeExample example,Paging page) ;
	
}
