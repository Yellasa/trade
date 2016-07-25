package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 *
 * 全额解冻 请求VO
* 0001_001_002
 */
public class TradePacketReqBodyFullUnFreeze extends TradeRequestBody {

    /**
     * 参数名：原交易编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "trade_no is required", groups = {Required.class})
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String trade_no;

    /**
     * 冻结余额减少客户账务历史
     */
    @Pattern(message = "fro_bal_decr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_1;
    @Pattern(message = "fro_bal_decr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_2;
    @Pattern(message = "fro_bal_decr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_3;
    /**
     * 可用余额增加客户账务历史
     */
    @Pattern(message = "avl_bal_incr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_1;
    @Pattern(message = "avl_bal_incr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_2;
    @Pattern(message = "avl_bal_incr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_3;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String tradeNo) {
        trade_no = tradeNo;
    }

    public String getFro_bal_decr_field_1() {
		return fro_bal_decr_field_1;
	}

	public void setFro_bal_decr_field_1(String fro_bal_decr_field_1) {
		this.fro_bal_decr_field_1 = fro_bal_decr_field_1;
	}

	public String getFro_bal_decr_field_2() {
		return fro_bal_decr_field_2;
	}

	public void setFro_bal_decr_field_2(String fro_bal_decr_field_2) {
		this.fro_bal_decr_field_2 = fro_bal_decr_field_2;
	}

	public String getFro_bal_decr_field_3() {
		return fro_bal_decr_field_3;
	}

	public void setFro_bal_decr_field_3(String fro_bal_decr_field_3) {
		this.fro_bal_decr_field_3 = fro_bal_decr_field_3;
	}

	public String getAvl_bal_incr_field_1() {
		return avl_bal_incr_field_1;
	}

	public void setAvl_bal_incr_field_1(String avl_bal_incr_field_1) {
		this.avl_bal_incr_field_1 = avl_bal_incr_field_1;
	}

	public String getAvl_bal_incr_field_2() {
		return avl_bal_incr_field_2;
	}

	public void setAvl_bal_incr_field_2(String avl_bal_incr_field_2) {
		this.avl_bal_incr_field_2 = avl_bal_incr_field_2;
	}

	public String getAvl_bal_incr_field_3() {
		return avl_bal_incr_field_3;
	}

	public void setAvl_bal_incr_field_3(String avl_bal_incr_field_3) {
		this.avl_bal_incr_field_3 = avl_bal_incr_field_3;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
