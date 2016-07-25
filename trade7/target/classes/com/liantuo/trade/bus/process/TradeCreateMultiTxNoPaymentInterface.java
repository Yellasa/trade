package com.liantuo.trade.bus.process;

import org.springframework.transaction.annotation.Transactional;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;

/**
 * 
 * ClassName: TradeCreateMultiTxNoPaymentInterface
 * @Description: TODO 可以自行增加需要的获取成员变量的方法
 * @author zzd
 * @date 2016-4-20
 */
public interface TradeCreateMultiTxNoPaymentInterface<B extends TradeRequestBody> {

	/**
	 * 
	 * @Description: 格式，业务校验
	 * @return void  
	 * @throws
	 * @date 2016-4-20
	 */
	void validate(TradeRequest<B> tradeRquest) throws Exception;
	
	
	/**
	 * 创建生效外部收款台账；创建等待入账交易状态记录
	 * 事务处理
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionStep01(TradeRequest<B> tradeRquest) throws Exception;

	/**
	 * 创建交易失败记录
	 * @Description: TODO
	 * @param @param tradeRquest
	 * @param @return
	 * @param @throws Exception   
	 * @return boolean  
	 * @throws
	 * @author zzd
	 * @date 2016-4-20
	 */
	void createTradeFailRecode(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 创建补差损益台账；账务操作；创建手续费损益台账；修改交易记录
	 * 事务处理
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionStep02(TradeRequest<B> tradeRquest) throws Exception;
	
	
	
	/**
	 * 获取需要进行返回的具体实体内容
	 * @Description: TODO
	 * @param @return   
	 * @return B  
	 * @throws
	 * @author zzd
	 * @date 2016-4-20
	 */
	Object getTradeDetails();
	/**
	 * 
	 * @Title:setReqNo 
	 * @Description: 设置 交易请求编号
	 * @param reqNo 交易请求编号
	 * @return:void
	 * @author:zoran.huang
	 * @date:2016年4月28日 下午6:18:56
	 */
	void setReqNo(String reqNo);
}