package com.liantuo.deposit.advanceaccount.web.vo.req;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;


public class OpenCreditAccountReqVo {
  /**
   * partnerid 验证规则 ：17 数字
   */
  @NotBlank(message="partner_id is required")
  @Pattern(message="partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
  private String partnerId;
  /**
   * @Fields coreMerchantNo : 余额账户所属资金池商户编号
   * @author liujingbei
   * @date 2016-03-31 下午1:36:57
   */
  @NotBlank(message="core_merchant_no is required")
  @Length(min=2,max=32,message="core_merchant_no format error")
  private String coreMerchantNo;
  /**
   * @Fields merchantNo : 商户编号
   * @author liujingbei
   * @date 2016-03-31 下午1:36:48
   */
  @NotBlank(message="merchant_no is required")
  @Length(min=2,max=32,message="merchant_no format error")
  private String merchantNo;
  /**
   * @字段名 poolNo : 资金池编号
   */
  @NotBlank(message="fund_pool_no is required")
  @Pattern(message = "fund_pool_no format error", regexp = RegexConstants.POOLNO_REGEX)
  private String poolNo;
  /**
   * @Fields accountName : 账户名
   * @author liujingbei
   * @date 2016-03-31 上午10:30:04
   */
  @Length(max=45,message="account_name format error")
  private String accountName;

  /**
   * @字段名 accountType : 账户类型
   * 账户类型：1-企业; 2-个人; 3-内部账户
   */
  @Pattern(message = "account_type format error", regexp = RegexConstants.ACCOUNTTYPE_REGEX)
  private String accountType;


  public String getPartnerId () {
    return partnerId;
  }


  public void setPartnerId (String partnerId) {
    this.partnerId = partnerId;
  }


  public String getCoreMerchantNo () {
    return coreMerchantNo;
  }


  public void setCoreMerchantNo (String coreMerchantNo) {
    this.coreMerchantNo = coreMerchantNo;
  }


  public String getMerchantNo () {
    return merchantNo;
  }


  public void setMerchantNo (String merchantNo) {
    this.merchantNo = merchantNo;
  }


  public String getPoolNo () {
    return poolNo;
  }


  public void setPoolNo (String poolNo) {
    this.poolNo = poolNo;
  }


  public String getAccountName () {
    return accountName;
  }


  public void setAccountName (String accountName) {
    this.accountName = accountName;
  }


  public String getAccountType () {
    return accountType;
  }


  public void setAccountType (String accountType) {
    this.accountType = accountType;
  }

}
