package com.liantuo.trade.orm.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentLogMapper;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentMapper;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentRefundLogMapper;
import com.liantuo.trade.orm.mapper.TradeSinglePaymentRefundMapper;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentLog;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefund;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundLog;
import com.liantuo.trade.orm.pojo.subvo.TradeSinglePaymentRefundVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class Mapper006Test {
	@Autowired 
	private TradeSinglePaymentMapper tradeSinglePaymentMapper;
	@Autowired 
	private TradeSinglePaymentLogMapper tradeSinglePaymentLogMapper;
	@Autowired 
	private TradeSinglePaymentRefundMapper tradeSinglePaymentRefundMapper;
	@Autowired 
	private TradeSinglePaymentRefundLogMapper tradeSinglePaymentRefundLogMapper;
	@Test
	public void testTradeSinglePayment(){
		try {
			TradeSinglePayment payment = new TradeSinglePayment();
			//合作商户编号
		    payment.setPartnerId("partnerId");
//		    payment.setId(1l);
		    //交易编号，必填，全局所有交易不重复
		    payment.setTradeNo("tradeNo");

		    //核心商户编号
		    payment.setCoreMerchantNo("coreMerchantNo");

		    //资金池编号
		    payment.setFundPoolNo("fundPoolNo");

		    //原交易编号
		    payment.setOriginalTradeNo("originalTradeNo");

		    //交易发起方发起请求编号
		    payment.setOutTradeNoExt("outTradeNoExt");

		    //交易发起方业务系统订单号
		    payment.setOutTradeNo("outTradeNo");

		    //交易创建日期时间
		    payment.setGmtCreated(new Date());

		    //最后变更日期时间
		    payment.setGmtModifiedLatest(new Date());

		    //最后变更交易请求类型
		    payment.setLatestTradeReqType("1");

		    //最后变更交易请求编号
		    payment.setLatestReqNo("latestReqNo");

		    //交易结束状态(已结束、未结束)
		    payment.setCloseStatus("1");

		    //交易状态(支付失败，等待付款，等待入账，等待退回，支付退回,支付成功,异常终止)
		    payment.setStatus("0");

		    //交易组别(【1】内部支付，【2】外部支付)
		    payment.setTradeCatagory("0");

		    //交易版本
		    payment.setVersion(0);

		    //异步通知地址
		    payment.setNotifyUrl("notifyUrl");

		    //交易客户保留字段1
		    payment.setMerchantExtendField1("merchantExtendField1");

		    //交易客户保留字段2
		    payment.setMerchantExtendField2("merchantExtendField2");

		    //交易客户保留字段3
		    payment.setMerchantExtendField3("merchantExtendField3");

		    //交易客户保留字段4
		    payment.setMerchantExtendField4("merchantExtendField4");

		    //交易客户保留字段5
		    payment.setMerchantExtendField5("merchantExtendField5");

		    //交易客户保留字段6
		    payment.setMerchantExtendField6("merchantExtendField6");

		    //交易客户保留字段7
		    payment.setMerchantExtendField7("merchantExtendField7");

		    //交易客户保留字段8
		    payment.setMerchantExtendField8("merchantExtendField8");

		    //交易客户保留字段9
		    payment.setMerchantExtendField9("merchantExtendField9");

		    //交易客户保留字段10
		    payment.setMerchantExtendField10("merchantExtendField10");

		    //支付失败日期时间
		    payment.setGmtFailPay(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitPay(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitInAccountting(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitRefund(new Date());

		    //支付退回日期时间
		    payment.setGmtRefundPay(new Date());

		    //支付成功日期时间
		    payment.setGmtSuccessPay(new Date());

		    //异常终止日期时间
		    payment.setGmtAbortUnexcepted(new Date());

		    //付款方付出金额
		    payment.setPayAmt(100l);

		    //付款方付出方式
		    payment.setPayType("1");

		    //付款方同步支付链接
		    payment.setPayUrl("payUrl");

		    //付款方外部业务台账编号
		    payment.setExternalPayLedgerNo("externalPayLedgerNo");

		    //付款方外部收付款渠道编号，用于户客户自己区分不同的收付款渠道
		    payment.setExternalPayChannel("pc");

		    //(付出方外部部分)付出手续费金额
		    payment.setExternalPayChannelFeeAmt(1l);

		    //(付出方外部部分)退回手续费金额
		    payment.setExternalPayChannelRefundFeeAmt(1l);

		    //提交第三方批次号
		    payment.setExternalPayChannelBatchNo("bn");

		    //提交第三方请求流水号
		    payment.setExternalPayChannelSerialNo("sn");

		    //付款方外部收款金额
		    payment.setExternalPayReceivedAmt(1l);

		    //付款方外部渠道收付款成功日期时间
		    payment.setGmtSuccessExternalPayChannel(new Date());

		    //付款方外部收付款渠道订单号
		    payment.setExternalPayChannelTradeNo("TradeNo");

		    //付款方损益业务台账编号
		    payment.setPayProfitLossLedgerNo("payProfitLossLedgerNo");

		    //付款方损益收入减少金额
		    payment.setPayProfitLossIncomeDecr(1l);

		    //付款方损益成本费用增加金额
		    payment.setPayProfitLossCostIncr(1l);

		    //付款方账户账户编号
		    payment.setPayAccountNo("payAccountNo");

		    //付款方账户所属商户编号
		    payment.setPayAccountMerchantNo("payAccountMerchantNo");

		    //付款方账户出账金额
		    payment.setPayAccountOutAccountingAmt(1l);

		    //付款方账户出账子账户类型
		    payment.setPayAccountOutAccountingType("1");

		    //付款方账户出账账务历史1
		    payment.setPayAccountOutAccountingHis1("ngHis1");

		    //付款方账户出账账务历史2
		    payment.setPayAccountOutAccountingHis2("untingHis2");

		    //付款方账户出账账务历史2
		    payment.setPayAccountOutAccountingHis3("ingHis3");

		    //付款方账户入账子账户类型
		    payment.setPayAccountInAccountingType("1");

		    //付款方账户入账账务历史1
		    payment.setPayAccountInAccountingHis1("His1");

		    //付款方账户入账账务历史2
		    payment.setPayAccountInAccountingHis2("gHis2");

		    //付款方账户入账账务历史1
		    payment.setPayAccountInAccountingHis3("InAccountingHis3");

		    //付款方手续费账户账户编号
		    payment.setPayFeeAccountNo("payFeeAccountNo");

		    //付款方手续费账户所属商户编号
		    payment.setPayFeeAccountMerchantNo("payFeeAccountMerchantNo");

		    //付款方手续费账户出账金额
		    payment.setPayFeeAccountOutAccountingAmt(1l);

		    //付款方手续费账户出账子账户类型
		    payment.setPayFeeAccountOutAccountingType("1");

		    //付款方手续费账户出账账务历史1
		    payment.setPayFeeAccountOutAccountingHis1("ngHis1");

		    //付款方手续费账户出账账务历史1
		    payment.setPayFeeAccountOutAccountingHis2("His2");

		    //付款方手续费账户出账账务历史3
		    payment.setPayFeeAccountOutAccountingHis3("His3");

		    //收款方收到金额
		    payment.setReceiveAmt(1l);

		    //收款方收到方式
		    payment.setReceiveType("1");

		    //收款方损益业务台账编号
		    payment.setReceiveProfitLossLedgerNo("receiveProfitLossLedgerNo");

		    //收款方损益收入增加金额
		    payment.setReceiveProfitLossIncomeIncr(1l);

		    //收款方损益成本费用减少金额
		    payment.setReceiveProfitLossCostDecr(1l);

		    //收款方账户账户编号
		    payment.setReceiveAccountNo("receiveAccountNo");

		    //收款方账户所属商户编号
		    payment.setReceiveAccountMerchantNo("receiveAccountMerchantNo");

		    //收款方账户入账金额
		    payment.setReceiveAccountInAccountingAmt(1l);

		    //收款方账户入账子账户类型
		    payment.setReceiveAccountInAccountingType("1");

		    //收款方账户入账账务历史1
		    payment.setReceiveAccountInAccountingHis1("raiahis1");

		    //收款方账户入账账务历史2
		    payment.setReceiveAccountInAccountingHis2("raiahis2");

		    //收款方账户入账账务历史3
		    payment.setReceiveAccountInAccountingHis3("receiveAccountInAccountingHis3");

		    //收款方手续费账户账户编号
		    payment.setReceiveFeeAccountNo("receiveFeeAccountNo");

		    //收款方手续费账户所属商户编号
		    payment.setReceiveFeeAccountMerchantNo("ReceiveFeeAccountMerchantNo");

		    //收款方手续费账户出账金额
		    payment.setReceiveFeeAccountOutAccountingAmt(1l);

		    //收款方手续费账户出账子账户类型
		    payment.setReceiveFeeAccountOutAccountingType("1");

		    //收款方手续费账户出账账务历史1
		    payment.setReceiveFeeAccountOutAccountingHis1("his1");

		    //收款方手续费账户出账账务历史1
		    payment.setReceiveFeeAccountOutAccountingHis2("his2");

		    //收款方手续费账户出账账务历史3
		    payment.setReceiveFeeAccountOutAccountingHis3("receiveFeeAccountOutAccountingHis3");

		    //付款方退回付出方式
		    payment.setRefundPayType("1");

		    //付款方退回外部业务台账编号
		    payment.setExternalRefundLedgerNo("externalRefundLedgerNo");

		    //付款方退回外部收付款渠道编号
		    payment.setExternalRefundChannel("externalRefundChannel");

		    //付款方退回外部收付款属性1（付出手续费金额）
		    payment.setExternalRefundChannelPayAmt(1l);

		    //付款方退回外部收付款属性2（退回手续费金额）
		    payment.setExternalRefundChannelRefundFeeAmt(1l);

		    //付款方退回外部付款金额
		    payment.setExternalRefundAmt(1l);

		    //付款方退回外部渠道收付款成功日期时间
		    payment.setGmtSuccessRefundExternalPayChannel(new Date());

		    //付款方退回外部收付款渠道订单号
		    payment.setExternalRefundChannelTradeNo("externalRefundChannelTradeNo");

		    //付款方外部收付款备注4【提交第三方批次号】
		    payment.setExternalRefundChannelBatchNo("externalRefundChannelBatchNo");

		    //付款方外部收付款备注5【提交第三方请求流水号】
		    payment.setExternalRefundChannelSerialNo("externalRefundChannelSerialNo");

		    //付款方退回损益业务台账编号
		    payment.setRefundPayProfitLossLedgerNo("refundPayProfitLossLedgerNo");

		    //付款方退回损益收入增加金额
		    payment.setRefundPayProfitLossIncomeIncr(1l);

		    //付款方退回损益成本费用减少金额
		    payment.setRefundPayProfitLossCostDecr(1l);

		    //付款方退回账户账户编号
		    payment.setRefundPayAccountNo("refundPayAccountNo");

		    //付款方退回账户所属商户编号
		    payment.setRefundPayMerchantNo("refundPayMerchantNo");

		    //付款方退回账户入账金额
		    payment.setRefundPayInAccountingAmt(1l);

		    //付款方退回账户出账子账户类型
		    payment.setRefundPayOutAccountingType("1");

		    //付款方退回账户出账账务历史1
		    payment.setRefundPayOutAccountingHis1("his1");

		    //付款方退回账户出账账务历史3
		    payment.setRefundPayOutAccountingHis2("his2");

		    //付款方退回账户出账账务历史3
		    payment.setRefundPayOutAccountingHis3("refundPayOutAccountingHis3");

		    //付款方退回账户入账子账户类型
		    payment.setRefundPayInAccountingType("1");

		    //付款方退回账户入账账务历史1
		    payment.setRefundPayInAccountingHis1("his1");

		    //付款方退回账户入账账务历史2
		    payment.setRefundPayInAccountingHis2("his2");

		    //付款方退回账户入账账务历史3
		    payment.setRefundPayInAccountingHis3("refundPayInAccountingHis3");

		    //付出方冻结余额
		    payment.setPayFreezeBal(1l);

		    //收到方冻结余额
		    payment.setReceiveFreezeBal(1l);

		    //累计收款方退款金额
		    payment.setSumRefundedReceiveAccountAmt(1l);

		    //累计付款方账户手续费退回金额
		    payment.setSumRefundedPayFeeAccountAmt(1l);

		    //累计收款方账户手续费退回金额
		    payment.setSumRefundedReceiveFeeAccountAmt(1l);

		    //累计付款方账户出账退回金额
		    payment.setSumRefundedPayAccountOutAccountingAmt(1l);

		    //累计付款方台账退回金额
		    payment.setSumRefundedPayLedgerAmt(1l);

		    //累计补充支付金额
		    payment.setSumSuppliedAmt(1l);

		    //累计补充支付退款金额
		    payment.setSumRefundedSupplyRefundAmt(1l);

		    //累计分账金额
		    payment.setSumDistributedRoyaltyAmt(1l);

		    //累计分账退款金额
		    payment.setSumRefundedDistributedRoyaltyAmt(1l);

		    //后续交易开关(允许，禁止)
		    payment.setContinueTradeStatus("2");

		    //交易扩展字段1
		    payment.setTradeExtendField1("tradeExtendField1");

		    //交易扩展字段2
		    payment.setTradeExtendField2("tradeExtendField2");

		    //交易扩展字段3
		    payment.setTradeExtendField3("tradeExtendField3");

		    //交易扩展字段4
		    payment.setTradeExtendField4("tradeExtendField4");

		    //交易扩展字段5
		    payment.setTradeExtendField5("tradeExtendField5");

		    //交易扩展字段6
		    payment.setTradeExtendField6("tradeExtendField6");

		    //交易扩展字段7
		    payment.setTradeExtendField7("tradeExtendField7");

		    //交易扩展字段8
		    payment.setTradeExtendField8("tradeExtendField8");

		    //交易扩展字段9
		    payment.setTradeExtendField9("tradeExtendField9");

		    //交易扩展字段10
		    payment.setTradeExtendField10("tradeExtendField10");

		    //其他损益台账List，保存对应损益台账表集合数据（json）
		    payment.setExtendProfitLoss("extendProfitLoss");
//		    tradeSinglePaymentMapper.insertSelective(payment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testTradeSinglePaymentLogMapper(){
		try {
			System.out.println(tradeSinglePaymentLogMapper);
			TradeSinglePaymentLog payment = new TradeSinglePaymentLog();
			//合作商户编号
		    payment.setPartnerId("partnerId");
//		    payment.setId(1l);
		    //交易编号，必填，全局所有交易不重复
		    payment.setTradeNo("tradeNo");

		    //核心商户编号
		    payment.setCoreMerchantNo("coreMerchantNo");

		    //资金池编号
		    payment.setFundPoolNo("fundPoolNo");

		    //原交易编号
		    payment.setOriginalTradeNo("originalTradeNo");

		    //交易发起方发起请求编号
		    payment.setOutTradeNoExt("outTradeNoExt");

		    //交易发起方业务系统订单号
		    payment.setOutTradeNo("outTradeNo");

		    //交易创建日期时间
		    payment.setGmtCreated(new Date());

		    //最后变更日期时间
		    payment.setGmtModifiedLatest(new Date());

		    //最后变更交易请求类型
		    payment.setLatestTradeReqType("1");

		    //最后变更交易请求编号
		    payment.setLatestReqNo("latestReqNo");

		    //交易结束状态(已结束、未结束)
		    payment.setCloseStatus("1");

		    //交易状态(支付失败，等待付款，等待入账，等待退回，支付退回,支付成功,异常终止)
		    payment.setStatus("0");

		    //交易组别(【1】内部支付，【2】外部支付)
		    payment.setTradeCatagory("0");

		    //交易版本
		    payment.setVersion(0);

		    //异步通知地址
		    payment.setNotifyUrl("notifyUrl");

		    //交易客户保留字段1
		    payment.setMerchantExtendField1("merchantExtendField1");

		    //交易客户保留字段2
		    payment.setMerchantExtendField2("merchantExtendField2");

		    //交易客户保留字段3
		    payment.setMerchantExtendField3("merchantExtendField3");

		    //交易客户保留字段4
		    payment.setMerchantExtendField4("merchantExtendField4");

		    //交易客户保留字段5
		    payment.setMerchantExtendField5("merchantExtendField5");

		    //交易客户保留字段6
		    payment.setMerchantExtendField6("merchantExtendField6");

		    //交易客户保留字段7
		    payment.setMerchantExtendField7("merchantExtendField7");

		    //交易客户保留字段8
		    payment.setMerchantExtendField8("merchantExtendField8");

		    //交易客户保留字段9
		    payment.setMerchantExtendField9("merchantExtendField9");

		    //交易客户保留字段10
		    payment.setMerchantExtendField10("merchantExtendField10");

		    //支付失败日期时间
		    payment.setGmtFailPay(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitPay(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitInAccountting(new Date());

		    //支付失败日期时间
		    payment.setGmtWaitRefund(new Date());

		    //支付退回日期时间
		    payment.setGmtRefundPay(new Date());

		    //支付成功日期时间
		    payment.setGmtSuccessPay(new Date());

		    //异常终止日期时间
		    payment.setGmtAbortUnexcepted(new Date());

		    //付款方付出金额
		    payment.setPayAmt(100l);

		    //付款方付出方式
		    payment.setPayType("1");

		    //付款方同步支付链接
		    payment.setPayUrl("payUrl");

		    //付款方外部业务台账编号
		    payment.setExternalPayLedgerNo("externalPayLedgerNo");

		    //付款方外部收付款渠道编号，用于户客户自己区分不同的收付款渠道
		    payment.setExternalPayChannel("pc");

		    //(付出方外部部分)付出手续费金额
		    payment.setExternalPayChannelFeeAmt(1l);

		    //(付出方外部部分)退回手续费金额
		    payment.setExternalPayChannelRefundFeeAmt(1l);

		    //提交第三方批次号
		    payment.setExternalPayChannelBatchNo("bn");

		    //提交第三方请求流水号
		    payment.setExternalPayChannelSerialNo("sn");

		    //付款方外部收款金额
		    payment.setExternalPayReceivedAmt(1l);

		    //付款方外部渠道收付款成功日期时间
		    payment.setGmtSuccessExternalPayChannel(new Date());

		    //付款方外部收付款渠道订单号
		    payment.setExternalPayChannelTradeNo("TradeNo");

		    //付款方损益业务台账编号
		    payment.setPayProfitLossLedgerNo("payProfitLossLedgerNo");

		    //付款方损益收入减少金额
		    payment.setPayProfitLossIncomeDecr(1l);

		    //付款方损益成本费用增加金额
		    payment.setPayProfitLossCostIncr(1l);

		    //付款方账户账户编号
		    payment.setPayAccountNo("payAccountNo");

		    //付款方账户所属商户编号
		    payment.setPayAccountMerchantNo("payAccountMerchantNo");

		    //付款方账户出账金额
		    payment.setPayAccountOutAccountingAmt(1l);

		    //付款方账户出账子账户类型
		    payment.setPayAccountOutAccountingType("1");

		    //付款方账户出账账务历史1
		    payment.setPayAccountOutAccountingHis1("ngHis1");

		    //付款方账户出账账务历史2
		    payment.setPayAccountOutAccountingHis2("untingHis2");

		    //付款方账户出账账务历史2
		    payment.setPayAccountOutAccountingHis3("ingHis3");

		    //付款方账户入账子账户类型
		    payment.setPayAccountInAccountingType("1");

		    //付款方账户入账账务历史1
		    payment.setPayAccountInAccountingHis1("His1");

		    //付款方账户入账账务历史2
		    payment.setPayAccountInAccountingHis2("gHis2");

		    //付款方账户入账账务历史1
		    payment.setPayAccountInAccountingHis3("InAccountingHis3");

		    //付款方手续费账户账户编号
		    payment.setPayFeeAccountNo("payFeeAccountNo");

		    //付款方手续费账户所属商户编号
		    payment.setPayFeeAccountMerchantNo("payFeeAccountMerchantNo");

		    //付款方手续费账户出账金额
		    payment.setPayFeeAccountOutAccountingAmt(1l);

		    //付款方手续费账户出账子账户类型
		    payment.setPayFeeAccountOutAccountingType("1");

		    //付款方手续费账户出账账务历史1
		    payment.setPayFeeAccountOutAccountingHis1("ngHis1");

		    //付款方手续费账户出账账务历史1
		    payment.setPayFeeAccountOutAccountingHis2("His2");

		    //付款方手续费账户出账账务历史3
		    payment.setPayFeeAccountOutAccountingHis3("His3");

		    //收款方收到金额
		    payment.setReceiveAmt(1l);

		    //收款方收到方式
		    payment.setReceiveType("1");

		    //收款方损益业务台账编号
		    payment.setReceiveProfitLossLedgerNo("receiveProfitLossLedgerNo");

		    //收款方损益收入增加金额
		    payment.setReceiveProfitLossIncomeIncr(1l);

		    //收款方损益成本费用减少金额
		    payment.setReceiveProfitLossCostDecr(1l);

		    //收款方账户账户编号
		    payment.setReceiveAccountNo("receiveAccountNo");

		    //收款方账户所属商户编号
		    payment.setReceiveAccountMerchantNo("receiveAccountMerchantNo");

		    //收款方账户入账金额
		    payment.setReceiveAccountInAccountingAmt(1l);

		    //收款方账户入账子账户类型
		    payment.setReceiveAccountInAccountingType("1");

		    //收款方账户入账账务历史1
		    payment.setReceiveAccountInAccountingHis1("raiahis1");

		    //收款方账户入账账务历史2
		    payment.setReceiveAccountInAccountingHis2("raiahis2");

		    //收款方账户入账账务历史3
		    payment.setReceiveAccountInAccountingHis3("receiveAccountInAccountingHis3");

		    //收款方手续费账户账户编号
		    payment.setReceiveFeeAccountNo("receiveFeeAccountNo");

		    //收款方手续费账户所属商户编号
		    payment.setReceiveFeeAccountMerchantNo("ReceiveFeeAccountMerchantNo");

		    //收款方手续费账户出账金额
		    payment.setReceiveFeeAccountOutAccountingAmt(1l);

		    //收款方手续费账户出账子账户类型
		    payment.setReceiveFeeAccountOutAccountingType("1");

		    //收款方手续费账户出账账务历史1
		    payment.setReceiveFeeAccountOutAccountingHis1("his1");

		    //收款方手续费账户出账账务历史1
		    payment.setReceiveFeeAccountOutAccountingHis2("his2");

		    //收款方手续费账户出账账务历史3
		    payment.setReceiveFeeAccountOutAccountingHis3("receiveFeeAccountOutAccountingHis3");

		    //付款方退回付出方式
		    payment.setRefundPayType("1");

		    //付款方退回外部业务台账编号
		    payment.setExternalRefundLedgerNo("externalRefundLedgerNo");

		    //付款方退回外部收付款渠道编号
		    payment.setExternalRefundChannel("externalRefundChannel");

		    //付款方退回外部收付款属性1（付出手续费金额）
		    payment.setExternalRefundChannelPayAmt(1l);

		    //付款方退回外部收付款属性2（退回手续费金额）
		    payment.setExternalRefundChannelRefundFeeAmt(1l);

		    //付款方退回外部付款金额
		    payment.setExternalRefundAmt(1l);

		    //付款方退回外部渠道收付款成功日期时间
		    payment.setGmtSuccessRefundExternalPayChannel(new Date());

		    //付款方退回外部收付款渠道订单号
		    payment.setExternalRefundChannelTradeNo("externalRefundChannelTradeNo");

		    //付款方外部收付款备注4【提交第三方批次号】
		    payment.setExternalRefundChannelBatchNo("externalRefundChannelBatchNo");

		    //付款方外部收付款备注5【提交第三方请求流水号】
		    payment.setExternalRefundChannelSerialNo("externalRefundChannelSerialNo");

		    //付款方退回损益业务台账编号
		    payment.setRefundPayProfitLossLedgerNo("refundPayProfitLossLedgerNo");

		    //付款方退回损益收入增加金额
		    payment.setRefundPayProfitLossIncomeIncr(1l);

		    //付款方退回损益成本费用减少金额
		    payment.setRefundPayProfitLossCostDecr(1l);

		    //付款方退回账户账户编号
		    payment.setRefundPayAccountNo("refundPayAccountNo");

		    //付款方退回账户所属商户编号
		    payment.setRefundPayMerchantNo("refundPayMerchantNo");

		    //付款方退回账户入账金额
		    payment.setRefundPayInAccountingAmt(1l);

		    //付款方退回账户出账子账户类型
		    payment.setRefundPayOutAccountingType("1");

		    //付款方退回账户出账账务历史1
		    payment.setRefundPayOutAccountingHis1("his1");

		    //付款方退回账户出账账务历史3
		    payment.setRefundPayOutAccountingHis2("his2");

		    //付款方退回账户出账账务历史3
		    payment.setRefundPayOutAccountingHis3("refundPayOutAccountingHis3");

		    //付款方退回账户入账子账户类型
		    payment.setRefundPayInAccountingType("1");

		    //付款方退回账户入账账务历史1
		    payment.setRefundPayInAccountingHis1("his1");

		    //付款方退回账户入账账务历史2
		    payment.setRefundPayInAccountingHis2("his2");

		    //付款方退回账户入账账务历史3
		    payment.setRefundPayInAccountingHis3("refundPayInAccountingHis3");

		    //付出方冻结余额
		    payment.setPayFreezeBal(1l);

		    //收到方冻结余额
		    payment.setReceiveFreezeBal(1l);

		    //累计收款方退款金额
		    payment.setSumRefundedReceiveAccountAmt(1l);

		    //累计付款方账户手续费退回金额
		    payment.setSumRefundedPayFeeAccountAmt(1l);

		    //累计收款方账户手续费退回金额
		    payment.setSumRefundedReceiveFeeAccountAmt(1l);

		    //累计付款方账户出账退回金额
		    payment.setSumRefundedPayAccountOutAccountingAmt(1l);

		    //累计付款方台账退回金额
		    payment.setSumRefundedPayLedgerAmt(1l);

		    //累计补充支付金额
		    payment.setSumSuppliedAmt(1l);

		    //累计补充支付退款金额
		    payment.setSumRefundedSupplyRefundAmt(1l);

		    //累计分账金额
		    payment.setSumDistributedRoyaltyAmt(1l);

		    //累计分账退款金额
		    payment.setSumRefundedDistributedRoyaltyAmt(1l);

		    //后续交易开关(允许，禁止)
		    payment.setContinueTradeStatus("2");

		    //交易扩展字段1
		    payment.setTradeExtendField1("tradeExtendField1");

		    //交易扩展字段2
		    payment.setTradeExtendField2("tradeExtendField2");

		    //交易扩展字段3
		    payment.setTradeExtendField3("tradeExtendField3");

		    //交易扩展字段4
		    payment.setTradeExtendField4("tradeExtendField4");

		    //交易扩展字段5
		    payment.setTradeExtendField5("tradeExtendField5");

		    //交易扩展字段6
		    payment.setTradeExtendField6("tradeExtendField6");

		    //交易扩展字段7
		    payment.setTradeExtendField7("tradeExtendField7");

		    //交易扩展字段8
		    payment.setTradeExtendField8("tradeExtendField8");

		    //交易扩展字段9
		    payment.setTradeExtendField9("tradeExtendField9");

		    //交易扩展字段10
		    payment.setTradeExtendField10("tradeExtendField10");

		    //其他损益台账List，保存对应损益台账表集合数据（json）
		    payment.setExtendProfitLoss("extendProfitLoss");
//		    tradeSinglePaymentLogMapper.insertSelective(payment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testTradeSinglePaymentRefund(){
		try {
			System.out.println(tradeSinglePaymentRefundMapper);
			TradeSinglePaymentRefund refund = new TradeSinglePaymentRefund();
			 //主键为属性
		    refund.setId(3l);

		    //交易编号
		    refund.setTradeNo("tradeNo");

		    //核心商户编号
		    refund.setCoreMerchantNo("coreMerchantNo");

		    //资金池编号
		    refund.setFundPoolNo("fundPoolNo");

		    //合作商户编号
		    refund.setPartnerId("partnerId");

		    //原交易编号
		    refund.setOriginalTradeNo("originalTradeNo");

		    //交易发起方发起请求编号
		    refund.setOutTradeNoExt("outTradeNoExt");

		    //交易发起方业务系统订单号
		    refund.setOutTradeNo("outTradeNo");

		    //交易创建日期时间
		    refund.setGmtCreated(new Date());

		    //最后变更日期时间
		    refund.setGmtModifiedLatest(new Date());

		    //最后变更交易请求类型
		    refund.setLatestTradeReqType("latestTradeReqType");

		    //最后变更交易请求编号
		    refund.setLatestReqNo("latestReqNo");

		    //交易结束状态
		    refund.setCloseStatus("1");

		    //交易状态
		    refund.setStatus("1");

		    //交易组别
		    refund.setTradeCatatory("1");

		    //交易版本
		    refund.setVersion(0);

		    //异步通知地址
		    refund.setNotifyUrl("notifyUrl");

		    //交易客户保留字段1
		    refund.setMerchantExtendField1("merchantExtendField1");

		    //交易客户保留字段2
		    refund.setMerchantExtendField2("merchantExtendField2");

		    //交易客户保留字段2
		    refund.setMerchantExtendField3("merchantExtendField3");

		    //交易客户保留字段4
		    refund.setMerchantExtendField4("erchantExtendField4");

		    //交易客户保留字段5
		    refund.setMerchantExtendField5("merchantExtendField5");

		    //交易客户保留字段6
		    refund.setMerchantExtendField6("merchantExtendField6");

		    //交易客户保留字段7
		    refund.setMerchantExtendField7("merchantExtendField7");

		    //交易客户保留字段8
		    refund.setMerchantExtendField8("merchantExtendField8");

		    //交易客户保留字段9
		    refund.setMerchantExtendField9("merchantExtendField9");

		    //交易客户保留字段10
		    refund.setMerchantExtendField10("merchantExtendField10");

		    //退款扣款
		    refund.setGmtRefundDeduct(new Date());

		    //退款失败
		    refund.setGmtFailRefund(new Date());

		    //等待退款
		    refund.setGmtWaitRefund(new Date());

		    //退款拒绝
		    refund.setGmtRefuseRefund(new Date());

		    //退款撤销
		    refund.setGmtCancelRefund(new Date());

		    //退款成功
		    refund.setGmtSuccessRefund(new Date());

		    //异常终止
		    refund.setGmtAbortUnexcepted(new Date());

		    //收款方退回付出金额
		    refund.setRefundReceiveAmt(1l);

		    //收款方退回付出方式
		    refund.setRefundReceiveType("1");

		    //收款方损益退回业务台账编号
		    refund.setRefundReceiveProfitLossLedgerNo("refundReceiveProfitLossLedgerNo");

		    //收款方损益退回金额
		    refund.setRefundReceiveProfitLossAmt(1l);

		    //收款方账户退回账户编号
		    refund.setRefundReceiveAccountNo("refundReceiveAccountNo");

		    //收款方账户退回所属商户编号
		    refund.setRefundReceiveAccountMerchantNo("refundReceiveAccountMerchantNo");

		    //收款方账户退回出账金额
		    refund.setRefundReceiveAccountOutAccountingAmt(1l);

		    //收款方账户退回出账账务历史1
		    refund.setRefundReceiveAccountOutAccountingHis1("his1");

		    //收款方账户退回出账账务历史2
		    refund.setRefundReceiveAccountOutAccountingHis2("his2");

		    //收款方账户退回出账账务历史3
		    refund.setRefundReceiveAccountOutAccountingHis3("his3");

		    //收款方手续费账户退回账户编号
		    refund.setRefundReceiveFeeAccountNo("refundReceiveFeeAccountNo");

		    //收款方手续费账户退回所属商户编号
		    refund.setRefundReceiveFeeAccountMerchantNo("ceiveFeeAccountMerchantNo");

		    //收款方手续费账户退回入账金额
		    refund.setRefundReceiveFeeAccountInAccountingAmt(1l);

		    //收款方手续费账户退回入账子账户类型
		    refund.setRefundReceiveFeeAccountInAccountingType("1");

		    //收款方手续费账户退回入账账务历史1
		    refund.setRefundReceiveFeeAccountInAccountingHis1("his1");

		    //收款方手续费账户退回入账账务历史2
		    refund.setRefundReceiveFeeAccountInAccountingHis2("his2");

		    //收款方手续费账户退回入账账务历史3
		    refund.setRefundReceiveFeeAccountInAccountingHis3("his");

		    //付款方手续费账户退回账户编号
		    refund.setRefundPayFeeAccountNo("refundPayFeeAccountNo");

		    //付款方手续费账户退回所属商户编号
		    refund.setRefundPayFeeAccountMerchantNo("ayFeeAccountMerchantNo");

		    //付款方手续费账户退回入账金额
		    refund.setRefundPayFeeAccountInAccountingAmt(1l);

		    //付款方手续费账户退回入账子账户类型
		    refund.setRefundPayFeeAccountInAccountingType("1");

		    //付款方手续费账户退回入账账务历史1
		    refund.setRefundPayFeeAccountInAccountingHis1("his1");

		    //付款方手续费账户退回入账账务历史2
		    refund.setRefundPayFeeAccountInAccountingHis2("his2");

		    //付款方手续费账户退回入账账务历史3
		    refund.setRefundPayFeeAccountInAccountingHis3("his3");

		    //付款方退回收到退回金额
		    refund.setRefundPayAmt(1l);

		    //付款方退回收到方式
		    refund.setRefundPayType("1");

		    //付款方损益退回业务台账编号
		    refund.setRefundPayProfitLossLedgerNo("1");

		    //付款方损益退回收到金额
		    refund.setRefundPayProfitLossAmt(1l);

		    //付款方外部退回业务台账编号
		    refund.setExternalRefundLedgerNo("externalRefundLedgerNo");

		    //付款方外部退回收付款渠道编号
		    refund.setExternalRefundChannel("externalRefundChannel");

		    //付款方外部退回收付款属性1（付出手续费金额）
		    refund.setExternalRefundChannelPayFeeAmt(1l);

		    //付款方外部退回收付款属性2（退回手续费金额）
		    refund.setExternalRefundChannelFeeAmt(1l);

		    //付款方外部退回付款金额
		    refund.setExternalRefundAmt(1l);

		    //付款方外部退回外部渠道收付款成功日期时间
		    refund.setGmtSuccessExternalRefund(new Date());

		    //付款方外部退回收付款渠道订单号
		    refund.setExternalRefundChannelTradeNo("RefundChannelTradeNo");

		    //提交第三方批次号
		    refund.setExternalRefundChannelBatchNo("fundChannelBatchNo");

		    //提交第三方请求流水号
		    refund.setExternalRefundChannelSerialNo("SerialNo");

		    //付款方账户退回账户编号
		    refund.setRefundPayAccountNo("refundPayAccountNo");

		    //付款方账户退回所属商户编号
		    refund.setRefundPayAccountMerchantNo("rdPayAccountMerchantNo");

		    //付款方账户退回入账金额
		    refund.setRefundPayAccountInAccountingAmt(1l);

		    //付款方账户退回出账子账户类型
		    refund.setRefundPayAccountOutAccountingType("1");

		    //付款方账户退回出账账务历史1
		    refund.setRefundPayAccountOutAccountingHis1("his1");

		    //付款方账户退回出账账务历史2
		    refund.setRefundPayAccountOutAccountingHis2("his2");

		    //付款方账户退回出账账务历史3
		    refund.setRefundPayAccountOutAccountingHis3("reccountOutAccountingHis3");

		    //付款方账户退回入账子账户类型
		    refund.setRefundPayAccountInAccountingType("1");

		    //付款方账户退回入账账务历史1
		    refund.setRefundPayAccountInAccountingHis1("his1");

		    //付款方账户退回入账账务历史2
		    refund.setRefundPayAccountInAccountingHis2("his2");

		    //付款方账户退回入账账务历史3
		    refund.setRefundPayAccountInAccountingHis3("refundPayAccountInAccountingHis3");

		    //其他损益台账List退回,保存对应损益台账属性（json）
		    refund.setRefundExtendProfitLoss("{[]}");

		    //付款方账户退回撤销账户编号
		    refund.setCancelRefundPayAcconutNo("cancundPayAcconutNo");

		    //付款方账户退回撤销所属商户编号
		    refund.setCancelRefundPayAcconutMerchantNo("dPayAcconutMerchantNo");

		    //付款方账户退回撤销出账金额
		    refund.setCancelRefundPayAcconutOutAccountingAmt(1l);

		    //付款方账户退回撤销出账子账户类型
		    refund.setCancelRefundPayAcconutOutAccountingType("1");

		    //付款方账户退回撤销出账账务历史1
		    refund.setCancelRefundPayAcconutOutAccountingHis1("his1");

		    //付款方账户退回撤销出账账务历史2
		    refund.setCancelRefundPayAcconutOutAccountingHis2("his2");

		    //付款方账户退回撤销出账账务历史3
		    refund.setCancelRefundPayAcconutOutAccountingHis3("his3");

		    //付款方账户退回撤销入账子账户类型
		    refund.setCancelRefundPayAcconutInAccountingType("1");

		    //付款方账户退回撤销入账账务历史1
		    refund.setCancelRefundPayAcconutInAccountingHis1("his1");

		    //付款方账户退回撤销入账账务历史2
		    refund.setCancelRefundPayAcconutInAccountingHis2("his3");

		    //付款方账户退回撤销入账账务历史3
		    refund.setCancelRefundPayAcconutInAccountingHis3("cancelRefundPayAcconutInAccountingHis3");

		    //付款方手续费账户退回撤销账户编号
		    refund.setCancelRefundPayFeeAccountNo("cancelRePayFeeAccountNo");

		    //付款方手续费账户退回撤销所属商户编号
		    refund.setCancelRefundPayFeeAccountMerchantNo("asdf");

		    //付款方手续费账户退回撤销入账金额
		    refund.setCancelRefundPayFeeAccountOutAccountingAmt(1l);

		    //付款方手续费账户退回撤销入账子账户类型
		    refund.setCancelRefundPayFeeAccountOutAccountingType("1");

		    //付款方手续费账户退回撤销入账账务历史1
		    refund.setCancelRefundPayFeeAccountOutAccountingHis1("crpfainathis1");

		    //付款方手续费账户退回撤销入账账务历史2
		    refund.setCancelRefundPayFeeAccountOutAccountingHis2("his2");

		    //付款方手续费账户退回撤销入账账务历史3
		    refund.setCancelRefundPayFeeAccountOutAccountingHis3("his3");

		    //收款方损益退回撤销业务台账编号
		    refund.setCancelRefundReceiveProfitLossLedgerNo("ln");

		    //收款方损益退回撤销损益生效时间
		    refund.setGmtEffectCancelRefundReceiveGainLoss(new Date());

		    //收款方损益退回撤销金额
		    refund.setCancelRefundReceiveProfitLossAmt(1l);

		    //收款方账户退回撤销账户编号
		    refund.setCancelRefundReceiveAccountNo("zn");

		    //收款方账户退回撤销所属商户编号
		    refund.setCancelRefundReceiveAccountMerchantNo("1");

		    //收款方账户退回撤销入账金额
		    refund.setCancelRefundReceiveAccountInAccountingAmt(1l);

		    //收款方账户退回撤销入账子账户类型
		    refund.setCancelRefundReceiveAccountInAccountingType("1");

		    //收款方账户退回撤销入账账务历史1
		    refund.setCancelRefundReceiveAccountInAccountingHis1("his1");

		    //收款方账户退回撤销入账账务历史2
		    refund.setCancelRefundReceiveAccountInAccountingHis2("his2");

		    //收款方账户退回撤销入账账务历史3
		    refund.setCancelRefundReceiveAccountInAccountingHis3("his3");

		    //收款方手续费账户退回撤销账户编号
		    refund.setCancelRefundReceiveFeeAccountNo("3223");

		    //收款方手续费账户退回撤销所属商户编号
		    refund.setCancelRefundReceiveFeeAccountMerchantNo("crpfainat");

		    //收款方手续费账户退回撤销出账金额
		    refund.setCancelRefundReceiveFeeAccountOutAcountingAmt(1l);

		    //收款方手续费账户退回撤销出账子账户类型
		    refund.setCancelRefundReceiveFeeAccountOutAcountingType("1");

		    //收款方手续费账户退回撤销出账账务历史1
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis1("his=1");

		    //收款方手续费账户退回撤销出账账务历史2
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis2("his2");

		    //收款方手续费账户退回撤销出账账务历史2
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis3("his3");

		    //其他损益台账List退回撤销，对应相应的损益台账字段(json)
		    refund.setCancelRefundExtendProfitLoss("json");

		    //付出方冻结余额
//		    refund.setPayFreezeBal(1l);

		    //收到方冻结余额
		    refund.setReceiveFreezeBal(1l);

		    //交易扩展字段1
		    refund.setTradeExtendField1("tradeield1crpfainat");

		    //交易扩展字段2
		    refund.setTradeExtendField2("tradeExtendField2");

		    //交易扩展字段3
		    refund.setTradeExtendField3("tradeExtendField3");

		    //交易扩展字段4
		    refund.setTradeExtendField4("tradeExtendField4");

		    //交易扩展字段5
		    refund.setTradeExtendField5("tradeExtendField5");

		    //交易扩展字段6
		    refund.setTradeExtendField6("tradeExtendField6");

		    //交易扩展字段7
		    refund.setTradeExtendField7("tradeExtendField7");

		    //交易扩展字段8
		    refund.setTradeExtendField8("tradeExtendField8");

		    //交易扩展字段9
		    refund.setTradeExtendField9("tradeExtendField9");

		    //交易扩展字段10
		    refund.setTradeExtendField10("tradeExtendField10");
//		    tradeSinglePaymentRefundMapper.updateByKeyVersionSelective(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void testTradeSinglePaymentRefundLog(){
		try {
			TradeSinglePaymentRefundLog refund = new TradeSinglePaymentRefundLog();
			 //主键为属性
//		    refund.setId(3l);

		    //交易编号
		    refund.setTradeNo("tradeNo");

		    //核心商户编号
		    refund.setCoreMerchantNo("coreMerchantNo");

		    //资金池编号
		    refund.setFundPoolNo("fundPoolNo");

		    //合作商户编号
		    refund.setPartnerId("partnerId");

		    //原交易编号
		    refund.setOriginalTradeNo("originalTradeNo");

		    //交易发起方发起请求编号
		    refund.setOutTradeNoExt("outTradeNoExt");

		    //交易发起方业务系统订单号
		    refund.setOutTradeNo("outTradeNo");

		    //交易创建日期时间
		    refund.setGmtCreated(new Date());

		    //最后变更日期时间
		    refund.setGmtModifiedLatest(new Date());

		    //最后变更交易请求类型
		    refund.setLatestTradeReqType("latestTradeReqType");

		    //最后变更交易请求编号
		    refund.setLatestReqNo("latestReqNo");

		    //交易结束状态
		    refund.setCloseStatus("1");

		    //交易状态
		    refund.setStatus("1");

		    //交易组别
		    refund.setTradeCatatory("1");

		    //交易版本
		    refund.setVersion(0);

		    //异步通知地址
		    refund.setNotifyUrl("notifyUrl");

		    //交易客户保留字段1
		    refund.setMerchantExtendField1("merchantExtendField1");

		    //交易客户保留字段2
		    refund.setMerchantExtendField2("merchantExtendField2");

		    //交易客户保留字段2
		    refund.setMerchantExtendField3("merchantExtendField3");

		    //交易客户保留字段4
		    refund.setMerchantExtendField4("erchantExtendField4");

		    //交易客户保留字段5
		    refund.setMerchantExtendField5("merchantExtendField5");

		    //交易客户保留字段6
		    refund.setMerchantExtendField6("merchantExtendField6");

		    //交易客户保留字段7
		    refund.setMerchantExtendField7("merchantExtendField7");

		    //交易客户保留字段8
		    refund.setMerchantExtendField8("merchantExtendField8");

		    //交易客户保留字段9
		    refund.setMerchantExtendField9("merchantExtendField9");

		    //交易客户保留字段10
		    refund.setMerchantExtendField10("merchantExtendField10");

		    //退款扣款
		    refund.setGmtRefundDeduct(new Date());

		    //退款失败
		    refund.setGmtFailRefund(new Date());

		    //等待退款
		    refund.setGmtWaitRefund(new Date());

		    //退款拒绝
		    refund.setGmtRefuseRefund(new Date());

		    //退款撤销
		    refund.setGmtCancelRefund(new Date());

		    //退款成功
		    refund.setGmtSuccessRefund(new Date());

		    //异常终止
		    refund.setGmtAbortUnexcepted(new Date());

		    //收款方退回付出金额
		    refund.setRefundReceiveAmt(1l);

		    //收款方退回付出方式
		    refund.setRefundReceiveType("1");

		    //收款方损益退回业务台账编号
		    refund.setRefundReceiveProfitLossLedgerNo("refundReceiveProfitLossLedgerNo");

		    //收款方损益退回金额
		    refund.setRefundReceiveProfitLossAmt(1l);

		    //收款方账户退回账户编号
		    refund.setRefundReceiveAccountNo("refundReceiveAccountNo");

		    //收款方账户退回所属商户编号
		    refund.setRefundReceiveAccountMerchantNo("refundReceiveAccountMerchantNo");

		    //收款方账户退回出账金额
		    refund.setRefundReceiveAccountOutAccountingAmt(1l);

		    //收款方账户退回出账账务历史1
		    refund.setRefundReceiveAccountOutAccountingHis1("his1");

		    //收款方账户退回出账账务历史2
		    refund.setRefundReceiveAccountOutAccountingHis2("his2");

		    //收款方账户退回出账账务历史3
		    refund.setRefundReceiveAccountOutAccountingHis3("his3");

		    //收款方手续费账户退回账户编号
		    refund.setRefundReceiveFeeAccountNo("refundReceiveFeeAccountNo");

		    //收款方手续费账户退回所属商户编号
		    refund.setRefundReceiveFeeAccountMerchantNo("ceiveFeeAccountMerchantNo");

		    //收款方手续费账户退回入账金额
		    refund.setRefundReceiveFeeAccountInAccountingAmt(1l);

		    //收款方手续费账户退回入账子账户类型
		    refund.setRefundReceiveFeeAccountInAccountingType("1");

		    //收款方手续费账户退回入账账务历史1
		    refund.setRefundReceiveFeeAccountInAccountingHis1("his1");

		    //收款方手续费账户退回入账账务历史2
		    refund.setRefundReceiveFeeAccountInAccountingHis2("his2");

		    //收款方手续费账户退回入账账务历史3
		    refund.setRefundReceiveFeeAccountInAccountingHis3("his");

		    //付款方手续费账户退回账户编号
		    refund.setRefundPayFeeAccountNo("refundPayFeeAccountNo");

		    //付款方手续费账户退回所属商户编号
		    refund.setRefundPayFeeAccountMerchantNo("ayFeeAccountMerchantNo");

		    //付款方手续费账户退回入账金额
		    refund.setRefundPayFeeAccountInAccountingAmt(1l);

		    //付款方手续费账户退回入账子账户类型
		    refund.setRefundPayFeeAccountInAccountingType("1");

		    //付款方手续费账户退回入账账务历史1
		    refund.setRefundPayFeeAccountInAccountingHis1("his1");

		    //付款方手续费账户退回入账账务历史2
		    refund.setRefundPayFeeAccountInAccountingHis2("his2");

		    //付款方手续费账户退回入账账务历史3
		    refund.setRefundPayFeeAccountInAccountingHis3("his3");

		    //付款方退回收到退回金额
		    refund.setRefundPayAmt(1l);

		    //付款方退回收到方式
		    refund.setRefundPayType("1");

		    //付款方损益退回业务台账编号
		    refund.setRefundPayProfitLossLedgerNo("1");

		    //付款方损益退回收到金额
		    refund.setRefundPayProfitLossAmt(1l);

		    //付款方外部退回业务台账编号
		    refund.setExternalRefundLedgerNo("externalRefundLedgerNo");

		    //付款方外部退回收付款渠道编号
		    refund.setExternalRefundChannel("externalRefundChannel");

		    //付款方外部退回收付款属性1（付出手续费金额）
		    refund.setExternalRefundChannelPayFeeAmt(1l);

		    //付款方外部退回收付款属性2（退回手续费金额）
		    refund.setExternalRefundChannelFeeAmt(1l);

		    //付款方外部退回付款金额
		    refund.setExternalRefundAmt(1l);

		    //付款方外部退回外部渠道收付款成功日期时间
		    refund.setGmtSuccessExternalRefund(new Date());

		    //付款方外部退回收付款渠道订单号
		    refund.setExternalRefundChannelTradeNo("RefundChannelTradeNo");

		    //提交第三方批次号
		    refund.setExternalRefundChannelBatchNo("fundChannelBatchNo");

		    //提交第三方请求流水号
		    refund.setExternalRefundChannelSerialNo("SerialNo");

		    //付款方账户退回账户编号
		    refund.setRefundPayAccountNo("refundPayAccountNo");

		    //付款方账户退回所属商户编号
		    refund.setRefundPayAccountMerchantNo("rdPayAccountMerchantNo");

		    //付款方账户退回入账金额
		    refund.setRefundPayAccountInAccountingAmt(1l);

		    //付款方账户退回出账子账户类型
		    refund.setRefundPayAccountOutAccountingType("1");

		    //付款方账户退回出账账务历史1
		    refund.setRefundPayAccountOutAccountingHis1("his1");

		    //付款方账户退回出账账务历史2
		    refund.setRefundPayAccountOutAccountingHis2("his2");

		    //付款方账户退回出账账务历史3
		    refund.setRefundPayAccountOutAccountingHis3("reccountOutAccountingHis3");

		    //付款方账户退回入账子账户类型
		    refund.setRefundPayAccountInAccountingType("1");

		    //付款方账户退回入账账务历史1
		    refund.setRefundPayAccountInAccountingHis1("his1");

		    //付款方账户退回入账账务历史2
		    refund.setRefundPayAccountInAccountingHis2("his2");

		    //付款方账户退回入账账务历史3
		    refund.setRefundPayAccountInAccountingHis3("refundPayAccountInAccountingHis3");

		    //其他损益台账List退回,保存对应损益台账属性（json）
		    refund.setRefundExtendProfitLoss("{[]}");

		    //付款方账户退回撤销账户编号
		    refund.setCancelRefundPayAcconutNo("cancundPayAcconutNo");

		    //付款方账户退回撤销所属商户编号
		    refund.setCancelRefundPayAcconutMerchantNo("dPayAcconutMerchantNo");

		    //付款方账户退回撤销出账金额
		    refund.setCancelRefundPayAcconutOutAccountingAmt(1l);

		    //付款方账户退回撤销出账子账户类型
		    refund.setCancelRefundPayAcconutOutAccountingType("1");

		    //付款方账户退回撤销出账账务历史1
		    refund.setCancelRefundPayAcconutOutAccountingHis1("his1");

		    //付款方账户退回撤销出账账务历史2
		    refund.setCancelRefundPayAcconutOutAccountingHis2("his2");

		    //付款方账户退回撤销出账账务历史3
		    refund.setCancelRefundPayAcconutOutAccountingHis3("his3");

		    //付款方账户退回撤销入账子账户类型
		    refund.setCancelRefundPayAcconutInAccountingType("1");

		    //付款方账户退回撤销入账账务历史1
		    refund.setCancelRefundPayAcconutInAccountingHis1("his1");

		    //付款方账户退回撤销入账账务历史2
		    refund.setCancelRefundPayAcconutInAccountingHis2("his3");

		    //付款方账户退回撤销入账账务历史3
		    refund.setCancelRefundPayAcconutInAccountingHis3("cancelRefundPayAcconutInAccountingHis3");

		    //付款方手续费账户退回撤销账户编号
		    refund.setCancelRefundPayFeeAccountNo("cancelRePayFeeAccountNo");

		    //付款方手续费账户退回撤销所属商户编号
		    refund.setCancelRefundPayFeeAccountMerchantNo("asdf");

		    //付款方手续费账户退回撤销入账金额
		    refund.setCancelRefundPayFeeAccountOutAccountingAmt(1l);

		    //付款方手续费账户退回撤销入账子账户类型
		    refund.setCancelRefundPayFeeAccountOutAccountingType("1");

		    //付款方手续费账户退回撤销入账账务历史1
		    refund.setCancelRefundPayFeeAccountOutAccountingHis1("crpfainathis1");

		    //付款方手续费账户退回撤销入账账务历史2
		    refund.setCancelRefundPayFeeAccountOutAccountingHis2("his2");

		    //付款方手续费账户退回撤销入账账务历史3
		    refund.setCancelRefundPayFeeAccountOutAccountingHis3("his3");

		    //收款方损益退回撤销业务台账编号
		    refund.setCancelRefundReceiveProfitLossLedgerNo("ln");

		    //收款方损益退回撤销损益生效时间
		    refund.setGmtEffectCancelRefundReceiveGainLoss(new Date());

		    //收款方损益退回撤销金额
		    refund.setCancelRefundReceiveProfitLossAmt(1l);

		    //收款方账户退回撤销账户编号
		    refund.setCancelRefundReceiveAccountNo("zn");

		    //收款方账户退回撤销所属商户编号
		    refund.setCancelRefundReceiveAccountMerchantNo("1");

		    //收款方账户退回撤销入账金额
		    refund.setCancelRefundReceiveAccountInAccountingAmt(1l);

		    //收款方账户退回撤销入账子账户类型
		    refund.setCancelRefundReceiveAccountInAccountingType("1");

		    //收款方账户退回撤销入账账务历史1
		    refund.setCancelRefundReceiveAccountInAccountingHis1("his1");

		    //收款方账户退回撤销入账账务历史2
		    refund.setCancelRefundReceiveAccountInAccountingHis2("his2");

		    //收款方账户退回撤销入账账务历史3
		    refund.setCancelRefundReceiveAccountInAccountingHis3("his3");

		    //收款方手续费账户退回撤销账户编号
		    refund.setCancelRefundReceiveFeeAccountNo("3223");

		    //收款方手续费账户退回撤销所属商户编号
		    refund.setCancelRefundReceiveFeeAccountMerchantNo("crpfainat");

		    //收款方手续费账户退回撤销出账金额
		    refund.setCancelRefundReceiveFeeAccountOutAcountingAmt(1l);

		    //收款方手续费账户退回撤销出账子账户类型
		    refund.setCancelRefundReceiveFeeAccountOutAcountingType("1");

		    //收款方手续费账户退回撤销出账账务历史1
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis1("his=1");

		    //收款方手续费账户退回撤销出账账务历史2
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis2("his2");

		    //收款方手续费账户退回撤销出账账务历史2
		    refund.setCancelRefundReceiveFeeAccountOutAcountingHis3("his3");

		    //其他损益台账List退回撤销，对应相应的损益台账字段(json)
		    refund.setCancelRefundExtendProfitLoss("json");

		    //付出方冻结余额
//		    refund.setPayFreezeBal(1l);

		    //收到方冻结余额
		    refund.setReceiveFreezeBal(1l);

		    //交易扩展字段1
		    refund.setTradeExtendField1("tradeield1crpfainat");

		    //交易扩展字段2
		    refund.setTradeExtendField2("tradeExtendField2");

		    //交易扩展字段3
		    refund.setTradeExtendField3("tradeExtendField3");

		    //交易扩展字段4
		    refund.setTradeExtendField4("tradeExtendField4");

		    //交易扩展字段5
		    refund.setTradeExtendField5("tradeExtendField5");

		    //交易扩展字段6
		    refund.setTradeExtendField6("tradeExtendField6");

		    //交易扩展字段7
		    refund.setTradeExtendField7("tradeExtendField7");

		    //交易扩展字段8
		    refund.setTradeExtendField8("tradeExtendField8");

		    //交易扩展字段9
		    refund.setTradeExtendField9("tradeExtendField9");

		    //交易扩展字段10
		    refund.setTradeExtendField10("tradeExtendField10");
//		    tradeSinglePaymentRefundLogMapper.insertSelective(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testTradeSinglePaymentRefundVo(){
		TradeSinglePaymentRefundLog refund = new TradeSinglePaymentRefundLog();
		 //主键为属性
	    refund.setId(3l);

	    //交易编号
	    refund.setTradeNo("tradeNo");

	    //核心商户编号
	    refund.setCoreMerchantNo("coreMerchantNo");

	    //资金池编号
	    refund.setFundPoolNo("fundPoolNo");

	    //合作商户编号
	    refund.setPartnerId("partnerId");

	    //原交易编号
	    refund.setOriginalTradeNo("originalTradeNo");

	    //交易发起方发起请求编号
	    refund.setOutTradeNoExt("outTradeNoExt");

	    //交易发起方业务系统订单号
	    refund.setOutTradeNo("outTradeNo");

	    //交易创建日期时间
	    refund.setGmtCreated(new Date());

	    //最后变更日期时间
	    refund.setGmtModifiedLatest(new Date());

	    //最后变更交易请求类型
	    refund.setLatestTradeReqType("latestTradeReqType");

	    //最后变更交易请求编号
	    refund.setLatestReqNo("latestReqNo");

	    //交易结束状态
	    refund.setCloseStatus("1");

	    //交易状态
	    refund.setStatus("1");

	    //交易组别
	    refund.setTradeCatatory("1");

	    //交易版本
	    refund.setVersion(0);

	    //异步通知地址
	    refund.setNotifyUrl("notifyUrl");

	    //交易客户保留字段1
	    refund.setMerchantExtendField1("merchantExtendField1");

	    //交易客户保留字段2
	    refund.setMerchantExtendField2("merchantExtendField2");

	    //交易客户保留字段2
	    refund.setMerchantExtendField3("merchantExtendField3");

	    //交易客户保留字段4
	    refund.setMerchantExtendField4("erchantExtendField4");

	    //交易客户保留字段5
	    refund.setMerchantExtendField5("merchantExtendField5");

	    //交易客户保留字段6
	    refund.setMerchantExtendField6("merchantExtendField6");

	    //交易客户保留字段7
	    refund.setMerchantExtendField7("merchantExtendField7");

	    //交易客户保留字段8
	    refund.setMerchantExtendField8("merchantExtendField8");

	    //交易客户保留字段9
	    refund.setMerchantExtendField9("merchantExtendField9");

	    //交易客户保留字段10
	    refund.setMerchantExtendField10("merchantExtendField10");

	    //退款扣款
	    refund.setGmtRefundDeduct(new Date());

	    //退款失败
	    refund.setGmtFailRefund(new Date());

	    //等待退款
	    refund.setGmtWaitRefund(new Date());

	    //退款拒绝
	    refund.setGmtRefuseRefund(new Date());

	    //退款撤销
	    refund.setGmtCancelRefund(new Date());

	    //退款成功
	    refund.setGmtSuccessRefund(new Date());

	    //异常终止
	    refund.setGmtAbortUnexcepted(new Date());

	    //收款方退回付出金额
	    refund.setRefundReceiveAmt(1l);

	    //收款方退回付出方式
	    refund.setRefundReceiveType("1");

	    //收款方损益退回业务台账编号
	    refund.setRefundReceiveProfitLossLedgerNo("refundReceiveProfitLossLedgerNo");

	    //收款方损益退回金额
	    refund.setRefundReceiveProfitLossAmt(1l);

	    //收款方账户退回账户编号
	    refund.setRefundReceiveAccountNo("refundReceiveAccountNo");

	    //收款方账户退回所属商户编号
	    refund.setRefundReceiveAccountMerchantNo("refundReceiveAccountMerchantNo");

	    //收款方账户退回出账金额
	    refund.setRefundReceiveAccountOutAccountingAmt(1l);

	    //收款方账户退回出账账务历史1
	    refund.setRefundReceiveAccountOutAccountingHis1("his1");

	    //收款方账户退回出账账务历史2
	    refund.setRefundReceiveAccountOutAccountingHis2("his2");

	    //收款方账户退回出账账务历史3
	    refund.setRefundReceiveAccountOutAccountingHis3("his3");

	    //收款方手续费账户退回账户编号
	    refund.setRefundReceiveFeeAccountNo("refundReceiveFeeAccountNo");

	    //收款方手续费账户退回所属商户编号
	    refund.setRefundReceiveFeeAccountMerchantNo("ceiveFeeAccountMerchantNo");

	    //收款方手续费账户退回入账金额
	    refund.setRefundReceiveFeeAccountInAccountingAmt(1l);

	    //收款方手续费账户退回入账子账户类型
	    refund.setRefundReceiveFeeAccountInAccountingType("1");

	    //收款方手续费账户退回入账账务历史1
	    refund.setRefundReceiveFeeAccountInAccountingHis1("his1");

	    //收款方手续费账户退回入账账务历史2
	    refund.setRefundReceiveFeeAccountInAccountingHis2("his2");

	    //收款方手续费账户退回入账账务历史3
	    refund.setRefundReceiveFeeAccountInAccountingHis3("his");

	    //付款方手续费账户退回账户编号
	    refund.setRefundPayFeeAccountNo("refundPayFeeAccountNo");

	    //付款方手续费账户退回所属商户编号
	    refund.setRefundPayFeeAccountMerchantNo("ayFeeAccountMerchantNo");

	    //付款方手续费账户退回入账金额
	    refund.setRefundPayFeeAccountInAccountingAmt(1l);

	    //付款方手续费账户退回入账子账户类型
	    refund.setRefundPayFeeAccountInAccountingType("1");

	    //付款方手续费账户退回入账账务历史1
	    refund.setRefundPayFeeAccountInAccountingHis1("his1");

	    //付款方手续费账户退回入账账务历史2
	    refund.setRefundPayFeeAccountInAccountingHis2("his2");

	    //付款方手续费账户退回入账账务历史3
	    refund.setRefundPayFeeAccountInAccountingHis3("his3");

	    //付款方退回收到退回金额
	    refund.setRefundPayAmt(1l);

	    //付款方退回收到方式
	    refund.setRefundPayType("1");

	    //付款方损益退回业务台账编号
	    refund.setRefundPayProfitLossLedgerNo("1");

	    //付款方损益退回收到金额
	    refund.setRefundPayProfitLossAmt(1l);

	    //付款方外部退回业务台账编号
	    refund.setExternalRefundLedgerNo("externalRefundLedgerNo");

	    //付款方外部退回收付款渠道编号
	    refund.setExternalRefundChannel("externalRefundChannel");

	    //付款方外部退回收付款属性1（付出手续费金额）
	    refund.setExternalRefundChannelPayFeeAmt(1l);

	    //付款方外部退回收付款属性2（退回手续费金额）
	    refund.setExternalRefundChannelFeeAmt(1l);

	    //付款方外部退回付款金额
	    refund.setExternalRefundAmt(1l);

	    //付款方外部退回外部渠道收付款成功日期时间
	    refund.setGmtSuccessExternalRefund(new Date());

	    //付款方外部退回收付款渠道订单号
	    refund.setExternalRefundChannelTradeNo("RefundChannelTradeNo");

	    //提交第三方批次号
	    refund.setExternalRefundChannelBatchNo("fundChannelBatchNo");

	    //提交第三方请求流水号
	    refund.setExternalRefundChannelSerialNo("SerialNo");

	    //付款方账户退回账户编号
	    refund.setRefundPayAccountNo("refundPayAccountNo");

	    //付款方账户退回所属商户编号
	    refund.setRefundPayAccountMerchantNo("rdPayAccountMerchantNo");

	    //付款方账户退回入账金额
	    refund.setRefundPayAccountInAccountingAmt(1l);

	    //付款方账户退回出账子账户类型
	    refund.setRefundPayAccountOutAccountingType("1");

	    //付款方账户退回出账账务历史1
	    refund.setRefundPayAccountOutAccountingHis1("his1");

	    //付款方账户退回出账账务历史2
	    refund.setRefundPayAccountOutAccountingHis2("his2");

	    //付款方账户退回出账账务历史3
	    refund.setRefundPayAccountOutAccountingHis3("reccountOutAccountingHis3");

	    //付款方账户退回入账子账户类型
	    refund.setRefundPayAccountInAccountingType("1");

	    //付款方账户退回入账账务历史1
	    refund.setRefundPayAccountInAccountingHis1("his1");

	    //付款方账户退回入账账务历史2
	    refund.setRefundPayAccountInAccountingHis2("his2");

	    //付款方账户退回入账账务历史3
	    refund.setRefundPayAccountInAccountingHis3("refundPayAccountInAccountingHis3");

	    //其他损益台账List退回,保存对应损益台账属性（json）
	    refund.setRefundExtendProfitLoss("{[]}");

	    //付款方账户退回撤销账户编号
	    refund.setCancelRefundPayAcconutNo("cancundPayAcconutNo");

	    //付款方账户退回撤销所属商户编号
	    refund.setCancelRefundPayAcconutMerchantNo("dPayAcconutMerchantNo");

	    //付款方账户退回撤销出账金额
	    refund.setCancelRefundPayAcconutOutAccountingAmt(1l);

	    //付款方账户退回撤销出账子账户类型
	    refund.setCancelRefundPayAcconutOutAccountingType("1");

	    //付款方账户退回撤销出账账务历史1
	    refund.setCancelRefundPayAcconutOutAccountingHis1("his1");

	    //付款方账户退回撤销出账账务历史2
	    refund.setCancelRefundPayAcconutOutAccountingHis2("his2");

	    //付款方账户退回撤销出账账务历史3
	    refund.setCancelRefundPayAcconutOutAccountingHis3("his3");

	    //付款方账户退回撤销入账子账户类型
	    refund.setCancelRefundPayAcconutInAccountingType("1");

	    //付款方账户退回撤销入账账务历史1
	    refund.setCancelRefundPayAcconutInAccountingHis1("his1");

	    //付款方账户退回撤销入账账务历史2
	    refund.setCancelRefundPayAcconutInAccountingHis2("his3");

	    //付款方账户退回撤销入账账务历史3
	    refund.setCancelRefundPayAcconutInAccountingHis3("cancelRefundPayAcconutInAccountingHis3");

	    //付款方手续费账户退回撤销账户编号
	    refund.setCancelRefundPayFeeAccountNo("cancelRePayFeeAccountNo");

	    //付款方手续费账户退回撤销所属商户编号
	    refund.setCancelRefundPayFeeAccountMerchantNo("asdf");

	    //付款方手续费账户退回撤销入账金额
	    refund.setCancelRefundPayFeeAccountOutAccountingAmt(1l);

	    //付款方手续费账户退回撤销入账子账户类型
	    refund.setCancelRefundPayFeeAccountOutAccountingType("1");

	    //付款方手续费账户退回撤销入账账务历史1
	    refund.setCancelRefundPayFeeAccountOutAccountingHis1("crpfainathis1");

	    //付款方手续费账户退回撤销入账账务历史2
	    refund.setCancelRefundPayFeeAccountOutAccountingHis2("his2");

	    //付款方手续费账户退回撤销入账账务历史3
	    refund.setCancelRefundPayFeeAccountOutAccountingHis3("his3");

	    //收款方损益退回撤销业务台账编号
	    refund.setCancelRefundReceiveProfitLossLedgerNo("ln");

	    //收款方损益退回撤销损益生效时间
	    refund.setGmtEffectCancelRefundReceiveGainLoss(new Date());

	    //收款方损益退回撤销金额
	    refund.setCancelRefundReceiveProfitLossAmt(1l);

	    //收款方账户退回撤销账户编号
	    refund.setCancelRefundReceiveAccountNo("zn");

	    //收款方账户退回撤销所属商户编号
	    refund.setCancelRefundReceiveAccountMerchantNo("1");

	    //收款方账户退回撤销入账金额
	    refund.setCancelRefundReceiveAccountInAccountingAmt(1l);

	    //收款方账户退回撤销入账子账户类型
	    refund.setCancelRefundReceiveAccountInAccountingType("1");

	    //收款方账户退回撤销入账账务历史1
	    refund.setCancelRefundReceiveAccountInAccountingHis1("his1");

	    //收款方账户退回撤销入账账务历史2
	    refund.setCancelRefundReceiveAccountInAccountingHis2("his2");

	    //收款方账户退回撤销入账账务历史3
	    refund.setCancelRefundReceiveAccountInAccountingHis3("his3");

	    //收款方手续费账户退回撤销账户编号
	    refund.setCancelRefundReceiveFeeAccountNo("3223");

	    //收款方手续费账户退回撤销所属商户编号
	    refund.setCancelRefundReceiveFeeAccountMerchantNo("crpfainat");

	    //收款方手续费账户退回撤销出账金额
	    refund.setCancelRefundReceiveFeeAccountOutAcountingAmt(1l);

	    //收款方手续费账户退回撤销出账子账户类型
	    refund.setCancelRefundReceiveFeeAccountOutAcountingType("1");

	    //收款方手续费账户退回撤销出账账务历史1
	    refund.setCancelRefundReceiveFeeAccountOutAcountingHis1("his=1");

	    //收款方手续费账户退回撤销出账账务历史2
	    refund.setCancelRefundReceiveFeeAccountOutAcountingHis2("his2");

	    //收款方手续费账户退回撤销出账账务历史2
	    refund.setCancelRefundReceiveFeeAccountOutAcountingHis3("his3");

	    //其他损益台账List退回撤销，对应相应的损益台账字段(json)
	    refund.setCancelRefundExtendProfitLoss("json");

	    //付出方冻结余额
	    refund.setPayFreezeBal(1l);

	    //收到方冻结余额
	    refund.setReceiveFreezeBal(11222222222l);

	    //交易扩展字段1
	    refund.setTradeExtendField1("tradeield1crpfainat");

	    //交易扩展字段2
	    refund.setTradeExtendField2("tradeExtendField2");

	    //交易扩展字段3
	    refund.setTradeExtendField3("tradeExtendField3");

	    //交易扩展字段4
	    refund.setTradeExtendField4("tradeExtendField4");

	    //交易扩展字段5
	    refund.setTradeExtendField5("tradeExtendField5");

	    //交易扩展字段6
	    refund.setTradeExtendField6("tradeExtendField6");

	    //交易扩展字段7
	    refund.setTradeExtendField7("tradeExtendField7");

	    //交易扩展字段8
	    refund.setTradeExtendField8("tradeExtendField8");

	    //交易扩展字段9
	    refund.setTradeExtendField9("tradeExtendField9");

	    //交易扩展字段10
	    refund.setTradeExtendField10("tradeExtendField10");
		TradeSinglePaymentRefundVo vo = new TradeSinglePaymentRefundVo();
		BeanUtils.copyProperties(refund,vo);
		try {
			System.out.println(ObjectJsonUtil.object2String(refund));
			System.out.println(ObjectJsonUtil.object2String(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
