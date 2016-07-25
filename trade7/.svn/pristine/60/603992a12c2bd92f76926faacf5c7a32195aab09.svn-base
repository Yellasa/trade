package com.liantuo.deposit.advanceaccount.orm.pojo;


import java.io.Serializable;
import java.util.Date;

public class AccountForbidTrade implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 账户
     */
    private String accountNo;

    /**
     * 交易禁止项内容(例如0001_001或0001_001_001，ALL表示全部)
     */
    private String forbidCode;

    /**
     * 交易禁止类型(01表示交易类型，02表示交易请求，如交易禁止项内容为ALL，此参数01或02均可)
     */
    private String type;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 创建人编号
     */
    private String creatorNo;

    /**
     * 创建人
     */
    private String creatorCn;

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
     * @return 账户
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo 
	 *            账户
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * @return 交易禁止项内容(例如0001_001或0001_001_001，ALL表示全部)
     */
    public String getForbidCode() {
        return forbidCode;
    }

    /**
     * @param forbidCode 
	 *            交易禁止项内容(例如0001_001或0001_001_001，ALL表示全部)
     */
    public void setForbidCode(String forbidCode) {
        this.forbidCode = forbidCode == null ? null : forbidCode.trim();
    }

    /**
     * @return 交易禁止类型(01表示交易类型，02表示交易请求，如交易禁止项内容为ALL，此参数01或02均可)
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            交易禁止类型(01表示交易类型，02表示交易请求，如交易禁止项内容为ALL，此参数01或02均可)
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * @return 创建人
     */
    public String getCreatorCn() {
        return creatorCn;
    }

    /**
     * @param creatorCn 
	 *            创建人
     */
    public void setCreatorCn(String creatorCn) {
        this.creatorCn = creatorCn == null ? null : creatorCn.trim();
    }
}