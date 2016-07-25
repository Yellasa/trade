package com.liantuo.trade.bus.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.service.SinglePaymentRefundService;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefund;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class SinglePaymentRefundServiceTest {
	@Resource(name="")
	private SinglePaymentRefundService singlePaymentRefundService;
	
	private TradeSinglePaymentRefund refund  ;
	@Before
	public void prepareParam(){
		refund = new TradeSinglePaymentRefund();

	    //交易编号
	    refund.setTradeNo("tradeNo"+Math.random()*1000);

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
	    refund.setCloseStatus("2");

	    //交易状态
	    refund.setStatus("2");

	    //交易组别
	    refund.setTradeCatatory("2");

	    //交易版本
	    refund.setVersion(1);

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
//	    refund.setPayFreezeBal(1l);

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
	}
	@Test
	public void testCreateInnerTradeForRefundOfSuccess(){
		try {
			System.out.println(singlePaymentRefundService);
			singlePaymentRefundService.createInnerTradeForRefundOfSuccess(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testCreateInnerTradeForRefundOfFailure(){
		try {
			singlePaymentRefundService.createInnerTradeForRefundOfFailure(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateOuterTradeForRefundOfSuccess(){
		try {
			singlePaymentRefundService.createOuterTradeForRefundOfSuccess(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateOuterTradeForRefundOfFailure(){
		try {
			singlePaymentRefundService.createOuterTradeForRefundOfFailure(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateOuterTradePaymentRefundSuccess(){
		try {
			refund.setId(10l);
			singlePaymentRefundService.updateOuterTradePaymentRefundSuccess(refund);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
