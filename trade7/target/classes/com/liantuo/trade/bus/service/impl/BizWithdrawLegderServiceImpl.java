/**
 * 
 */
package com.liantuo.trade.bus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.liantuo.trade.bus.service.BizLegderService;
import com.liantuo.trade.bus.vo.WithdrawAlipayPayBizVO;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPay;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.seqno.IdFactory;

/**
 * @ClassName:     BizWithdrawLegderServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-1-26 上午10:40:53 
 */
@Component(value = "bizWithdrawLegderServiceImpl")
public class BizWithdrawLegderServiceImpl implements BizLegderService<TradePacketReqSingleWithdrawPay, WithdrawAlipayPayBizVO> {

	@Resource
    private TradeLedgerService tradeLedgerService;
    
    @Resource(name = "idFactoryTradeLegderLegderNo")
    private IdFactory idFactoryTradeLegderLegderNo;
    
	/* 创建提现空白台账
	 * @see com.liantuo.trade.bus.service.BizLegderService#create(com.liantuo.trade.client.trade.packet.TradePacket, com.liantuo.trade.bus.vo.ATradeBizVO)
	 */
	@Override
	public void create(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
		String ledgerno = TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code())+idFactoryTradeLegderLegderNo.generate().toString();
		trade.getReqContext().put("ledgerno", ledgerno);
		TradeLedger ledger = new TradeLedger();
        ledger.setLedgerNo(ledgerno);//业务台账编号
        ledger.setCoreMerchantNo(trade.getTradeWithdraw().getCoreMerchantNo());//核心商户编号
        ledger.setFundPoolNo(trade.getTradeWithdraw().getFundPoolNo());//资金池编号
        
        ledger.setMerchantExtendField1(tradePacket.getBody().getMerchant_extend_field_1());//业务台账客户保留字段1
        ledger.setMerchantExtendField2(tradePacket.getBody().getMerchant_extend_field_2());
        ledger.setMerchantExtendField3(tradePacket.getBody().getMerchant_extend_field_3());
        ledger.setMerchantExtendField4("");
        ledger.setMerchantExtendField5("");
        
        ledger.setTradeType(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code())); // 所属业务交易类型（例：0002_001）
        ledger.setTradeNo(trade.getTradeWithdraw().getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(trade.getTradeWithdraw().getGmtCreated()); // 所属业务交易创建日期

        ledger.setCreateReqType(tradePacket.getBusHead().getRequest_code());//创建交易请求类型
        ledger.setCreateReqNo(trade.getReqContext().getReq().getReqNo());//创建交易请求编号
        if(!StringUtils.isEmpty(trade.getTradeWithdraw().getOutTradeNo())){
        	ledger.setOutTradeNo(trade.getTradeWithdraw().getOutTradeNo()); // 交易发起方业务系统订单号
        }
        ledger.setOutTradeNoExt(trade.getTradeWithdraw().getOutTradeNoExt()); // 交易发起方发起请求ID
        ledger.setStatus(TradeConstants.LEDGER_STATUS_INIT); // 台账状态（00：新建 01生效）
        ledger.setClearChannel(TradeConstants.WITHDRAW_ALIPAY_TRADE_TYPE);//收付款渠道编号
        
        ledger.setExtendField1(tradePacket.getBody().getPay_transaction_id());//收付款备注1,来自输入【出款渠道身份编号】
        ledger.setExtendField2(tradePacket.getBody().getPayer_account());//收付款备注2,来自输入【付款方账户】
        ledger.setExtendField3(tradePacket.getBody().getPayer_name());//收付款备注3,来自输入【付款方账户名称】
        ledger.setExtendField4((String) trade.getReqContext().get("batch_no"));//收付款备注4,来自系统生成【提交支付宝批量付款批次号】
        ledger.setExtendField5((String) trade.getReqContext().get("serial_number"));//收付款备注5,来自系统生成【提交支付宝批量付款批次流水号】
       
        ledger.setPaymentAmount(trade.getTradeWithdraw().getWithdrawAmount());//付款金额
        this.tradeLedgerService.insertTradeLedgerBlank(ledger);
        trade.setLedger(ledger);
		
	}

}
