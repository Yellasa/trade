package com.liantuo.deposit.pool.processor.v1.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.ebill.framework.validator.ValidatorUtil;
import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode005Constants;
import com.liantuo.deposit.web.vo.DepReq;
import com.liantuo.deposit.web.vo.DepRsp;

public class CreatePoolReqVO implements DepReq {


	/* (non-Javadoc)
	 * @see com.liantuo.deposit.web.vo.DepReq#validate()
	 */
	@Override
	public DepRsp validate() {
		String result = ValidatorUtil.validateResult(this, this.getClass());
		DepRsp rsp = null;
		if (result != null && !result.trim().equals("")) {
			rsp = new CreatePoolRspVO();
			rsp.fail(ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS, "格式校验未通过:"
					+ result);
		}
		return rsp;
	}

	public CreatePoolReqVO(String coreMerchantNo, String poolName,
			String partnerId, String rmk) {
		super();
		this.coreMerchantNo = coreMerchantNo;
		this.poolName = poolName;
		this.partnerId = partnerId;
		this.rmk = rmk;
	}
	
	/**
	 * @字段名 coreMerchantNo : 核心商户编号
	 */
	@NotBlank(message = "core_merchant_no is required")
	@Length(min = 2, max = 32, message = "core_merchant_no format error")
	private String coreMerchantNo;

	/**
	 * @字段名 poolNo : 资金池名称
	 */
	@NotBlank(message = "pool_name is required")
	@Length(min = 1, max = 128, message = "pool_name format error")
	private String poolName;

	@NotBlank(message = "partner_id is required")
	@Pattern(message = "partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;

	@Length(max = 512, message = "rmk format error")
	private String rmk;

	public String getCoreMerchantNo() {
		return coreMerchantNo;
	}

	public void setCoreMerchantNo(String coreMerchantNo) {
		this.coreMerchantNo = coreMerchantNo;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

}
