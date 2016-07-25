package com.liantuo.trade.client.trade.packet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"return_code", "is_success", "err_code", "err_code_des"})
public abstract class TradePacketResultInfo {
    /**
     * 通信标识
     */
    private String return_code;
    /**
     * 业务结果
     */
    private String is_success;//
    /**
     * 错误码
     */
    private String err_code;//
    /**
     * 错误描述
     */
    private String err_code_des;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String isSuccess) {
        is_success = isSuccess;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}