package com.liantuo.trade.client.trade.packet.body.withdraw;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.validator.date.DateTime;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * 成员提现-交易列表查询
 */
public class TradePacketReqBodySingleWithdrawPageDetails extends TradeRequestBody implements Paging {

    // 交易编号 trade_no 字符串 64 可空 联拓金融交易编号，精确查询条件
    @Pattern(message = "trade_no format error", regexp = "\\s||(.{0}|[\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String trade_no;

    // 交易客户保留字段1 merchant_extend_field_1 字符串 1024 可空 精确查询条件
    @Length(message = "merchant_extend_field_1 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_1;

    // 交易客户保留字段2 merchant_extend_field_2 字符串 1024 可空 精确查询条件
    @Length(message = "merchant_extend_field_2 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_2;

    // 交易客户保留字段3 merchant_extend_field_3 字符串 1024 可空 精确查询条件
    @Length(message = "merchant_extend_field_3 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_3;

    // 交易客户保留字段4 merchant_extend_field_4 字符串 1024 可空 精确查询条件
    @Length(message = "merchant_extend_field_4 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_4;

    // 交易客户保留字段5 merchant_extend_field_5 字符串 1024 可空 精确查询条件
    @Length(message = "merchant_extend_field_5 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_5;

    // 交易发起方发起请求编号 字符串 64 可空 精确查询条件
    @Pattern(message = "out_trade_no_ext format error", regexp = "\\s||(.{0}|[\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no_ext;

    // 交易发起方业务系统订单号 字符串 64 可空 精确查询条件
    @Pattern(message = "out_trade_no format error", regexp = "\\s||(.{0}|[\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no;

    // 交易状态 枚举 可空 精确查询条件
    @Pattern(message = "status format error", regexp = "\\s||([\\d]{2}(\\^[\\d]{2})*)", groups = Format.class)
    private String status;

    // 出款渠道编号 字符串 可空 精确查询条件
    @Pattern(message = "pay_clear_channel format error", regexp = "\\s||([\\d]{1,16})", groups = Format.class)
    private String pay_clear_channel;

    // 提交第三方批次号 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_batch_no format error", regexp = "\\s||([\\d|a-z-A-Z|_]{8,64})", groups = Format.class)
    private String withdraw_batch_no;

    // 提交第三方批次流水号 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_serial_number format error", regexp = "\\s||([\\d|a-z-A-Z|_]{1,64})", groups = Format.class)
    private String withdraw_serial_number;

    // 出款渠道订单号 字符串 可空 精确查询条件
    @Pattern(message = "pay_third_trade_no format error", regexp = "\\s||([\\d]{1,64})", groups = Format.class)
    private String pay_third_trade_no;

    // 付款方账户 字符串 可空 精确查询条件
    @Pattern(message = "payer_account format error", regexp = "\\s||(.{1,64})", groups = Format.class)
    private String payer_account;

    // 付款方账户名称 字符串 可空 模糊查询条件
    @Pattern(message = "payer_name format error", regexp = "\\s||(.{1,64})", groups = Format.class)
    private String payer_name;

    // 提现CA账户编号 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_account_no format error", regexp = "\\s||([\\w]{6,32})", groups = Format.class)
    private String withdraw_account_no;

    // 提现成员商户编号 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_merchant_no format error", regexp = "\\s||([\\w]{2,32})", groups = Format.class)
    private String withdraw_merchant_no;

    // 提现银行/账户编码 枚举 可空 精确查询条件
    @Pattern(message = "withdraw_account_type format error", regexp = "\\s||([\\d]{1,2})", groups = Format.class)
    private String withdraw_account_type;

    // 提现银行账户 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_bank_account format error", regexp = "\\s||([\\d]{1,64})", groups = Format.class)
    private String withdraw_bank_account;

    // 提现第三方账户 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_third_account format error", regexp = "\\s||(.{1,64})", groups = Format.class)
    private String withdraw_third_account;

    // 提现第三方账户姓名 字符串 可空 精确查询条件
    @Pattern(message = "withdraw_third_account_name format error", regexp = "\\s||(.{1,64})", groups = Format.class)
    private String withdraw_third_account_name;


    // 交易创建日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_created_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_created_start format error", groups = Format.class)
    private String gmt_created_start;

    // 交易创建日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_created_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_created_end format error", groups = Format.class)
    private String gmt_created_end;

    // 交易创建失败日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_created_fail_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_created_fail_start format error", groups = Format.class)
    private String gmt_created_fail_start;

    // 交易创建失败日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_created_fail_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_created_fail_end format error", groups = Format.class)
    private String gmt_created_fail_end;

    // 扣减成功日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_deduct_success_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_deduct_success_start format error", groups = Format.class)
    private String gmt_deduct_success_start;

    // 扣减成功日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_deduct_success_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_deduct_success_end format error", groups = Format.class)
    private String gmt_deduct_success_end;

    // 出款成功日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_pay_success_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_pay_success_start format error", groups = Format.class)
    private String gmt_pay_success_start;

    // 出款成功日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_pay_success_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_pay_success_end format error", groups = Format.class)
    private String gmt_pay_success_end;

    // 退回成功日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_refund_success_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_refund_success_start format error", groups = Format.class)
    private String gmt_refund_success_start;

    // 退回成功日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_refund_success_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_refund_success_end format error", groups = Format.class)
    private String gmt_refund_success_end;

    // 最后出款失败日期时间起始 日期时间 可空 日期时间起始
//    @Pattern(message="gmt_last_pay_fail_start format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_last_pay_fail_start format error", groups = Format.class)
    private String gmt_last_pay_fail_start;

    // 最后出款失败日期时间结束 日期时间 可空 日期时间截止
//    @Pattern(message="gmt_last_pay_fail_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    @DateTime(message = "gmt_last_pay_fail_end format error", groups = Format.class)
    private String gmt_last_pay_fail_end;

    // 分页页数 字符串 可空 默认0页，0表示第一页, 如总页数为20页，则分页页数为0-19页
    @Pattern(message = "page format error", regexp = "\\s||(0|[1-9][\\d]{0,8})", groups = Format.class)
    private String page = "0";

    // 分页每页条数 字符串 可空 默认50条，最大100条
    @Pattern(message = "page_size format error", regexp = "\\s||([1-9][0-9]?0?)", groups = Format.class)
    private String page_size = "50";

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getMerchant_extend_field_1() {
        return merchant_extend_field_1;
    }

    public void setMerchant_extend_field_1(String merchant_extend_field_1) {
        this.merchant_extend_field_1 = merchant_extend_field_1;
    }

    public String getMerchant_extend_field_2() {
        return merchant_extend_field_2;
    }

    public void setMerchant_extend_field_2(String merchant_extend_field_2) {
        this.merchant_extend_field_2 = merchant_extend_field_2;
    }

    public String getMerchant_extend_field_3() {
        return merchant_extend_field_3;
    }

    public void setMerchant_extend_field_3(String merchant_extend_field_3) {
        this.merchant_extend_field_3 = merchant_extend_field_3;
    }

    public String getMerchant_extend_field_4() {
        return merchant_extend_field_4;
    }

    public void setMerchant_extend_field_4(String merchant_extend_field_4) {
        this.merchant_extend_field_4 = merchant_extend_field_4;
    }

    public String getMerchant_extend_field_5() {
        return merchant_extend_field_5;
    }

    public void setMerchant_extend_field_5(String merchant_extend_field_5) {
        this.merchant_extend_field_5 = merchant_extend_field_5;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay_clear_channel() {
        return pay_clear_channel;
    }

    public void setPay_clear_channel(String pay_clear_channel) {
        this.pay_clear_channel = pay_clear_channel;
    }

    public String getWithdraw_batch_no() {
        return withdraw_batch_no;
    }

    public void setWithdraw_batch_no(String withdraw_batch_no) {
        this.withdraw_batch_no = withdraw_batch_no;
    }

    public String getWithdraw_serial_number() {
        return withdraw_serial_number;
    }

    public void setWithdraw_serial_number(String withdraw_serial_number) {
        this.withdraw_serial_number = withdraw_serial_number;
    }

    public String getPay_third_trade_no() {
        return pay_third_trade_no;
    }

    public void setPay_third_trade_no(String pay_third_trade_no) {
        this.pay_third_trade_no = pay_third_trade_no;
    }

    public String getPayer_account() {
        return payer_account;
    }

    public void setPayer_account(String payer_account) {
        this.payer_account = payer_account;
    }

    public String getPayer_name() {
        return payer_name;
    }

    public void setPayer_name(String payer_name) {
        this.payer_name = payer_name;
    }

    public String getWithdraw_account_no() {
        return withdraw_account_no;
    }

    public void setWithdraw_account_no(String withdraw_account_no) {
        this.withdraw_account_no = withdraw_account_no;
    }

    public String getWithdraw_merchant_no() {
        return withdraw_merchant_no;
    }

    public void setWithdraw_merchant_no(String withdraw_merchant_no) {
        this.withdraw_merchant_no = withdraw_merchant_no;
    }

    public String getWithdraw_account_type() {
        return withdraw_account_type;
    }

    public void setWithdraw_account_type(String withdraw_account_type) {
        this.withdraw_account_type = withdraw_account_type;
    }

    public String getWithdraw_bank_account() {
        return withdraw_bank_account;
    }

    public void setWithdraw_bank_account(String withdraw_bank_account) {
        this.withdraw_bank_account = withdraw_bank_account;
    }

    public String getWithdraw_third_account() {
        return withdraw_third_account;
    }

    public void setWithdraw_third_account(String withdraw_third_account) {
        this.withdraw_third_account = withdraw_third_account;
    }

    public String getWithdraw_third_account_name() {
        return withdraw_third_account_name;
    }

    public void setWithdraw_third_account_name(String withdraw_third_account_name) {
        this.withdraw_third_account_name = withdraw_third_account_name;
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

    public String getGmt_created_fail_start() {
        return gmt_created_fail_start;
    }

    public void setGmt_created_fail_start(String gmt_created_fail_start) {
        this.gmt_created_fail_start = gmt_created_fail_start;
    }

    public String getGmt_created_fail_end() {
        return gmt_created_fail_end;
    }

    public void setGmt_created_fail_end(String gmt_created_fail_end) {
        this.gmt_created_fail_end = gmt_created_fail_end;
    }

    public String getGmt_deduct_success_start() {
        return gmt_deduct_success_start;
    }

    public void setGmt_deduct_success_start(String gmt_deduct_success_start) {
        this.gmt_deduct_success_start = gmt_deduct_success_start;
    }

    public String getGmt_deduct_success_end() {
        return gmt_deduct_success_end;
    }

    public void setGmt_deduct_success_end(String gmt_deduct_success_end) {
        this.gmt_deduct_success_end = gmt_deduct_success_end;
    }

    public String getGmt_pay_success_start() {
        return gmt_pay_success_start;
    }

    public void setGmt_pay_success_start(String gmt_pay_success_start) {
        this.gmt_pay_success_start = gmt_pay_success_start;
    }

    public String getGmt_pay_success_end() {
        return gmt_pay_success_end;
    }

    public void setGmt_pay_success_end(String gmt_pay_success_end) {
        this.gmt_pay_success_end = gmt_pay_success_end;
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

    public String getGmt_last_pay_fail_start() {
        return gmt_last_pay_fail_start;
    }

    public void setGmt_last_pay_fail_start(String gmt_last_pay_fail_start) {
        this.gmt_last_pay_fail_start = gmt_last_pay_fail_start;
    }

    public String getGmt_last_pay_fail_end() {
        return gmt_last_pay_fail_end;
    }

    public void setGmt_last_pay_fail_end(String gmt_last_pay_fail_end) {
        this.gmt_last_pay_fail_end = gmt_last_pay_fail_end;
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
