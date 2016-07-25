package com.liantuo.trade.orm.pojo;

import java.util.Date;

public class TradeLedger {
    //
    private Long id;

    //业务台账编号（交易系统生成，全局唯一）
    private String ledgerNo;

    //业务台账创建日期时间（交易系统系统时间）
    private Date gmtCreated;

    //业务台账生效日期时间（交易系统系统时间）
    private Date gmtEffective;

    //业务台账失败日期时间（交易系统系统时间）
    private Date gmtFailed;

    //核心商户编号（请求协议参数）
    private String coreMerchantNo;

    //资金池编号（请求协议参数）
    private String fundPoolNo;

    //业务台账客户保留字段1
    private String merchantExtendField1;

    //业务台账客户保留字段2
    private String merchantExtendField2;

    //业务台账客户保留字段3
    private String merchantExtendField3;

    //业务台账客户保留字段4
    private String merchantExtendField4;

    //业务台账客户保留字段5
    private String merchantExtendField5;

    //所属业务交易类型（例：0001_001）
    private String tradeType;

    //交易编号
    private String tradeNo;

    //所属业务交易创建日期
    private Date gmtTradeCreated;

    //创建交易请求类型（例：0001_001_001）
    private String createReqType;

    //创建交易请求编号
    private String createReqNo;

    //生效交易请求类型（例：0001_001_001）
    private String effectiveReqType;

    //生效交易请求编号
    private String effectiveReqNo;

    //失败交易请求类型（例：0001_001_001）
    private String failReqType;

    //失败交易请求编号
    private String failReqNo;

    //交易发起方业务系统订单号
    private String outTradeNo;

    //交易发起方发起请求ID
    private String outTradeNoExt;

    //台账状态（00：新建 01生效）
    private String status;

    //收付款渠道编号（请求业务参数）
    private String clearChannel;

    //收付款属性1（请求业务参数）
    private String clearChannelAttr1;

    //收付款属性2（请求业务参数）
    private String clearChannelAttr2;

    //收付款属性3（请求业务参数）
    private String clearChannelAttr3;

    //收付款属性4（请求业务参数）
    private String clearChannelAttr4;

    //收付款属性5（请求业务参数）
    private String clearChannelAttr5;

    //收付款属性6（请求业务参数）
    private String clearChannelAttr6;

    //付款金额（请求业务参数）
    private Long paymentAmount;

    //收款金额（请求业务参数）
    private Long receiveAmount;

    //外部渠道收付款成功日期时间
    private Date gmtSuccessClearChannel;

    //收付款渠道订单号
    private String thirdTradeNo;

    //支付中心记录编号
    private String paymentTradeNo;

    //收付款备注1
    private String extendField1;

    //收付款备注2
    private String extendField2;

    //收付款备注3
    private String extendField3;

    //收付款备注4
    private String extendField4;

    //收付款备注5
    private String extendField5;

    //收付款备注6
    private String extendField6;

    //收付款备注7
    private String extendField7;

    //收付款备注8
    private String extendField8;

    //收付款备注9
    private String extendField9;

    //收付款备注10
    private String extendField10;

    //备注11-15用于统计
    private String extendField11;

    //
    private String extendField12;

    //
    private String extendField13;

    //
    private String extendField14;

    //
    private String extendField15;

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

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtEffective() {
        return gmtEffective;
    }

    public void setGmtEffective(Date gmtEffective) {
        this.gmtEffective = gmtEffective;
    }

    public Date getGmtFailed() {
        return gmtFailed;
    }

    public void setGmtFailed(Date gmtFailed) {
        this.gmtFailed = gmtFailed;
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

    public String getClearChannelAttr1() {
        return clearChannelAttr1;
    }

    public void setClearChannelAttr1(String clearChannelAttr1) {
        this.clearChannelAttr1 = clearChannelAttr1 == null ? null : clearChannelAttr1.trim();
    }

    public String getClearChannelAttr2() {
        return clearChannelAttr2;
    }

    public void setClearChannelAttr2(String clearChannelAttr2) {
        this.clearChannelAttr2 = clearChannelAttr2 == null ? null : clearChannelAttr2.trim();
    }

    public String getClearChannelAttr3() {
        return clearChannelAttr3;
    }

    public void setClearChannelAttr3(String clearChannelAttr3) {
        this.clearChannelAttr3 = clearChannelAttr3 == null ? null : clearChannelAttr3.trim();
    }

    public String getClearChannelAttr4() {
        return clearChannelAttr4;
    }

    public void setClearChannelAttr4(String clearChannelAttr4) {
        this.clearChannelAttr4 = clearChannelAttr4 == null ? null : clearChannelAttr4.trim();
    }

    public String getClearChannelAttr5() {
        return clearChannelAttr5;
    }

    public void setClearChannelAttr5(String clearChannelAttr5) {
        this.clearChannelAttr5 = clearChannelAttr5 == null ? null : clearChannelAttr5.trim();
    }

    public String getClearChannelAttr6() {
        return clearChannelAttr6;
    }

    public void setClearChannelAttr6(String clearChannelAttr6) {
        this.clearChannelAttr6 = clearChannelAttr6 == null ? null : clearChannelAttr6.trim();
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(Long receiveAmount) {
        this.receiveAmount = receiveAmount;
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

    public String getPaymentTradeNo() {
        return paymentTradeNo;
    }

    public void setPaymentTradeNo(String paymentTradeNo) {
        this.paymentTradeNo = paymentTradeNo == null ? null : paymentTradeNo.trim();
    }

    public String getExtendField1() {
        return extendField1;
    }

    public void setExtendField1(String extendField1) {
        this.extendField1 = extendField1 == null ? null : extendField1.trim();
    }

    public String getExtendField2() {
        return extendField2;
    }

    public void setExtendField2(String extendField2) {
        this.extendField2 = extendField2 == null ? null : extendField2.trim();
    }

    public String getExtendField3() {
        return extendField3;
    }

    public void setExtendField3(String extendField3) {
        this.extendField3 = extendField3 == null ? null : extendField3.trim();
    }

    public String getExtendField4() {
        return extendField4;
    }

    public void setExtendField4(String extendField4) {
        this.extendField4 = extendField4 == null ? null : extendField4.trim();
    }

    public String getExtendField5() {
        return extendField5;
    }

    public void setExtendField5(String extendField5) {
        this.extendField5 = extendField5 == null ? null : extendField5.trim();
    }

    public String getExtendField6() {
        return extendField6;
    }

    public void setExtendField6(String extendField6) {
        this.extendField6 = extendField6 == null ? null : extendField6.trim();
    }

    public String getExtendField7() {
        return extendField7;
    }

    public void setExtendField7(String extendField7) {
        this.extendField7 = extendField7 == null ? null : extendField7.trim();
    }

    public String getExtendField8() {
        return extendField8;
    }

    public void setExtendField8(String extendField8) {
        this.extendField8 = extendField8 == null ? null : extendField8.trim();
    }

    public String getExtendField9() {
        return extendField9;
    }

    public void setExtendField9(String extendField9) {
        this.extendField9 = extendField9 == null ? null : extendField9.trim();
    }

    public String getExtendField10() {
        return extendField10;
    }

    public void setExtendField10(String extendField10) {
        this.extendField10 = extendField10 == null ? null : extendField10.trim();
    }

    public String getExtendField11() {
        return extendField11;
    }

    public void setExtendField11(String extendField11) {
        this.extendField11 = extendField11 == null ? null : extendField11.trim();
    }

    public String getExtendField12() {
        return extendField12;
    }

    public void setExtendField12(String extendField12) {
        this.extendField12 = extendField12 == null ? null : extendField12.trim();
    }

    public String getExtendField13() {
        return extendField13;
    }

    public void setExtendField13(String extendField13) {
        this.extendField13 = extendField13 == null ? null : extendField13.trim();
    }

    public String getExtendField14() {
        return extendField14;
    }

    public void setExtendField14(String extendField14) {
        this.extendField14 = extendField14 == null ? null : extendField14.trim();
    }

    public String getExtendField15() {
        return extendField15;
    }

    public void setExtendField15(String extendField15) {
        this.extendField15 = extendField15 == null ? null : extendField15.trim();
    }
}