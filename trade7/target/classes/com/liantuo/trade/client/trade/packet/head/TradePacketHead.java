package com.liantuo.trade.client.trade.packet.head;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlTransient;

//@XmlType(propOrder = { "version", "partner_id", "core_merchant_no","fund_pool_no","request_code","request_time","sign"})
public class TradePacketHead implements java.io.Serializable {
    @NotBlank(message = "partner_id is required", groups = Required.class)
//    @Length(message = "partner_id length not match", min = 17, max = 17, groups = Format.class)
    @Pattern(message = "partner_id content not match", regexp = "[\\d]{17}", groups = Format.class)
    private String partner_id;

    @NotBlank(message = "core_merchant_no is required", groups = Required.class)
//    @Length(message = "core_merchant_no length not match", min = 2, max = 32, groups = Format.class)
    @Pattern(message = "core_merchant_no content not match", regexp = "\\s||([\\d|a-z-A-Z|_]{2,32})", groups = Format.class)
    private String core_merchant_no;

    @NotBlank(message = "fund_pool_no is required", groups = Required.class)
//    @Length(message = "fund_pool_no length not match", min =19, max = 32, groups = Format.class)
    @Pattern(message = "fund_pool_no content not match", regexp = "\\s||([\\d|a-z-A-Z|_]{19,32})", groups = Format.class)
    private String fund_pool_no;

    @NotBlank(message = "request_code is required", groups = Required.class)
//    @Length(message = "request_code length not match", min = 12, max = 32, groups = Format.class)
    @Pattern(message = "request_code content not match", regexp = "[\\da-zA-Z_]{12,32}", groups = Format.class)
    private String request_code;

    @NotBlank(message = "request_time is required", groups = Required.class)
    @Length(message = "request_time length not match", min = 14, max = 32, groups = Format.class)
    private String request_time;

    @NotBlank(message = "version is required", groups = Required.class)
//    @Length(message = "version length not match", min = 1, max = 5, groups = Format.class)
    @Pattern(message = "version content not match", regexp = "[\\d]{1,2}(\\.[\\d]{1,2})?", groups = Format.class)
    private String version;

    @NotBlank(message = "sign is required", groups = Required.class)
//    @Length(message = "sign length not match", min = 32, max = 32, groups = Format.class)
    @Pattern(message = "sign content not match", regexp = "[\\da-zA-Z]{32}", groups = Format.class)
    private String sign;

    private String auth_code;
    private String system_code;
    private String busi_code;

    @XmlTransient
    public String getSystem_code() {
        return system_code;
    }

    @XmlTransient
    public String getBusi_code() {
        return busi_code;
    }

    @XmlTransient
    public String getAuth_code() {
        return auth_code;
    }

    public String getRequest_code() {
        return request_code;
    }

    public void setRequest_code(String request_code) {
        this.request_code = request_code;
    }

    public void setSystem_code(String system_code) {
        this.system_code = system_code;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getCore_merchant_no() {
        return core_merchant_no;
    }

    public void setCore_merchant_no(String core_merchant_no) {
        this.core_merchant_no = core_merchant_no;
    }

    public String getFund_pool_no() {
        return fund_pool_no;
    }

    public void setFund_pool_no(String fund_pool_no) {
        this.fund_pool_no = fund_pool_no;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }


    public void setBusi_code(String busi_code) {
        this.busi_code = busi_code;
    }

    public String getRequest_time() {
        return request_time;
    }

    public void setRequest_time(String request_time) {
        this.request_time = request_time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static void main(String[] args) {
        System.err.println("0001_001_001".matches("[\\d|_]"));
    }
}
