package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.validator.date.DateTime;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Pattern;

/**
 * 交易列表查询 退款 请求VO
 * 0001_002_998
 * 0001_002_999
 */
public class TradePacketReqBodyRefundPageDetails extends TradeRequestBody implements Paging {
    /**
     * 参数名：交易编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "trade_no format error", regexp = "\\s||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String trade_no;
    /**
     * 参数名：交易发起方发起请求编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "out_trade_no_ext format error", regexp = "\\s||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no_ext;

    @Pattern(message = "out_trade_no format error", regexp = "\\s||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no;
    /**
     * 参数名：付出成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "clear_order_no format error", regexp = "\\s||([\\d|a-z-A-Z|_]{1,128})", groups = Format.class)
    private String clear_order_no;

    @Pattern(message = "refund_merchant_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String refund_merchant_no;

    @Pattern(message = "refund_account_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String refund_account_no;
    /**
     * 参数名：收款成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "receive_merchant_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String receive_merchant_no;

    @Pattern(message = "receive_account_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String receive_account_no;
    
    /**
     * 参数名：付出成员商户编号</br>
     * 参数类型：必填</br>
     */
    @Pattern(message = "payment_merchant_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String payment_merchant_no;

    @Pattern(message = "status format error", regexp = "\\s||([\\d]{2}(\\^[\\d]{2})*)", groups = Format.class)
    private String status;
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

    @DateTime(message = "gmt_refund_success_start format error", groups = Format.class)
    private String gmt_refund_success_start;

    @DateTime(message = "gmt_refund_success_end format error", groups = Format.class)
    private String gmt_refund_success_end;

    @DateTime(message = "gmt_fund_channel_refund_success_start format error", groups = Format.class)
    private String gmt_fund_channel_refund_success_start;

    @DateTime(message = "gmt_fund_channel_refund_success_end format error", groups = Format.class)
    private String gmt_fund_channel_refund_success_end;

    /**
     * 交易客户保留字段1
     */
    @Pattern(message = "extend_field_1_accurate_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_1_accurate_query;
    /**
     * 交易客户保留字段2
     */
    @Pattern(message = "extend_field_2_accurate_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_2_accurate_query;
    /**
     * 交易客户保留字段3
     */
    @Pattern(message = "extend_field_3_accurate_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_3_accurate_query;
    /**
     * 交易客户保留字段4
     */
    @Pattern(message = "extend_field_4_accurate_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_4_accurate_query;
    /**
     * 交易客户保留字段5
     */
    @Pattern(message = "extend_field_5_accurate_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_5_accurate_query;
    /**
     * 交易客户保留字段1
     */
    @Pattern(message = "extend_field_1_fuzzy_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_1_fuzzy_query;
    /**
     * 交易客户保留字段2
     */
    @Pattern(message = "extend_field_2_fuzzy_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_2_fuzzy_query;
    /**
     * 交易客户保留字段3
     */
    @Pattern(message = "extend_field_3_fuzzy_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_3_fuzzy_query;
    /**
     * 交易客户保留字段4
     */
    @Pattern(message = "extend_field_4_fuzzy_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_4_fuzzy_query;
    /**
     * 交易客户保留字段5
     */
    @Pattern(message = "extend_field_5_fuzzy_query format error", regexp = "\\s||(.{0,1024})", groups = Format.class)
    private String extend_field_5_fuzzy_query;

    @Pattern(message = "page format error", regexp = "\\s||(0|[1-9][\\d]{0,8})", groups = Format.class)
    private String page = "0";

    @Pattern(message = "page_size format error", regexp = "\\s||([1-9][0-9]?0?)", groups = Format.class)
    private String page_size = "50";

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String out_trade_no_ext) {
        this.out_trade_no_ext = out_trade_no_ext;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getClear_order_no() {
        return clear_order_no;
    }

    public void setClear_order_no(String clear_order_no) {
        this.clear_order_no = clear_order_no;
    }

    public String getRefund_merchant_no() {
        return refund_merchant_no;
    }

    public void setRefund_merchant_no(String refund_merchant_no) {
        this.refund_merchant_no = refund_merchant_no;
    }

    public String getRefund_account_no() {
        return refund_account_no;
    }

    public void setRefund_account_no(String refund_account_no) {
        this.refund_account_no = refund_account_no;
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

    public String getReceive_account_no() {
        return receive_account_no;
    }

    public void setReceive_account_no(String receive_account_no) {
        this.receive_account_no = receive_account_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getGmt_refund_success_start() {
        return gmt_refund_success_start;
    }

    public void setGmt_refund_success_start(String gmt_refund_success_start) {
        this.gmt_refund_success_start = gmt_refund_success_start;
    }

    public String getGmt_refund_success_end() {
        return gmt_refund_success_end;
    }

    public void setGmt_refund_success_end(String gmt_refund_success_end) {
        this.gmt_refund_success_end = gmt_refund_success_end;
    }

    public String getGmt_fund_channel_refund_success_start() {
        return gmt_fund_channel_refund_success_start;
    }

    public void setGmt_fund_channel_refund_success_start(String gmt_fund_channel_refund_success_start) {
        this.gmt_fund_channel_refund_success_start = gmt_fund_channel_refund_success_start;
    }

    public String getGmt_fund_channel_refund_success_end() {
        return gmt_fund_channel_refund_success_end;
    }

    public void setGmt_fund_channel_refund_success_end(String gmt_fund_channel_refund_success_end) {
        this.gmt_fund_channel_refund_success_end = gmt_fund_channel_refund_success_end;
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
}