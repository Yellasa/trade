package com.liantuo.trade.orm.pojo;

import java.util.Date;

public class TradePayment {
    private Long id;

    private String tradeNo;

    private String coreMerchantNo;

    private String fundPoolNo;

    private String merchantExtendField1;

    private String merchantExtendField2;

    private String merchantExtendField3;

    private String merchantExtendField4;

    private String merchantExtendField5;
    
    private String merchantExtendField6;
    
    private String merchantExtendField7;
    
    private String merchantExtendField8;
    
    private String merchantExtendField9;
    
    private String merchantExtendField10;

    private String outTradeNo;

    private String outTradeNoExt;

    private Date gmtCreated;

    private Date gmtLatestModified;

    private String latestTradeReqType;

    private String latestReqNo;

    private String closeStatus;

    private String paymentAccountNo;

    private String paymentMerchantNo;

    private String receiveAccountNo;

    private String receiveMerchantNo;

    private Long freezeAmount;

    private Date gmtFreeze;

    private Date gmtUnfreeze;

    private Date gmtUnfreezeDedcut;

    private String status;

    private String clearChannel;

    private Date gmtSuccessClearChannel;

    private String thirdTradeNo;

    private Long actualAmount;

    private Integer version;

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

    public String getMerchantExtendField6() {
		return merchantExtendField6;
	}

	public void setMerchantExtendField6(String merchantExtendField6) {
		this.merchantExtendField6 = merchantExtendField6 == null ? null : merchantExtendField6.trim();
	}

	public String getMerchantExtendField7() {
		return merchantExtendField7;
	}

	public void setMerchantExtendField7(String merchantExtendField7) {
		this.merchantExtendField7 = merchantExtendField7 == null ? null : merchantExtendField7.trim();
	}

	public String getMerchantExtendField8() {
		return merchantExtendField8;
	}

	public void setMerchantExtendField8(String merchantExtendField8) {
		this.merchantExtendField8 = merchantExtendField8 == null ? null : merchantExtendField8.trim();
	}

	public String getMerchantExtendField9() {
		return merchantExtendField9;
	}

	public void setMerchantExtendField9(String merchantExtendField9) {
		this.merchantExtendField9 = merchantExtendField9 == null ? null : merchantExtendField9.trim();
	}

	public String getMerchantExtendField10() {
		return merchantExtendField10;
	}

	public void setMerchantExtendField10(String merchantExtendField10) {
		this.merchantExtendField10 = merchantExtendField10 == null ? null : merchantExtendField10.trim();
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

    public Long getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public Date getGmtFreeze() {
        return gmtFreeze;
    }

    public void setGmtFreeze(Date gmtFreeze) {
        this.gmtFreeze = gmtFreeze;
    }

    public Date getGmtUnfreeze() {
        return gmtUnfreeze;
    }

    public void setGmtUnfreeze(Date gmtUnfreeze) {
        this.gmtUnfreeze = gmtUnfreeze;
    }

    public Date getGmtUnfreezeDedcut() {
        return gmtUnfreezeDedcut;
    }

    public void setGmtUnfreezeDedcut(Date gmtUnfreezeDedcut) {
        this.gmtUnfreezeDedcut = gmtUnfreezeDedcut;
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

    public String getThirdTradeNo() {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo) {
        this.thirdTradeNo = thirdTradeNo == null ? null : thirdTradeNo.trim();
    }

    public Long getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Long actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}