package com.liantuo.deposit.advanceaccount.web.vo.returnvo;

import java.util.Date;

public class CreditAccountVo {

	private String accountNo;
        private String coreMerchantNo;
        private String poolNo;
        private String merchantNo;
        private String accountName;
        private Date balLastChangeTime;
        private Long version;
        private Integer status;
        private Double availableBalance;
	private Double freezenBalance;
	private Double totalBalance;
	private Integer accountType;
	private Integer creditType;
	private String payChannel;
	private String balanceNFlag;
	private Date gmtCreated;
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getCoreMerchantNo() {
			return coreMerchantNo;
		}
		public void setCoreMerchantNo(String coreMerchantNo) {
			this.coreMerchantNo = coreMerchantNo;
		}
		public String getPoolNo() {
			return poolNo;
		}
		public void setPoolNo(String poolNo) {
			this.poolNo = poolNo;
		}
		public String getMerchantNo() {
			return merchantNo;
		}
		public void setMerchantNo(String merchantNo) {
			this.merchantNo = merchantNo;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public Date getBalLastChangeTime() {
			return balLastChangeTime;
		}
		public void setBalLastChangeTime(Date balLastChangeTime) {
			this.balLastChangeTime = balLastChangeTime;
		}
		public Long getVersion() {
			return version;
		}
		public void setVersion(Long version) {
			this.version = version;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
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
		public Double getTotalBalance() {
			return totalBalance;
		}
		public void setTotalBalance(Double totalBalance) {
			this.totalBalance = totalBalance;
		}
		public Integer getAccountType() {
			return accountType;
		}
		public void setAccountType(Integer accountType) {
			this.accountType = accountType;
		}
		public Integer getCreditType() {
			return creditType;
		}
		public void setCreditType(Integer creditType) {
			this.creditType = creditType;
		}
		public String getPayChannel() {
			return payChannel;
		}
		public void setPayChannel(String payChannel) {
			this.payChannel = payChannel;
		}
		public String getBalanceNFlag() {
			return balanceNFlag;
		}
		public void setBalanceNFlag(String balanceNFlag) {
			this.balanceNFlag = balanceNFlag;
		}
		public Date getGmtCreated() {
			return gmtCreated;
		}
		public void setGmtCreated(Date gmtCreated) {
			this.gmtCreated = gmtCreated;
		}


}
