package com.liantuo.trade.client.trade.packet.body.withdraw;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 提现报文body
 */
public class WithdrawNotifyReqBody extends NotifyReqBody{

    // 字段
    @NotBlank(message = "out_batch_no is required", groups = Required.class)
    @Pattern(message = "out_batch_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_batch_no; // 商户批次号
    
    public String getOut_batch_no() {
        return out_batch_no;
    }

    public void setOut_batch_no(String out_batch_no) {
        this.out_batch_no = out_batch_no;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
