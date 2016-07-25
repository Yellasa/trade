package com.liantuo.trade.orm.pojo;

import java.util.Date;

public class TradeRefundLog {
    private Long id;

    private String coreMerchantNo;

    private String fundPoolNo;

    private String tradeNo;

    private String outTradeNo;

    private String outTradeNoExt;

    private String merchantExtendField1;

    private String merchantExtendField2;

    private String merchantExtendField3;

    private String merchantExtendField4;

    private String merchantExtendField5;

    private Date gmtCreated;

    private Date gmtLatestModified;

    private String latestTradeReqType;

    private String latestReqNo;

    private String closeStatus;

    private String originalTradeNo;

    private String refundAccountNo;

    private String refundMerchantNo;

    private Date gmtRefundSuccess;

    private String status;

    private String clearChannel;

    private Date gmtSuccessClearChannel;

    private String clearOrderNo;

    private Long clearRefundAmount;

    private String receiveAccountNo;

    private String receiveMerchantNo;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getOutTradeNoExt() {
        return outTradeNoExt;
    }

    public void setOutTradeNoExt(String outTradeNoExt) {
        this.outTradeNoExt = outTradeNoExt == null ? null : outTradeNoExt.trim();
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

    public String getOriginalTradeNo() {
        return originalTradeNo;
    }

    public void setOriginalTradeNo(String originalTradeNo) {
        this.originalTradeNo = originalTradeNo == null ? null : originalTradeNo.trim();
    }

    public String getRefundAccountNo() {
        return refundAccountNo;
    }

    public void setRefundAccountNo(String refundAccountNo) {
        this.refundAccountNo = refundAccountNo == null ? null : refundAccountNo.trim();
    }

    public String getRefundMerchantNo() {
        return refundMerchantNo;
    }

    public void setRefundMerchantNo(String refundMerchantNo) {
        this.refundMerchantNo = refundMerchantNo == null ? null : refundMerchantNo.trim();
    }

    public Date getGmtRefundSuccess() {
        return gmtRefundSuccess;
    }

    public void setGmtRefundSuccess(Date gmtRefundSuccess) {
        this.gmtRefundSuccess = gmtRefundSuccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getClearOrderNo() {
        return clearOrderNo;
    }

    public void setClearOrderNo(String clearOrderNo) {
        this.clearOrderNo = clearOrderNo == null ? null : clearOrderNo.trim();
    }

    public Long getClearRefundAmount() {
        return clearRefundAmount;
    }

    public void setClearRefundAmount(Long clearRefundAmount) {
        this.clearRefundAmount = clearRefundAmount;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}