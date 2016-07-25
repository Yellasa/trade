package com.liantuo.trade.client.trade.packet.body.simple_fund_handle;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.annotation.EmptyAnnotation;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.validator.date.DateTime;

/**
 * @ClassName:     TradePacketReqBodyAdjustAccountQry.java
 * @Description:   0003_001_998 V1.0CA调整
 * Company:联拓金融信息服务有限公司
 * @author         zzd
 * @version        V1.0  
 * @Date           2016-4-5 下午5:18:34 
 */
public class TradePacketReqBodyAdjustAccountQry extends TradeRequestBody  implements Paging{
    /**
     * 参数名：交易编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "trade_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String trade_no;
    
    /**
     * 交易客户保留字段1
     */
    @Pattern(message = "extend_field_1_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_1_accurate_query;
    /**
     * 交易客户保留字段2
     */
    @Pattern(message = "extend_field_2_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_2_accurate_query;
    /**
     * 交易客户保留字段3
     */
    @Pattern(message = "extend_field_3_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_3_accurate_query;
    /**
     * 交易客户保留字段4
     */
    @Pattern(message = "extend_field_4_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_4_accurate_query;
    /**
     * 交易客户保留字段5
     */
    @Pattern(message = "extend_field_5_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_5_accurate_query;
    /**
     * 交易客户保留字段1
     */
    @Pattern(message = "extend_field_1_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_1_fuzzy_query;
    /**
     * 交易客户保留字段2
     */
    @Pattern(message = "extend_field_2_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_2_fuzzy_query;
    /**
     * 交易客户保留字段3
     */
    @Pattern(message = "extend_field_3_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_3_fuzzy_query;
    /**
     * 交易客户保留字段4
     */
    @Pattern(message = "extend_field_4_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_4_fuzzy_query;
    /**
     * 交易客户保留字段5
     */
    @Pattern(message = "extend_field_5_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_5_fuzzy_query;
    
    /**
     * 参数名：交易发起方发起请求编号 <br/>
     * 参数类型：可空 <br/>
     */
    @Pattern(message = "out_trade_no_ext format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no_ext;
    /**
     * 参数名：交易发起方业务系统订单号 <br/>
     * 参数类型：可空 <br/>
     */
    @Pattern(message = "out_trade_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no;
    
    /**
     * 参数名：交易创建日期时间起始<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_created_start format error", groups = Format.class)
    private String gmt_created_start;
    /**
     * 参数名：交易创建日期时间截止<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_created_end format error", groups = Format.class)
    private String gmt_created_end;
    /**
     * 参数名：交易最后变更日期时间起始<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_latest_modified_start format error", groups = Format.class)
    private String gmt_latest_modified_start;
    /**
     * 参数名：交易最后变更日期时间终止<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_latest_modified_end format error", groups = Format.class)
    private String gmt_latest_modified_end;
    
    /**
     * 参数名：交易状态<br/>
     * 参数类型：可空<br/>
     * 版本：1.0
     */
    @Pattern(message = "status format error", regexp = "({0})||([\\d]{2}(\\^[\\d]{2})*)", groups = Format.class)
    private String status;
    
    /**
     * 参数名：付出成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "payment_merchant_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String payment_merchant_no;
    /**
     * 参数名：付出CA账户编号<br/>
     * 参数类型：可空<br/>
     * 版本：1.0
     */
    @Pattern(message = "payment_account_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String payment_account_no;
    /**
     * 参数名：收款成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "receive_merchant_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String receive_merchant_no;
    /**
     * 参数名：收款CA账户编号<br/>
     * 参数类型：可空<br/>
     * 版本：1.0
     */
    @Pattern(message = "receive_account_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String receive_account_no;
   
    /**
     * 请求组别
     */
    @Pattern(message = "request_group format error", regexp = "({0})||([\\d]{2})", groups = Format.class)
    private String request_group;
    
    /**
     * 收付款渠道编号
     */
    @Pattern(message = "clear_channel format error", regexp = "({0})||([\\w]{1,16})", groups = Format.class)
    private String clear_channel;
    
    /**
     * 收付款渠道收到日期时间起始
     */
    @DateTime(message = "gmt_success_clear_channel_start format error", groups = Format.class)
    private String gmt_success_clear_channel_start;
    /**
     * 收付款渠道收到日期时间结束
     */
    @DateTime(message = "gmt_success_clear_channel_end format error", groups = Format.class)
    private String gmt_success_clear_channel_end;
    
    /**
     * 收付款渠道订单号
     */
    @Pattern(message = "third_trade_no format error", regexp = "({0})||([\\w]{1,128})", groups = Format.class)
    private String third_trade_no;
    
    /**
     * 调整金额起始
     */
//    @DecimalMin(message = "adjust_amount_start format error", groups = {Format.class}, value = "0.00")
    @Pattern(message = "adjust_amount_start format error", regexp = "{0}||(\\d{1}\\d{0,12}(\\.\\d{0,2})?)", groups = Format.class)
//    @Digits(message = "adjust_amount_start format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String adjust_amount_start;
    
    /**
     * 调整金额结束
     */
//    @DecimalMin(message = "adjust_amount_end format error", groups = {Format.class}, value = "0.00")
//    @Digits(message = "adjust_amount_end format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    @Pattern(message = "adjust_amount_end format error", regexp = "{0}||(\\d{1}\\d{0,12}(\\.\\d{0,2})?)", groups = Format.class)
    private String adjust_amount_end;

    @Pattern(message = "page format error", regexp = "({0})||(0|[1-9][\\d]{0,8})", groups = Format.class)
    private String page = "0";

    @Max(value=100,message="page_size format error",groups = {Format.class})
    @Pattern(message = "page_size format error", regexp = "({0})||([1-9][0-9]?0?)", groups = Format.class)
    private String page_size = "50";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        if(null != page && "".equals(page.trim()))return;
        this.page = page;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        if(null != page_size && "".equals(page_size.trim()))return;
        this.page_size = page_size;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String tradeNo) {
		trade_no = tradeNo;
	}

	public String getExtend_field_1_accurate_query() {
		return extend_field_1_accurate_query;
	}

	public void setExtend_field_1_accurate_query(String extendField_1AccurateQuery) {
		extend_field_1_accurate_query = extendField_1AccurateQuery;
	}

	public String getExtend_field_2_accurate_query() {
		return extend_field_2_accurate_query;
	}

	public void setExtend_field_2_accurate_query(String extendField_2AccurateQuery) {
		extend_field_2_accurate_query = extendField_2AccurateQuery;
	}

	public String getExtend_field_3_accurate_query() {
		return extend_field_3_accurate_query;
	}

	public void setExtend_field_3_accurate_query(String extendField_3AccurateQuery) {
		extend_field_3_accurate_query = extendField_3AccurateQuery;
	}

	public String getExtend_field_4_accurate_query() {
		return extend_field_4_accurate_query;
	}

	public void setExtend_field_4_accurate_query(String extendField_4AccurateQuery) {
		extend_field_4_accurate_query = extendField_4AccurateQuery;
	}

	public String getExtend_field_5_accurate_query() {
		return extend_field_5_accurate_query;
	}

	public void setExtend_field_5_accurate_query(String extendField_5AccurateQuery) {
		extend_field_5_accurate_query = extendField_5AccurateQuery;
	}

	public String getExtend_field_1_fuzzy_query() {
		return extend_field_1_fuzzy_query;
	}

	public void setExtend_field_1_fuzzy_query(String extendField_1FuzzyQuery) {
		extend_field_1_fuzzy_query = extendField_1FuzzyQuery;
	}

	public String getExtend_field_2_fuzzy_query() {
		return extend_field_2_fuzzy_query;
	}

	public void setExtend_field_2_fuzzy_query(String extendField_2FuzzyQuery) {
		extend_field_2_fuzzy_query = extendField_2FuzzyQuery;
	}

	public String getExtend_field_3_fuzzy_query() {
		return extend_field_3_fuzzy_query;
	}

	public void setExtend_field_3_fuzzy_query(String extendField_3FuzzyQuery) {
		extend_field_3_fuzzy_query = extendField_3FuzzyQuery;
	}

	public String getExtend_field_4_fuzzy_query() {
		return extend_field_4_fuzzy_query;
	}

	public void setExtend_field_4_fuzzy_query(String extendField_4FuzzyQuery) {
		extend_field_4_fuzzy_query = extendField_4FuzzyQuery;
	}

	public String getExtend_field_5_fuzzy_query() {
		return extend_field_5_fuzzy_query;
	}

	public void setExtend_field_5_fuzzy_query(String extendField_5FuzzyQuery) {
		extend_field_5_fuzzy_query = extendField_5FuzzyQuery;
	}

	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}

	public void setOut_trade_no_ext(String outTradeNoExt) {
		out_trade_no_ext = outTradeNoExt;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}

	public String getGmt_created_start() {
		return gmt_created_start;
	}

	public void setGmt_created_start(String gmtCreatedStart) {
		gmt_created_start = gmtCreatedStart;
	}

	public String getGmt_created_end() {
		return gmt_created_end;
	}

	public void setGmt_created_end(String gmtCreatedEnd) {
		gmt_created_end = gmtCreatedEnd;
	}

	public String getGmt_latest_modified_start() {
		return gmt_latest_modified_start;
	}

	public void setGmt_latest_modified_start(String gmtLatestModifiedStart) {
		gmt_latest_modified_start = gmtLatestModifiedStart;
	}

	public String getGmt_latest_modified_end() {
		return gmt_latest_modified_end;
	}

	public void setGmt_latest_modified_end(String gmtLatestModifiedEnd) {
		gmt_latest_modified_end = gmtLatestModifiedEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_merchant_no() {
		return payment_merchant_no;
	}

	public void setPayment_merchant_no(String paymentMerchantNo) {
		payment_merchant_no = paymentMerchantNo;
	}

	public String getPayment_account_no() {
		return payment_account_no;
	}

	public void setPayment_account_no(String paymentAccountNo) {
		payment_account_no = paymentAccountNo;
	}

	public String getReceive_merchant_no() {
		return receive_merchant_no;
	}

	public void setReceive_merchant_no(String receiveMerchantNo) {
		receive_merchant_no = receiveMerchantNo;
	}

	public String getReceive_account_no() {
		return receive_account_no;
	}

	public void setReceive_account_no(String receiveAccountNo) {
		receive_account_no = receiveAccountNo;
	}

	public String getRequest_group() {
		return request_group;
	}

	public void setRequest_group(String requestGroup) {
		request_group = requestGroup;
	}

	public String getClear_channel() {
		return clear_channel;
	}

	public void setClear_channel(String clearChannel) {
		clear_channel = clearChannel;
	}

	public String getGmt_success_clear_channel_start() {
		return gmt_success_clear_channel_start;
	}

	public void setGmt_success_clear_channel_start(
			String gmtSuccessClearChannelStart) {
		gmt_success_clear_channel_start = gmtSuccessClearChannelStart;
	}

	public String getGmt_success_clear_channel_end() {
		return gmt_success_clear_channel_end;
	}

	public void setGmt_success_clear_channel_end(String gmtSuccessClearChannelEnd) {
		gmt_success_clear_channel_end = gmtSuccessClearChannelEnd;
	}

	public String getThird_trade_no() {
		return third_trade_no;
	}

	public void setThird_trade_no(String thirdTradeNo) {
		third_trade_no = thirdTradeNo;
	}

	public String getAdjust_amount_start() {
		return adjust_amount_start;
	}

	public void setAdjust_amount_start(String adjustAmountStart) {
		adjust_amount_start = adjustAmountStart;
	}

	public String getAdjust_amount_end() {
		return adjust_amount_end;
	}

	public void setAdjust_amount_end(String adjustAmountEnd) {
		adjust_amount_end = adjustAmountEnd;
	}
}