package com.liantuo.deposit.advanceaccount.orm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Pool implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 资金池编号
     */
    private String poolNo;

    /**
     * 资金池名称
     */
    private String poolName;

    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 机构编号
     */
    private String organizationNo;

    /**
     * 备注
     */
    private String rmk;

    /**
     * 资金池状态：1-正常；2-不可用；
     */
    private String status;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 创建人编号
     */
    private String creatorNo;

    /**
     * 创建人姓名
     */
    private String creatorCn;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 修改人编号
     */
    private String modifierNo;

    /**
     * 修改人姓名
     */
    private String modifierCn;

    /**
     * 开户信息
     */
    private Integer openInfoId;

    /**
     * 资金池简称
     */
    private String shortName;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 资金池编号
     */
    public String getPoolNo() {
        return poolNo;
    }

    /**
     * @param poolNo 
	 *            资金池编号
     */
    public void setPoolNo(String poolNo) {
        this.poolNo = poolNo == null ? null : poolNo.trim();
    }

    /**
     * @return 资金池名称
     */
    public String getPoolName() {
        return poolName;
    }

    /**
     * @param poolName 
	 *            资金池名称
     */
    public void setPoolName(String poolName) {
        this.poolName = poolName == null ? null : poolName.trim();
    }

    /**
     * @return 商户编号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo 
	 *            商户编号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * @return 机构编号
     */
    public String getOrganizationNo() {
        return organizationNo;
    }

    /**
     * @param organizationNo 
	 *            机构编号
     */
    public void setOrganizationNo(String organizationNo) {
        this.organizationNo = organizationNo == null ? null : organizationNo.trim();
    }

    /**
     * @return 备注
     */
    public String getRmk() {
        return rmk;
    }

    /**
     * @param rmk 
	 *            备注
     */
    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }

    /**
     * @return 资金池状态：1-正常；2-不可用；
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            资金池状态：1-正常；2-不可用；
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 创建时间
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * @param gmtCreated 
	 *            创建时间
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * @return 创建人编号
     */
    public String getCreatorNo() {
        return creatorNo;
    }

    /**
     * @param creatorNo 
	 *            创建人编号
     */
    public void setCreatorNo(String creatorNo) {
        this.creatorNo = creatorNo == null ? null : creatorNo.trim();
    }

    /**
     * @return 创建人姓名
     */
    public String getCreatorCn() {
        return creatorCn;
    }

    /**
     * @param creatorCn 
	 *            创建人姓名
     */
    public void setCreatorCn(String creatorCn) {
        this.creatorCn = creatorCn == null ? null : creatorCn.trim();
    }

    /**
     * @return 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified 
	 *            修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return 修改人编号
     */
    public String getModifierNo() {
        return modifierNo;
    }

    /**
     * @param modifierNo 
	 *            修改人编号
     */
    public void setModifierNo(String modifierNo) {
        this.modifierNo = modifierNo == null ? null : modifierNo.trim();
    }

    /**
     * @return 修改人姓名
     */
    public String getModifierCn() {
        return modifierCn;
    }

    /**
     * @param modifierCn 
	 *            修改人姓名
     */
    public void setModifierCn(String modifierCn) {
        this.modifierCn = modifierCn == null ? null : modifierCn.trim();
    }

    /**
     * @return 开户信息
     */
    public Integer getOpenInfoId() {
        return openInfoId;
    }

    /**
     * @param openInfoId 
	 *            开户信息
     */
    public void setOpenInfoId(Integer openInfoId) {
        this.openInfoId = openInfoId;
    }

    /**
     * @return 资金池简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName 
	 *            资金池简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }
}