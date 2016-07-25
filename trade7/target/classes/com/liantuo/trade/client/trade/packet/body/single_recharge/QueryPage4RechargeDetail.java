package com.liantuo.trade.client.trade.packet.body.single_recharge;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.validator.date.DateTime;

import javax.validation.constraints.Pattern;

/**
 * @author jiangkun
 * @version V1.0
 * @ClassName: QueryPage4RechargeDetail
 * @Description: 0005_001_998 V1.0 0005_001_999 V1.0 成员充值-交易列表查询
 * Company:联拓金融信息服务有限公司
 * @Date 2016-4-26
 */
public class QueryPage4RechargeDetail extends TradeRequestBody implements Paging {

    /**
     * 参数名：交易编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "trade_no format error", regexp = ".{0}|([\\d|a-zA-Z|_]{8,64})", groups = Format.class)
    private String trade_no;

    /**
     * 参数名：交易客户保留字段1<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_1;

    /**
     * 参数名：交易客户保留字段2<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_2;

    /**
     * 参数名：交易客户保留字段3<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_3;

    /**
     * 参数名：交易客户保留字段4<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "merchant_extend_field_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_4;

    /**
     * 参数名：交易客户保留字段5<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "merchant_extend_field_5 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_5;

    /**
     * 参数名：交易发起方发起请求编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "out_trade_no_ext format error", regexp = ".{0}|([\\d|a-zA-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no_ext;

    /**
     * 参数名：交易发起方业务系统订单号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "out_trade_no format error", regexp = ".{0}|([\\d|a-zA-Z|_]{8,64})", groups = Format.class)
    private String out_trade_no;

    /**
     * 参数名：交易创建日期时间起始<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_created_start format error", groups = Format.class)
    private String gmt_created_start;
    
    /**
     * 参数名：交易创建日期时间结束<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_created_end format error", groups = Format.class)
    private String gmt_created_end;
    
    /**
     * 参数名：最后变更日期时间起始<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_latest_modified_start format error", groups = Format.class)
    private String gmt_latest_modified_start;
    
    /**
     * 参数名：最后变更日期时间截止<br/>
     * 参数类型：可空<br/>
     */
    @DateTime(message = "gmt_latest_modified_end format error", groups = Format.class)
    private String gmt_latest_modified_end;
    
    /**
     * 参数名：充值CA账户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "recharge_account_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String recharge_account_no;
    
    /**
     * 参数名：充值成员商户编号<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "recharge_merchant_no format error", regexp = "({0})||([\\w]{2,32})", groups = Format.class)
    private String recharge_merchant_no;
    
    /**
     * 参数名：交易状态<br/>
     * 参数类型：可空<br/>
     */
    @Pattern(message = "status format error", regexp = "({0})||([\\d]{2}(\\^[\\d]{2})*)", groups = Format.class)
    private String status;

    /**
     * 参数名：分页页数<br/>
     * 参数类型：可空<br/>
     * 分页页数 字符串 可空 默认0页，0表示第一页, 如总页数为20页，则分页页数为0-19页
     */
    @Pattern(message = "page format error", regexp = "({0})||(0|[1-9][\\d]{0,7})", groups = Format.class)
    private String page = "0";

    /**
     * 参数名：分页每页条数<br/>
     * 参数类型：可空<br/>
     * 分页每页条数 字符串 可空 默认50条，最大100条
     */
    @Pattern(message = "page_size format error", regexp = "({0})||([1-9][0-9]?0?)", groups = Format.class)
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
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

	public String getRecharge_account_no() {
		return recharge_account_no;
	}

	public void setRecharge_account_no(String recharge_account_no) {
		this.recharge_account_no = recharge_account_no;
	}

	public String getRecharge_merchant_no() {
		return recharge_merchant_no;
	}

	public void setRecharge_merchant_no(String recharge_merchant_no) {
		this.recharge_merchant_no = recharge_merchant_no;
	}
    
    
}