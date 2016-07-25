package com.liantuo.trade.unittest.jy0005;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyInnerRefund;
import com.liantuo.trade.client.trade.packet.body.single_recharge.QueryPage4RechargeDetail;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyQueryAndCheck;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOffline;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodySupplyBill;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.vo.TradePacketReqBodyRechargeOnline;
import com.liantuo.trade.client.vo.TradeRequestBodyVisible;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.orm.mapper.TradeWithdrawErrorinfoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class TradeClient0005 {
	
	@Autowired
	private TestClientPayQueryService service;
	
	/**
	 * 0005_001_001：V1.0线下充值
	 * @throws Exception
	 * 充值金额 (10) = 支付金额(9)+充值补差金额(1)
	 */
	@Test
	public void test0005001001() throws Exception{
		TradeRequest<TradePacketReqBodyRechargeOffline> bizReq = new TradeRequest<TradePacketReqBodyRechargeOffline>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyRechargeOffline body = new TradePacketReqBodyRechargeOffline();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");
		//核心商户编号	来自输入
//		head.setCore_merchant_no("CC_C3878185775");0a
		head.setCore_merchant_no("CC_C3878185775");
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010429");
		//交易客户保留字段1	来自输入
		body.setMerchant_extend_field_1("merchant_extend_field_1-001");
		//交易客户保留字段2	来自输入
		body.setMerchant_extend_field_2("Merchant_extend_field_2-001");
		//交易客户保留字段3	来自输入
		body.setMerchant_extend_field_3("Merchant_extend_field_3-001");
		//交易客户保留字段4	来自输入
		body.setMerchant_extend_field_4("Merchant_extend_field_4-001");
		//交易客户保留字段5	来自输入
		body.setMerchant_extend_field_5("Merchant_extend_field_5-001");
		//交易发起方发起请求编号	来自输入
		body.setOut_trade_no_ext("20160503105350");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("1234564");
		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0005_001_001
		head.setRequest_code("0005_001_001");
		head.setVersion("1.0");
		/**
		 * 充值付款方数据	
		 */
		//支付金额	来自输入 sign is required
		body.setPay_amount("99");
		//充值渠道号	来自输入
		body.setClear_channel("01");
		//充值渠道身份编号	来自输入
		body.setTransaction_id("transaction_id_0");
		//提交第三方批次号	来自输入
		body.setBatch_no("batch_no_001");
		//提交第三方批次流水号	来自输入
		body.setSerial_number("Serial_number_001");
		//充值渠道订单号	来自输入
		body.setThird_trade_no("Third_trade_no_001");
		//外部付款成功日期时间	来自输入yyyy-mm-dd hh:mm:ss
		body.setGmt_success_clear_channel(DateUtil.toDateTime(new Date()));
		//充值付款业务台账保留字段1	来自输入
		body.setRecharge_ledger_extend_field_1("Recharge_ledger_extend_field_1-001");
		//充值付款业务台账保留字段2	来自输入
		body.setRecharge_ledger_extend_field_2("Recharge_ledger_extend_field_2-001");
		//充值付款业务台账保留字段3	来自输入
		body.setRecharge_ledger_extend_field_3("Recharge_ledger_extend_field_3-001");
		
		/**
		 * 收款账户数据	
		 */
		//充值CA账户编号	来自输入
		body.setRecharge_account_no("CA21000000060625");//CA21000000060625
		//充值CA账户入账账务历史1	来自输入
		body.setRecharge_account_extend_field_1("Recharge_account_extend_field_1-001");
		//充值CA账户入账账务历史2	来自输入
		body.setRecharge_account_extend_field_2("Recharge_account_extend_field_2-001");
		//充值CA账户入账账务历史3	来自输入
		body.setRecharge_account_extend_field_3("Recharge_account_extend_field_3-001");
		/**
		 * 交易数据	
		 */
		//充值金额	来自输入
		body.setRecharge_amount("100");
		/**
		 * 充值手续费数据	
		 */
		//充值手续费金额	来自输入
		body.setFee_amount("1");
		//充值手续费接收方式	来自输入
		body.setFee_way("1");
		//充值手续费收款账户	来自输入
		body.setFee_receive_account_no("CA21000000060623");
		//充值手续费充值CA账户扣费账务历史1	来自输入
		body.setFee_pay_account_extend_field_1("Fee_pay_account_extend_field_1-001");
		//充值手续费充值CA账户扣费账务历史2	来自输入
		body.setFee_pay_account_extend_field_2("Fee_pay_account_extend_field_2-001");
		//充值手续费充值CA账户扣费账务历史3	来自输入
		body.setFee_pay_account_extend_field_3("Fee_pay_account_extend_field_3-001");
		//充值手续费收款账户入账账务历史1	来自输入
		body.setFee_receive_account_extend_field_1("Fee_receive_account_extend_field_1-001");
		//充值手续费收款账户入账账务历史2	来自输入
		body.setFee_receive_account_extend_field_2("Fee_receive_account_extend_field_2-001");
		//充值手续费收款账户入账账务历史3	来自输入
		body.setFee_receive_account_extend_field_3("Fee_receive_account_extend_field_3-001");
		//充值手续费台账类别	来自输入
		body.setFee_ledger_type("1");
		//充值手续费台账客户保留字段1	来自输入
		body.setFee_ledger_extend_field_1("Fee_ledger_extend_field_1-001");
		//充值手续费台账客户保留字段2	来自输入
		body.setFee_ledger_extend_field_2("Fee_ledger_extend_field_2-001");
		//充值手续费台账客户保留字段3	来自输入
		body.setFee_ledger_extend_field_1("Fee_ledger_extend_field_3-001");
		//充值手续费损益属性1	来自输入
		body.setFee_profit_loss_attr_1("Fee_profit_loss_attr_1-001");
		//充值手续费损益属性2	来自输入
		body.setFee_profit_loss_attr_2("Fee_profit_loss_attr_2-001");
		//充值手续费损益属性3	来自输入
		body.setFee_profit_loss_attr_3("Fee_profit_loss_attr_3-001");
		//充值手续费损益属性4	来自输入
		body.setFee_profit_loss_attr_4("Fee_profit_loss_attr_4-001");
		//充值手续费损益属性5	来自输入
		body.setFee_profit_loss_attr_5("Fee_profit_loss_attr_5-001");
		//充值手续费损益属性6	来自输入
		body.setFee_profit_loss_attr_6("Fee_profit_loss_attr_6-001");
		//充值手续费损益属性7	来自输入
		body.setFee_profit_loss_attr_7("Fee_profit_loss_attr_7-001");
		//充值手续费损益属性8	来自输入
		body.setFee_profit_loss_attr_8("Fee_profit_loss_attr_8-001");
		//充值手续费损益属性9	来自输入
		body.setFee_profit_loss_attr_9("Fee_profit_loss_attr_9-001");
		//充值手续费损益属性10	来自输入
		body.setFee_profit_loss_attr_10("Fee_profit_loss_attr_10-001");
		/**
		 * 充值补差数据	
		 */
		//充值补差金额	来自输入
		body.setSupply_amount("1");
		//充值补差付出方式	来自输入
		body.setSupply_way("1");
		//充值补差付款账户	来自输入
		body.setSupply_pay_account_no("CA21000000060621");//CA21000000060621
		//充值补差充值CA账户扣费账务历史1	来自输入
		body.setSupply_pay_account_extend_field_1("Supply_pay_account_extend_field_1-001");
		//充值补差充值CA账户扣费账务历史2	来自输入
		body.setSupply_pay_account_extend_field_2("Supply_pay_account_extend_field_2-001");
		//充值补差充值CA账户扣费账务历史3	来自输入
		body.setSupply_pay_account_extend_field_3("Supply_pay_account_extend_field_3-001");
		//充值补差台账类别	来自输入
		body.setSupply_ledger_type("1");
		//充值补差台账客户保留字段1	来自输入
		body.setSupply_ledger_extend_field_1("ewewewewewewewewew");
		//充值补差台账客户保留字段2	来自输入
		body.setSupply_ledger_extend_field_2("Supply_ledger_extend_field_2-001");
		//充值补差台账客户保留字段3	来自输入
		body.setSupply_ledger_extend_field_3("212121-001");
		//充值补差损益属性1	来自输入
		body.setSupply_profit_loss_attr_1("Supply_profit_loss_attr_1-001");
		//充值补差损益属性2	来自输入
		body.setSupply_profit_loss_attr_2("Supply_profit_loss_attr_2-001");
		//充值补差损益属性3	来自输入
		body.setSupply_profit_loss_attr_3("Supply_profit_loss_attr_3-001");
		//充值补差损益属性4	来自输入
		body.setSupply_profit_loss_attr_4("Supply_profit_loss_attr_4-001");
		//充值补差损益属性5	来自输入
		body.setSupply_profit_loss_attr_5("Supply_profit_loss_attr_5-001");
		//充值补差损益属性6	来自输入
		body.setSupply_profit_loss_attr_6("Supply_profit_loss_attr_6-001");
		//充值补差损益属性7	来自输入
		body.setSupply_profit_loss_attr_7("Supply_profit_loss_attr_7-001");
		//充值补差损益属性8	来自输入
		body.setSupply_profit_loss_attr_8("Supply_profit_loss_attr_8-001");
		//充值补差损益属性9	来自输入
		body.setSupply_profit_loss_attr_9("Supply_profit_loss_attr_9-001");
		//充值补差损益属性10	来自输入
		body.setSupply_profit_loss_attr_10("Supply_profit_loss_attr_10-001");
		body.setRecharge_attr_1("Recharge_attr_1-001");
		body.setRecharge_attr_2("Recharge_attr_2-001");
		body.setRecharge_attr_3("Recharge_attr_3-001");
		body.setRecharge_attr_4("Recharge_attr_4-001");
		body.setRecharge_attr_5("Recharge_attr_5-001");
		body.setRecharge_attr_6("Recharge_attr_6-001");
		
		
		body.setRecharge_remark_1("Recharge_remark_1-001");
		body.setRecharge_remark_2("Recharge_remark_2-001");
		body.setRecharge_remark_3("Recharge_remark_3-001");
		body.setRecharge_remark_4("Recharge_remark_4-001");
		body.setRecharge_remark_5("Recharge_remark_5-001");
		body.setRecharge_remark_6("Recharge_remark_6-001");
		body.setRecharge_remark_7("Recharge_remark_7-001");
		body.setRecharge_remark_8("Recharge_remark_8-001");
		body.setRecharge_remark_9("Recharge_remark_9-001");
		body.setRecharge_remark_10("Recharge_remark_10-001");
		
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0005_001_002：V1.0补充入账
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTest0005001002() throws Exception {
		TradeRequest<TradePacketReqBodySupplyBill> bizReq = new TradeRequest<TradePacketReqBodySupplyBill>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodySupplyBill body = new TradePacketReqBodySupplyBill();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
				.format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345682");
		// 核心商户编号 来自输入
		head.setCore_merchant_no("CC_C3878185775CC_C3878185775CC_C3878185775CC_C3878185775CC_C3878185775CC_C3878185775CC_C3878185775");
		// 资金池编号 来自输入
		head.setFund_pool_no("PN01000000000010429");
		// 交易发起方业务系统订单号 来自输入
		// 最后变更交易请求类型 0005_001_001
		head.setRequest_code("0005_001_002");
		head.setVersion("1.0");
		//D00050011605061727358120000007503 交易编号不存在 已测试
		//原订单状态异常 已测试
		//交易记录修改失败 已测试
		body.setTrade_no("00050011605091745022950000009200");
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	@Resource
    private TradeWithdrawErrorinfoMapper tradeWithdrawErrorinfoMapper;
	
    @Test
    public void Test0005001006(){
    	/**
			0005线上测试数据
    	 * 核心：EW_B0480444447
			资金池号：PN01000000000032434
			账户编号：CA21000000032208   CA21000000007186
			PID：10036122233150929
			transaction_id：000000000000001
    	 */
    	TradeRequest<TradePacketReqBodyQueryAndCheck> request = new TradeRequest<TradePacketReqBodyQueryAndCheck>();
    	TradePacketReqBodyQueryAndCheck body = new TradePacketReqBodyQueryAndCheck();
    	TradePacketHead head = new TradePacketHead();
		 request.setBody(body);
	     request.setHead(head);
	
	     head.setPartner_id("10000002048131212");
	     head.setCore_merchant_no("liantuo");
	     head.setFund_pool_no("PN01000000000000761");
	     head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
	     head.setVersion("1.0");
	
	     head.setRequest_code("0005_001_006");
	     head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
	     body.setTrade_no("00050011606061738436530000017311");
	     body.setOut_trade_no_ext("201606151134411022");
	     TradeResponse response = TradeClient.excute(request);
	     System.out.println(response.marshal());
    }
    
    /**
	 * test0005_001_999成员充值-交易列表查询V1.0-内部接口
	 * @throws Exception
	 */
	@Test
	public void test0005_001_999() throws Exception{
		TradeRequest<QueryPage4RechargeDetail> bizReq = new TradeRequest<QueryPage4RechargeDetail>();
		QueryPage4RechargeDetail body = new QueryPage4RechargeDetail();
		TradePacketHead head = new TradePacketHead();
	
//		CA:CA21000000017026
//		Partner_id("10012426000150917")
//		Core_merchant_no("CC_C8785258588")
//		Fund_pool_no("PN01000000000010876")

		head.setRequest_code("0005_001_999");
		head.setVersion("1.0");
		//必填
		head.setPartner_id("10012426000150917");//10038012689151119
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988
		//可空
//		body.setTrade_no("1605041047091280000003400");
//		body.setMerchant_extend_field_1("0123Ab!@_");
//		body.setMerchant_extend_field_2("搞笑");
//		body.setMerchant_extend_field_3("1a#_搞笑");
//		body.setMerchant_extend_field_4("1--2");
//		body.setMerchant_extend_field_5("");
//		body.setOut_trade_no_ext("");
//		body.setOut_trade_no("");
		body.setStatus("01^02");	
//		body.setPage("0");
//		body.setPage_size("2");

		bizReq.setHead(head);
		bizReq.setBody(body);

		TradeResponse response = TradeClient.excute(bizReq);

		if (null != response) {
			System.err.println(response.marshal());
		}
	
	}
	
	/**
	 * test0005_001_998成员充值-交易列表查询V1.0-公用
	 * @throws Exception
	 */
	@Test
	public void test0005_001_998() throws Exception{
		TradeRequest<QueryPage4RechargeDetail> bizReq = new TradeRequest<QueryPage4RechargeDetail>();
		QueryPage4RechargeDetail body = new QueryPage4RechargeDetail();
		TradePacketHead head = new TradePacketHead();
		

		head.setRequest_code("0005_001_998");
		head.setVersion("1.0");
		//必填
		head.setPartner_id("10012426000150917");//10038012689151119
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988
		//可空
//		body.setTrade_no("1");
		body.setMerchant_extend_field_1("");
//		body.setMerchant_extend_field_2("搞笑");
//		body.setMerchant_extend_field_3("1a#_搞笑");
//		body.setMerchant_extend_field_4("1--2");
//		body.setMerchant_extend_field_5("");
//		body.setOut_trade_no_ext("");
//		body.setOut_trade_no("");
//		body.setStatus("");	
//		body.setPage("0");
//		body.setPage_size("2");

		bizReq.setHead(head);
		bizReq.setBody(body);

		TradeResponse response = TradeClient.excute(bizReq);

		if (null != response) {
			System.err.println(response.marshal());
		}
	
	}
    /*@Test
    public void readExcel(){
    	File file = new File("D://222.xls");
    	HSSFWorkbook wb = null;
		try {
			InputStream inp = new FileInputStream(file);
			wb = new HSSFWorkbook(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
        	HSSFSheet st = wb.getSheetAt(numSheet);
        	if(st==null){
        		continue;
        	}
        	for (int rowNum = 1; rowNum <= st.getLastRowNum(); rowNum++) {
        		HSSFRow hssfRow = st.getRow(rowNum);
        		if (hssfRow != null) {
        			TradeWithdrawErrorinfo record = new TradeWithdrawErrorinfo();
        			HSSFCell err_code = hssfRow.getCell(1);
        			HSSFCell err_msg = hssfRow.getCell(2);
        			record.setErrorCode(err_code.getStringCellValue());
        			record.setErrorDesc(err_msg.getStringCellValue());
        			record.setPayChannel("1");
        			record.setChannelNo("36");
        			record.setGmtCreated(new Date());
        			tradeWithdrawErrorinfoMapper.insertSelective(record);
        		}
        		
        	}
        }
    }*/
	
	/**
	 * 在线充值---请求支付 (线下)
	 */
	@Test
	public void test0005_001_004(){
		TradeRequest<TradePacketReqBodyRechargeOnline> request = new TradeRequest<TradePacketReqBodyRechargeOnline>();
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		TradePacketHead head = new TradePacketHead();
		head.setPartner_id("10012426000150917");   
		head.setCore_merchant_no("CC_C3878185775"); 
		head.setFund_pool_no("PN01000000000010429"); 
		head.setRequest_time("2016-05-17 19:21:55");
		head.setRequest_code("0005_001_004");
		head.setVersion("1.0");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		
//		body.setFee_amount("2");
//		body.setFee_way("2");
		body.setOut_trade_no_ext("df20163589233959994890");
		body.setOut_trade_no("df20163589233959992847");
		body.setPay_remark("ces");
		body.setPay_date("20160517");
		body.setNotify_url("www.baidu.com");
		body.setRecharge_account_no("CA21000000060621"); 
		body.setTransaction_id("000000000000105"); 
		body.setAccount_name("合肥联拓金融信息服务有限公司");
		body.setEmail("ltfzfb03@126.com");
		body.setReceive_email("ltftest02_zfb@126.com");
		body.setReceive_name("合肥联拓金融信息服务有限公司");
		body.setRecharge_amount("0.05");
		body.setPay_amount("0.05");
//		body.setSupply_amount("0.04");
//		body.setFee_receive_account_no("CA21000000060623"); 
//		body.setSupply_profit_loss_attr_1("95645643F_S58886435643ADSFGDSFGSD32453245654656564374375qwd####!#$$___*()_)*_^^####$$$$$$$$$$$$$$$$$$$RWQERWSDF14234ABcd01345789a");
		request.setBody(body);
		request.setHead(head);
		try {
			TradeResponse response = TradeClient.excute(request);
	        System.err.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 在线充值---请求支付 (线上)
	 */
	@Test
	public void test0005_001_004_online(){
		TradeRequest<TradePacketReqBodyRechargeOnline> request = new TradeRequest<TradePacketReqBodyRechargeOnline>();
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		TradePacketHead head = new TradePacketHead();
		head.setPartner_id("10036122233150929");  
		head.setCore_merchant_no("EW_B0480444447"); 
		head.setFund_pool_no("PN01000000000032434"); 
		head.setRequest_time("2016-05-17 19:21:55");
		head.setRequest_code("0005_001_004");
		head.setVersion("1.0");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		
//		body.setFee_amount("2");
//		body.setFee_way("2");
		body.setOut_trade_no_ext("df20163589233959994890");
		body.setOut_trade_no("df20163589233959992847");
		body.setPay_remark("ces");
		body.setPay_date("20160517");
		body.setNotify_url("www.baidu.com");
		body.setRecharge_account_no("CA21000000032208"); //
		body.setTransaction_id("000000000000001"); //
		body.setAccount_name("合肥联拓金融信息服务有限公司");
		body.setEmail("ltfzfb03@126.com");
		body.setReceive_email("ltftest02_zfb@126.com");
		body.setReceive_name("合肥联拓金融信息服务有限公司");
		body.setRecharge_amount("0.05");
		body.setPay_amount("0.05");
//		body.setSupply_amount("0.04");
		body.setFee_receive_account_no("CA21000000007186"); //
//		body.setSupply_profit_loss_attr_1("95645643F_S58886435643ADSFGDSFGSD32453245654656564374375qwd####!#$$___*()_)*_^^####$$$$$$$$$$$$$$$$$$$RWQERWSDF14234ABcd01345789a");
		request.setBody(body);
		request.setHead(head);
		try {
			TradeResponse response = TradeClient.excute(request);
	        System.err.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void TestJackSon() throws Exception{
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		//该字段加上了 org.codehaus.jackson.annotate.JsonIgnore 注解，json转换忽略该属性
		body.setOut_trade_no_ext("df20163589233959994890");
		body.setOut_trade_no("df20163589233959992847");
		body.setPay_remark("ces");
		body.setPay_date("20160517");
		body.setNotify_url("www.baidu.com");
		String json = ObjectJsonUtil.object2String(body);
		System.out.println(json);
	}
	
	@Test
	public void TestVisable() throws Exception{
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		body.setOut_trade_no_ext("df20163589233959994890");
		body.setOut_trade_no("df20163589233959992847");
		body.setPay_remark("ces");
		body.setPay_date("20160517");
		body.setNotify_url("www.baidu.com");
		//只允许父类的5个备注返回可见
		body.setMerchant_extend_field_1("merchant_extend_field_1");
		body.setMerchant_extend_field_2("merchant_extend_field_2");
		body.setMerchant_extend_field_3("merchant_extend_field_3");
		body.setMerchant_extend_field_4("merchant_extend_field_4");
		TradeRequestBodyVisible newTradeRecharge = new TradeRequestBodyVisible();
        BeanUtils.copyProperties(body, newTradeRecharge);
        System.out.println(ObjectJsonUtil.object2String(newTradeRecharge));
	}
	
	@Test
	public void TestList(){
		TradePacketReqBodyInnerRefund body = new TradePacketReqBodyInnerRefund();
		TradePacketHead head = new TradePacketHead();
		head.setPartner_id("10036122233150929");  
		head.setCore_merchant_no("EW_B0480444447"); 
		head.setFund_pool_no("PN01000000000032434"); 
		head.setRequest_time("2016-05-17 19:21:55");
		head.setRequest_code("0005_001_004");
		head.setVersion("1.0");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		
		
		body.setOriginal_trade_no("52321456");
		body.setOut_trade_no_ext("df20163589233959994890");
		body.setOut_trade_no("df20163589233959992847");
		body.setRefund_pay_type("0");
		body.setRefund_receive_amt("0.04");
		body.setMerchant_extend_field_1("mxf1");
		List<TradePacketReqBodyOtherPofitLossLedger> list =  new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		TradePacketReqBodyOtherPofitLossLedger item = new TradePacketReqBodyOtherPofitLossLedger();
		item.setCost_decr("x1");
		body.setProfit_loss_list(list);
		TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest = new TradeRequest<TradePacketReqBodyInnerRefund>();
		tradeRquest.setBody(body);
		tradeRquest.setHead(head);
		List<String> validates = new ArrayList<String>();
		validates.add("merchant_extend_field_1");
//		String msg = ValidationUtil.validateObjectAllMsg(tradeRquest, Format.class,Special.class);
		try {
			String msg = TradeValidationUtil.validateRequestSpecial(tradeRquest,TradePacketReqBodyInnerRefund.class,validates);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addCcunt(){
		TradePacketReqBodyQueryAndCheck body = new TradePacketReqBodyQueryAndCheck();
		body.setTrade_no("00050011605191926263210000000100");
		try {
			service.handlerRealAcount(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}