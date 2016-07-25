package com.liantuo.trade.client.trade.packet.body.simple_fund_transfer;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.validator.date.DateTime;

/**
 * 0007_001_998
 * 0007_001_999
 * 成员转账-列表查询VO
 */
public class QueryPage4TransferDetail extends TradeRequestBody implements Paging{

	/*@NotBlank(message = "partner_id is required", groups = {Required.class})
	private String partner_id;
	@NotBlank(message = "core_merchant_no is required", groups = {Required.class})
	@Pattern(message = "core_merchant_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
	private String core_merchant_no;

	@NotBlank(message = "fund_pool_no is required", groups = {Required.class})
	@Pattern(message = "fund_pool_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String fund_pool_no;*/
	
	 @Pattern(message = "trade_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
	private String trade_no;
	
    @Pattern(message = "extend_field_1_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_1_accurate_query;
    
    @Pattern(message = "extend_field_2_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_2_accurate_query;
    
    @Pattern(message = "extend_field_3_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_3_accurate_query;
    @Pattern(message = "extend_field_4_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_4_accurate_query;
    @Pattern(message = "extend_field_5_accurate_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_5_accurate_query;
    
    @Pattern(message = "extend_field_1_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_1_fuzzy_query;
    @Pattern(message = "extend_field_2_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_2_fuzzy_query;
    @Pattern(message = "extend_field_3_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_3_fuzzy_query;
    @Pattern(message = "extend_field_4_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_4_fuzzy_query;
    @Pattern(message = "extend_field_5_fuzzy_query format error", regexp = "({0})||(.{0,1024})", groups = Format.class)
    private String extend_field_5_fuzzy_query;
    
    @Pattern(message = "out_trade_no format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no;

    @Pattern(message = "out_trade_no_ext format error", regexp = "({0})||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no_ext;
    
    @Pattern(message = "payment_account_no format error", regexp = "({0})||([\\w]{6,32})", groups = Format.class)
    private String payment_account_no;
    
    /**
     * 参数名：付出成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "payment_merchant_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String payment_merchant_no;
    
    //CA成员收款信息
    @Pattern(message = "receive_account_no format error", regexp = "({0})||([\\w]{6,32})", groups = Format.class)
    private String receive_account_no;
    
    /**
     * 参数名：收款成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "receive_merchant_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String receive_merchant_no;
    
    /**
     * 参数名：转账起始金额
     */
//    @DecimalMin(message = "transfer_amount_start format error", groups = { Format.class }, value = "0.00")
//    @Digits(message = "transfer_amount_start format error", groups = { Format.class }, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    @Pattern(message = "transfer_amount_start format error", regexp = "{0}||(\\d{1}\\d{0,12}(\\.\\d{0,2})?)", groups = Format.class)
    private String transfer_amount_start;
    
    
    /**
     * 参数名：转账金额结束
     */
//    @DecimalMin(message = "transfer_amount_end format error", groups = { Format.class }, value = "0.00")
//    @Digits(message = "transfer_amount_end format error", groups = { Format.class }, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    @Pattern(message = "transfer_amount_end format error", regexp = "{0}||(\\d{1}\\d{0,12}(\\.\\d{0,2})?)", groups = Format.class)
    private String transfer_amount_end;
    
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
     * 版本：1.1
     */
    @Pattern(message = "status format error", regexp = "({0})||([\\d]{2}(\\^[\\d]{2})*)", groups = Format.class)
    private String status;
    
 // 分页页数 字符串 可空 默认0页，0表示第一页, 如总页数为20页，则分页页数为0-19页
    @Pattern(message = "page format error", regexp = "({0})||(0|[1-9][\\d]{0,8})", groups = Format.class)
    private String page = "0";

    // 分页每页条数 字符串 可空 默认50条，最大100条
    @Pattern(message = "page_size format error", regexp = "({0})||([1-9][0-9]?0?)", groups = Format.class)
    private String page_size = "50";
    
    
    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String out_trade_no_ext) {
        this.out_trade_no_ext = out_trade_no_ext;
    }

    public String getPayment_account_no() {
        return payment_account_no;
    }

    public void setPayment_account_no(String payment_account_no) {
        this.payment_account_no = payment_account_no;
    }



    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

	public String getReceive_account_no() {
		return receive_account_no;
	}

	public void setReceive_account_no(String receive_account_no) {
		this.receive_account_no = receive_account_no;
	}
	
	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getExtend_field_1_accurate_query() {
		return extend_field_1_accurate_query;
	}

	public void setExtend_field_1_accurate_query(String extend_field_1_accurate_query) {
		this.extend_field_1_accurate_query = extend_field_1_accurate_query;
	}

	public String getExtend_field_2_accurate_query() {
		return extend_field_2_accurate_query;
	}

	public void setExtend_field_2_accurate_query(String extend_field_2_accurate_query) {
		this.extend_field_2_accurate_query = extend_field_2_accurate_query;
	}

	public String getExtend_field_3_accurate_query() {
		return extend_field_3_accurate_query;
	}

	public void setExtend_field_3_accurate_query(String extend_field_3_accurate_query) {
		this.extend_field_3_accurate_query = extend_field_3_accurate_query;
	}

	public String getExtend_field_4_accurate_query() {
		return extend_field_4_accurate_query;
	}

	public void setExtend_field_4_accurate_query(String extend_field_4_accurate_query) {
		this.extend_field_4_accurate_query = extend_field_4_accurate_query;
	}

	public String getExtend_field_5_accurate_query() {
		return extend_field_5_accurate_query;
	}

	public void setExtend_field_5_accurate_query(String extend_field_5_accurate_query) {
		this.extend_field_5_accurate_query = extend_field_5_accurate_query;
	}

	public String getExtend_field_1_fuzzy_query() {
		return extend_field_1_fuzzy_query;
	}

	public void setExtend_field_1_fuzzy_query(String extend_field_1_fuzzy_query) {
		this.extend_field_1_fuzzy_query = extend_field_1_fuzzy_query;
	}

	public String getExtend_field_2_fuzzy_query() {
		return extend_field_2_fuzzy_query;
	}

	public void setExtend_field_2_fuzzy_query(String extend_field_2_fuzzy_query) {
		this.extend_field_2_fuzzy_query = extend_field_2_fuzzy_query;
	}

	public String getExtend_field_3_fuzzy_query() {
		return extend_field_3_fuzzy_query;
	}

	public void setExtend_field_3_fuzzy_query(String extend_field_3_fuzzy_query) {
		this.extend_field_3_fuzzy_query = extend_field_3_fuzzy_query;
	}

	public String getExtend_field_4_fuzzy_query() {
		return extend_field_4_fuzzy_query;
	}

	public void setExtend_field_4_fuzzy_query(String extend_field_4_fuzzy_query) {
		this.extend_field_4_fuzzy_query = extend_field_4_fuzzy_query;
	}

	public String getExtend_field_5_fuzzy_query() {
		return extend_field_5_fuzzy_query;
	}

	public void setExtend_field_5_fuzzy_query(String extend_field_5_fuzzy_query) {
		this.extend_field_5_fuzzy_query = extend_field_5_fuzzy_query;
	}

	public String getPayment_merchant_no() {
		return payment_merchant_no;
	}

	public void setPayment_merchant_no(String payment_merchant_no) {
		this.payment_merchant_no = payment_merchant_no;
	}

	public String getReceive_merchant_no() {
		return receive_merchant_no;
	}

	public void setReceive_merchant_no(String receive_merchant_no) {
		this.receive_merchant_no = receive_merchant_no;
	}

	public String getTransfer_amount_start() {
		return transfer_amount_start;
	}

	public void setTransfer_amount_start(String transfer_amount_start) {
		this.transfer_amount_start = transfer_amount_start;
	}

	public String getTransfer_amount_end() {
		return transfer_amount_end;
	}

	public void setTransfer_amount_end(String transfer_amount_end) {
		this.transfer_amount_end = transfer_amount_end;
	}

	public String getGmt_created_start() {
		return gmt_created_start;
	}

	public void setGmt_created_start(String gmt_created_start) {
		this.gmt_created_start = gmt_created_start;
	}

	public String getGmt_created_end() {
		return gmt_created_end;
	}

	public void setGmt_created_end(String gmt_created_end) {
		this.gmt_created_end = gmt_created_end;
	}

	public String getGmt_latest_modified_start() {
		return gmt_latest_modified_start;
	}

	public void setGmt_latest_modified_start(String gmt_latest_modified_start) {
		this.gmt_latest_modified_start = gmt_latest_modified_start;
	}

	public String getGmt_latest_modified_end() {
		return gmt_latest_modified_end;
	}

	public void setGmt_latest_modified_end(String gmt_latest_modified_end) {
		this.gmt_latest_modified_end = gmt_latest_modified_end;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public String getPage() {
		return page;
	}

	@Override
	public String getPage_size() {
		return page_size;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}
	
}