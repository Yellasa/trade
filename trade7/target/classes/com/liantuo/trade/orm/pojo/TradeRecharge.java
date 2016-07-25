package com.liantuo.trade.orm.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TradeRecharge {
    private Long id;

    private String tradeNo;

    private String partnerId;

    private String coreMerchantNo;

    private String fundPoolNo;

    private String merchantExtendField1;

    private String merchantExtendField2;

    private String merchantExtendField3;

    private String merchantExtendField4;

    private String merchantExtendField5;

    private String outTradeNoExt;

    private String outTradeNo;

    private Date gmtCreated;

    private Date gmtCreatedFail;

    private Date gmtLatestModified;

    private String latestTradeReqType;

    private String latestReqNo;

    private String closeStatus;

    private String status;

    private Date gmtRechargeFail;

    private Date gmtRechargeWait;

    private Date gmtRechargeSuccess;

    private Date gmtRechargeRefund;

    private Date gmtExceptionEnd;

    private Long payAmount;

    private String clearChannel;

    private String transactionId;

    private String batchNo;

    private String serialNumber;

    private String thirdTradeNo;

    private Date gmtSuccessClearChannel;

    private String rechargeLedgerNo;

    private String rechargeLedgerExtendField1;

    private String rechargeLedgerExtendField2;

    private String rechargeLedgerExtendField3;

    private String rechargeAccountNo;

    private String rechargeMerchantNo;

    private String rechargeAccountExtendField1;

    private String rechargeAccountExtendField2;

    private String rechargeAccountExtendField3;

    private Long rechargeAmount;

    private String notifyUrl;

    private Integer version;

    private String requestGroup;

    private Long feeAmount;

    private String feeWay;

    private String feeReceiveAccountNo;

    private String feePayAccountExtendField1;

    private String feePayAccountExtendField2;

    private String feePayAccountExtendField3;

    private String feeReceiveAccountExtendField1;

    private String feeReceiveAccountExtendField2;

    private String feeReceiveAccountExtendField3;

    private String feeLedgerNo;

    private String feeLedgerType;

    private String feeLedgerExtendField1;

    private String feeLedgerExtendField2;

    private String feeLedgerExtendField3;

    private String feeProfitLossAttr1;

    private String feeProfitLossAttr2;

    private String feeProfitLossAttr3;

    private String feeProfitLossAttr4;

    private String feeProfitLossAttr5;

    private String feeProfitLossAttr6;

    private String feeProfitLossAttr7;

    private String feeProfitLossAttr8;

    private String feeProfitLossAttr9;

    private String feeProfitLossAttr10;

    private Long supplyAmount;

    private String supplyWay;

    private String supplyPayAccountNo;

    private String supplyPayAccountExtendField1;

    private String supplyPayAccountExtendField2;

    private String supplyPayAccountExtendField3;

    private String supplyReceiveAccountExtendField1;

    private String supplyReceiveAccountExtendField2;

    private String supplyReceiveAccountExtendField3;

    private String supplyRechargeType;

    private String supplyLedgerNo;

    private String supplyLedgerType;

    private String supplyLedgerExtendField1;

    private String supplyLedgerExtendField2;

    private String supplyLedgerExtendField3;

    private String supplyProfitLossAttr1;

    private String supplyProfitLossAttr2;

    private String supplyProfitLossAttr3;

    private String supplyProfitLossAttr4;

    private String supplyProfitLossAttr5;

    private String supplyProfitLossAttr6;

    private String supplyProfitLossAttr7;

    private String supplyProfitLossAttr8;

    private String supplyProfitLossAttr9;

    private String supplyProfitLossAttr10;

    private Long refundAmount;

    private String refundClearChannel;

    private String refundTransactionId;

    private String refundBatchNo;

    private String refundSerialNumber;

    private String refundThirdTradeNo;

    private Date refundSuccessClearChannel;

    private String refundLedgerExtendField1;

    private String refundLedgerExtendField2;

    private String refundLedgerExtendField3;

    private String refundLedgerNo;

    private String payUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
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

    public String getMerchantExtendField4() {
        return merchantExtendField4;
    }

    public void setMerchantExtendField4(String merchantExtendField4) {
        this.merchantExtendField4 = merchantExtendField4 == null ? null : merchantExtendField4.trim();
    }

    public String getMerchantExtendField5() {
        return merchantExtendField5;
    }

    public void setMerchantExtendField5(String merchantExtendField5) {
        this.merchantExtendField5 = merchantExtendField5 == null ? null : merchantExtendField5.trim();
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

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtCreatedFail() {
        return gmtCreatedFail;
    }

    public void setGmtCreatedFail(Date gmtCreatedFail) {
        this.gmtCreatedFail = gmtCreatedFail;
    }

    public Date getGmtLatestModified() {
        return gmtLatestModified;
    }

    public void setGmtLatestModified(Date gmtLatestModified) {
        this.gmtLatestModified = gmtLatestModified;
    }

    public String getLatestTradeReqType() {
        return latestTradeReqType;
    }

    public void setLatestTradeReqType(String latestTradeReqType) {
        this.latestTradeReqType = latestTradeReqType == null ? null : latestTradeReqType.trim();
    }

    public String getLatestReqNo() {
        return latestReqNo;
    }

    public void setLatestReqNo(String latestReqNo) {
        this.latestReqNo = latestReqNo == null ? null : latestReqNo.trim();
    }

    public String getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(String closeStatus) {
        this.closeStatus = closeStatus == null ? null : closeStatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getGmtRechargeFail() {
        return gmtRechargeFail;
    }

    public void setGmtRechargeFail(Date gmtRechargeFail) {
        this.gmtRechargeFail = gmtRechargeFail;
    }

    public Date getGmtRechargeWait() {
        return gmtRechargeWait;
    }

    public void setGmtRechargeWait(Date gmtRechargeWait) {
        this.gmtRechargeWait = gmtRechargeWait;
    }

    public Date getGmtRechargeSuccess() {
        return gmtRechargeSuccess;
    }

    public void setGmtRechargeSuccess(Date gmtRechargeSuccess) {
        this.gmtRechargeSuccess = gmtRechargeSuccess;
    }

    public Date getGmtRechargeRefund() {
        return gmtRechargeRefund;
    }

    public void setGmtRechargeRefund(Date gmtRechargeRefund) {
        this.gmtRechargeRefund = gmtRechargeRefund;
    }

    public Date getGmtExceptionEnd() {
        return gmtExceptionEnd;
    }

    public void setGmtExceptionEnd(Date gmtExceptionEnd) {
        this.gmtExceptionEnd = gmtExceptionEnd;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getClearChannel() {
        return clearChannel;
    }

    public void setClearChannel(String clearChannel) {
        this.clearChannel = clearChannel == null ? null : clearChannel.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getThirdTradeNo() {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo) {
        this.thirdTradeNo = thirdTradeNo == null ? null : thirdTradeNo.trim();
    }

    public Date getGmtSuccessClearChannel() {
        return gmtSuccessClearChannel;
    }

    public void setGmtSuccessClearChannel(Date gmtSuccessClearChannel) {
        this.gmtSuccessClearChannel = gmtSuccessClearChannel;
    }

    public String getRechargeLedgerNo() {
        return rechargeLedgerNo;
    }

    public void setRechargeLedgerNo(String rechargeLedgerNo) {
        this.rechargeLedgerNo = rechargeLedgerNo == null ? null : rechargeLedgerNo.trim();
    }

    public String getRechargeLedgerExtendField1() {
        return rechargeLedgerExtendField1;
    }

    public void setRechargeLedgerExtendField1(String rechargeLedgerExtendField1) {
        this.rechargeLedgerExtendField1 = rechargeLedgerExtendField1 == null ? null : rechargeLedgerExtendField1.trim();
    }

    public String getRechargeLedgerExtendField2() {
        return rechargeLedgerExtendField2;
    }

    public void setRechargeLedgerExtendField2(String rechargeLedgerExtendField2) {
        this.rechargeLedgerExtendField2 = rechargeLedgerExtendField2 == null ? null : rechargeLedgerExtendField2.trim();
    }

    public String getRechargeLedgerExtendField3() {
        return rechargeLedgerExtendField3;
    }

    public void setRechargeLedgerExtendField3(String rechargeLedgerExtendField3) {
        this.rechargeLedgerExtendField3 = rechargeLedgerExtendField3 == null ? null : rechargeLedgerExtendField3.trim();
    }

    public String getRechargeAccountNo() {
        return rechargeAccountNo;
    }

    public void setRechargeAccountNo(String rechargeAccountNo) {
        this.rechargeAccountNo = rechargeAccountNo == null ? null : rechargeAccountNo.trim();
    }

    public String getRechargeMerchantNo() {
        return rechargeMerchantNo;
    }

    public void setRechargeMerchantNo(String rechargeMerchantNo) {
        this.rechargeMerchantNo = rechargeMerchantNo == null ? null : rechargeMerchantNo.trim();
    }

    public String getRechargeAccountExtendField1() {
        return rechargeAccountExtendField1;
    }

    public void setRechargeAccountExtendField1(String rechargeAccountExtendField1) {
        this.rechargeAccountExtendField1 = rechargeAccountExtendField1 == null ? null : rechargeAccountExtendField1.trim();
    }

    public String getRechargeAccountExtendField2() {
        return rechargeAccountExtendField2;
    }

    public void setRechargeAccountExtendField2(String rechargeAccountExtendField2) {
        this.rechargeAccountExtendField2 = rechargeAccountExtendField2 == null ? null : rechargeAccountExtendField2.trim();
    }

    public String getRechargeAccountExtendField3() {
        return rechargeAccountExtendField3;
    }

    public void setRechargeAccountExtendField3(String rechargeAccountExtendField3) {
        this.rechargeAccountExtendField3 = rechargeAccountExtendField3 == null ? null : rechargeAccountExtendField3.trim();
    }

    public Long getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Long rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRequestGroup() {
        return requestGroup;
    }

    public void setRequestGroup(String requestGroup) {
        this.requestGroup = requestGroup == null ? null : requestGroup.trim();
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeWay() {
        return feeWay;
    }

    public void setFeeWay(String feeWay) {
        this.feeWay = feeWay == null ? null : feeWay.trim();
    }

    public String getFeeReceiveAccountNo() {
        return feeReceiveAccountNo;
    }

    public void setFeeReceiveAccountNo(String feeReceiveAccountNo) {
        this.feeReceiveAccountNo = feeReceiveAccountNo == null ? null : feeReceiveAccountNo.trim();
    }

    public String getFeePayAccountExtendField1() {
        return feePayAccountExtendField1;
    }

    public void setFeePayAccountExtendField1(String feePayAccountExtendField1) {
        this.feePayAccountExtendField1 = feePayAccountExtendField1 == null ? null : feePayAccountExtendField1.trim();
    }

    public String getFeePayAccountExtendField2() {
        return feePayAccountExtendField2;
    }

    public void setFeePayAccountExtendField2(String feePayAccountExtendField2) {
        this.feePayAccountExtendField2 = feePayAccountExtendField2 == null ? null : feePayAccountExtendField2.trim();
    }

    public String getFeePayAccountExtendField3() {
        return feePayAccountExtendField3;
    }

    public void setFeePayAccountExtendField3(String feePayAccountExtendField3) {
        this.feePayAccountExtendField3 = feePayAccountExtendField3 == null ? null : feePayAccountExtendField3.trim();
    }

    public String getFeeReceiveAccountExtendField1() {
        return feeReceiveAccountExtendField1;
    }

    public void setFeeReceiveAccountExtendField1(String feeReceiveAccountExtendField1) {
        this.feeReceiveAccountExtendField1 = feeReceiveAccountExtendField1 == null ? null : feeReceiveAccountExtendField1.trim();
    }

    public String getFeeReceiveAccountExtendField2() {
        return feeReceiveAccountExtendField2;
    }

    public void setFeeReceiveAccountExtendField2(String feeReceiveAccountExtendField2) {
        this.feeReceiveAccountExtendField2 = feeReceiveAccountExtendField2 == null ? null : feeReceiveAccountExtendField2.trim();
    }

    public String getFeeReceiveAccountExtendField3() {
        return feeReceiveAccountExtendField3;
    }

    public void setFeeReceiveAccountExtendField3(String feeReceiveAccountExtendField3) {
        this.feeReceiveAccountExtendField3 = feeReceiveAccountExtendField3 == null ? null : feeReceiveAccountExtendField3.trim();
    }

    public String getFeeLedgerNo() {
        return feeLedgerNo;
    }

    public void setFeeLedgerNo(String feeLedgerNo) {
        this.feeLedgerNo = feeLedgerNo == null ? null : feeLedgerNo.trim();
    }

    public String getFeeLedgerType() {
        return feeLedgerType;
    }

    public void setFeeLedgerType(String feeLedgerType) {
        this.feeLedgerType = feeLedgerType == null ? null : feeLedgerType.trim();
    }

    public String getFeeLedgerExtendField1() {
        return feeLedgerExtendField1;
    }

    public void setFeeLedgerExtendField1(String feeLedgerExtendField1) {
        this.feeLedgerExtendField1 = feeLedgerExtendField1 == null ? null : feeLedgerExtendField1.trim();
    }

    public String getFeeLedgerExtendField2() {
        return feeLedgerExtendField2;
    }

    public void setFeeLedgerExtendField2(String feeLedgerExtendField2) {
        this.feeLedgerExtendField2 = feeLedgerExtendField2 == null ? null : feeLedgerExtendField2.trim();
    }

    public String getFeeLedgerExtendField3() {
        return feeLedgerExtendField3;
    }

    public void setFeeLedgerExtendField3(String feeLedgerExtendField3) {
        this.feeLedgerExtendField3 = feeLedgerExtendField3 == null ? null : feeLedgerExtendField3.trim();
    }

    public String getFeeProfitLossAttr1() {
        return feeProfitLossAttr1;
    }

    public void setFeeProfitLossAttr1(String feeProfitLossAttr1) {
        this.feeProfitLossAttr1 = feeProfitLossAttr1 == null ? null : feeProfitLossAttr1.trim();
    }

    public String getFeeProfitLossAttr2() {
        return feeProfitLossAttr2;
    }

    public void setFeeProfitLossAttr2(String feeProfitLossAttr2) {
        this.feeProfitLossAttr2 = feeProfitLossAttr2 == null ? null : feeProfitLossAttr2.trim();
    }

    public String getFeeProfitLossAttr3() {
        return feeProfitLossAttr3;
    }

    public void setFeeProfitLossAttr3(String feeProfitLossAttr3) {
        this.feeProfitLossAttr3 = feeProfitLossAttr3 == null ? null : feeProfitLossAttr3.trim();
    }

    public String getFeeProfitLossAttr4() {
        return feeProfitLossAttr4;
    }

    public void setFeeProfitLossAttr4(String feeProfitLossAttr4) {
        this.feeProfitLossAttr4 = feeProfitLossAttr4 == null ? null : feeProfitLossAttr4.trim();
    }

    public String getFeeProfitLossAttr5() {
        return feeProfitLossAttr5;
    }

    public void setFeeProfitLossAttr5(String feeProfitLossAttr5) {
        this.feeProfitLossAttr5 = feeProfitLossAttr5 == null ? null : feeProfitLossAttr5.trim();
    }

    public String getFeeProfitLossAttr6() {
        return feeProfitLossAttr6;
    }

    public void setFeeProfitLossAttr6(String feeProfitLossAttr6) {
        this.feeProfitLossAttr6 = feeProfitLossAttr6 == null ? null : feeProfitLossAttr6.trim();
    }

    public String getFeeProfitLossAttr7() {
        return feeProfitLossAttr7;
    }

    public void setFeeProfitLossAttr7(String feeProfitLossAttr7) {
        this.feeProfitLossAttr7 = feeProfitLossAttr7 == null ? null : feeProfitLossAttr7.trim();
    }

    public String getFeeProfitLossAttr8() {
        return feeProfitLossAttr8;
    }

    public void setFeeProfitLossAttr8(String feeProfitLossAttr8) {
        this.feeProfitLossAttr8 = feeProfitLossAttr8 == null ? null : feeProfitLossAttr8.trim();
    }

    public String getFeeProfitLossAttr9() {
        return feeProfitLossAttr9;
    }

    public void setFeeProfitLossAttr9(String feeProfitLossAttr9) {
        this.feeProfitLossAttr9 = feeProfitLossAttr9 == null ? null : feeProfitLossAttr9.trim();
    }

    public String getFeeProfitLossAttr10() {
        return feeProfitLossAttr10;
    }

    public void setFeeProfitLossAttr10(String feeProfitLossAttr10) {
        this.feeProfitLossAttr10 = feeProfitLossAttr10 == null ? null : feeProfitLossAttr10.trim();
    }

    public Long getSupplyAmount() {
        return supplyAmount;
    }

    public void setSupplyAmount(Long supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    public String getSupplyWay() {
        return supplyWay;
    }

    public void setSupplyWay(String supplyWay) {
        this.supplyWay = supplyWay == null ? null : supplyWay.trim();
    }

    public String getSupplyPayAccountNo() {
        return supplyPayAccountNo;
    }

    public void setSupplyPayAccountNo(String supplyPayAccountNo) {
        this.supplyPayAccountNo = supplyPayAccountNo == null ? null : supplyPayAccountNo.trim();
    }

    public String getSupplyPayAccountExtendField1() {
        return supplyPayAccountExtendField1;
    }

    public void setSupplyPayAccountExtendField1(String supplyPayAccountExtendField1) {
        this.supplyPayAccountExtendField1 = supplyPayAccountExtendField1 == null ? null : supplyPayAccountExtendField1.trim();
    }

    public String getSupplyPayAccountExtendField2() {
        return supplyPayAccountExtendField2;
    }

    public void setSupplyPayAccountExtendField2(String supplyPayAccountExtendField2) {
        this.supplyPayAccountExtendField2 = supplyPayAccountExtendField2 == null ? null : supplyPayAccountExtendField2.trim();
    }

    public String getSupplyPayAccountExtendField3() {
        return supplyPayAccountExtendField3;
    }

    public void setSupplyPayAccountExtendField3(String supplyPayAccountExtendField3) {
        this.supplyPayAccountExtendField3 = supplyPayAccountExtendField3 == null ? null : supplyPayAccountExtendField3.trim();
    }

    public String getSupplyReceiveAccountExtendField1() {
        return supplyReceiveAccountExtendField1;
    }

    public void setSupplyReceiveAccountExtendField1(String supplyReceiveAccountExtendField1) {
        this.supplyReceiveAccountExtendField1 = supplyReceiveAccountExtendField1 == null ? null : supplyReceiveAccountExtendField1.trim();
    }

    public String getSupplyReceiveAccountExtendField2() {
        return supplyReceiveAccountExtendField2;
    }

    public void setSupplyReceiveAccountExtendField2(String supplyReceiveAccountExtendField2) {
        this.supplyReceiveAccountExtendField2 = supplyReceiveAccountExtendField2 == null ? null : supplyReceiveAccountExtendField2.trim();
    }

    public String getSupplyReceiveAccountExtendField3() {
        return supplyReceiveAccountExtendField3;
    }

    public void setSupplyReceiveAccountExtendField3(String supplyReceiveAccountExtendField3) {
        this.supplyReceiveAccountExtendField3 = supplyReceiveAccountExtendField3 == null ? null : supplyReceiveAccountExtendField3.trim();
    }

    public String getSupplyRechargeType() {
        return supplyRechargeType;
    }

    public void setSupplyRechargeType(String supplyRechargeType) {
        this.supplyRechargeType = supplyRechargeType == null ? null : supplyRechargeType.trim();
    }

    public String getSupplyLedgerNo() {
        return supplyLedgerNo;
    }

    public void setSupplyLedgerNo(String supplyLedgerNo) {
        this.supplyLedgerNo = supplyLedgerNo == null ? null : supplyLedgerNo.trim();
    }

    public String getSupplyLedgerType() {
        return supplyLedgerType;
    }

    public void setSupplyLedgerType(String supplyLedgerType) {
        this.supplyLedgerType = supplyLedgerType == null ? null : supplyLedgerType.trim();
    }

    public String getSupplyLedgerExtendField1() {
        return supplyLedgerExtendField1;
    }

    public void setSupplyLedgerExtendField1(String supplyLedgerExtendField1) {
        this.supplyLedgerExtendField1 = supplyLedgerExtendField1 == null ? null : supplyLedgerExtendField1.trim();
    }

    public String getSupplyLedgerExtendField2() {
        return supplyLedgerExtendField2;
    }

    public void setSupplyLedgerExtendField2(String supplyLedgerExtendField2) {
        this.supplyLedgerExtendField2 = supplyLedgerExtendField2 == null ? null : supplyLedgerExtendField2.trim();
    }

    public String getSupplyLedgerExtendField3() {
        return supplyLedgerExtendField3;
    }

    public void setSupplyLedgerExtendField3(String supplyLedgerExtendField3) {
        this.supplyLedgerExtendField3 = supplyLedgerExtendField3 == null ? null : supplyLedgerExtendField3.trim();
    }

    public String getSupplyProfitLossAttr1() {
        return supplyProfitLossAttr1;
    }

    public void setSupplyProfitLossAttr1(String supplyProfitLossAttr1) {
        this.supplyProfitLossAttr1 = supplyProfitLossAttr1 == null ? null : supplyProfitLossAttr1.trim();
    }

    public String getSupplyProfitLossAttr2() {
        return supplyProfitLossAttr2;
    }

    public void setSupplyProfitLossAttr2(String supplyProfitLossAttr2) {
        this.supplyProfitLossAttr2 = supplyProfitLossAttr2 == null ? null : supplyProfitLossAttr2.trim();
    }

    public String getSupplyProfitLossAttr3() {
        return supplyProfitLossAttr3;
    }

    public void setSupplyProfitLossAttr3(String supplyProfitLossAttr3) {
        this.supplyProfitLossAttr3 = supplyProfitLossAttr3 == null ? null : supplyProfitLossAttr3.trim();
    }

    public String getSupplyProfitLossAttr4() {
        return supplyProfitLossAttr4;
    }

    public void setSupplyProfitLossAttr4(String supplyProfitLossAttr4) {
        this.supplyProfitLossAttr4 = supplyProfitLossAttr4 == null ? null : supplyProfitLossAttr4.trim();
    }

    public String getSupplyProfitLossAttr5() {
        return supplyProfitLossAttr5;
    }

    public void setSupplyProfitLossAttr5(String supplyProfitLossAttr5) {
        this.supplyProfitLossAttr5 = supplyProfitLossAttr5 == null ? null : supplyProfitLossAttr5.trim();
    }

    public String getSupplyProfitLossAttr6() {
        return supplyProfitLossAttr6;
    }

    public void setSupplyProfitLossAttr6(String supplyProfitLossAttr6) {
        this.supplyProfitLossAttr6 = supplyProfitLossAttr6 == null ? null : supplyProfitLossAttr6.trim();
    }

    public String getSupplyProfitLossAttr7() {
        return supplyProfitLossAttr7;
    }

    public void setSupplyProfitLossAttr7(String supplyProfitLossAttr7) {
        this.supplyProfitLossAttr7 = supplyProfitLossAttr7 == null ? null : supplyProfitLossAttr7.trim();
    }

    public String getSupplyProfitLossAttr8() {
        return supplyProfitLossAttr8;
    }

    public void setSupplyProfitLossAttr8(String supplyProfitLossAttr8) {
        this.supplyProfitLossAttr8 = supplyProfitLossAttr8 == null ? null : supplyProfitLossAttr8.trim();
    }

    public String getSupplyProfitLossAttr9() {
        return supplyProfitLossAttr9;
    }

    public void setSupplyProfitLossAttr9(String supplyProfitLossAttr9) {
        this.supplyProfitLossAttr9 = supplyProfitLossAttr9 == null ? null : supplyProfitLossAttr9.trim();
    }

    public String getSupplyProfitLossAttr10() {
        return supplyProfitLossAttr10;
    }

    public void setSupplyProfitLossAttr10(String supplyProfitLossAttr10) {
        this.supplyProfitLossAttr10 = supplyProfitLossAttr10 == null ? null : supplyProfitLossAttr10.trim();
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundClearChannel() {
        return refundClearChannel;
    }

    public void setRefundClearChannel(String refundClearChannel) {
        this.refundClearChannel = refundClearChannel == null ? null : refundClearChannel.trim();
    }

    public String getRefundTransactionId() {
        return refundTransactionId;
    }

    public void setRefundTransactionId(String refundTransactionId) {
        this.refundTransactionId = refundTransactionId == null ? null : refundTransactionId.trim();
    }

    public String getRefundBatchNo() {
        return refundBatchNo;
    }

    public void setRefundBatchNo(String refundBatchNo) {
        this.refundBatchNo = refundBatchNo == null ? null : refundBatchNo.trim();
    }

    public String getRefundSerialNumber() {
        return refundSerialNumber;
    }

    public void setRefundSerialNumber(String refundSerialNumber) {
        this.refundSerialNumber = refundSerialNumber == null ? null : refundSerialNumber.trim();
    }

    public String getRefundThirdTradeNo() {
        return refundThirdTradeNo;
    }

    public void setRefundThirdTradeNo(String refundThirdTradeNo) {
        this.refundThirdTradeNo = refundThirdTradeNo == null ? null : refundThirdTradeNo.trim();
    }

    public Date getRefundSuccessClearChannel() {
        return refundSuccessClearChannel;
    }

    public void setRefundSuccessClearChannel(Date refundSuccessClearChannel) {
        this.refundSuccessClearChannel = refundSuccessClearChannel;
    }

    public String getRefundLedgerExtendField1() {
        return refundLedgerExtendField1;
    }

    public void setRefundLedgerExtendField1(String refundLedgerExtendField1) {
        this.refundLedgerExtendField1 = refundLedgerExtendField1 == null ? null : refundLedgerExtendField1.trim();
    }

    public String getRefundLedgerExtendField2() {
        return refundLedgerExtendField2;
    }

    public void setRefundLedgerExtendField2(String refundLedgerExtendField2) {
        this.refundLedgerExtendField2 = refundLedgerExtendField2 == null ? null : refundLedgerExtendField2.trim();
    }

    public String getRefundLedgerExtendField3() {
        return refundLedgerExtendField3;
    }

    public void setRefundLedgerExtendField3(String refundLedgerExtendField3) {
        this.refundLedgerExtendField3 = refundLedgerExtendField3 == null ? null : refundLedgerExtendField3.trim();
    }

    public String getRefundLedgerNo() {
        return refundLedgerNo;
    }

    public void setRefundLedgerNo(String refundLedgerNo) {
        this.refundLedgerNo = refundLedgerNo == null ? null : refundLedgerNo.trim();
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl == null ? null : payUrl.trim();
    }
}