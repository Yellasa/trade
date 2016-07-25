package com.liantuo.trade.orm.pojo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(value="id,coreMerchantNo,fundPoolNo,merchantExtendField1,merchantExtendField2,merchantExtendField3,tradeType,tradeNo," +
		" private Date gmtTradeCreated,outTradeNoExt,outTradeNo,createReqType,createReqNo,gmtCreated,effectiveReqType,effectiveReqNo," +
		"gmtEffective,failReqType,failReqNo,gmtFailed,status,profitLossAttr1,profitLossAttr2,profitLossAttr3,profitLossAttr4,profitLossAttr5," +
		"profitLossAttr6,profitLossAttr7,profitLossAttr8,profitLossAttr9, profitLossAttr10,version")
public class TradeProfitLossLedger {
    private Long id;

    private String ledgerNo;

    private String coreMerchantNo;

    private String fundPoolNo;

    private String merchantExtendField1;

    private String merchantExtendField2;

    private String merchantExtendField3;

    private String tradeType;

    private String tradeNo;

    private Date gmtTradeCreated;

    private String outTradeNoExt;

    private String outTradeNo;

    private String createReqType;

    private String createReqNo;

    private Date gmtCreated;

    private String effectiveReqType;

    private String effectiveReqNo;

    private Date gmtEffective;

    private String failReqType;

    private String failReqNo;

    private Date gmtFailed;

    private String status;

    private String profitLossAttr1;

    private String profitLossAttr2;

    private String profitLossAttr3;

    private String profitLossAttr4;

    private String profitLossAttr5;

    private String profitLossAttr6;

    private String profitLossAttr7;

    private String profitLossAttr8;

    private String profitLossAttr9;

    private String profitLossAttr10;

    private Long incomeIncr;

    private Long incomeDecr;

    private Long costIncr;

    private Long costDecr;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLedgerNo() {
        return ledgerNo;
    }

    public void setLedgerNo(String ledgerNo) {
        this.ledgerNo = ledgerNo == null ? null : ledgerNo.trim();
    }

    public String getCoreMerchantNo() {
        return coreMerchantNo;
    }

    public void setCoreMerchantNo(String coreMerchantNo) {
        this.coreMerchantNo = coreMerchantNo == null ? null : coreMerchantNo.trim();
    }

    public String getFundPoolNo() {
        return fundPoolNo;
    }

    public void setFundPoolNo(String fundPoolNo) {
        this.fundPoolNo = fundPoolNo == null ? null : fundPoolNo.trim();
    }

    public String getMerchantExtendField1() {
        return merchantExtendField1;
    }

    public void setMerchantExtendField1(String merchantExtendField1) {
        this.merchantExtendField1 = merchantExtendField1 == null ? null : merchantExtendField1.trim();
    }

    public String getMerchantExtendField2() {
        return merchantExtendField2;
    }

    public void setMerchantExtendField2(String merchantExtendField2) {
        this.merchantExtendField2 = merchantExtendField2 == null ? null : merchantExtendField2.trim();
    }

    public String getMerchantExtendField3() {
        return merchantExtendField3;
    }

    public void setMerchantExtendField3(String merchantExtendField3) {
        this.merchantExtendField3 = merchantExtendField3 == null ? null : merchantExtendField3.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Date getGmtTradeCreated() {
        return gmtTradeCreated;
    }

    public void setGmtTradeCreated(Date gmtTradeCreated) {
        this.gmtTradeCreated = gmtTradeCreated;
    }

    public String getOutTradeNoExt() {
        return outTradeNoExt;
    }

    public void setOutTradeNoExt(String outTradeNoExt) {
        this.outTradeNoExt = outTradeNoExt == null ? null : outTradeNoExt.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getCreateReqType() {
        return createReqType;
    }

    public void setCreateReqType(String createReqType) {
        this.createReqType = createReqType == null ? null : createReqType.trim();
    }

    public String getCreateReqNo() {
        return createReqNo;
    }

    public void setCreateReqNo(String createReqNo) {
        this.createReqNo = createReqNo == null ? null : createReqNo.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getEffectiveReqType() {
        return effectiveReqType;
    }

    public void setEffectiveReqType(String effectiveReqType) {
        this.effectiveReqType = effectiveReqType == null ? null : effectiveReqType.trim();
    }

    public String getEffectiveReqNo() {
        return effectiveReqNo;
    }

    public void setEffectiveReqNo(String effectiveReqNo) {
        this.effectiveReqNo = effectiveReqNo == null ? null : effectiveReqNo.trim();
    }

    public Date getGmtEffective() {
        return gmtEffective;
    }

    public void setGmtEffective(Date gmtEffective) {
        this.gmtEffective = gmtEffective;
    }

    public String getFailReqType() {
        return failReqType;
    }

    public void setFailReqType(String failReqType) {
        this.failReqType = failReqType == null ? null : failReqType.trim();
    }

    public String getFailReqNo() {
        return failReqNo;
    }

    public void setFailReqNo(String failReqNo) {
        this.failReqNo = failReqNo == null ? null : failReqNo.trim();
    }

    public Date getGmtFailed() {
        return gmtFailed;
    }

    public void setGmtFailed(Date gmtFailed) {
        this.gmtFailed = gmtFailed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProfitLossAttr1() {
        return profitLossAttr1;
    }

    public void setProfitLossAttr1(String profitLossAttr1) {
        this.profitLossAttr1 = profitLossAttr1 == null ? null : profitLossAttr1.trim();
    }

    public String getProfitLossAttr2() {
        return profitLossAttr2;
    }

    public void setProfitLossAttr2(String profitLossAttr2) {
        this.profitLossAttr2 = profitLossAttr2 == null ? null : profitLossAttr2.trim();
    }

    public String getProfitLossAttr3() {
        return profitLossAttr3;
    }

    public void setProfitLossAttr3(String profitLossAttr3) {
        this.profitLossAttr3 = profitLossAttr3 == null ? null : profitLossAttr3.trim();
    }

    public String getProfitLossAttr4() {
        return profitLossAttr4;
    }

    public void setProfitLossAttr4(String profitLossAttr4) {
        this.profitLossAttr4 = profitLossAttr4 == null ? null : profitLossAttr4.trim();
    }

    public String getProfitLossAttr5() {
        return profitLossAttr5;
    }

    public void setProfitLossAttr5(String profitLossAttr5) {
        this.profitLossAttr5 = profitLossAttr5 == null ? null : profitLossAttr5.trim();
    }

    public String getProfitLossAttr6() {
        return profitLossAttr6;
    }

    public void setProfitLossAttr6(String profitLossAttr6) {
        this.profitLossAttr6 = profitLossAttr6 == null ? null : profitLossAttr6.trim();
    }

    public String getProfitLossAttr7() {
        return profitLossAttr7;
    }

    public void setProfitLossAttr7(String profitLossAttr7) {
        this.profitLossAttr7 = profitLossAttr7 == null ? null : profitLossAttr7.trim();
    }

    public String getProfitLossAttr8() {
        return profitLossAttr8;
    }

    public void setProfitLossAttr8(String profitLossAttr8) {
        this.profitLossAttr8 = profitLossAttr8 == null ? null : profitLossAttr8.trim();
    }

    public String getProfitLossAttr9() {
        return profitLossAttr9;
    }

    public void setProfitLossAttr9(String profitLossAttr9) {
        this.profitLossAttr9 = profitLossAttr9 == null ? null : profitLossAttr9.trim();
    }

    public String getProfitLossAttr10() {
        return profitLossAttr10;
    }

    public void setProfitLossAttr10(String profitLossAttr10) {
        this.profitLossAttr10 = profitLossAttr10 == null ? null : profitLossAttr10.trim();
    }

    public Long getIncomeIncr() {
        return incomeIncr;
    }

    public void setIncomeIncr(Long incomeIncr) {
        this.incomeIncr = incomeIncr;
    }

    public Long getIncomeDecr() {
        return incomeDecr;
    }

    public void setIncomeDecr(Long incomeDecr) {
        this.incomeDecr = incomeDecr;
    }

    public Long getCostIncr() {
        return costIncr;
    }

    public void setCostIncr(Long costIncr) {
        this.costIncr = costIncr;
    }

    public Long getCostDecr() {
        return costDecr;
    }

    public void setCostDecr(Long costDecr) {
        this.costDecr = costDecr;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}