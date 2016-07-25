package com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo;

public class PoolQueryInnerVo {
	private String coreMerchantNo;
	private String poolNo;
	private String poolName;
	private int currentPage;
	private int showCount;
	private int startCount;
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
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getStartCount() {
		return startCount;
	}
	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
	
}
