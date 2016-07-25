package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;

import com.liantuo.trade.common.validate.Format;

public class Extend_params {

	@Pattern(message = "sys_service_provider_id format error", regexp = "({0})||(.{1,64})", groups = { Format.class })
	private String sys_service_provider_id;
	@Pattern(message = "hb_fq_num format error", regexp = "({0})||(.{1,5})", groups = { Format.class })
	private String hb_fq_num;//花呗分期数
	@Pattern(message = "hb_fq_seller_percent format error", regexp = "({0})||(.{1,3})", groups = { Format.class })
	private String hb_fq_seller_percent;//花呗手续费
	
	public String getSys_service_provider_id() {
		return sys_service_provider_id;
	}

	public void setSys_service_provider_id(String sysServiceProviderId) {
		sys_service_provider_id = sysServiceProviderId;
	}

	public String getHb_fq_num() {
		return hb_fq_num;
	}

	public void setHb_fq_num(String hbFqNum) {
		hb_fq_num = hbFqNum;
	}

	public String getHb_fq_seller_percent() {
		return hb_fq_seller_percent;
	}

	public void setHb_fq_seller_percent(String hbFqSellerPercent) {
		hb_fq_seller_percent = hbFqSellerPercent;
	}
	
	
	
}
