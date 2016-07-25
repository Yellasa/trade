package com.liantuo.deposit.advanceaccount.orm.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CreditAccount {
    private Integer id;

    private Long version;

    private String accountNo;

    private Integer ownerAgencyId;

    private Integer creditByAgencyId;

    private Double creditLine;

    private Integer status;

    private Double feeRate;

    private Double totalBalance;

    private Double availableBalance;

    private Double freezenBalance;

    private String password;

    private Integer creditRechargeSystemChargePayer;

    private Integer creditRechargeTenpaySystemChargePayer;

    private Integer creditRechargeCyberSystemChargePayer;

    private Integer creditRechargeCreditSystemChargePayer;

    private Integer creditWithdrawSystemChargePayer;

    private String creditReceiveAlipayEmail;

    private String creditReceiveAlipayEmailName;

    private String creditPaymentAlipayEmail;

    private String creditPaymentAlipayEmailName;

    private String protectCreditEmail;

    private Integer creditProtectStatus;

    private Integer creditProblemOne;

    private Integer creditProblemTwo;

    private String creditAnswerOne;

    private String creditAnswerTwo;

    private Integer creditSign;

    private Integer customId;

    private Integer creditType;

    private Double posrechargeFee;

    private Double unavailableBalance;

    private String tzzh;

    private Double nocardRechargeFee;

    private Integer openId;

    private Integer superiorOpenId;

    private String coreMerchantNo;

    private String organizationNo;

    private String merchantNo;

    private Integer accountType;

    private String poolNo;

    private String isbuffering;

    private String subjectNo;

    private String balanceDir;

    private BigDecimal intransitAmt;

    private BigDecimal lastBalanceAmt;

    private Date gmtCreated;

    private String creatorNo;

    private String creatorCn;

    private Date gmtModified;

    private String modifierNo;

    private String modifierCn;

    private String payChannel;

    private String rmkName;

    private String balanceNFlag;

    private String superType;

    private String isdr;

    private String isreal;

    private Date balLastChangeTime;

    private Date sysTime;

    private String rmk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public Integer getOwnerAgencyId() {
        return ownerAgencyId;
    }

    public void setOwnerAgencyId(Integer ownerAgencyId) {
        this.ownerAgencyId = ownerAgencyId;
    }

    public Integer getCreditByAgencyId() {
        return creditByAgencyId;
    }

    public void setCreditByAgencyId(Integer creditByAgencyId) {
        this.creditByAgencyId = creditByAgencyId;
    }

    public Double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Double feeRate) {
        this.feeRate = feeRate;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getFreezenBalance() {
        return freezenBalance;
    }

    public void setFreezenBalance(Double freezenBalance) {
        this.freezenBalance = freezenBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getCreditRechargeSystemChargePayer() {
        return creditRechargeSystemChargePayer;
    }

    public void setCreditRechargeSystemChargePayer(Integer creditRechargeSystemChargePayer) {
        this.creditRechargeSystemChargePayer = creditRechargeSystemChargePayer;
    }

    public Integer getCreditRechargeTenpaySystemChargePayer() {
        return creditRechargeTenpaySystemChargePayer;
    }

    public void setCreditRechargeTenpaySystemChargePayer(Integer creditRechargeTenpaySystemChargePayer) {
        this.creditRechargeTenpaySystemChargePayer = creditRechargeTenpaySystemChargePayer;
    }

    public Integer getCreditRechargeCyberSystemChargePayer() {
        return creditRechargeCyberSystemChargePayer;
    }

    public void setCreditRechargeCyberSystemChargePayer(Integer creditRechargeCyberSystemChargePayer) {
        this.creditRechargeCyberSystemChargePayer = creditRechargeCyberSystemChargePayer;
    }

    public Integer getCreditRechargeCreditSystemChargePayer() {
        return creditRechargeCreditSystemChargePayer;
    }

    public void setCreditRechargeCreditSystemChargePayer(Integer creditRechargeCreditSystemChargePayer) {
        this.creditRechargeCreditSystemChargePayer = creditRechargeCreditSystemChargePayer;
    }

    public Integer getCreditWithdrawSystemChargePayer() {
        return creditWithdrawSystemChargePayer;
    }

    public void setCreditWithdrawSystemChargePayer(Integer creditWithdrawSystemChargePayer) {
        this.creditWithdrawSystemChargePayer = creditWithdrawSystemChargePayer;
    }

    public String getCreditReceiveAlipayEmail() {
        return creditReceiveAlipayEmail;
    }

    public void setCreditReceiveAlipayEmail(String creditReceiveAlipayEmail) {
        this.creditReceiveAlipayEmail = creditReceiveAlipayEmail == null ? null : creditReceiveAlipayEmail.trim();
    }

    public String getCreditReceiveAlipayEmailName() {
        return creditReceiveAlipayEmailName;
    }

    public void setCreditReceiveAlipayEmailName(String creditReceiveAlipayEmailName) {
        this.creditReceiveAlipayEmailName = creditReceiveAlipayEmailName == null ? null : creditReceiveAlipayEmailName.trim();
    }

    public String getCreditPaymentAlipayEmail() {
        return creditPaymentAlipayEmail;
    }

    public void setCreditPaymentAlipayEmail(String creditPaymentAlipayEmail) {
        this.creditPaymentAlipayEmail = creditPaymentAlipayEmail == null ? null : creditPaymentAlipayEmail.trim();
    }

    public String getCreditPaymentAlipayEmailName() {
        return creditPaymentAlipayEmailName;
    }

    public void setCreditPaymentAlipayEmailName(String creditPaymentAlipayEmailName) {
        this.creditPaymentAlipayEmailName = creditPaymentAlipayEmailName == null ? null : creditPaymentAlipayEmailName.trim();
    }

    public String getProtectCreditEmail() {
        return protectCreditEmail;
    }

    public void setProtectCreditEmail(String protectCreditEmail) {
        this.protectCreditEmail = protectCreditEmail == null ? null : protectCreditEmail.trim();
    }

    public Integer getCreditProtectStatus() {
        return creditProtectStatus;
    }

    public void setCreditProtectStatus(Integer creditProtectStatus) {
        this.creditProtectStatus = creditProtectStatus;
    }

    public Integer getCreditProblemOne() {
        return creditProblemOne;
    }

    public void setCreditProblemOne(Integer creditProblemOne) {
        this.creditProblemOne = creditProblemOne;
    }

    public Integer getCreditProblemTwo() {
        return creditProblemTwo;
    }

    public void setCreditProblemTwo(Integer creditProblemTwo) {
        this.creditProblemTwo = creditProblemTwo;
    }

    public String getCreditAnswerOne() {
        return creditAnswerOne;
    }

    public void setCreditAnswerOne(String creditAnswerOne) {
        this.creditAnswerOne = creditAnswerOne == null ? null : creditAnswerOne.trim();
    }

    public String getCreditAnswerTwo() {
        return creditAnswerTwo;
    }

    public void setCreditAnswerTwo(String creditAnswerTwo) {
        this.creditAnswerTwo = creditAnswerTwo == null ? null : creditAnswerTwo.trim();
    }

    public Integer getCreditSign() {
        return creditSign;
    }

    public void setCreditSign(Integer creditSign) {
        this.creditSign = creditSign;
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public Integer getCreditType() {
        return creditType;
    }

    public void setCreditType(Integer creditType) {
        this.creditType = creditType;
    }

    public Double getPosrechargeFee() {
        return posrechargeFee;
    }

    public void setPosrechargeFee(Double posrechargeFee) {
        this.posrechargeFee = posrechargeFee;
    }

    public Double getUnavailableBalance() {
        return unavailableBalance;
    }

    public void setUnavailableBalance(Double unavailableBalance) {
        this.unavailableBalance = unavailableBalance;
    }

    public String getTzzh() {
        return tzzh;
    }

    public void setTzzh(String tzzh) {
        this.tzzh = tzzh == null ? null : tzzh.trim();
    }

    public Double getNocardRechargeFee() {
        return nocardRechargeFee;
    }

    public void setNocardRechargeFee(Double nocardRechargeFee) {
        this.nocardRechargeFee = nocardRechargeFee;
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Integer getSuperiorOpenId() {
        return superiorOpenId;
    }

    public void setSuperiorOpenId(Integer superiorOpenId) {
        this.superiorOpenId = superiorOpenId;
    }

    public String getCoreMerchantNo() {
        return coreMerchantNo;
    }

    public void setCoreMerchantNo(String coreMerchantNo) {
        this.coreMerchantNo = coreMerchantNo == null ? null : coreMerchantNo.trim();
    }

    public String getOrganizationNo() {
        return organizationNo;
    }

    public void setOrganizationNo(String organizationNo) {
        this.organizationNo = organizationNo == null ? null : organizationNo.trim();
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getPoolNo() {
        return poolNo;
    }

    public void setPoolNo(String poolNo) {
        this.poolNo = poolNo == null ? null : poolNo.trim();
    }

    public String getIsbuffering() {
        return isbuffering;
    }

    public void setIsbuffering(String isbuffering) {
        this.isbuffering = isbuffering == null ? null : isbuffering.trim();
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo == null ? null : subjectNo.trim();
    }

    public String getBalanceDir() {
        return balanceDir;
    }

    public void setBalanceDir(String balanceDir) {
        this.balanceDir = balanceDir == null ? null : balanceDir.trim();
    }

    public BigDecimal getIntransitAmt() {
        return intransitAmt;
    }

    public void setIntransitAmt(BigDecimal intransitAmt) {
        this.intransitAmt = intransitAmt;
    }

    public BigDecimal getLastBalanceAmt() {
        return lastBalanceAmt;
    }

    public void setLastBalanceAmt(BigDecimal lastBalanceAmt) {
        this.lastBalanceAmt = lastBalanceAmt;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getCreatorNo() {
        return creatorNo;
    }

    public void setCreatorNo(String creatorNo) {
        this.creatorNo = creatorNo == null ? null : creatorNo.trim();
    }

    public String getCreatorCn() {
        return creatorCn;
    }

    public void setCreatorCn(String creatorCn) {
        this.creatorCn = creatorCn == null ? null : creatorCn.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getModifierNo() {
        return modifierNo;
    }

    public void setModifierNo(String modifierNo) {
        this.modifierNo = modifierNo == null ? null : modifierNo.trim();
    }

    public String getModifierCn() {
        return modifierCn;
    }

    public void setModifierCn(String modifierCn) {
        this.modifierCn = modifierCn == null ? null : modifierCn.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public String getRmkName() {
        return rmkName;
    }

    public void setRmkName(String rmkName) {
        this.rmkName = rmkName == null ? null : rmkName.trim();
    }

    public String getBalanceNFlag() {
        return balanceNFlag;
    }

    public void setBalanceNFlag(String balanceNFlag) {
        this.balanceNFlag = balanceNFlag == null ? null : balanceNFlag.trim();
    }

    public String getSuperType() {
        return superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType == null ? null : superType.trim();
    }

    public String getIsdr() {
        return isdr;
    }

    public void setIsdr(String isdr) {
        this.isdr = isdr == null ? null : isdr.trim();
    }

    public String getIsreal() {
        return isreal;
    }

    public void setIsreal(String isreal) {
        this.isreal = isreal == null ? null : isreal.trim();
    }

    public Date getBalLastChangeTime() {
        return balLastChangeTime;
    }

    public void setBalLastChangeTime(Date balLastChangeTime) {
        this.balLastChangeTime = balLastChangeTime;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }
}