package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeSinglePaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeSinglePaymentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(String value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(String value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(String value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(String value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLike(String value) {
            addCriterion("partner_id like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotLike(String value) {
            addCriterion("partner_id not like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<String> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<String> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(String value1, String value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(String value1, String value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoIsNull() {
            addCriterion("core_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoIsNotNull() {
            addCriterion("core_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoEqualTo(String value) {
            addCriterion("core_merchant_no =", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoNotEqualTo(String value) {
            addCriterion("core_merchant_no <>", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoGreaterThan(String value) {
            addCriterion("core_merchant_no >", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("core_merchant_no >=", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoLessThan(String value) {
            addCriterion("core_merchant_no <", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("core_merchant_no <=", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoLike(String value) {
            addCriterion("core_merchant_no like", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoNotLike(String value) {
            addCriterion("core_merchant_no not like", value, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoIn(List<String> values) {
            addCriterion("core_merchant_no in", values, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoNotIn(List<String> values) {
            addCriterion("core_merchant_no not in", values, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoBetween(String value1, String value2) {
            addCriterion("core_merchant_no between", value1, value2, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCoreMerchantNoNotBetween(String value1, String value2) {
            addCriterion("core_merchant_no not between", value1, value2, "coreMerchantNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoIsNull() {
            addCriterion("fund_pool_no is null");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoIsNotNull() {
            addCriterion("fund_pool_no is not null");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoEqualTo(String value) {
            addCriterion("fund_pool_no =", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoNotEqualTo(String value) {
            addCriterion("fund_pool_no <>", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoGreaterThan(String value) {
            addCriterion("fund_pool_no >", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoGreaterThanOrEqualTo(String value) {
            addCriterion("fund_pool_no >=", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoLessThan(String value) {
            addCriterion("fund_pool_no <", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoLessThanOrEqualTo(String value) {
            addCriterion("fund_pool_no <=", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoLike(String value) {
            addCriterion("fund_pool_no like", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoNotLike(String value) {
            addCriterion("fund_pool_no not like", value, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoIn(List<String> values) {
            addCriterion("fund_pool_no in", values, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoNotIn(List<String> values) {
            addCriterion("fund_pool_no not in", values, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoBetween(String value1, String value2) {
            addCriterion("fund_pool_no between", value1, value2, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andFundPoolNoNotBetween(String value1, String value2) {
            addCriterion("fund_pool_no not between", value1, value2, "fundPoolNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoIsNull() {
            addCriterion("original_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoIsNotNull() {
            addCriterion("original_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoEqualTo(String value) {
            addCriterion("original_trade_no =", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoNotEqualTo(String value) {
            addCriterion("original_trade_no <>", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoGreaterThan(String value) {
            addCriterion("original_trade_no >", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("original_trade_no >=", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoLessThan(String value) {
            addCriterion("original_trade_no <", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoLessThanOrEqualTo(String value) {
            addCriterion("original_trade_no <=", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoLike(String value) {
            addCriterion("original_trade_no like", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoNotLike(String value) {
            addCriterion("original_trade_no not like", value, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoIn(List<String> values) {
            addCriterion("original_trade_no in", values, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoNotIn(List<String> values) {
            addCriterion("original_trade_no not in", values, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoBetween(String value1, String value2) {
            addCriterion("original_trade_no between", value1, value2, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriginalTradeNoNotBetween(String value1, String value2) {
            addCriterion("original_trade_no not between", value1, value2, "originalTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtIsNull() {
            addCriterion("out_trade_no_ext is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtIsNotNull() {
            addCriterion("out_trade_no_ext is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtEqualTo(String value) {
            addCriterion("out_trade_no_ext =", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtNotEqualTo(String value) {
            addCriterion("out_trade_no_ext <>", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtGreaterThan(String value) {
            addCriterion("out_trade_no_ext >", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no_ext >=", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtLessThan(String value) {
            addCriterion("out_trade_no_ext <", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no_ext <=", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtLike(String value) {
            addCriterion("out_trade_no_ext like", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtNotLike(String value) {
            addCriterion("out_trade_no_ext not like", value, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtIn(List<String> values) {
            addCriterion("out_trade_no_ext in", values, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtNotIn(List<String> values) {
            addCriterion("out_trade_no_ext not in", values, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtBetween(String value1, String value2) {
            addCriterion("out_trade_no_ext between", value1, value2, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoExtNotBetween(String value1, String value2) {
            addCriterion("out_trade_no_ext not between", value1, value2, "outTradeNoExt");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestIsNull() {
            addCriterion("gmt_modified_latest is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestIsNotNull() {
            addCriterion("gmt_modified_latest is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestEqualTo(Date value) {
            addCriterion("gmt_modified_latest =", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestNotEqualTo(Date value) {
            addCriterion("gmt_modified_latest <>", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestGreaterThan(Date value) {
            addCriterion("gmt_modified_latest >", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified_latest >=", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestLessThan(Date value) {
            addCriterion("gmt_modified_latest <", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified_latest <=", value, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestIn(List<Date> values) {
            addCriterion("gmt_modified_latest in", values, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestNotIn(List<Date> values) {
            addCriterion("gmt_modified_latest not in", values, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestBetween(Date value1, Date value2) {
            addCriterion("gmt_modified_latest between", value1, value2, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLatestNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified_latest not between", value1, value2, "gmtModifiedLatest");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeIsNull() {
            addCriterion("latest_trade_req_type is null");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeIsNotNull() {
            addCriterion("latest_trade_req_type is not null");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeEqualTo(String value) {
            addCriterion("latest_trade_req_type =", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeNotEqualTo(String value) {
            addCriterion("latest_trade_req_type <>", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeGreaterThan(String value) {
            addCriterion("latest_trade_req_type >", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("latest_trade_req_type >=", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeLessThan(String value) {
            addCriterion("latest_trade_req_type <", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeLessThanOrEqualTo(String value) {
            addCriterion("latest_trade_req_type <=", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeLike(String value) {
            addCriterion("latest_trade_req_type like", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeNotLike(String value) {
            addCriterion("latest_trade_req_type not like", value, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeIn(List<String> values) {
            addCriterion("latest_trade_req_type in", values, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeNotIn(List<String> values) {
            addCriterion("latest_trade_req_type not in", values, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeBetween(String value1, String value2) {
            addCriterion("latest_trade_req_type between", value1, value2, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestTradeReqTypeNotBetween(String value1, String value2) {
            addCriterion("latest_trade_req_type not between", value1, value2, "latestTradeReqType");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoIsNull() {
            addCriterion("latest_req_no is null");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoIsNotNull() {
            addCriterion("latest_req_no is not null");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoEqualTo(String value) {
            addCriterion("latest_req_no =", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoNotEqualTo(String value) {
            addCriterion("latest_req_no <>", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoGreaterThan(String value) {
            addCriterion("latest_req_no >", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoGreaterThanOrEqualTo(String value) {
            addCriterion("latest_req_no >=", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoLessThan(String value) {
            addCriterion("latest_req_no <", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoLessThanOrEqualTo(String value) {
            addCriterion("latest_req_no <=", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoLike(String value) {
            addCriterion("latest_req_no like", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoNotLike(String value) {
            addCriterion("latest_req_no not like", value, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoIn(List<String> values) {
            addCriterion("latest_req_no in", values, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoNotIn(List<String> values) {
            addCriterion("latest_req_no not in", values, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoBetween(String value1, String value2) {
            addCriterion("latest_req_no between", value1, value2, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andLatestReqNoNotBetween(String value1, String value2) {
            addCriterion("latest_req_no not between", value1, value2, "latestReqNo");
            return (Criteria) this;
        }

        public Criteria andCloseStatusIsNull() {
            addCriterion("close_status is null");
            return (Criteria) this;
        }

        public Criteria andCloseStatusIsNotNull() {
            addCriterion("close_status is not null");
            return (Criteria) this;
        }

        public Criteria andCloseStatusEqualTo(String value) {
            addCriterion("close_status =", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusNotEqualTo(String value) {
            addCriterion("close_status <>", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusGreaterThan(String value) {
            addCriterion("close_status >", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("close_status >=", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusLessThan(String value) {
            addCriterion("close_status <", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusLessThanOrEqualTo(String value) {
            addCriterion("close_status <=", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusLike(String value) {
            addCriterion("close_status like", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusNotLike(String value) {
            addCriterion("close_status not like", value, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusIn(List<String> values) {
            addCriterion("close_status in", values, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusNotIn(List<String> values) {
            addCriterion("close_status not in", values, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusBetween(String value1, String value2) {
            addCriterion("close_status between", value1, value2, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andCloseStatusNotBetween(String value1, String value2) {
            addCriterion("close_status not between", value1, value2, "closeStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryIsNull() {
            addCriterion("trade_catagory is null");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryIsNotNull() {
            addCriterion("trade_catagory is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryEqualTo(String value) {
            addCriterion("trade_catagory =", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryNotEqualTo(String value) {
            addCriterion("trade_catagory <>", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryGreaterThan(String value) {
            addCriterion("trade_catagory >", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryGreaterThanOrEqualTo(String value) {
            addCriterion("trade_catagory >=", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryLessThan(String value) {
            addCriterion("trade_catagory <", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryLessThanOrEqualTo(String value) {
            addCriterion("trade_catagory <=", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryLike(String value) {
            addCriterion("trade_catagory like", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryNotLike(String value) {
            addCriterion("trade_catagory not like", value, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryIn(List<String> values) {
            addCriterion("trade_catagory in", values, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryNotIn(List<String> values) {
            addCriterion("trade_catagory not in", values, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryBetween(String value1, String value2) {
            addCriterion("trade_catagory between", value1, value2, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andTradeCatagoryNotBetween(String value1, String value2) {
            addCriterion("trade_catagory not between", value1, value2, "tradeCatagory");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1IsNull() {
            addCriterion("merchant_extend_field_1 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1IsNotNull() {
            addCriterion("merchant_extend_field_1 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1EqualTo(String value) {
            addCriterion("merchant_extend_field_1 =", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1NotEqualTo(String value) {
            addCriterion("merchant_extend_field_1 <>", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1GreaterThan(String value) {
            addCriterion("merchant_extend_field_1 >", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_1 >=", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1LessThan(String value) {
            addCriterion("merchant_extend_field_1 <", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_1 <=", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1Like(String value) {
            addCriterion("merchant_extend_field_1 like", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1NotLike(String value) {
            addCriterion("merchant_extend_field_1 not like", value, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1In(List<String> values) {
            addCriterion("merchant_extend_field_1 in", values, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1NotIn(List<String> values) {
            addCriterion("merchant_extend_field_1 not in", values, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1Between(String value1, String value2) {
            addCriterion("merchant_extend_field_1 between", value1, value2, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField1NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_1 not between", value1, value2, "merchantExtendField1");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2IsNull() {
            addCriterion("merchant_extend_field_2 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2IsNotNull() {
            addCriterion("merchant_extend_field_2 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2EqualTo(String value) {
            addCriterion("merchant_extend_field_2 =", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2NotEqualTo(String value) {
            addCriterion("merchant_extend_field_2 <>", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2GreaterThan(String value) {
            addCriterion("merchant_extend_field_2 >", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_2 >=", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2LessThan(String value) {
            addCriterion("merchant_extend_field_2 <", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_2 <=", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2Like(String value) {
            addCriterion("merchant_extend_field_2 like", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2NotLike(String value) {
            addCriterion("merchant_extend_field_2 not like", value, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2In(List<String> values) {
            addCriterion("merchant_extend_field_2 in", values, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2NotIn(List<String> values) {
            addCriterion("merchant_extend_field_2 not in", values, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2Between(String value1, String value2) {
            addCriterion("merchant_extend_field_2 between", value1, value2, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField2NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_2 not between", value1, value2, "merchantExtendField2");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3IsNull() {
            addCriterion("merchant_extend_field_3 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3IsNotNull() {
            addCriterion("merchant_extend_field_3 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3EqualTo(String value) {
            addCriterion("merchant_extend_field_3 =", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3NotEqualTo(String value) {
            addCriterion("merchant_extend_field_3 <>", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3GreaterThan(String value) {
            addCriterion("merchant_extend_field_3 >", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_3 >=", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3LessThan(String value) {
            addCriterion("merchant_extend_field_3 <", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_3 <=", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3Like(String value) {
            addCriterion("merchant_extend_field_3 like", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3NotLike(String value) {
            addCriterion("merchant_extend_field_3 not like", value, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3In(List<String> values) {
            addCriterion("merchant_extend_field_3 in", values, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3NotIn(List<String> values) {
            addCriterion("merchant_extend_field_3 not in", values, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3Between(String value1, String value2) {
            addCriterion("merchant_extend_field_3 between", value1, value2, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField3NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_3 not between", value1, value2, "merchantExtendField3");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4IsNull() {
            addCriterion("merchant_extend_field_4 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4IsNotNull() {
            addCriterion("merchant_extend_field_4 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4EqualTo(String value) {
            addCriterion("merchant_extend_field_4 =", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4NotEqualTo(String value) {
            addCriterion("merchant_extend_field_4 <>", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4GreaterThan(String value) {
            addCriterion("merchant_extend_field_4 >", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_4 >=", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4LessThan(String value) {
            addCriterion("merchant_extend_field_4 <", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_4 <=", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4Like(String value) {
            addCriterion("merchant_extend_field_4 like", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4NotLike(String value) {
            addCriterion("merchant_extend_field_4 not like", value, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4In(List<String> values) {
            addCriterion("merchant_extend_field_4 in", values, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4NotIn(List<String> values) {
            addCriterion("merchant_extend_field_4 not in", values, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4Between(String value1, String value2) {
            addCriterion("merchant_extend_field_4 between", value1, value2, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField4NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_4 not between", value1, value2, "merchantExtendField4");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5IsNull() {
            addCriterion("merchant_extend_field_5 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5IsNotNull() {
            addCriterion("merchant_extend_field_5 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5EqualTo(String value) {
            addCriterion("merchant_extend_field_5 =", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5NotEqualTo(String value) {
            addCriterion("merchant_extend_field_5 <>", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5GreaterThan(String value) {
            addCriterion("merchant_extend_field_5 >", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_5 >=", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5LessThan(String value) {
            addCriterion("merchant_extend_field_5 <", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_5 <=", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5Like(String value) {
            addCriterion("merchant_extend_field_5 like", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5NotLike(String value) {
            addCriterion("merchant_extend_field_5 not like", value, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5In(List<String> values) {
            addCriterion("merchant_extend_field_5 in", values, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5NotIn(List<String> values) {
            addCriterion("merchant_extend_field_5 not in", values, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5Between(String value1, String value2) {
            addCriterion("merchant_extend_field_5 between", value1, value2, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField5NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_5 not between", value1, value2, "merchantExtendField5");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6IsNull() {
            addCriterion("merchant_extend_field_6 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6IsNotNull() {
            addCriterion("merchant_extend_field_6 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6EqualTo(String value) {
            addCriterion("merchant_extend_field_6 =", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6NotEqualTo(String value) {
            addCriterion("merchant_extend_field_6 <>", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6GreaterThan(String value) {
            addCriterion("merchant_extend_field_6 >", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_6 >=", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6LessThan(String value) {
            addCriterion("merchant_extend_field_6 <", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_6 <=", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6Like(String value) {
            addCriterion("merchant_extend_field_6 like", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6NotLike(String value) {
            addCriterion("merchant_extend_field_6 not like", value, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6In(List<String> values) {
            addCriterion("merchant_extend_field_6 in", values, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6NotIn(List<String> values) {
            addCriterion("merchant_extend_field_6 not in", values, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6Between(String value1, String value2) {
            addCriterion("merchant_extend_field_6 between", value1, value2, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField6NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_6 not between", value1, value2, "merchantExtendField6");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7IsNull() {
            addCriterion("merchant_extend_field_7 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7IsNotNull() {
            addCriterion("merchant_extend_field_7 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7EqualTo(String value) {
            addCriterion("merchant_extend_field_7 =", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7NotEqualTo(String value) {
            addCriterion("merchant_extend_field_7 <>", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7GreaterThan(String value) {
            addCriterion("merchant_extend_field_7 >", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_7 >=", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7LessThan(String value) {
            addCriterion("merchant_extend_field_7 <", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_7 <=", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7Like(String value) {
            addCriterion("merchant_extend_field_7 like", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7NotLike(String value) {
            addCriterion("merchant_extend_field_7 not like", value, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7In(List<String> values) {
            addCriterion("merchant_extend_field_7 in", values, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7NotIn(List<String> values) {
            addCriterion("merchant_extend_field_7 not in", values, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7Between(String value1, String value2) {
            addCriterion("merchant_extend_field_7 between", value1, value2, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField7NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_7 not between", value1, value2, "merchantExtendField7");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8IsNull() {
            addCriterion("merchant_extend_field_8 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8IsNotNull() {
            addCriterion("merchant_extend_field_8 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8EqualTo(String value) {
            addCriterion("merchant_extend_field_8 =", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8NotEqualTo(String value) {
            addCriterion("merchant_extend_field_8 <>", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8GreaterThan(String value) {
            addCriterion("merchant_extend_field_8 >", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_8 >=", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8LessThan(String value) {
            addCriterion("merchant_extend_field_8 <", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_8 <=", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8Like(String value) {
            addCriterion("merchant_extend_field_8 like", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8NotLike(String value) {
            addCriterion("merchant_extend_field_8 not like", value, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8In(List<String> values) {
            addCriterion("merchant_extend_field_8 in", values, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8NotIn(List<String> values) {
            addCriterion("merchant_extend_field_8 not in", values, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8Between(String value1, String value2) {
            addCriterion("merchant_extend_field_8 between", value1, value2, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField8NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_8 not between", value1, value2, "merchantExtendField8");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9IsNull() {
            addCriterion("merchant_extend_field_9 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9IsNotNull() {
            addCriterion("merchant_extend_field_9 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9EqualTo(String value) {
            addCriterion("merchant_extend_field_9 =", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9NotEqualTo(String value) {
            addCriterion("merchant_extend_field_9 <>", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9GreaterThan(String value) {
            addCriterion("merchant_extend_field_9 >", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_9 >=", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9LessThan(String value) {
            addCriterion("merchant_extend_field_9 <", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_9 <=", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9Like(String value) {
            addCriterion("merchant_extend_field_9 like", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9NotLike(String value) {
            addCriterion("merchant_extend_field_9 not like", value, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9In(List<String> values) {
            addCriterion("merchant_extend_field_9 in", values, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9NotIn(List<String> values) {
            addCriterion("merchant_extend_field_9 not in", values, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9Between(String value1, String value2) {
            addCriterion("merchant_extend_field_9 between", value1, value2, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField9NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_9 not between", value1, value2, "merchantExtendField9");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10IsNull() {
            addCriterion("merchant_extend_field_10 is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10IsNotNull() {
            addCriterion("merchant_extend_field_10 is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10EqualTo(String value) {
            addCriterion("merchant_extend_field_10 =", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10NotEqualTo(String value) {
            addCriterion("merchant_extend_field_10 <>", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10GreaterThan(String value) {
            addCriterion("merchant_extend_field_10 >", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10GreaterThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_10 >=", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10LessThan(String value) {
            addCriterion("merchant_extend_field_10 <", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10LessThanOrEqualTo(String value) {
            addCriterion("merchant_extend_field_10 <=", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10Like(String value) {
            addCriterion("merchant_extend_field_10 like", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10NotLike(String value) {
            addCriterion("merchant_extend_field_10 not like", value, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10In(List<String> values) {
            addCriterion("merchant_extend_field_10 in", values, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10NotIn(List<String> values) {
            addCriterion("merchant_extend_field_10 not in", values, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10Between(String value1, String value2) {
            addCriterion("merchant_extend_field_10 between", value1, value2, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andMerchantExtendField10NotBetween(String value1, String value2) {
            addCriterion("merchant_extend_field_10 not between", value1, value2, "merchantExtendField10");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayIsNull() {
            addCriterion("gmt_fail_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayIsNotNull() {
            addCriterion("gmt_fail_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayEqualTo(Date value) {
            addCriterion("gmt_fail_pay =", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayNotEqualTo(Date value) {
            addCriterion("gmt_fail_pay <>", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayGreaterThan(Date value) {
            addCriterion("gmt_fail_pay >", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_fail_pay >=", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayLessThan(Date value) {
            addCriterion("gmt_fail_pay <", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_fail_pay <=", value, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayIn(List<Date> values) {
            addCriterion("gmt_fail_pay in", values, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayNotIn(List<Date> values) {
            addCriterion("gmt_fail_pay not in", values, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayBetween(Date value1, Date value2) {
            addCriterion("gmt_fail_pay between", value1, value2, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtFailPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_fail_pay not between", value1, value2, "gmtFailPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayIsNull() {
            addCriterion("gmt_wait_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayIsNotNull() {
            addCriterion("gmt_wait_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayEqualTo(Date value) {
            addCriterion("gmt_wait_pay =", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayNotEqualTo(Date value) {
            addCriterion("gmt_wait_pay <>", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayGreaterThan(Date value) {
            addCriterion("gmt_wait_pay >", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_pay >=", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayLessThan(Date value) {
            addCriterion("gmt_wait_pay <", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_pay <=", value, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayIn(List<Date> values) {
            addCriterion("gmt_wait_pay in", values, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayNotIn(List<Date> values) {
            addCriterion("gmt_wait_pay not in", values, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_pay between", value1, value2, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_pay not between", value1, value2, "gmtWaitPay");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingIsNull() {
            addCriterion("gmt_wait_in_accountting is null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingIsNotNull() {
            addCriterion("gmt_wait_in_accountting is not null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingEqualTo(Date value) {
            addCriterion("gmt_wait_in_accountting =", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingNotEqualTo(Date value) {
            addCriterion("gmt_wait_in_accountting <>", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingGreaterThan(Date value) {
            addCriterion("gmt_wait_in_accountting >", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_in_accountting >=", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingLessThan(Date value) {
            addCriterion("gmt_wait_in_accountting <", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingLessThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_in_accountting <=", value, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingIn(List<Date> values) {
            addCriterion("gmt_wait_in_accountting in", values, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingNotIn(List<Date> values) {
            addCriterion("gmt_wait_in_accountting not in", values, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_in_accountting between", value1, value2, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitInAccounttingNotBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_in_accountting not between", value1, value2, "gmtWaitInAccountting");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundIsNull() {
            addCriterion("gmt_wait_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundIsNotNull() {
            addCriterion("gmt_wait_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundEqualTo(Date value) {
            addCriterion("gmt_wait_refund =", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundNotEqualTo(Date value) {
            addCriterion("gmt_wait_refund <>", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundGreaterThan(Date value) {
            addCriterion("gmt_wait_refund >", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_refund >=", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundLessThan(Date value) {
            addCriterion("gmt_wait_refund <", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_wait_refund <=", value, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundIn(List<Date> values) {
            addCriterion("gmt_wait_refund in", values, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundNotIn(List<Date> values) {
            addCriterion("gmt_wait_refund not in", values, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_refund between", value1, value2, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtWaitRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_wait_refund not between", value1, value2, "gmtWaitRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIsNull() {
            addCriterion("gmt_refund_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIsNotNull() {
            addCriterion("gmt_refund_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayEqualTo(Date value) {
            addCriterion("gmt_refund_pay =", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotEqualTo(Date value) {
            addCriterion("gmt_refund_pay <>", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayGreaterThan(Date value) {
            addCriterion("gmt_refund_pay >", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_pay >=", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayLessThan(Date value) {
            addCriterion("gmt_refund_pay <", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_pay <=", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIn(List<Date> values) {
            addCriterion("gmt_refund_pay in", values, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotIn(List<Date> values) {
            addCriterion("gmt_refund_pay not in", values, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_pay between", value1, value2, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_pay not between", value1, value2, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayIsNull() {
            addCriterion("gmt_success_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayIsNotNull() {
            addCriterion("gmt_success_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayEqualTo(Date value) {
            addCriterion("gmt_success_pay =", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayNotEqualTo(Date value) {
            addCriterion("gmt_success_pay <>", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayGreaterThan(Date value) {
            addCriterion("gmt_success_pay >", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_pay >=", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayLessThan(Date value) {
            addCriterion("gmt_success_pay <", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_pay <=", value, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayIn(List<Date> values) {
            addCriterion("gmt_success_pay in", values, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayNotIn(List<Date> values) {
            addCriterion("gmt_success_pay not in", values, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayBetween(Date value1, Date value2) {
            addCriterion("gmt_success_pay between", value1, value2, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_pay not between", value1, value2, "gmtSuccessPay");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedIsNull() {
            addCriterion("gmt_abort_unexcepted is null");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedIsNotNull() {
            addCriterion("gmt_abort_unexcepted is not null");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedEqualTo(Date value) {
            addCriterion("gmt_abort_unexcepted =", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedNotEqualTo(Date value) {
            addCriterion("gmt_abort_unexcepted <>", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedGreaterThan(Date value) {
            addCriterion("gmt_abort_unexcepted >", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_abort_unexcepted >=", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedLessThan(Date value) {
            addCriterion("gmt_abort_unexcepted <", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_abort_unexcepted <=", value, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedIn(List<Date> values) {
            addCriterion("gmt_abort_unexcepted in", values, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedNotIn(List<Date> values) {
            addCriterion("gmt_abort_unexcepted not in", values, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedBetween(Date value1, Date value2) {
            addCriterion("gmt_abort_unexcepted between", value1, value2, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andGmtAbortUnexceptedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_abort_unexcepted not between", value1, value2, "gmtAbortUnexcepted");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNull() {
            addCriterion("pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNotNull() {
            addCriterion("pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmtEqualTo(Long value) {
            addCriterion("pay_amt =", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotEqualTo(Long value) {
            addCriterion("pay_amt <>", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThan(Long value) {
            addCriterion("pay_amt >", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_amt >=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThan(Long value) {
            addCriterion("pay_amt <", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThanOrEqualTo(Long value) {
            addCriterion("pay_amt <=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtIn(List<Long> values) {
            addCriterion("pay_amt in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotIn(List<Long> values) {
            addCriterion("pay_amt not in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtBetween(Long value1, Long value2) {
            addCriterion("pay_amt between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotBetween(Long value1, Long value2) {
            addCriterion("pay_amt not between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayUrlIsNull() {
            addCriterion("pay_url is null");
            return (Criteria) this;
        }

        public Criteria andPayUrlIsNotNull() {
            addCriterion("pay_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayUrlEqualTo(String value) {
            addCriterion("pay_url =", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlNotEqualTo(String value) {
            addCriterion("pay_url <>", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlGreaterThan(String value) {
            addCriterion("pay_url >", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_url >=", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlLessThan(String value) {
            addCriterion("pay_url <", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_url <=", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlLike(String value) {
            addCriterion("pay_url like", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlNotLike(String value) {
            addCriterion("pay_url not like", value, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlIn(List<String> values) {
            addCriterion("pay_url in", values, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlNotIn(List<String> values) {
            addCriterion("pay_url not in", values, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlBetween(String value1, String value2) {
            addCriterion("pay_url between", value1, value2, "payUrl");
            return (Criteria) this;
        }

        public Criteria andPayUrlNotBetween(String value1, String value2) {
            addCriterion("pay_url not between", value1, value2, "payUrl");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoIsNull() {
            addCriterion("external_pay_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoIsNotNull() {
            addCriterion("external_pay_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoEqualTo(String value) {
            addCriterion("external_pay_ledger_no =", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoNotEqualTo(String value) {
            addCriterion("external_pay_ledger_no <>", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoGreaterThan(String value) {
            addCriterion("external_pay_ledger_no >", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_pay_ledger_no >=", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoLessThan(String value) {
            addCriterion("external_pay_ledger_no <", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("external_pay_ledger_no <=", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoLike(String value) {
            addCriterion("external_pay_ledger_no like", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoNotLike(String value) {
            addCriterion("external_pay_ledger_no not like", value, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoIn(List<String> values) {
            addCriterion("external_pay_ledger_no in", values, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoNotIn(List<String> values) {
            addCriterion("external_pay_ledger_no not in", values, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoBetween(String value1, String value2) {
            addCriterion("external_pay_ledger_no between", value1, value2, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayLedgerNoNotBetween(String value1, String value2) {
            addCriterion("external_pay_ledger_no not between", value1, value2, "externalPayLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelIsNull() {
            addCriterion("external_pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelIsNotNull() {
            addCriterion("external_pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelEqualTo(String value) {
            addCriterion("external_pay_channel =", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelNotEqualTo(String value) {
            addCriterion("external_pay_channel <>", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelGreaterThan(String value) {
            addCriterion("external_pay_channel >", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelGreaterThanOrEqualTo(String value) {
            addCriterion("external_pay_channel >=", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelLessThan(String value) {
            addCriterion("external_pay_channel <", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelLessThanOrEqualTo(String value) {
            addCriterion("external_pay_channel <=", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelLike(String value) {
            addCriterion("external_pay_channel like", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelNotLike(String value) {
            addCriterion("external_pay_channel not like", value, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelIn(List<String> values) {
            addCriterion("external_pay_channel in", values, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelNotIn(List<String> values) {
            addCriterion("external_pay_channel not in", values, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBetween(String value1, String value2) {
            addCriterion("external_pay_channel between", value1, value2, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelNotBetween(String value1, String value2) {
            addCriterion("external_pay_channel not between", value1, value2, "externalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtIsNull() {
            addCriterion("external_pay_channel_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtIsNotNull() {
            addCriterion("external_pay_channel_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtEqualTo(Long value) {
            addCriterion("external_pay_channel_fee_amt =", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtNotEqualTo(Long value) {
            addCriterion("external_pay_channel_fee_amt <>", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtGreaterThan(Long value) {
            addCriterion("external_pay_channel_fee_amt >", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_pay_channel_fee_amt >=", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtLessThan(Long value) {
            addCriterion("external_pay_channel_fee_amt <", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_pay_channel_fee_amt <=", value, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtIn(List<Long> values) {
            addCriterion("external_pay_channel_fee_amt in", values, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtNotIn(List<Long> values) {
            addCriterion("external_pay_channel_fee_amt not in", values, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtBetween(Long value1, Long value2) {
            addCriterion("external_pay_channel_fee_amt between", value1, value2, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelFeeAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_pay_channel_fee_amt not between", value1, value2, "externalPayChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtIsNull() {
            addCriterion("external_pay_channel_refund_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtIsNotNull() {
            addCriterion("external_pay_channel_refund_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtEqualTo(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt =", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtNotEqualTo(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt <>", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtGreaterThan(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt >", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt >=", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtLessThan(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt <", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_pay_channel_refund_fee_amt <=", value, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtIn(List<Long> values) {
            addCriterion("external_pay_channel_refund_fee_amt in", values, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtNotIn(List<Long> values) {
            addCriterion("external_pay_channel_refund_fee_amt not in", values, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtBetween(Long value1, Long value2) {
            addCriterion("external_pay_channel_refund_fee_amt between", value1, value2, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelRefundFeeAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_pay_channel_refund_fee_amt not between", value1, value2, "externalPayChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoIsNull() {
            addCriterion("external_pay_channel_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoIsNotNull() {
            addCriterion("external_pay_channel_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoEqualTo(String value) {
            addCriterion("external_pay_channel_batch_no =", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoNotEqualTo(String value) {
            addCriterion("external_pay_channel_batch_no <>", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoGreaterThan(String value) {
            addCriterion("external_pay_channel_batch_no >", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_batch_no >=", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoLessThan(String value) {
            addCriterion("external_pay_channel_batch_no <", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoLessThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_batch_no <=", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoLike(String value) {
            addCriterion("external_pay_channel_batch_no like", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoNotLike(String value) {
            addCriterion("external_pay_channel_batch_no not like", value, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoIn(List<String> values) {
            addCriterion("external_pay_channel_batch_no in", values, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoNotIn(List<String> values) {
            addCriterion("external_pay_channel_batch_no not in", values, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoBetween(String value1, String value2) {
            addCriterion("external_pay_channel_batch_no between", value1, value2, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelBatchNoNotBetween(String value1, String value2) {
            addCriterion("external_pay_channel_batch_no not between", value1, value2, "externalPayChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoIsNull() {
            addCriterion("external_pay_channel_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoIsNotNull() {
            addCriterion("external_pay_channel_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoEqualTo(String value) {
            addCriterion("external_pay_channel_serial_no =", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoNotEqualTo(String value) {
            addCriterion("external_pay_channel_serial_no <>", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoGreaterThan(String value) {
            addCriterion("external_pay_channel_serial_no >", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_serial_no >=", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoLessThan(String value) {
            addCriterion("external_pay_channel_serial_no <", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoLessThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_serial_no <=", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoLike(String value) {
            addCriterion("external_pay_channel_serial_no like", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoNotLike(String value) {
            addCriterion("external_pay_channel_serial_no not like", value, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoIn(List<String> values) {
            addCriterion("external_pay_channel_serial_no in", values, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoNotIn(List<String> values) {
            addCriterion("external_pay_channel_serial_no not in", values, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoBetween(String value1, String value2) {
            addCriterion("external_pay_channel_serial_no between", value1, value2, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelSerialNoNotBetween(String value1, String value2) {
            addCriterion("external_pay_channel_serial_no not between", value1, value2, "externalPayChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtIsNull() {
            addCriterion("external_pay_received_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtIsNotNull() {
            addCriterion("external_pay_received_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtEqualTo(Long value) {
            addCriterion("external_pay_received_amt =", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtNotEqualTo(Long value) {
            addCriterion("external_pay_received_amt <>", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtGreaterThan(Long value) {
            addCriterion("external_pay_received_amt >", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_pay_received_amt >=", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtLessThan(Long value) {
            addCriterion("external_pay_received_amt <", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_pay_received_amt <=", value, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtIn(List<Long> values) {
            addCriterion("external_pay_received_amt in", values, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtNotIn(List<Long> values) {
            addCriterion("external_pay_received_amt not in", values, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtBetween(Long value1, Long value2) {
            addCriterion("external_pay_received_amt between", value1, value2, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andExternalPayReceivedAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_pay_received_amt not between", value1, value2, "externalPayReceivedAmt");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelIsNull() {
            addCriterion("gmt_success_external_pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelIsNotNull() {
            addCriterion("gmt_success_external_pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelEqualTo(Date value) {
            addCriterion("gmt_success_external_pay_channel =", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelNotEqualTo(Date value) {
            addCriterion("gmt_success_external_pay_channel <>", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelGreaterThan(Date value) {
            addCriterion("gmt_success_external_pay_channel >", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_external_pay_channel >=", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelLessThan(Date value) {
            addCriterion("gmt_success_external_pay_channel <", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_external_pay_channel <=", value, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelIn(List<Date> values) {
            addCriterion("gmt_success_external_pay_channel in", values, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelNotIn(List<Date> values) {
            addCriterion("gmt_success_external_pay_channel not in", values, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelBetween(Date value1, Date value2) {
            addCriterion("gmt_success_external_pay_channel between", value1, value2, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalPayChannelNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_external_pay_channel not between", value1, value2, "gmtSuccessExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoIsNull() {
            addCriterion("external_pay_channel_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoIsNotNull() {
            addCriterion("external_pay_channel_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoEqualTo(String value) {
            addCriterion("external_pay_channel_trade_no =", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoNotEqualTo(String value) {
            addCriterion("external_pay_channel_trade_no <>", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoGreaterThan(String value) {
            addCriterion("external_pay_channel_trade_no >", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_trade_no >=", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoLessThan(String value) {
            addCriterion("external_pay_channel_trade_no <", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoLessThanOrEqualTo(String value) {
            addCriterion("external_pay_channel_trade_no <=", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoLike(String value) {
            addCriterion("external_pay_channel_trade_no like", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoNotLike(String value) {
            addCriterion("external_pay_channel_trade_no not like", value, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoIn(List<String> values) {
            addCriterion("external_pay_channel_trade_no in", values, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoNotIn(List<String> values) {
            addCriterion("external_pay_channel_trade_no not in", values, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoBetween(String value1, String value2) {
            addCriterion("external_pay_channel_trade_no between", value1, value2, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalPayChannelTradeNoNotBetween(String value1, String value2) {
            addCriterion("external_pay_channel_trade_no not between", value1, value2, "externalPayChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoIsNull() {
            addCriterion("pay_profit_loss_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoIsNotNull() {
            addCriterion("pay_profit_loss_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoEqualTo(String value) {
            addCriterion("pay_profit_loss_ledger_no =", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoNotEqualTo(String value) {
            addCriterion("pay_profit_loss_ledger_no <>", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoGreaterThan(String value) {
            addCriterion("pay_profit_loss_ledger_no >", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_profit_loss_ledger_no >=", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoLessThan(String value) {
            addCriterion("pay_profit_loss_ledger_no <", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("pay_profit_loss_ledger_no <=", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoLike(String value) {
            addCriterion("pay_profit_loss_ledger_no like", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoNotLike(String value) {
            addCriterion("pay_profit_loss_ledger_no not like", value, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoIn(List<String> values) {
            addCriterion("pay_profit_loss_ledger_no in", values, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoNotIn(List<String> values) {
            addCriterion("pay_profit_loss_ledger_no not in", values, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoBetween(String value1, String value2) {
            addCriterion("pay_profit_loss_ledger_no between", value1, value2, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossLedgerNoNotBetween(String value1, String value2) {
            addCriterion("pay_profit_loss_ledger_no not between", value1, value2, "payProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrIsNull() {
            addCriterion("pay_profit_loss_income_decr is null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrIsNotNull() {
            addCriterion("pay_profit_loss_income_decr is not null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrEqualTo(Long value) {
            addCriterion("pay_profit_loss_income_decr =", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrNotEqualTo(Long value) {
            addCriterion("pay_profit_loss_income_decr <>", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrGreaterThan(Long value) {
            addCriterion("pay_profit_loss_income_decr >", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_profit_loss_income_decr >=", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrLessThan(Long value) {
            addCriterion("pay_profit_loss_income_decr <", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrLessThanOrEqualTo(Long value) {
            addCriterion("pay_profit_loss_income_decr <=", value, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrIn(List<Long> values) {
            addCriterion("pay_profit_loss_income_decr in", values, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrNotIn(List<Long> values) {
            addCriterion("pay_profit_loss_income_decr not in", values, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrBetween(Long value1, Long value2) {
            addCriterion("pay_profit_loss_income_decr between", value1, value2, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossIncomeDecrNotBetween(Long value1, Long value2) {
            addCriterion("pay_profit_loss_income_decr not between", value1, value2, "payProfitLossIncomeDecr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrIsNull() {
            addCriterion("pay_profit_loss_cost_incr is null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrIsNotNull() {
            addCriterion("pay_profit_loss_cost_incr is not null");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrEqualTo(Long value) {
            addCriterion("pay_profit_loss_cost_incr =", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrNotEqualTo(Long value) {
            addCriterion("pay_profit_loss_cost_incr <>", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrGreaterThan(Long value) {
            addCriterion("pay_profit_loss_cost_incr >", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_profit_loss_cost_incr >=", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrLessThan(Long value) {
            addCriterion("pay_profit_loss_cost_incr <", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrLessThanOrEqualTo(Long value) {
            addCriterion("pay_profit_loss_cost_incr <=", value, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrIn(List<Long> values) {
            addCriterion("pay_profit_loss_cost_incr in", values, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrNotIn(List<Long> values) {
            addCriterion("pay_profit_loss_cost_incr not in", values, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrBetween(Long value1, Long value2) {
            addCriterion("pay_profit_loss_cost_incr between", value1, value2, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayProfitLossCostIncrNotBetween(Long value1, Long value2) {
            addCriterion("pay_profit_loss_cost_incr not between", value1, value2, "payProfitLossCostIncr");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoIsNull() {
            addCriterion("pay_account_no is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoIsNotNull() {
            addCriterion("pay_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoEqualTo(String value) {
            addCriterion("pay_account_no =", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoNotEqualTo(String value) {
            addCriterion("pay_account_no <>", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoGreaterThan(String value) {
            addCriterion("pay_account_no >", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_no >=", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoLessThan(String value) {
            addCriterion("pay_account_no <", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoLessThanOrEqualTo(String value) {
            addCriterion("pay_account_no <=", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoLike(String value) {
            addCriterion("pay_account_no like", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoNotLike(String value) {
            addCriterion("pay_account_no not like", value, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoIn(List<String> values) {
            addCriterion("pay_account_no in", values, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoNotIn(List<String> values) {
            addCriterion("pay_account_no not in", values, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoBetween(String value1, String value2) {
            addCriterion("pay_account_no between", value1, value2, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountNoNotBetween(String value1, String value2) {
            addCriterion("pay_account_no not between", value1, value2, "payAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoIsNull() {
            addCriterion("pay_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoIsNotNull() {
            addCriterion("pay_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoEqualTo(String value) {
            addCriterion("pay_account_merchant_no =", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoNotEqualTo(String value) {
            addCriterion("pay_account_merchant_no <>", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoGreaterThan(String value) {
            addCriterion("pay_account_merchant_no >", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_merchant_no >=", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoLessThan(String value) {
            addCriterion("pay_account_merchant_no <", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("pay_account_merchant_no <=", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoLike(String value) {
            addCriterion("pay_account_merchant_no like", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoNotLike(String value) {
            addCriterion("pay_account_merchant_no not like", value, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoIn(List<String> values) {
            addCriterion("pay_account_merchant_no in", values, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoNotIn(List<String> values) {
            addCriterion("pay_account_merchant_no not in", values, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("pay_account_merchant_no between", value1, value2, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("pay_account_merchant_no not between", value1, value2, "payAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtIsNull() {
            addCriterion("pay_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtIsNotNull() {
            addCriterion("pay_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("pay_account_out_accounting_amt =", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("pay_account_out_accounting_amt <>", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("pay_account_out_accounting_amt >", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_account_out_accounting_amt >=", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("pay_account_out_accounting_amt <", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("pay_account_out_accounting_amt <=", value, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("pay_account_out_accounting_amt in", values, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("pay_account_out_accounting_amt not in", values, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("pay_account_out_accounting_amt between", value1, value2, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("pay_account_out_accounting_amt not between", value1, value2, "payAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeIsNull() {
            addCriterion("pay_account_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeIsNotNull() {
            addCriterion("pay_account_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeEqualTo(String value) {
            addCriterion("pay_account_out_accounting_type =", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeNotEqualTo(String value) {
            addCriterion("pay_account_out_accounting_type <>", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeGreaterThan(String value) {
            addCriterion("pay_account_out_accounting_type >", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_type >=", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeLessThan(String value) {
            addCriterion("pay_account_out_accounting_type <", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_type <=", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeLike(String value) {
            addCriterion("pay_account_out_accounting_type like", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeNotLike(String value) {
            addCriterion("pay_account_out_accounting_type not like", value, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeIn(List<String> values) {
            addCriterion("pay_account_out_accounting_type in", values, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeNotIn(List<String> values) {
            addCriterion("pay_account_out_accounting_type not in", values, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("pay_account_out_accounting_type between", value1, value2, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("pay_account_out_accounting_type not between", value1, value2, "payAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1IsNull() {
            addCriterion("pay_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1IsNotNull() {
            addCriterion("pay_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("pay_account_out_accounting_his1 =", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his1 <>", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("pay_account_out_accounting_his1 >", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his1 >=", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1LessThan(String value) {
            addCriterion("pay_account_out_accounting_his1 <", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his1 <=", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1Like(String value) {
            addCriterion("pay_account_out_accounting_his1 like", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1NotLike(String value) {
            addCriterion("pay_account_out_accounting_his1 not like", value, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1In(List<String> values) {
            addCriterion("pay_account_out_accounting_his1 in", values, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("pay_account_out_accounting_his1 not in", values, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his1 between", value1, value2, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his1 not between", value1, value2, "payAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2IsNull() {
            addCriterion("pay_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2IsNotNull() {
            addCriterion("pay_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("pay_account_out_accounting_his2 =", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his2 <>", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("pay_account_out_accounting_his2 >", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his2 >=", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2LessThan(String value) {
            addCriterion("pay_account_out_accounting_his2 <", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his2 <=", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2Like(String value) {
            addCriterion("pay_account_out_accounting_his2 like", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2NotLike(String value) {
            addCriterion("pay_account_out_accounting_his2 not like", value, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2In(List<String> values) {
            addCriterion("pay_account_out_accounting_his2 in", values, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("pay_account_out_accounting_his2 not in", values, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his2 between", value1, value2, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his2 not between", value1, value2, "payAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3IsNull() {
            addCriterion("pay_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3IsNotNull() {
            addCriterion("pay_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("pay_account_out_accounting_his3 =", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his3 <>", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("pay_account_out_accounting_his3 >", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his3 >=", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3LessThan(String value) {
            addCriterion("pay_account_out_accounting_his3 <", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("pay_account_out_accounting_his3 <=", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3Like(String value) {
            addCriterion("pay_account_out_accounting_his3 like", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3NotLike(String value) {
            addCriterion("pay_account_out_accounting_his3 not like", value, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3In(List<String> values) {
            addCriterion("pay_account_out_accounting_his3 in", values, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("pay_account_out_accounting_his3 not in", values, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his3 between", value1, value2, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("pay_account_out_accounting_his3 not between", value1, value2, "payAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeIsNull() {
            addCriterion("pay_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeIsNotNull() {
            addCriterion("pay_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeEqualTo(String value) {
            addCriterion("pay_account_in_accounting_type =", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("pay_account_in_accounting_type <>", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("pay_account_in_accounting_type >", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_type >=", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeLessThan(String value) {
            addCriterion("pay_account_in_accounting_type <", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_type <=", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeLike(String value) {
            addCriterion("pay_account_in_accounting_type like", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeNotLike(String value) {
            addCriterion("pay_account_in_accounting_type not like", value, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeIn(List<String> values) {
            addCriterion("pay_account_in_accounting_type in", values, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("pay_account_in_accounting_type not in", values, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("pay_account_in_accounting_type between", value1, value2, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("pay_account_in_accounting_type not between", value1, value2, "payAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1IsNull() {
            addCriterion("pay_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1IsNotNull() {
            addCriterion("pay_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1EqualTo(String value) {
            addCriterion("pay_account_in_accounting_his1 =", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his1 <>", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("pay_account_in_accounting_his1 >", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his1 >=", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1LessThan(String value) {
            addCriterion("pay_account_in_accounting_his1 <", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his1 <=", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1Like(String value) {
            addCriterion("pay_account_in_accounting_his1 like", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1NotLike(String value) {
            addCriterion("pay_account_in_accounting_his1 not like", value, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1In(List<String> values) {
            addCriterion("pay_account_in_accounting_his1 in", values, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("pay_account_in_accounting_his1 not in", values, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his1 between", value1, value2, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his1 not between", value1, value2, "payAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2IsNull() {
            addCriterion("pay_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2IsNotNull() {
            addCriterion("pay_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2EqualTo(String value) {
            addCriterion("pay_account_in_accounting_his2 =", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his2 <>", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("pay_account_in_accounting_his2 >", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his2 >=", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2LessThan(String value) {
            addCriterion("pay_account_in_accounting_his2 <", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his2 <=", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2Like(String value) {
            addCriterion("pay_account_in_accounting_his2 like", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2NotLike(String value) {
            addCriterion("pay_account_in_accounting_his2 not like", value, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2In(List<String> values) {
            addCriterion("pay_account_in_accounting_his2 in", values, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("pay_account_in_accounting_his2 not in", values, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his2 between", value1, value2, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his2 not between", value1, value2, "payAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3IsNull() {
            addCriterion("pay_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3IsNotNull() {
            addCriterion("pay_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3EqualTo(String value) {
            addCriterion("pay_account_in_accounting_his3 =", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his3 <>", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("pay_account_in_accounting_his3 >", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his3 >=", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3LessThan(String value) {
            addCriterion("pay_account_in_accounting_his3 <", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("pay_account_in_accounting_his3 <=", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3Like(String value) {
            addCriterion("pay_account_in_accounting_his3 like", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3NotLike(String value) {
            addCriterion("pay_account_in_accounting_his3 not like", value, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3In(List<String> values) {
            addCriterion("pay_account_in_accounting_his3 in", values, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("pay_account_in_accounting_his3 not in", values, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his3 between", value1, value2, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("pay_account_in_accounting_his3 not between", value1, value2, "payAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoIsNull() {
            addCriterion("pay_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoIsNotNull() {
            addCriterion("pay_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoEqualTo(String value) {
            addCriterion("pay_fee_account_no =", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoNotEqualTo(String value) {
            addCriterion("pay_fee_account_no <>", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoGreaterThan(String value) {
            addCriterion("pay_fee_account_no >", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_no >=", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoLessThan(String value) {
            addCriterion("pay_fee_account_no <", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_no <=", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoLike(String value) {
            addCriterion("pay_fee_account_no like", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoNotLike(String value) {
            addCriterion("pay_fee_account_no not like", value, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoIn(List<String> values) {
            addCriterion("pay_fee_account_no in", values, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoNotIn(List<String> values) {
            addCriterion("pay_fee_account_no not in", values, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoBetween(String value1, String value2) {
            addCriterion("pay_fee_account_no between", value1, value2, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_no not between", value1, value2, "payFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoIsNull() {
            addCriterion("pay_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoIsNotNull() {
            addCriterion("pay_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("pay_fee_account_merchant_no =", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("pay_fee_account_merchant_no <>", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("pay_fee_account_merchant_no >", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_merchant_no >=", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoLessThan(String value) {
            addCriterion("pay_fee_account_merchant_no <", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_merchant_no <=", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoLike(String value) {
            addCriterion("pay_fee_account_merchant_no like", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoNotLike(String value) {
            addCriterion("pay_fee_account_merchant_no not like", value, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("pay_fee_account_merchant_no in", values, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("pay_fee_account_merchant_no not in", values, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("pay_fee_account_merchant_no between", value1, value2, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_merchant_no not between", value1, value2, "payFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtIsNull() {
            addCriterion("pay_fee_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtIsNotNull() {
            addCriterion("pay_fee_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt =", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt <>", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt >", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt >=", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt <", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("pay_fee_account_out_accounting_amt <=", value, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("pay_fee_account_out_accounting_amt in", values, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("pay_fee_account_out_accounting_amt not in", values, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("pay_fee_account_out_accounting_amt between", value1, value2, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("pay_fee_account_out_accounting_amt not between", value1, value2, "payFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeIsNull() {
            addCriterion("pay_fee_account_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeIsNotNull() {
            addCriterion("pay_fee_account_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_type =", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeNotEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_type <>", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeGreaterThan(String value) {
            addCriterion("pay_fee_account_out_accounting_type >", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_type >=", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeLessThan(String value) {
            addCriterion("pay_fee_account_out_accounting_type <", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_type <=", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeLike(String value) {
            addCriterion("pay_fee_account_out_accounting_type like", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeNotLike(String value) {
            addCriterion("pay_fee_account_out_accounting_type not like", value, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeIn(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_type in", values, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeNotIn(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_type not in", values, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_type between", value1, value2, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_type not between", value1, value2, "payFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1IsNull() {
            addCriterion("pay_fee_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1IsNotNull() {
            addCriterion("pay_fee_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 =", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 <>", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 >", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 >=", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1LessThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 <", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 <=", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1Like(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 like", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1NotLike(String value) {
            addCriterion("pay_fee_account_out_accounting_his1 not like", value, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1In(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his1 in", values, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his1 not in", values, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his1 between", value1, value2, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his1 not between", value1, value2, "payFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2IsNull() {
            addCriterion("pay_fee_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2IsNotNull() {
            addCriterion("pay_fee_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 =", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 <>", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 >", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 >=", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2LessThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 <", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 <=", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2Like(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 like", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2NotLike(String value) {
            addCriterion("pay_fee_account_out_accounting_his2 not like", value, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2In(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his2 in", values, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his2 not in", values, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his2 between", value1, value2, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his2 not between", value1, value2, "payFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3IsNull() {
            addCriterion("pay_fee_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3IsNotNull() {
            addCriterion("pay_fee_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 =", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 <>", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 >", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 >=", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3LessThan(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 <", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 <=", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3Like(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 like", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3NotLike(String value) {
            addCriterion("pay_fee_account_out_accounting_his3 not like", value, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3In(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his3 in", values, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("pay_fee_account_out_accounting_his3 not in", values, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his3 between", value1, value2, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFeeAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("pay_fee_account_out_accounting_his3 not between", value1, value2, "payFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtIsNull() {
            addCriterion("receive_amt is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtIsNotNull() {
            addCriterion("receive_amt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtEqualTo(Long value) {
            addCriterion("receive_amt =", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtNotEqualTo(Long value) {
            addCriterion("receive_amt <>", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtGreaterThan(Long value) {
            addCriterion("receive_amt >", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_amt >=", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtLessThan(Long value) {
            addCriterion("receive_amt <", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtLessThanOrEqualTo(Long value) {
            addCriterion("receive_amt <=", value, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtIn(List<Long> values) {
            addCriterion("receive_amt in", values, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtNotIn(List<Long> values) {
            addCriterion("receive_amt not in", values, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtBetween(Long value1, Long value2) {
            addCriterion("receive_amt between", value1, value2, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAmtNotBetween(Long value1, Long value2) {
            addCriterion("receive_amt not between", value1, value2, "receiveAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIsNull() {
            addCriterion("receive_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIsNotNull() {
            addCriterion("receive_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeEqualTo(String value) {
            addCriterion("receive_type =", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotEqualTo(String value) {
            addCriterion("receive_type <>", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThan(String value) {
            addCriterion("receive_type >", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_type >=", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThan(String value) {
            addCriterion("receive_type <", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThanOrEqualTo(String value) {
            addCriterion("receive_type <=", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLike(String value) {
            addCriterion("receive_type like", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotLike(String value) {
            addCriterion("receive_type not like", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIn(List<String> values) {
            addCriterion("receive_type in", values, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotIn(List<String> values) {
            addCriterion("receive_type not in", values, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeBetween(String value1, String value2) {
            addCriterion("receive_type between", value1, value2, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotBetween(String value1, String value2) {
            addCriterion("receive_type not between", value1, value2, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoIsNull() {
            addCriterion("receive_profit_loss_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoIsNotNull() {
            addCriterion("receive_profit_loss_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoEqualTo(String value) {
            addCriterion("receive_profit_loss_ledger_no =", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoNotEqualTo(String value) {
            addCriterion("receive_profit_loss_ledger_no <>", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoGreaterThan(String value) {
            addCriterion("receive_profit_loss_ledger_no >", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_profit_loss_ledger_no >=", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoLessThan(String value) {
            addCriterion("receive_profit_loss_ledger_no <", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("receive_profit_loss_ledger_no <=", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoLike(String value) {
            addCriterion("receive_profit_loss_ledger_no like", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoNotLike(String value) {
            addCriterion("receive_profit_loss_ledger_no not like", value, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoIn(List<String> values) {
            addCriterion("receive_profit_loss_ledger_no in", values, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoNotIn(List<String> values) {
            addCriterion("receive_profit_loss_ledger_no not in", values, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoBetween(String value1, String value2) {
            addCriterion("receive_profit_loss_ledger_no between", value1, value2, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossLedgerNoNotBetween(String value1, String value2) {
            addCriterion("receive_profit_loss_ledger_no not between", value1, value2, "receiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrIsNull() {
            addCriterion("receive_profit_loss_income_incr is null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrIsNotNull() {
            addCriterion("receive_profit_loss_income_incr is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrEqualTo(Long value) {
            addCriterion("receive_profit_loss_income_incr =", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrNotEqualTo(Long value) {
            addCriterion("receive_profit_loss_income_incr <>", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrGreaterThan(Long value) {
            addCriterion("receive_profit_loss_income_incr >", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_profit_loss_income_incr >=", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrLessThan(Long value) {
            addCriterion("receive_profit_loss_income_incr <", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrLessThanOrEqualTo(Long value) {
            addCriterion("receive_profit_loss_income_incr <=", value, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrIn(List<Long> values) {
            addCriterion("receive_profit_loss_income_incr in", values, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrNotIn(List<Long> values) {
            addCriterion("receive_profit_loss_income_incr not in", values, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrBetween(Long value1, Long value2) {
            addCriterion("receive_profit_loss_income_incr between", value1, value2, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossIncomeIncrNotBetween(Long value1, Long value2) {
            addCriterion("receive_profit_loss_income_incr not between", value1, value2, "receiveProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrIsNull() {
            addCriterion("receive_profit_loss_cost_decr is null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrIsNotNull() {
            addCriterion("receive_profit_loss_cost_decr is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrEqualTo(Long value) {
            addCriterion("receive_profit_loss_cost_decr =", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrNotEqualTo(Long value) {
            addCriterion("receive_profit_loss_cost_decr <>", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrGreaterThan(Long value) {
            addCriterion("receive_profit_loss_cost_decr >", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_profit_loss_cost_decr >=", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrLessThan(Long value) {
            addCriterion("receive_profit_loss_cost_decr <", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrLessThanOrEqualTo(Long value) {
            addCriterion("receive_profit_loss_cost_decr <=", value, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrIn(List<Long> values) {
            addCriterion("receive_profit_loss_cost_decr in", values, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrNotIn(List<Long> values) {
            addCriterion("receive_profit_loss_cost_decr not in", values, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrBetween(Long value1, Long value2) {
            addCriterion("receive_profit_loss_cost_decr between", value1, value2, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveProfitLossCostDecrNotBetween(Long value1, Long value2) {
            addCriterion("receive_profit_loss_cost_decr not between", value1, value2, "receiveProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoIsNull() {
            addCriterion("receive_account_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoIsNotNull() {
            addCriterion("receive_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoEqualTo(String value) {
            addCriterion("receive_account_no =", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoNotEqualTo(String value) {
            addCriterion("receive_account_no <>", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoGreaterThan(String value) {
            addCriterion("receive_account_no >", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_no >=", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoLessThan(String value) {
            addCriterion("receive_account_no <", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoLessThanOrEqualTo(String value) {
            addCriterion("receive_account_no <=", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoLike(String value) {
            addCriterion("receive_account_no like", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoNotLike(String value) {
            addCriterion("receive_account_no not like", value, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoIn(List<String> values) {
            addCriterion("receive_account_no in", values, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoNotIn(List<String> values) {
            addCriterion("receive_account_no not in", values, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoBetween(String value1, String value2) {
            addCriterion("receive_account_no between", value1, value2, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNoNotBetween(String value1, String value2) {
            addCriterion("receive_account_no not between", value1, value2, "receiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoIsNull() {
            addCriterion("receive_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoIsNotNull() {
            addCriterion("receive_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoEqualTo(String value) {
            addCriterion("receive_account_merchant_no =", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoNotEqualTo(String value) {
            addCriterion("receive_account_merchant_no <>", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoGreaterThan(String value) {
            addCriterion("receive_account_merchant_no >", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_merchant_no >=", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoLessThan(String value) {
            addCriterion("receive_account_merchant_no <", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("receive_account_merchant_no <=", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoLike(String value) {
            addCriterion("receive_account_merchant_no like", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoNotLike(String value) {
            addCriterion("receive_account_merchant_no not like", value, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoIn(List<String> values) {
            addCriterion("receive_account_merchant_no in", values, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoNotIn(List<String> values) {
            addCriterion("receive_account_merchant_no not in", values, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("receive_account_merchant_no between", value1, value2, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("receive_account_merchant_no not between", value1, value2, "receiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtIsNull() {
            addCriterion("receive_account_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtIsNotNull() {
            addCriterion("receive_account_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtEqualTo(Long value) {
            addCriterion("receive_account_in_accounting_amt =", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtNotEqualTo(Long value) {
            addCriterion("receive_account_in_accounting_amt <>", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtGreaterThan(Long value) {
            addCriterion("receive_account_in_accounting_amt >", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_account_in_accounting_amt >=", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtLessThan(Long value) {
            addCriterion("receive_account_in_accounting_amt <", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("receive_account_in_accounting_amt <=", value, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtIn(List<Long> values) {
            addCriterion("receive_account_in_accounting_amt in", values, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtNotIn(List<Long> values) {
            addCriterion("receive_account_in_accounting_amt not in", values, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("receive_account_in_accounting_amt between", value1, value2, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("receive_account_in_accounting_amt not between", value1, value2, "receiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeIsNull() {
            addCriterion("receive_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeIsNotNull() {
            addCriterion("receive_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeEqualTo(String value) {
            addCriterion("receive_account_in_accounting_type =", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("receive_account_in_accounting_type <>", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("receive_account_in_accounting_type >", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_type >=", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeLessThan(String value) {
            addCriterion("receive_account_in_accounting_type <", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_type <=", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeLike(String value) {
            addCriterion("receive_account_in_accounting_type like", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeNotLike(String value) {
            addCriterion("receive_account_in_accounting_type not like", value, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeIn(List<String> values) {
            addCriterion("receive_account_in_accounting_type in", values, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("receive_account_in_accounting_type not in", values, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("receive_account_in_accounting_type between", value1, value2, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("receive_account_in_accounting_type not between", value1, value2, "receiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1IsNull() {
            addCriterion("receive_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1IsNotNull() {
            addCriterion("receive_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1EqualTo(String value) {
            addCriterion("receive_account_in_accounting_his1 =", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his1 <>", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("receive_account_in_accounting_his1 >", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his1 >=", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1LessThan(String value) {
            addCriterion("receive_account_in_accounting_his1 <", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his1 <=", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1Like(String value) {
            addCriterion("receive_account_in_accounting_his1 like", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1NotLike(String value) {
            addCriterion("receive_account_in_accounting_his1 not like", value, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1In(List<String> values) {
            addCriterion("receive_account_in_accounting_his1 in", values, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("receive_account_in_accounting_his1 not in", values, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his1 between", value1, value2, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his1 not between", value1, value2, "receiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2IsNull() {
            addCriterion("receive_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2IsNotNull() {
            addCriterion("receive_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2EqualTo(String value) {
            addCriterion("receive_account_in_accounting_his2 =", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his2 <>", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("receive_account_in_accounting_his2 >", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his2 >=", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2LessThan(String value) {
            addCriterion("receive_account_in_accounting_his2 <", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his2 <=", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2Like(String value) {
            addCriterion("receive_account_in_accounting_his2 like", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2NotLike(String value) {
            addCriterion("receive_account_in_accounting_his2 not like", value, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2In(List<String> values) {
            addCriterion("receive_account_in_accounting_his2 in", values, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("receive_account_in_accounting_his2 not in", values, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his2 between", value1, value2, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his2 not between", value1, value2, "receiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3IsNull() {
            addCriterion("receive_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3IsNotNull() {
            addCriterion("receive_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3EqualTo(String value) {
            addCriterion("receive_account_in_accounting_his3 =", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his3 <>", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("receive_account_in_accounting_his3 >", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his3 >=", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3LessThan(String value) {
            addCriterion("receive_account_in_accounting_his3 <", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("receive_account_in_accounting_his3 <=", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3Like(String value) {
            addCriterion("receive_account_in_accounting_his3 like", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3NotLike(String value) {
            addCriterion("receive_account_in_accounting_his3 not like", value, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3In(List<String> values) {
            addCriterion("receive_account_in_accounting_his3 in", values, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("receive_account_in_accounting_his3 not in", values, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his3 between", value1, value2, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("receive_account_in_accounting_his3 not between", value1, value2, "receiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoIsNull() {
            addCriterion("receive_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoIsNotNull() {
            addCriterion("receive_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoEqualTo(String value) {
            addCriterion("receive_fee_account_no =", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoNotEqualTo(String value) {
            addCriterion("receive_fee_account_no <>", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoGreaterThan(String value) {
            addCriterion("receive_fee_account_no >", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_no >=", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoLessThan(String value) {
            addCriterion("receive_fee_account_no <", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_no <=", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoLike(String value) {
            addCriterion("receive_fee_account_no like", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoNotLike(String value) {
            addCriterion("receive_fee_account_no not like", value, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoIn(List<String> values) {
            addCriterion("receive_fee_account_no in", values, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoNotIn(List<String> values) {
            addCriterion("receive_fee_account_no not in", values, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoBetween(String value1, String value2) {
            addCriterion("receive_fee_account_no between", value1, value2, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_no not between", value1, value2, "receiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoIsNull() {
            addCriterion("receive_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoIsNotNull() {
            addCriterion("receive_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("receive_fee_account_merchant_no =", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("receive_fee_account_merchant_no <>", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("receive_fee_account_merchant_no >", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_merchant_no >=", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoLessThan(String value) {
            addCriterion("receive_fee_account_merchant_no <", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_merchant_no <=", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoLike(String value) {
            addCriterion("receive_fee_account_merchant_no like", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoNotLike(String value) {
            addCriterion("receive_fee_account_merchant_no not like", value, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("receive_fee_account_merchant_no in", values, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("receive_fee_account_merchant_no not in", values, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("receive_fee_account_merchant_no between", value1, value2, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_merchant_no not between", value1, value2, "receiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtIsNull() {
            addCriterion("receive_fee_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtIsNotNull() {
            addCriterion("receive_fee_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt =", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt <>", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt >", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt >=", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt <", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("receive_fee_account_out_accounting_amt <=", value, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("receive_fee_account_out_accounting_amt in", values, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("receive_fee_account_out_accounting_amt not in", values, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("receive_fee_account_out_accounting_amt between", value1, value2, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("receive_fee_account_out_accounting_amt not between", value1, value2, "receiveFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeIsNull() {
            addCriterion("receive_fee_account_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeIsNotNull() {
            addCriterion("receive_fee_account_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_type =", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeNotEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_type <>", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeGreaterThan(String value) {
            addCriterion("receive_fee_account_out_accounting_type >", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_type >=", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeLessThan(String value) {
            addCriterion("receive_fee_account_out_accounting_type <", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_type <=", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeLike(String value) {
            addCriterion("receive_fee_account_out_accounting_type like", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeNotLike(String value) {
            addCriterion("receive_fee_account_out_accounting_type not like", value, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeIn(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_type in", values, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeNotIn(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_type not in", values, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_type between", value1, value2, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_type not between", value1, value2, "receiveFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1IsNull() {
            addCriterion("receive_fee_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1IsNotNull() {
            addCriterion("receive_fee_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 =", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 <>", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 >", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 >=", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1LessThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 <", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 <=", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1Like(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 like", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1NotLike(String value) {
            addCriterion("receive_fee_account_out_accounting_his1 not like", value, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1In(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his1 in", values, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his1 not in", values, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his1 between", value1, value2, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his1 not between", value1, value2, "receiveFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2IsNull() {
            addCriterion("receive_fee_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2IsNotNull() {
            addCriterion("receive_fee_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 =", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 <>", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 >", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 >=", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2LessThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 <", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 <=", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2Like(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 like", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2NotLike(String value) {
            addCriterion("receive_fee_account_out_accounting_his2 not like", value, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2In(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his2 in", values, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his2 not in", values, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his2 between", value1, value2, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his2 not between", value1, value2, "receiveFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3IsNull() {
            addCriterion("receive_fee_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3IsNotNull() {
            addCriterion("receive_fee_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 =", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 <>", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 >", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 >=", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3LessThan(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 <", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 <=", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3Like(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 like", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3NotLike(String value) {
            addCriterion("receive_fee_account_out_accounting_his3 not like", value, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3In(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his3 in", values, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("receive_fee_account_out_accounting_his3 not in", values, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his3 between", value1, value2, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andReceiveFeeAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("receive_fee_account_out_accounting_his3 not between", value1, value2, "receiveFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeIsNull() {
            addCriterion("refund_pay_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeIsNotNull() {
            addCriterion("refund_pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeEqualTo(String value) {
            addCriterion("refund_pay_type =", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeNotEqualTo(String value) {
            addCriterion("refund_pay_type <>", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeGreaterThan(String value) {
            addCriterion("refund_pay_type >", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_type >=", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeLessThan(String value) {
            addCriterion("refund_pay_type <", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_type <=", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeLike(String value) {
            addCriterion("refund_pay_type like", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeNotLike(String value) {
            addCriterion("refund_pay_type not like", value, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeIn(List<String> values) {
            addCriterion("refund_pay_type in", values, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeNotIn(List<String> values) {
            addCriterion("refund_pay_type not in", values, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_type between", value1, value2, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andRefundPayTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_type not between", value1, value2, "refundPayType");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoIsNull() {
            addCriterion("external_refund_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoIsNotNull() {
            addCriterion("external_refund_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoEqualTo(String value) {
            addCriterion("external_refund_ledger_no =", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoNotEqualTo(String value) {
            addCriterion("external_refund_ledger_no <>", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoGreaterThan(String value) {
            addCriterion("external_refund_ledger_no >", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_refund_ledger_no >=", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoLessThan(String value) {
            addCriterion("external_refund_ledger_no <", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("external_refund_ledger_no <=", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoLike(String value) {
            addCriterion("external_refund_ledger_no like", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoNotLike(String value) {
            addCriterion("external_refund_ledger_no not like", value, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoIn(List<String> values) {
            addCriterion("external_refund_ledger_no in", values, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoNotIn(List<String> values) {
            addCriterion("external_refund_ledger_no not in", values, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoBetween(String value1, String value2) {
            addCriterion("external_refund_ledger_no between", value1, value2, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundLedgerNoNotBetween(String value1, String value2) {
            addCriterion("external_refund_ledger_no not between", value1, value2, "externalRefundLedgerNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelIsNull() {
            addCriterion("external_refund_channel is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelIsNotNull() {
            addCriterion("external_refund_channel is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelEqualTo(String value) {
            addCriterion("external_refund_channel =", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelNotEqualTo(String value) {
            addCriterion("external_refund_channel <>", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelGreaterThan(String value) {
            addCriterion("external_refund_channel >", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelGreaterThanOrEqualTo(String value) {
            addCriterion("external_refund_channel >=", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelLessThan(String value) {
            addCriterion("external_refund_channel <", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelLessThanOrEqualTo(String value) {
            addCriterion("external_refund_channel <=", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelLike(String value) {
            addCriterion("external_refund_channel like", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelNotLike(String value) {
            addCriterion("external_refund_channel not like", value, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelIn(List<String> values) {
            addCriterion("external_refund_channel in", values, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelNotIn(List<String> values) {
            addCriterion("external_refund_channel not in", values, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBetween(String value1, String value2) {
            addCriterion("external_refund_channel between", value1, value2, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelNotBetween(String value1, String value2) {
            addCriterion("external_refund_channel not between", value1, value2, "externalRefundChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtIsNull() {
            addCriterion("external_refund_channel_pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtIsNotNull() {
            addCriterion("external_refund_channel_pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_amt =", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtNotEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_amt <>", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtGreaterThan(Long value) {
            addCriterion("external_refund_channel_pay_amt >", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_amt >=", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtLessThan(Long value) {
            addCriterion("external_refund_channel_pay_amt <", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_amt <=", value, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtIn(List<Long> values) {
            addCriterion("external_refund_channel_pay_amt in", values, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtNotIn(List<Long> values) {
            addCriterion("external_refund_channel_pay_amt not in", values, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_pay_amt between", value1, value2, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_pay_amt not between", value1, value2, "externalRefundChannelPayAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtIsNull() {
            addCriterion("external_refund_channel_refund_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtIsNotNull() {
            addCriterion("external_refund_channel_refund_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtEqualTo(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt =", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtNotEqualTo(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt <>", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtGreaterThan(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt >", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt >=", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtLessThan(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt <", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_refund_fee_amt <=", value, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtIn(List<Long> values) {
            addCriterion("external_refund_channel_refund_fee_amt in", values, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtNotIn(List<Long> values) {
            addCriterion("external_refund_channel_refund_fee_amt not in", values, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_refund_fee_amt between", value1, value2, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelRefundFeeAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_refund_fee_amt not between", value1, value2, "externalRefundChannelRefundFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtIsNull() {
            addCriterion("external_refund_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtIsNotNull() {
            addCriterion("external_refund_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtEqualTo(Long value) {
            addCriterion("external_refund_amt =", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtNotEqualTo(Long value) {
            addCriterion("external_refund_amt <>", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtGreaterThan(Long value) {
            addCriterion("external_refund_amt >", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_refund_amt >=", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtLessThan(Long value) {
            addCriterion("external_refund_amt <", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_refund_amt <=", value, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtIn(List<Long> values) {
            addCriterion("external_refund_amt in", values, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtNotIn(List<Long> values) {
            addCriterion("external_refund_amt not in", values, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtBetween(Long value1, Long value2) {
            addCriterion("external_refund_amt between", value1, value2, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_refund_amt not between", value1, value2, "externalRefundAmt");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelIsNull() {
            addCriterion("gmt_success_refund_external_pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelIsNotNull() {
            addCriterion("gmt_success_refund_external_pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelEqualTo(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel =", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelNotEqualTo(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel <>", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelGreaterThan(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel >", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel >=", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelLessThan(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel <", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_refund_external_pay_channel <=", value, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelIn(List<Date> values) {
            addCriterion("gmt_success_refund_external_pay_channel in", values, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelNotIn(List<Date> values) {
            addCriterion("gmt_success_refund_external_pay_channel not in", values, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelBetween(Date value1, Date value2) {
            addCriterion("gmt_success_refund_external_pay_channel between", value1, value2, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundExternalPayChannelNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_refund_external_pay_channel not between", value1, value2, "gmtSuccessRefundExternalPayChannel");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoIsNull() {
            addCriterion("external_refund_channel_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoIsNotNull() {
            addCriterion("external_refund_channel_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoEqualTo(String value) {
            addCriterion("external_refund_channel_trade_no =", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoNotEqualTo(String value) {
            addCriterion("external_refund_channel_trade_no <>", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoGreaterThan(String value) {
            addCriterion("external_refund_channel_trade_no >", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_trade_no >=", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoLessThan(String value) {
            addCriterion("external_refund_channel_trade_no <", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoLessThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_trade_no <=", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoLike(String value) {
            addCriterion("external_refund_channel_trade_no like", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoNotLike(String value) {
            addCriterion("external_refund_channel_trade_no not like", value, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoIn(List<String> values) {
            addCriterion("external_refund_channel_trade_no in", values, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoNotIn(List<String> values) {
            addCriterion("external_refund_channel_trade_no not in", values, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoBetween(String value1, String value2) {
            addCriterion("external_refund_channel_trade_no between", value1, value2, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelTradeNoNotBetween(String value1, String value2) {
            addCriterion("external_refund_channel_trade_no not between", value1, value2, "externalRefundChannelTradeNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoIsNull() {
            addCriterion("external_refund_channel_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoIsNotNull() {
            addCriterion("external_refund_channel_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoEqualTo(String value) {
            addCriterion("external_refund_channel_batch_no =", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoNotEqualTo(String value) {
            addCriterion("external_refund_channel_batch_no <>", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoGreaterThan(String value) {
            addCriterion("external_refund_channel_batch_no >", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_batch_no >=", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoLessThan(String value) {
            addCriterion("external_refund_channel_batch_no <", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoLessThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_batch_no <=", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoLike(String value) {
            addCriterion("external_refund_channel_batch_no like", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoNotLike(String value) {
            addCriterion("external_refund_channel_batch_no not like", value, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoIn(List<String> values) {
            addCriterion("external_refund_channel_batch_no in", values, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoNotIn(List<String> values) {
            addCriterion("external_refund_channel_batch_no not in", values, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoBetween(String value1, String value2) {
            addCriterion("external_refund_channel_batch_no between", value1, value2, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelBatchNoNotBetween(String value1, String value2) {
            addCriterion("external_refund_channel_batch_no not between", value1, value2, "externalRefundChannelBatchNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoIsNull() {
            addCriterion("external_refund_channel_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoIsNotNull() {
            addCriterion("external_refund_channel_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoEqualTo(String value) {
            addCriterion("external_refund_channel_serial_no =", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoNotEqualTo(String value) {
            addCriterion("external_refund_channel_serial_no <>", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoGreaterThan(String value) {
            addCriterion("external_refund_channel_serial_no >", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_serial_no >=", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoLessThan(String value) {
            addCriterion("external_refund_channel_serial_no <", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoLessThanOrEqualTo(String value) {
            addCriterion("external_refund_channel_serial_no <=", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoLike(String value) {
            addCriterion("external_refund_channel_serial_no like", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoNotLike(String value) {
            addCriterion("external_refund_channel_serial_no not like", value, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoIn(List<String> values) {
            addCriterion("external_refund_channel_serial_no in", values, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoNotIn(List<String> values) {
            addCriterion("external_refund_channel_serial_no not in", values, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoBetween(String value1, String value2) {
            addCriterion("external_refund_channel_serial_no between", value1, value2, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelSerialNoNotBetween(String value1, String value2) {
            addCriterion("external_refund_channel_serial_no not between", value1, value2, "externalRefundChannelSerialNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoIsNull() {
            addCriterion("refund_pay_profit_loss_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoIsNotNull() {
            addCriterion("refund_pay_profit_loss_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoEqualTo(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no =", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoNotEqualTo(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no <>", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoGreaterThan(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no >", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no >=", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoLessThan(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no <", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no <=", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoLike(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no like", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoNotLike(String value) {
            addCriterion("refund_pay_profit_loss_ledger_no not like", value, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoIn(List<String> values) {
            addCriterion("refund_pay_profit_loss_ledger_no in", values, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoNotIn(List<String> values) {
            addCriterion("refund_pay_profit_loss_ledger_no not in", values, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoBetween(String value1, String value2) {
            addCriterion("refund_pay_profit_loss_ledger_no between", value1, value2, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossLedgerNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_profit_loss_ledger_no not between", value1, value2, "refundPayProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrIsNull() {
            addCriterion("refund_pay_profit_loss_income_incr is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrIsNotNull() {
            addCriterion("refund_pay_profit_loss_income_incr is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr =", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrNotEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr <>", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrGreaterThan(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr >", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr >=", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrLessThan(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr <", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_income_incr <=", value, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_income_incr in", values, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrNotIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_income_incr not in", values, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_income_incr between", value1, value2, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossIncomeIncrNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_income_incr not between", value1, value2, "refundPayProfitLossIncomeIncr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrIsNull() {
            addCriterion("refund_pay_profit_loss_cost_decr is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrIsNotNull() {
            addCriterion("refund_pay_profit_loss_cost_decr is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr =", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrNotEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr <>", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrGreaterThan(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr >", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr >=", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrLessThan(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr <", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_cost_decr <=", value, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_cost_decr in", values, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrNotIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_cost_decr not in", values, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_cost_decr between", value1, value2, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossCostDecrNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_cost_decr not between", value1, value2, "refundPayProfitLossCostDecr");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoIsNull() {
            addCriterion("refund_pay_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoIsNotNull() {
            addCriterion("refund_pay_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoEqualTo(String value) {
            addCriterion("refund_pay_account_no =", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoNotEqualTo(String value) {
            addCriterion("refund_pay_account_no <>", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoGreaterThan(String value) {
            addCriterion("refund_pay_account_no >", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_no >=", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoLessThan(String value) {
            addCriterion("refund_pay_account_no <", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_no <=", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoLike(String value) {
            addCriterion("refund_pay_account_no like", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoNotLike(String value) {
            addCriterion("refund_pay_account_no not like", value, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoIn(List<String> values) {
            addCriterion("refund_pay_account_no in", values, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoNotIn(List<String> values) {
            addCriterion("refund_pay_account_no not in", values, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoBetween(String value1, String value2) {
            addCriterion("refund_pay_account_no between", value1, value2, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_no not between", value1, value2, "refundPayAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoIsNull() {
            addCriterion("refund_pay_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoIsNotNull() {
            addCriterion("refund_pay_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoEqualTo(String value) {
            addCriterion("refund_pay_merchant_no =", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoNotEqualTo(String value) {
            addCriterion("refund_pay_merchant_no <>", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoGreaterThan(String value) {
            addCriterion("refund_pay_merchant_no >", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_merchant_no >=", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoLessThan(String value) {
            addCriterion("refund_pay_merchant_no <", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_merchant_no <=", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoLike(String value) {
            addCriterion("refund_pay_merchant_no like", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoNotLike(String value) {
            addCriterion("refund_pay_merchant_no not like", value, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoIn(List<String> values) {
            addCriterion("refund_pay_merchant_no in", values, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoNotIn(List<String> values) {
            addCriterion("refund_pay_merchant_no not in", values, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_pay_merchant_no between", value1, value2, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_merchant_no not between", value1, value2, "refundPayMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtIsNull() {
            addCriterion("refund_pay_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtIsNotNull() {
            addCriterion("refund_pay_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtEqualTo(Long value) {
            addCriterion("refund_pay_in_accounting_amt =", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtNotEqualTo(Long value) {
            addCriterion("refund_pay_in_accounting_amt <>", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtGreaterThan(Long value) {
            addCriterion("refund_pay_in_accounting_amt >", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_in_accounting_amt >=", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtLessThan(Long value) {
            addCriterion("refund_pay_in_accounting_amt <", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_in_accounting_amt <=", value, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtIn(List<Long> values) {
            addCriterion("refund_pay_in_accounting_amt in", values, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtNotIn(List<Long> values) {
            addCriterion("refund_pay_in_accounting_amt not in", values, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("refund_pay_in_accounting_amt between", value1, value2, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_in_accounting_amt not between", value1, value2, "refundPayInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeIsNull() {
            addCriterion("refund_pay_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeIsNotNull() {
            addCriterion("refund_pay_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_type =", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_type <>", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeGreaterThan(String value) {
            addCriterion("refund_pay_out_accounting_type >", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_type >=", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeLessThan(String value) {
            addCriterion("refund_pay_out_accounting_type <", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_type <=", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeLike(String value) {
            addCriterion("refund_pay_out_accounting_type like", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeNotLike(String value) {
            addCriterion("refund_pay_out_accounting_type not like", value, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeIn(List<String> values) {
            addCriterion("refund_pay_out_accounting_type in", values, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_pay_out_accounting_type not in", values, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_type between", value1, value2, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_type not between", value1, value2, "refundPayOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1IsNull() {
            addCriterion("refund_pay_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1IsNotNull() {
            addCriterion("refund_pay_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1EqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his1 =", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his1 <>", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1GreaterThan(String value) {
            addCriterion("refund_pay_out_accounting_his1 >", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his1 >=", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1LessThan(String value) {
            addCriterion("refund_pay_out_accounting_his1 <", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his1 <=", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1Like(String value) {
            addCriterion("refund_pay_out_accounting_his1 like", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1NotLike(String value) {
            addCriterion("refund_pay_out_accounting_his1 not like", value, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1In(List<String> values) {
            addCriterion("refund_pay_out_accounting_his1 in", values, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_pay_out_accounting_his1 not in", values, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his1 between", value1, value2, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his1 not between", value1, value2, "refundPayOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2IsNull() {
            addCriterion("refund_pay_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2IsNotNull() {
            addCriterion("refund_pay_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2EqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his2 =", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his2 <>", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2GreaterThan(String value) {
            addCriterion("refund_pay_out_accounting_his2 >", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his2 >=", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2LessThan(String value) {
            addCriterion("refund_pay_out_accounting_his2 <", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his2 <=", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2Like(String value) {
            addCriterion("refund_pay_out_accounting_his2 like", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2NotLike(String value) {
            addCriterion("refund_pay_out_accounting_his2 not like", value, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2In(List<String> values) {
            addCriterion("refund_pay_out_accounting_his2 in", values, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_pay_out_accounting_his2 not in", values, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his2 between", value1, value2, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his2 not between", value1, value2, "refundPayOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3IsNull() {
            addCriterion("refund_pay_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3IsNotNull() {
            addCriterion("refund_pay_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3EqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his3 =", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his3 <>", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3GreaterThan(String value) {
            addCriterion("refund_pay_out_accounting_his3 >", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his3 >=", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3LessThan(String value) {
            addCriterion("refund_pay_out_accounting_his3 <", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_out_accounting_his3 <=", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3Like(String value) {
            addCriterion("refund_pay_out_accounting_his3 like", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3NotLike(String value) {
            addCriterion("refund_pay_out_accounting_his3 not like", value, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3In(List<String> values) {
            addCriterion("refund_pay_out_accounting_his3 in", values, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_pay_out_accounting_his3 not in", values, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his3 between", value1, value2, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_pay_out_accounting_his3 not between", value1, value2, "refundPayOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeIsNull() {
            addCriterion("refund_pay_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeIsNotNull() {
            addCriterion("refund_pay_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_type =", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_type <>", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeGreaterThan(String value) {
            addCriterion("refund_pay_in_accounting_type >", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_type >=", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeLessThan(String value) {
            addCriterion("refund_pay_in_accounting_type <", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_type <=", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeLike(String value) {
            addCriterion("refund_pay_in_accounting_type like", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeNotLike(String value) {
            addCriterion("refund_pay_in_accounting_type not like", value, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeIn(List<String> values) {
            addCriterion("refund_pay_in_accounting_type in", values, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_pay_in_accounting_type not in", values, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_type between", value1, value2, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_type not between", value1, value2, "refundPayInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1IsNull() {
            addCriterion("refund_pay_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1IsNotNull() {
            addCriterion("refund_pay_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1EqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his1 =", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his1 <>", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1GreaterThan(String value) {
            addCriterion("refund_pay_in_accounting_his1 >", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his1 >=", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1LessThan(String value) {
            addCriterion("refund_pay_in_accounting_his1 <", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his1 <=", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1Like(String value) {
            addCriterion("refund_pay_in_accounting_his1 like", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1NotLike(String value) {
            addCriterion("refund_pay_in_accounting_his1 not like", value, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1In(List<String> values) {
            addCriterion("refund_pay_in_accounting_his1 in", values, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_pay_in_accounting_his1 not in", values, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his1 between", value1, value2, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his1 not between", value1, value2, "refundPayInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2IsNull() {
            addCriterion("refund_pay_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2IsNotNull() {
            addCriterion("refund_pay_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2EqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his2 =", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his2 <>", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2GreaterThan(String value) {
            addCriterion("refund_pay_in_accounting_his2 >", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his2 >=", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2LessThan(String value) {
            addCriterion("refund_pay_in_accounting_his2 <", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his2 <=", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2Like(String value) {
            addCriterion("refund_pay_in_accounting_his2 like", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2NotLike(String value) {
            addCriterion("refund_pay_in_accounting_his2 not like", value, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2In(List<String> values) {
            addCriterion("refund_pay_in_accounting_his2 in", values, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_pay_in_accounting_his2 not in", values, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his2 between", value1, value2, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his2 not between", value1, value2, "refundPayInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3IsNull() {
            addCriterion("refund_pay_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3IsNotNull() {
            addCriterion("refund_pay_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3EqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his3 =", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his3 <>", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3GreaterThan(String value) {
            addCriterion("refund_pay_in_accounting_his3 >", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his3 >=", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3LessThan(String value) {
            addCriterion("refund_pay_in_accounting_his3 <", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_in_accounting_his3 <=", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3Like(String value) {
            addCriterion("refund_pay_in_accounting_his3 like", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3NotLike(String value) {
            addCriterion("refund_pay_in_accounting_his3 not like", value, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3In(List<String> values) {
            addCriterion("refund_pay_in_accounting_his3 in", values, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_pay_in_accounting_his3 not in", values, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his3 between", value1, value2, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_pay_in_accounting_his3 not between", value1, value2, "refundPayInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalIsNull() {
            addCriterion("pay_freeze_bal is null");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalIsNotNull() {
            addCriterion("pay_freeze_bal is not null");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalEqualTo(Long value) {
            addCriterion("pay_freeze_bal =", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalNotEqualTo(Long value) {
            addCriterion("pay_freeze_bal <>", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalGreaterThan(Long value) {
            addCriterion("pay_freeze_bal >", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_freeze_bal >=", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalLessThan(Long value) {
            addCriterion("pay_freeze_bal <", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalLessThanOrEqualTo(Long value) {
            addCriterion("pay_freeze_bal <=", value, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalIn(List<Long> values) {
            addCriterion("pay_freeze_bal in", values, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalNotIn(List<Long> values) {
            addCriterion("pay_freeze_bal not in", values, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalBetween(Long value1, Long value2) {
            addCriterion("pay_freeze_bal between", value1, value2, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andPayFreezeBalNotBetween(Long value1, Long value2) {
            addCriterion("pay_freeze_bal not between", value1, value2, "payFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalIsNull() {
            addCriterion("receive_freeze_bal is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalIsNotNull() {
            addCriterion("receive_freeze_bal is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalEqualTo(Long value) {
            addCriterion("receive_freeze_bal =", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalNotEqualTo(Long value) {
            addCriterion("receive_freeze_bal <>", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalGreaterThan(Long value) {
            addCriterion("receive_freeze_bal >", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_freeze_bal >=", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalLessThan(Long value) {
            addCriterion("receive_freeze_bal <", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalLessThanOrEqualTo(Long value) {
            addCriterion("receive_freeze_bal <=", value, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalIn(List<Long> values) {
            addCriterion("receive_freeze_bal in", values, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalNotIn(List<Long> values) {
            addCriterion("receive_freeze_bal not in", values, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalBetween(Long value1, Long value2) {
            addCriterion("receive_freeze_bal between", value1, value2, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andReceiveFreezeBalNotBetween(Long value1, Long value2) {
            addCriterion("receive_freeze_bal not between", value1, value2, "receiveFreezeBal");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtIsNull() {
            addCriterion("sum_refunded_receive_account_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtIsNotNull() {
            addCriterion("sum_refunded_receive_account_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtEqualTo(Long value) {
            addCriterion("sum_refunded_receive_account_amt =", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_receive_account_amt <>", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_receive_account_amt >", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_receive_account_amt >=", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtLessThan(Long value) {
            addCriterion("sum_refunded_receive_account_amt <", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_receive_account_amt <=", value, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtIn(List<Long> values) {
            addCriterion("sum_refunded_receive_account_amt in", values, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_receive_account_amt not in", values, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_receive_account_amt between", value1, value2, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveAccountAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_receive_account_amt not between", value1, value2, "sumRefundedReceiveAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtIsNull() {
            addCriterion("sum_refunded_pay_fee_account_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtIsNotNull() {
            addCriterion("sum_refunded_pay_fee_account_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtEqualTo(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt =", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt <>", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt >", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt >=", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtLessThan(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt <", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_fee_account_amt <=", value, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtIn(List<Long> values) {
            addCriterion("sum_refunded_pay_fee_account_amt in", values, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_pay_fee_account_amt not in", values, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_fee_account_amt between", value1, value2, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayFeeAccountAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_fee_account_amt not between", value1, value2, "sumRefundedPayFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtIsNull() {
            addCriterion("sum_refunded_receive_fee_account_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtIsNotNull() {
            addCriterion("sum_refunded_receive_fee_account_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtEqualTo(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt =", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt <>", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt >", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt >=", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtLessThan(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt <", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_receive_fee_account_amt <=", value, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtIn(List<Long> values) {
            addCriterion("sum_refunded_receive_fee_account_amt in", values, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_receive_fee_account_amt not in", values, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_receive_fee_account_amt between", value1, value2, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedReceiveFeeAccountAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_receive_fee_account_amt not between", value1, value2, "sumRefundedReceiveFeeAccountAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtIsNull() {
            addCriterion("sum_refunded_pay_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtIsNotNull() {
            addCriterion("sum_refunded_pay_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt =", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt <>", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt >", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt >=", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt <", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt <=", value, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt in", values, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt not in", values, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt between", value1, value2, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_account_out_accounting_amt not between", value1, value2, "sumRefundedPayAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtIsNull() {
            addCriterion("sum_refunded_pay_ledger_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtIsNotNull() {
            addCriterion("sum_refunded_pay_ledger_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtEqualTo(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt =", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt <>", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt >", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt >=", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtLessThan(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt <", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_pay_ledger_amt <=", value, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtIn(List<Long> values) {
            addCriterion("sum_refunded_pay_ledger_amt in", values, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_pay_ledger_amt not in", values, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_ledger_amt between", value1, value2, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedPayLedgerAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_pay_ledger_amt not between", value1, value2, "sumRefundedPayLedgerAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtIsNull() {
            addCriterion("sum_supplied_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtIsNotNull() {
            addCriterion("sum_supplied_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtEqualTo(Long value) {
            addCriterion("sum_supplied_amt =", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtNotEqualTo(Long value) {
            addCriterion("sum_supplied_amt <>", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtGreaterThan(Long value) {
            addCriterion("sum_supplied_amt >", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_supplied_amt >=", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtLessThan(Long value) {
            addCriterion("sum_supplied_amt <", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_supplied_amt <=", value, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtIn(List<Long> values) {
            addCriterion("sum_supplied_amt in", values, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtNotIn(List<Long> values) {
            addCriterion("sum_supplied_amt not in", values, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtBetween(Long value1, Long value2) {
            addCriterion("sum_supplied_amt between", value1, value2, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumSuppliedAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_supplied_amt not between", value1, value2, "sumSuppliedAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtIsNull() {
            addCriterion("sum_refunded_supply_refund_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtIsNotNull() {
            addCriterion("sum_refunded_supply_refund_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtEqualTo(Long value) {
            addCriterion("sum_refunded_supply_refund_amt =", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_supply_refund_amt <>", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_supply_refund_amt >", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_supply_refund_amt >=", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtLessThan(Long value) {
            addCriterion("sum_refunded_supply_refund_amt <", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_supply_refund_amt <=", value, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtIn(List<Long> values) {
            addCriterion("sum_refunded_supply_refund_amt in", values, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_supply_refund_amt not in", values, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_supply_refund_amt between", value1, value2, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedSupplyRefundAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_supply_refund_amt not between", value1, value2, "sumRefundedSupplyRefundAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtIsNull() {
            addCriterion("sum_distributed_royalty_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtIsNotNull() {
            addCriterion("sum_distributed_royalty_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtEqualTo(Long value) {
            addCriterion("sum_distributed_royalty_amt =", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtNotEqualTo(Long value) {
            addCriterion("sum_distributed_royalty_amt <>", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtGreaterThan(Long value) {
            addCriterion("sum_distributed_royalty_amt >", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_distributed_royalty_amt >=", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtLessThan(Long value) {
            addCriterion("sum_distributed_royalty_amt <", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_distributed_royalty_amt <=", value, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtIn(List<Long> values) {
            addCriterion("sum_distributed_royalty_amt in", values, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtNotIn(List<Long> values) {
            addCriterion("sum_distributed_royalty_amt not in", values, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtBetween(Long value1, Long value2) {
            addCriterion("sum_distributed_royalty_amt between", value1, value2, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumDistributedRoyaltyAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_distributed_royalty_amt not between", value1, value2, "sumDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtIsNull() {
            addCriterion("sum_refunded_distributed_royalty_amt is null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtIsNotNull() {
            addCriterion("sum_refunded_distributed_royalty_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtEqualTo(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt =", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtNotEqualTo(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt <>", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtGreaterThan(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt >", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt >=", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtLessThan(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt <", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtLessThanOrEqualTo(Long value) {
            addCriterion("sum_refunded_distributed_royalty_amt <=", value, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtIn(List<Long> values) {
            addCriterion("sum_refunded_distributed_royalty_amt in", values, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtNotIn(List<Long> values) {
            addCriterion("sum_refunded_distributed_royalty_amt not in", values, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_distributed_royalty_amt between", value1, value2, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andSumRefundedDistributedRoyaltyAmtNotBetween(Long value1, Long value2) {
            addCriterion("sum_refunded_distributed_royalty_amt not between", value1, value2, "sumRefundedDistributedRoyaltyAmt");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusIsNull() {
            addCriterion("continue_trade_status is null");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusIsNotNull() {
            addCriterion("continue_trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusEqualTo(String value) {
            addCriterion("continue_trade_status =", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusNotEqualTo(String value) {
            addCriterion("continue_trade_status <>", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusGreaterThan(String value) {
            addCriterion("continue_trade_status >", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("continue_trade_status >=", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusLessThan(String value) {
            addCriterion("continue_trade_status <", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("continue_trade_status <=", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusLike(String value) {
            addCriterion("continue_trade_status like", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusNotLike(String value) {
            addCriterion("continue_trade_status not like", value, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusIn(List<String> values) {
            addCriterion("continue_trade_status in", values, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusNotIn(List<String> values) {
            addCriterion("continue_trade_status not in", values, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusBetween(String value1, String value2) {
            addCriterion("continue_trade_status between", value1, value2, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andContinueTradeStatusNotBetween(String value1, String value2) {
            addCriterion("continue_trade_status not between", value1, value2, "continueTradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1IsNull() {
            addCriterion("trade_extend_field_1 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1IsNotNull() {
            addCriterion("trade_extend_field_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1EqualTo(String value) {
            addCriterion("trade_extend_field_1 =", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1NotEqualTo(String value) {
            addCriterion("trade_extend_field_1 <>", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1GreaterThan(String value) {
            addCriterion("trade_extend_field_1 >", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_1 >=", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1LessThan(String value) {
            addCriterion("trade_extend_field_1 <", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_1 <=", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1Like(String value) {
            addCriterion("trade_extend_field_1 like", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1NotLike(String value) {
            addCriterion("trade_extend_field_1 not like", value, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1In(List<String> values) {
            addCriterion("trade_extend_field_1 in", values, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1NotIn(List<String> values) {
            addCriterion("trade_extend_field_1 not in", values, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1Between(String value1, String value2) {
            addCriterion("trade_extend_field_1 between", value1, value2, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField1NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_1 not between", value1, value2, "tradeExtendField1");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2IsNull() {
            addCriterion("trade_extend_field_2 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2IsNotNull() {
            addCriterion("trade_extend_field_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2EqualTo(String value) {
            addCriterion("trade_extend_field_2 =", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2NotEqualTo(String value) {
            addCriterion("trade_extend_field_2 <>", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2GreaterThan(String value) {
            addCriterion("trade_extend_field_2 >", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_2 >=", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2LessThan(String value) {
            addCriterion("trade_extend_field_2 <", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_2 <=", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2Like(String value) {
            addCriterion("trade_extend_field_2 like", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2NotLike(String value) {
            addCriterion("trade_extend_field_2 not like", value, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2In(List<String> values) {
            addCriterion("trade_extend_field_2 in", values, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2NotIn(List<String> values) {
            addCriterion("trade_extend_field_2 not in", values, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2Between(String value1, String value2) {
            addCriterion("trade_extend_field_2 between", value1, value2, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField2NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_2 not between", value1, value2, "tradeExtendField2");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3IsNull() {
            addCriterion("trade_extend_field_3 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3IsNotNull() {
            addCriterion("trade_extend_field_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3EqualTo(String value) {
            addCriterion("trade_extend_field_3 =", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3NotEqualTo(String value) {
            addCriterion("trade_extend_field_3 <>", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3GreaterThan(String value) {
            addCriterion("trade_extend_field_3 >", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_3 >=", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3LessThan(String value) {
            addCriterion("trade_extend_field_3 <", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_3 <=", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3Like(String value) {
            addCriterion("trade_extend_field_3 like", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3NotLike(String value) {
            addCriterion("trade_extend_field_3 not like", value, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3In(List<String> values) {
            addCriterion("trade_extend_field_3 in", values, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3NotIn(List<String> values) {
            addCriterion("trade_extend_field_3 not in", values, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3Between(String value1, String value2) {
            addCriterion("trade_extend_field_3 between", value1, value2, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField3NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_3 not between", value1, value2, "tradeExtendField3");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4IsNull() {
            addCriterion("trade_extend_field_4 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4IsNotNull() {
            addCriterion("trade_extend_field_4 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4EqualTo(String value) {
            addCriterion("trade_extend_field_4 =", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4NotEqualTo(String value) {
            addCriterion("trade_extend_field_4 <>", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4GreaterThan(String value) {
            addCriterion("trade_extend_field_4 >", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_4 >=", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4LessThan(String value) {
            addCriterion("trade_extend_field_4 <", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_4 <=", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4Like(String value) {
            addCriterion("trade_extend_field_4 like", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4NotLike(String value) {
            addCriterion("trade_extend_field_4 not like", value, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4In(List<String> values) {
            addCriterion("trade_extend_field_4 in", values, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4NotIn(List<String> values) {
            addCriterion("trade_extend_field_4 not in", values, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4Between(String value1, String value2) {
            addCriterion("trade_extend_field_4 between", value1, value2, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField4NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_4 not between", value1, value2, "tradeExtendField4");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5IsNull() {
            addCriterion("trade_extend_field_5 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5IsNotNull() {
            addCriterion("trade_extend_field_5 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5EqualTo(String value) {
            addCriterion("trade_extend_field_5 =", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5NotEqualTo(String value) {
            addCriterion("trade_extend_field_5 <>", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5GreaterThan(String value) {
            addCriterion("trade_extend_field_5 >", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_5 >=", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5LessThan(String value) {
            addCriterion("trade_extend_field_5 <", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_5 <=", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5Like(String value) {
            addCriterion("trade_extend_field_5 like", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5NotLike(String value) {
            addCriterion("trade_extend_field_5 not like", value, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5In(List<String> values) {
            addCriterion("trade_extend_field_5 in", values, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5NotIn(List<String> values) {
            addCriterion("trade_extend_field_5 not in", values, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5Between(String value1, String value2) {
            addCriterion("trade_extend_field_5 between", value1, value2, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField5NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_5 not between", value1, value2, "tradeExtendField5");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6IsNull() {
            addCriterion("trade_extend_field_6 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6IsNotNull() {
            addCriterion("trade_extend_field_6 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6EqualTo(String value) {
            addCriterion("trade_extend_field_6 =", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6NotEqualTo(String value) {
            addCriterion("trade_extend_field_6 <>", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6GreaterThan(String value) {
            addCriterion("trade_extend_field_6 >", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_6 >=", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6LessThan(String value) {
            addCriterion("trade_extend_field_6 <", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_6 <=", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6Like(String value) {
            addCriterion("trade_extend_field_6 like", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6NotLike(String value) {
            addCriterion("trade_extend_field_6 not like", value, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6In(List<String> values) {
            addCriterion("trade_extend_field_6 in", values, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6NotIn(List<String> values) {
            addCriterion("trade_extend_field_6 not in", values, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6Between(String value1, String value2) {
            addCriterion("trade_extend_field_6 between", value1, value2, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField6NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_6 not between", value1, value2, "tradeExtendField6");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7IsNull() {
            addCriterion("trade_extend_field_7 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7IsNotNull() {
            addCriterion("trade_extend_field_7 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7EqualTo(String value) {
            addCriterion("trade_extend_field_7 =", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7NotEqualTo(String value) {
            addCriterion("trade_extend_field_7 <>", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7GreaterThan(String value) {
            addCriterion("trade_extend_field_7 >", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_7 >=", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7LessThan(String value) {
            addCriterion("trade_extend_field_7 <", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_7 <=", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7Like(String value) {
            addCriterion("trade_extend_field_7 like", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7NotLike(String value) {
            addCriterion("trade_extend_field_7 not like", value, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7In(List<String> values) {
            addCriterion("trade_extend_field_7 in", values, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7NotIn(List<String> values) {
            addCriterion("trade_extend_field_7 not in", values, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7Between(String value1, String value2) {
            addCriterion("trade_extend_field_7 between", value1, value2, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField7NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_7 not between", value1, value2, "tradeExtendField7");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8IsNull() {
            addCriterion("trade_extend_field_8 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8IsNotNull() {
            addCriterion("trade_extend_field_8 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8EqualTo(String value) {
            addCriterion("trade_extend_field_8 =", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8NotEqualTo(String value) {
            addCriterion("trade_extend_field_8 <>", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8GreaterThan(String value) {
            addCriterion("trade_extend_field_8 >", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_8 >=", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8LessThan(String value) {
            addCriterion("trade_extend_field_8 <", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_8 <=", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8Like(String value) {
            addCriterion("trade_extend_field_8 like", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8NotLike(String value) {
            addCriterion("trade_extend_field_8 not like", value, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8In(List<String> values) {
            addCriterion("trade_extend_field_8 in", values, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8NotIn(List<String> values) {
            addCriterion("trade_extend_field_8 not in", values, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8Between(String value1, String value2) {
            addCriterion("trade_extend_field_8 between", value1, value2, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField8NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_8 not between", value1, value2, "tradeExtendField8");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9IsNull() {
            addCriterion("trade_extend_field_9 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9IsNotNull() {
            addCriterion("trade_extend_field_9 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9EqualTo(String value) {
            addCriterion("trade_extend_field_9 =", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9NotEqualTo(String value) {
            addCriterion("trade_extend_field_9 <>", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9GreaterThan(String value) {
            addCriterion("trade_extend_field_9 >", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_9 >=", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9LessThan(String value) {
            addCriterion("trade_extend_field_9 <", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_9 <=", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9Like(String value) {
            addCriterion("trade_extend_field_9 like", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9NotLike(String value) {
            addCriterion("trade_extend_field_9 not like", value, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9In(List<String> values) {
            addCriterion("trade_extend_field_9 in", values, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9NotIn(List<String> values) {
            addCriterion("trade_extend_field_9 not in", values, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9Between(String value1, String value2) {
            addCriterion("trade_extend_field_9 between", value1, value2, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField9NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_9 not between", value1, value2, "tradeExtendField9");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10IsNull() {
            addCriterion("trade_extend_field_10 is null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10IsNotNull() {
            addCriterion("trade_extend_field_10 is not null");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10EqualTo(String value) {
            addCriterion("trade_extend_field_10 =", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10NotEqualTo(String value) {
            addCriterion("trade_extend_field_10 <>", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10GreaterThan(String value) {
            addCriterion("trade_extend_field_10 >", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10GreaterThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_10 >=", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10LessThan(String value) {
            addCriterion("trade_extend_field_10 <", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10LessThanOrEqualTo(String value) {
            addCriterion("trade_extend_field_10 <=", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10Like(String value) {
            addCriterion("trade_extend_field_10 like", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10NotLike(String value) {
            addCriterion("trade_extend_field_10 not like", value, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10In(List<String> values) {
            addCriterion("trade_extend_field_10 in", values, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10NotIn(List<String> values) {
            addCriterion("trade_extend_field_10 not in", values, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10Between(String value1, String value2) {
            addCriterion("trade_extend_field_10 between", value1, value2, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andTradeExtendField10NotBetween(String value1, String value2) {
            addCriterion("trade_extend_field_10 not between", value1, value2, "tradeExtendField10");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossIsNull() {
            addCriterion("extend_profit_loss is null");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossIsNotNull() {
            addCriterion("extend_profit_loss is not null");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossEqualTo(String value) {
            addCriterion("extend_profit_loss =", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossNotEqualTo(String value) {
            addCriterion("extend_profit_loss <>", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossGreaterThan(String value) {
            addCriterion("extend_profit_loss >", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossGreaterThanOrEqualTo(String value) {
            addCriterion("extend_profit_loss >=", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossLessThan(String value) {
            addCriterion("extend_profit_loss <", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossLessThanOrEqualTo(String value) {
            addCriterion("extend_profit_loss <=", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossLike(String value) {
            addCriterion("extend_profit_loss like", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossNotLike(String value) {
            addCriterion("extend_profit_loss not like", value, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossIn(List<String> values) {
            addCriterion("extend_profit_loss in", values, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossNotIn(List<String> values) {
            addCriterion("extend_profit_loss not in", values, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossBetween(String value1, String value2) {
            addCriterion("extend_profit_loss between", value1, value2, "extendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andExtendProfitLossNotBetween(String value1, String value2) {
            addCriterion("extend_profit_loss not between", value1, value2, "extendProfitLoss");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_single_payment
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}