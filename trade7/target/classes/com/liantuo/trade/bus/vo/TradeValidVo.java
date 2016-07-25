/**
 * 
 */
package com.liantuo.trade.bus.vo;

/**
 * @ClassName:     TradeValidVo.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2015-12-16 下午1:49:26 
 */
public class TradeValidVo {

	private String fund_pool_no;
	private String service_code;
	private String out_trade_no_ext;
	private String core_merchant_no;
	private String trade_no;
	private String freeze_amt;
	private String actual_amount;
	/**
	 * @return the fund_pool_no
	 */
	public String getFund_pool_no() {
		return fund_pool_no;
	}
	/**
	 * @param fund_pool_no the fund_pool_no to set
	 */
	public void setFund_pool_no(String fund_pool_no) {
		this.fund_pool_no = fund_pool_no;
	}
	/**
	 * @return the service_code
	 */
	public String getService_code() {
		return service_code;
	}
	/**
	 * @param service_code the service_code to set
	 */
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	/**
	 * @return the out_trade_no_ext
	 */
	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}
	/**
	 * @param out_trade_no_ext the out_trade_no_ext to set
	 */
	public void setOut_trade_no_ext(String out_trade_no_ext) {
		this.out_trade_no_ext = out_trade_no_ext;
	}
	/**
	 * @return the core_merchant_no
	 */
	public String getCore_merchant_no() {
		return core_merchant_no;
	}
	/**
	 * @param core_merchant_no the core_merchant_no to set
	 */
	public void setCore_merchant_no(String core_merchant_no) {
		this.core_merchant_no = core_merchant_no;
	}
	/**
	 * @return the trade_no
	 */
	public String getTrade_no() {
		return trade_no;
	}
	/**
	 * @param trade_no the trade_no to set
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	/**
	 * @return the freeze_amt
	 */
	public String getFreeze_amt() {
		return freeze_amt;
	}
	/**
	 * @param freeze_amt the freeze_amt to set
	 */
	public void setFreeze_amt(String freeze_amt) {
		this.freeze_amt = freeze_amt;
	}
	/**
	 * @return the actual_amount
	 */
	public String getActual_amount() {
		return actual_amount;
	}
	/**
	 * @param actual_amount the actual_amount to set
	 */
	public void setActual_amount(String actual_amount) {
		this.actual_amount = actual_amount;
	}
	
}
