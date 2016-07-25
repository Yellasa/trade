package com.liantuo.trade.orm.pojo;

import java.util.Date;

public class TradeAdjustAccountLog {
    private Long id;

    private String tradeNo;

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

    private Date gmtLatestModified;

    private String latestTradeReqType;

    private String latestReqNo;

    private String closeStatus;

    private String status;

    private Date gmtAdjustSuccess;

    private Date gmtCreatedFail;

    private Date gmtAdjustDeal;

    private Date gmtAdjustCancel;

    private String paymentAccountNo;

    private String paymentMerchantNo;

    private String paymentAccountExtendField1;

    private String paymentAccountExtendField2;

    private String paymentAccountExtendField3;

    private String receiveAccountNo;

    private String receiveMerchantNo;

    private String receiveAccountExtendField1;

    private String receiveAccountExtendField2;

    private String receiveAccountExtendField3;

    private Long adjustAmount;

    private String requestGroup;

    private Integer version;

    private String clearChannel;

    private Date gmtSuccessClearChannel;

    private String thirdTradeNo;

    private String ledgerNo;

    private String ledgerMerchantExtendField1;

    private String ledgerMerchantExtendField2;

    private String ledgerMerchantExtendField3;

    private String refundClearChannel;

    private Date refundGmtSuccessClearChannel;

    private String refundThirdTradeNo;

    private String refundLedgerNo;

    private String refundLedgerMerchantExtendField1;

    private String refundLedgerMerchantExtendField2;

    private String refundLedgerMerchantExtendField3;

    private String profitLossType;

    private Date profitLossGmtEffective;

    private String profitLossLedgerNo;

    private String profitLossLedgerMerchantExtendField1;

    private String profitLossLedgerMerchantExtendField2;

    private String profitLossLedgerMerchantExtendField3;

    private String refundProfitLossType;

    private Date refundProfitLossGmtEffective;

    private String refundProfitLossLedgerNo;

    private String refundProfitLossLedgerMerchantExtendField1;

    private String refundProfitLossLedgerMerchantExtendField2;

    private String refundProfitLossLedgerMerchantExtendField3;

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

    public Date getGmtAdjustSuccess() {
        return gmtAdjustSuccess;
    }

    public void setGmtAdjustSuccess(Date gmtAdjustSuccess) {
        this.gmtAdjustSuccess = gmtAdjustSuccess;
    }

    public Date getGmtCreatedFail() {
        return gmtCreatedFail;
    }

    public void setGmtCreatedFail(Date gmtCreatedFail) {
        this.gmtCreatedFail = gmtCreatedFail;
    }

    public Date getGmtAdjustDeal() {
        return gmtAdjustDeal;
    }

    public void setGmtAdjustDeal(Date gmtAdjustDeal) {
        this.gmtAdjustDeal = gmtAdjustDeal;
    }

    public Date getGmtAdjustCancel() {
        return gmtAdjustCancel;
    }

    public void setGmtAdjustCancel(Date gmtAdjustCancel) {
        this.gmtAdjustCancel = gmtAdjustCancel;
    }

    public String getPaymentAccountNo() {
        return paymentAccountNo;
    }

    public void setPaymentAccountNo(String paymentAccountNo) {
        this.paymentAccountNo = paymentAccountNo == null ? null : paymentAccountNo.trim();
    }

    public String getPaymentMerchantNo() {
        return paymentMerchantNo;
    }

    public void setPaymentMerchantNo(String paymentMerchantNo) {
        this.paymentMerchantNo = paymentMerchantNo == null ? null : paymentMerchantNo.trim();
    }

    public String getPaymentAccountExtendField1() {
        return paymentAccountExtendField1;
    }

    public void setPaymentAccountExtendField1(String paymentAccountExtendField1) {
        this.paymentAccountExtendField1 = paymentAccountExtendField1 == null ? null : paymentAccountExtendField1.trim();
    }

    public String getPaymentAccountExtendField2() {
        return paymentAccountExtendField2;
    }

    public void setPaymentAccountExtendField2(String paymentAccountExtendField2) {
        this.paymentAccountExtendField2 = paymentAccountExtendField2 == null ? null : paymentAccountExtendField2.trim();
    }

    public String getPaymentAccountExtendField3() {
        return paymentAccountExtendField3;
    }

    public void setPaymentAccountExtendField3(String paymentAccountExtendField3) {
        this.paymentAccountExtendField3 = paymentAccountExtendField3 == null ? null : paymentAccountExtendField3.trim();
    }

    public String getReceiveAccountNo() {
        return receiveAccountNo;
    }

    public void setReceiveAccountNo(String receiveAccountNo) {
        this.receiveAccountNo = receiveAccountNo == null ? null : receiveAccountNo.trim();
    }

    public String getReceiveMerchantNo() {
        return receiveMerchantNo;
    }

    public void setReceiveMerchantNo(String receiveMerchantNo) {
        this.receiveMerchantNo = receiveMerchantNo == null ? null : receiveMerchantNo.trim();
    }

    public String getReceiveAccountExtendField1() {
        return receiveAccountExtendField1;
    }

    public void setReceiveAccountExtendField1(String receiveAccountExtendField1) {
        this.receiveAccountExtendField1 = receiveAccountExtendField1 == null ? null : receiveAccountExtendField1.trim();
    }

    public String getReceiveAccountExtendField2() {
        return receiveAccountExtendField2;
    }

    public void setReceiveAccountExtendField2(String receiveAccountExtendField2) {
        this.receiveAccountExtendField2 = receiveAccountExtendField2 == null ? null : receiveAccountExtendField2.trim();
    }

    public String getReceiveAccountExtendField3() {
        return receiveAccountExtendField3;
    }

    public void setReceiveAccountExtendField3(String receiveAccountExtendField3) {
        this.receiveAccountExtendField3 = receiveAccountExtendField3 == null ? null : receiveAccountExtendField3.trim();
    }

    public Long getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(Long adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public String getRequestGroup() {
        return requestGroup;
    }

    public void setRequestGroup(String requestGroup) {
        this.requestGroup = requestGroup == null ? null : requestGroup.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getClearChannel() {
        return clearChannel;
    }

    public void setClearChannel(String clearChannel) {
        this.clearChannel = clearChannel == null ? null : clearChannel.trim();
    }

    public Date getGmtSuccessClearChannel() {
        return gmtSuccessClearChannel;
    }

    public void setGmtSuccessClearChannel(Date gmtSuccessClearChannel) {
        this.gmtSuccessClearChannel = gmtSuccessClearChannel;
    }

    public String getThirdTradeNo() {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo) {
        this.thirdTradeNo = thirdTradeNo == null ? null : thirdTradeNo.trim();
    }

    public String getLedgerNo() {
        return ledgerNo;
    }

    public void setLedgerNo(String ledgerNo) {
        this.ledgerNo = ledgerNo == null ? null : ledgerNo.trim();
    }

    public String getLedgerMerchantExtendField1() {
        return ledgerMerchantExtendField1;
    }

    public void setLedgerMerchantExtendField1(String ledgerMerchantExtendField1) {
        this.ledgerMerchantExtendField1 = ledgerMerchantExtendField1 == null ? null : ledgerMerchantExtendField1.trim();
    }

    public String getLedgerMerchantExtendField2() {
        return ledgerMerchantExtendField2;
    }

    public void setLedgerMerchantExtendField2(String ledgerMerchantExtendField2) {
        this.ledgerMerchantExtendField2 = ledgerMerchantExtendField2 == null ? null : ledgerMerchantExtendField2.trim();
    }

    public String getLedgerMerchantExtendField3() {
        return ledgerMerchantExtendField3;
    }

    public void setLedgerMerchantExtendField3(String ledgerMerchantExtendField3) {
        this.ledgerMerchantExtendField3 = ledgerMerchantExtendField3 == null ? null : ledgerMerchantExtendField3.trim();
    }

    public String getRefundClearChannel() {
        return refundClearChannel;
    }

    public void setRefundClearChannel(String refundClearChannel) {
        this.refundClearChannel = refundClearChannel == null ? null : refundClearChannel.trim();
    }

    public Date getRefundGmtSuccessClearChannel() {
        return refundGmtSuccessClearChannel;
    }

    public void setRefundGmtSuccessClearChannel(Date refundGmtSuccessClearChannel) {
        this.refundGmtSuccessClearChannel = refundGmtSuccessClearChannel;
    }

    public String getRefundThirdTradeNo() {
        return refundThirdTradeNo;
    }

    public void setRefundThirdTradeNo(String refundThirdTradeNo) {
        this.refundThirdTradeNo = refundThirdTradeNo == null ? null : refundThirdTradeNo.trim();
    }

    public String getRefundLedgerNo() {
        return refundLedgerNo;
    }

    public void setRefundLedgerNo(String refundLedgerNo) {
        this.refundLedgerNo = refundLedgerNo == null ? null : refundLedgerNo.trim();
    }

    public String getRefundLedgerMerchantExtendField1() {
        return refundLedgerMerchantExtendField1;
    }

    public void setRefundLedgerMerchantExtendField1(String refundLedgerMerchantExtendField1) {
        this.refundLedgerMerchantExtendField1 = refundLedgerMerchantExtendField1 == null ? null : refundLedgerMerchantExtendField1.trim();
    }

    public String getRefundLedgerMerchantExtendField2() {
        return refundLedgerMerchantExtendField2;
    }

    public void setRefundLedgerMerchantExtendField2(String refundLedgerMerchantExtendField2) {
        this.refundLedgerMerchantExtendField2 = refundLedgerMerchantExtendField2 == null ? null : refundLedgerMerchantExtendField2.trim();
    }

    public String getRefundLedgerMerchantExtendField3() {
        return refundLedgerMerchantExtendField3;
    }

    public void setRefundLedgerMerchantExtendField3(String refundLedgerMerchantExtendField3) {
        this.refundLedgerMerchantExtendField3 = refundLedgerMerchantExtendField3 == null ? null : refundLedgerMerchantExtendField3.trim();
    }

    public String getProfitLossType() {
        return profitLossType;
    }

    public void setProfitLossType(String profitLossType) {
        this.profitLossType = profitLossType == null ? null : profitLossType.trim();
    }

    public Date getProfitLossGmtEffective() {
        return profitLossGmtEffective;
    }

    public void setProfitLossGmtEffective(Date profitLossGmtEffective) {
        this.profitLossGmtEffective = profitLossGmtEffective;
    }

    public String getProfitLossLedgerNo() {
        return profitLossLedgerNo;
    }

    public void setProfitLossLedgerNo(String profitLossLedgerNo) {
        this.profitLossLedgerNo = profitLossLedgerNo == null ? null : profitLossLedgerNo.trim();
    }

    public String getProfitLossLedgerMerchantExtendField1() {
        return profitLossLedgerMerchantExtendField1;
    }

    public void setProfitLossLedgerMerchantExtendField1(String profitLossLedgerMerchantExtendField1) {
        this.profitLossLedgerMerchantExtendField1 = profitLossLedgerMerchantExtendField1 == null ? null : profitLossLedgerMerchantExtendField1.trim();
    }

    public String getProfitLossLedgerMerchantExtendField2() {
        return profitLossLedgerMerchantExtendField2;
    }

    public void setProfitLossLedgerMerchantExtendField2(String profitLossLedgerMerchantExtendField2) {
        this.profitLossLedgerMerchantExtendField2 = profitLossLedgerMerchantExtendField2 == null ? null : profitLossLedgerMerchantExtendField2.trim();
    }

    public String getProfitLossLedgerMerchantExtendField3() {
        return profitLossLedgerMerchantExtendField3;
    }

    public void setProfitLossLedgerMerchantExtendField3(String profitLossLedgerMerchantExtendField3) {
        this.profitLossLedgerMerchantExtendField3 = profitLossLedgerMerchantExtendField3 == null ? null : profitLossLedgerMerchantExtendField3.trim();
    }

    public String getRefundProfitLossType() {
        return refundProfitLossType;
    }

    public void setRefundProfitLossType(String refundProfitLossType) {
        this.refundProfitLossType = refundProfitLossType == null ? null : refundProfitLossType.trim();
    }

    public Date getRefundProfitLossGmtEffective() {
        return refundProfitLossGmtEffective;
    }

    public void setRefundProfitLossGmtEffective(Date refundProfitLossGmtEffective) {
        this.refundProfitLossGmtEffective = refundProfitLossGmtEffective;
    }

    public String getRefundProfitLossLedgerNo() {
        return refundProfitLossLedgerNo;
    }

    public void setRefundProfitLossLedgerNo(String refundProfitLossLedgerNo) {
        this.refundProfitLossLedgerNo = refundProfitLossLedgerNo == null ? null : refundProfitLossLedgerNo.trim();
    }

    public String getRefundProfitLossLedgerMerchantExtendField1() {
        return refundProfitLossLedgerMerchantExtendField1;
    }

    public void setRefundProfitLossLedgerMerchantExtendField1(String refundProfitLossLedgerMerchantExtendField1) {
        this.refundProfitLossLedgerMerchantExtendField1 = refundProfitLossLedgerMerchantExtendField1 == null ? null : refundProfitLossLedgerMerchantExtendField1.trim();
    }

    public String getRefundProfitLossLedgerMerchantExtendField2() {
        return refundProfitLossLedgerMerchantExtendField2;
    }

    public void setRefundProfitLossLedgerMerchantExtendField2(String refundProfitLossLedgerMerchantExtendField2) {
        this.refundProfitLossLedgerMerchantExtendField2 = refundProfitLossLedgerMerchantExtendField2 == null ? null : refundProfitLossLedgerMerchantExtendField2.trim();
    }

    public String getRefundProfitLossLedgerMerchantExtendField3() {
        return refundProfitLossLedgerMerchantExtendField3;
    }

    public void setRefundProfitLossLedgerMerchantExtendField3(String refundProfitLossLedgerMerchantExtendField3) {
        this.refundProfitLossLedgerMerchantExtendField3 = refundProfitLossLedgerMerchantExtendField3 == null ? null : refundProfitLossLedgerMerchantExtendField3.trim();
    }
}