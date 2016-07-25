package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeSinglePaymentRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeSinglePaymentRefundExample() {
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

        public Criteria andTradeCatatoryIsNull() {
            addCriterion("trade_catatory is null");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryIsNotNull() {
            addCriterion("trade_catatory is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryEqualTo(String value) {
            addCriterion("trade_catatory =", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryNotEqualTo(String value) {
            addCriterion("trade_catatory <>", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryGreaterThan(String value) {
            addCriterion("trade_catatory >", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryGreaterThanOrEqualTo(String value) {
            addCriterion("trade_catatory >=", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryLessThan(String value) {
            addCriterion("trade_catatory <", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryLessThanOrEqualTo(String value) {
            addCriterion("trade_catatory <=", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryLike(String value) {
            addCriterion("trade_catatory like", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryNotLike(String value) {
            addCriterion("trade_catatory not like", value, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryIn(List<String> values) {
            addCriterion("trade_catatory in", values, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryNotIn(List<String> values) {
            addCriterion("trade_catatory not in", values, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryBetween(String value1, String value2) {
            addCriterion("trade_catatory between", value1, value2, "tradeCatatory");
            return (Criteria) this;
        }

        public Criteria andTradeCatatoryNotBetween(String value1, String value2) {
            addCriterion("trade_catatory not between", value1, value2, "tradeCatatory");
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

        public Criteria andGmtRefundDeductIsNull() {
            addCriterion("gmt_refund_deduct is null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductIsNotNull() {
            addCriterion("gmt_refund_deduct is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductEqualTo(Date value) {
            addCriterion("gmt_refund_deduct =", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductNotEqualTo(Date value) {
            addCriterion("gmt_refund_deduct <>", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductGreaterThan(Date value) {
            addCriterion("gmt_refund_deduct >", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_deduct >=", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductLessThan(Date value) {
            addCriterion("gmt_refund_deduct <", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductLessThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_deduct <=", value, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductIn(List<Date> values) {
            addCriterion("gmt_refund_deduct in", values, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductNotIn(List<Date> values) {
            addCriterion("gmt_refund_deduct not in", values, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_deduct between", value1, value2, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtRefundDeductNotBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_deduct not between", value1, value2, "gmtRefundDeduct");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundIsNull() {
            addCriterion("gmt_fail_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundIsNotNull() {
            addCriterion("gmt_fail_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundEqualTo(Date value) {
            addCriterion("gmt_fail_refund =", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundNotEqualTo(Date value) {
            addCriterion("gmt_fail_refund <>", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundGreaterThan(Date value) {
            addCriterion("gmt_fail_refund >", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_fail_refund >=", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundLessThan(Date value) {
            addCriterion("gmt_fail_refund <", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_fail_refund <=", value, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundIn(List<Date> values) {
            addCriterion("gmt_fail_refund in", values, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundNotIn(List<Date> values) {
            addCriterion("gmt_fail_refund not in", values, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_fail_refund between", value1, value2, "gmtFailRefund");
            return (Criteria) this;
        }

        public Criteria andGmtFailRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_fail_refund not between", value1, value2, "gmtFailRefund");
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

        public Criteria andGmtRefuseRefundIsNull() {
            addCriterion("gmt_refuse_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundIsNotNull() {
            addCriterion("gmt_refuse_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundEqualTo(Date value) {
            addCriterion("gmt_refuse_refund =", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundNotEqualTo(Date value) {
            addCriterion("gmt_refuse_refund <>", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundGreaterThan(Date value) {
            addCriterion("gmt_refuse_refund >", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_refuse_refund >=", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundLessThan(Date value) {
            addCriterion("gmt_refuse_refund <", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_refuse_refund <=", value, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundIn(List<Date> values) {
            addCriterion("gmt_refuse_refund in", values, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundNotIn(List<Date> values) {
            addCriterion("gmt_refuse_refund not in", values, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_refuse_refund between", value1, value2, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtRefuseRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_refuse_refund not between", value1, value2, "gmtRefuseRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundIsNull() {
            addCriterion("gmt_cancel_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundIsNotNull() {
            addCriterion("gmt_cancel_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundEqualTo(Date value) {
            addCriterion("gmt_cancel_refund =", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundNotEqualTo(Date value) {
            addCriterion("gmt_cancel_refund <>", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundGreaterThan(Date value) {
            addCriterion("gmt_cancel_refund >", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_cancel_refund >=", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundLessThan(Date value) {
            addCriterion("gmt_cancel_refund <", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_cancel_refund <=", value, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundIn(List<Date> values) {
            addCriterion("gmt_cancel_refund in", values, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundNotIn(List<Date> values) {
            addCriterion("gmt_cancel_refund not in", values, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_cancel_refund between", value1, value2, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtCancelRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_cancel_refund not between", value1, value2, "gmtCancelRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundIsNull() {
            addCriterion("gmt_success_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundIsNotNull() {
            addCriterion("gmt_success_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundEqualTo(Date value) {
            addCriterion("gmt_success_refund =", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundNotEqualTo(Date value) {
            addCriterion("gmt_success_refund <>", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundGreaterThan(Date value) {
            addCriterion("gmt_success_refund >", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_refund >=", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundLessThan(Date value) {
            addCriterion("gmt_success_refund <", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_refund <=", value, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundIn(List<Date> values) {
            addCriterion("gmt_success_refund in", values, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundNotIn(List<Date> values) {
            addCriterion("gmt_success_refund not in", values, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_success_refund between", value1, value2, "gmtSuccessRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_refund not between", value1, value2, "gmtSuccessRefund");
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

        public Criteria andRefundReceiveAmtIsNull() {
            addCriterion("refund_receive_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtIsNotNull() {
            addCriterion("refund_receive_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtEqualTo(Long value) {
            addCriterion("refund_receive_amt =", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtNotEqualTo(Long value) {
            addCriterion("refund_receive_amt <>", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtGreaterThan(Long value) {
            addCriterion("refund_receive_amt >", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_receive_amt >=", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtLessThan(Long value) {
            addCriterion("refund_receive_amt <", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_receive_amt <=", value, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtIn(List<Long> values) {
            addCriterion("refund_receive_amt in", values, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtNotIn(List<Long> values) {
            addCriterion("refund_receive_amt not in", values, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtBetween(Long value1, Long value2) {
            addCriterion("refund_receive_amt between", value1, value2, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_receive_amt not between", value1, value2, "refundReceiveAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeIsNull() {
            addCriterion("refund_receive_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeIsNotNull() {
            addCriterion("refund_receive_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeEqualTo(String value) {
            addCriterion("refund_receive_type =", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeNotEqualTo(String value) {
            addCriterion("refund_receive_type <>", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeGreaterThan(String value) {
            addCriterion("refund_receive_type >", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_type >=", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeLessThan(String value) {
            addCriterion("refund_receive_type <", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_type <=", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeLike(String value) {
            addCriterion("refund_receive_type like", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeNotLike(String value) {
            addCriterion("refund_receive_type not like", value, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeIn(List<String> values) {
            addCriterion("refund_receive_type in", values, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeNotIn(List<String> values) {
            addCriterion("refund_receive_type not in", values, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeBetween(String value1, String value2) {
            addCriterion("refund_receive_type between", value1, value2, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveTypeNotBetween(String value1, String value2) {
            addCriterion("refund_receive_type not between", value1, value2, "refundReceiveType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoIsNull() {
            addCriterion("refund_receive_profit_loss_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoIsNotNull() {
            addCriterion("refund_receive_profit_loss_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoEqualTo(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no =", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoNotEqualTo(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no <>", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoGreaterThan(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no >", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no >=", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoLessThan(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no <", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no <=", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoLike(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no like", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoNotLike(String value) {
            addCriterion("refund_receive_profit_loss_ledger_no not like", value, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoIn(List<String> values) {
            addCriterion("refund_receive_profit_loss_ledger_no in", values, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoNotIn(List<String> values) {
            addCriterion("refund_receive_profit_loss_ledger_no not in", values, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoBetween(String value1, String value2) {
            addCriterion("refund_receive_profit_loss_ledger_no between", value1, value2, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossLedgerNoNotBetween(String value1, String value2) {
            addCriterion("refund_receive_profit_loss_ledger_no not between", value1, value2, "refundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtIsNull() {
            addCriterion("refund_receive_profit_loss_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtIsNotNull() {
            addCriterion("refund_receive_profit_loss_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtEqualTo(Long value) {
            addCriterion("refund_receive_profit_loss_amt =", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtNotEqualTo(Long value) {
            addCriterion("refund_receive_profit_loss_amt <>", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtGreaterThan(Long value) {
            addCriterion("refund_receive_profit_loss_amt >", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_receive_profit_loss_amt >=", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtLessThan(Long value) {
            addCriterion("refund_receive_profit_loss_amt <", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_receive_profit_loss_amt <=", value, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtIn(List<Long> values) {
            addCriterion("refund_receive_profit_loss_amt in", values, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtNotIn(List<Long> values) {
            addCriterion("refund_receive_profit_loss_amt not in", values, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtBetween(Long value1, Long value2) {
            addCriterion("refund_receive_profit_loss_amt between", value1, value2, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveProfitLossAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_receive_profit_loss_amt not between", value1, value2, "refundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoIsNull() {
            addCriterion("refund_receive_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoIsNotNull() {
            addCriterion("refund_receive_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoEqualTo(String value) {
            addCriterion("refund_receive_account_no =", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoNotEqualTo(String value) {
            addCriterion("refund_receive_account_no <>", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoGreaterThan(String value) {
            addCriterion("refund_receive_account_no >", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_no >=", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoLessThan(String value) {
            addCriterion("refund_receive_account_no <", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_no <=", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoLike(String value) {
            addCriterion("refund_receive_account_no like", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoNotLike(String value) {
            addCriterion("refund_receive_account_no not like", value, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoIn(List<String> values) {
            addCriterion("refund_receive_account_no in", values, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoNotIn(List<String> values) {
            addCriterion("refund_receive_account_no not in", values, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoBetween(String value1, String value2) {
            addCriterion("refund_receive_account_no between", value1, value2, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountNoNotBetween(String value1, String value2) {
            addCriterion("refund_receive_account_no not between", value1, value2, "refundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoIsNull() {
            addCriterion("refund_receive_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoIsNotNull() {
            addCriterion("refund_receive_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoEqualTo(String value) {
            addCriterion("refund_receive_account_merchant_no =", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoNotEqualTo(String value) {
            addCriterion("refund_receive_account_merchant_no <>", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoGreaterThan(String value) {
            addCriterion("refund_receive_account_merchant_no >", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_merchant_no >=", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoLessThan(String value) {
            addCriterion("refund_receive_account_merchant_no <", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_merchant_no <=", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoLike(String value) {
            addCriterion("refund_receive_account_merchant_no like", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoNotLike(String value) {
            addCriterion("refund_receive_account_merchant_no not like", value, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoIn(List<String> values) {
            addCriterion("refund_receive_account_merchant_no in", values, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoNotIn(List<String> values) {
            addCriterion("refund_receive_account_merchant_no not in", values, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_receive_account_merchant_no between", value1, value2, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_receive_account_merchant_no not between", value1, value2, "refundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtIsNull() {
            addCriterion("refund_receive_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtIsNotNull() {
            addCriterion("refund_receive_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt =", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt <>", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt >", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt >=", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt <", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_receive_account_out_accounting_amt <=", value, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("refund_receive_account_out_accounting_amt in", values, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("refund_receive_account_out_accounting_amt not in", values, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("refund_receive_account_out_accounting_amt between", value1, value2, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_receive_account_out_accounting_amt not between", value1, value2, "refundReceiveAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1IsNull() {
            addCriterion("refund_receive_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1IsNotNull() {
            addCriterion("refund_receive_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 =", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 <>", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 >", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 >=", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1LessThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 <", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 <=", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1Like(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 like", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1NotLike(String value) {
            addCriterion("refund_receive_account_out_accounting_his1 not like", value, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1In(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his1 in", values, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his1 not in", values, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his1 between", value1, value2, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his1 not between", value1, value2, "refundReceiveAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2IsNull() {
            addCriterion("refund_receive_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2IsNotNull() {
            addCriterion("refund_receive_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 =", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 <>", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 >", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 >=", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2LessThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 <", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 <=", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2Like(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 like", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2NotLike(String value) {
            addCriterion("refund_receive_account_out_accounting_his2 not like", value, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2In(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his2 in", values, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his2 not in", values, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his2 between", value1, value2, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his2 not between", value1, value2, "refundReceiveAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3IsNull() {
            addCriterion("refund_receive_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3IsNotNull() {
            addCriterion("refund_receive_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 =", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 <>", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 >", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 >=", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3LessThan(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 <", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 <=", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3Like(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 like", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3NotLike(String value) {
            addCriterion("refund_receive_account_out_accounting_his3 not like", value, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3In(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his3 in", values, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_receive_account_out_accounting_his3 not in", values, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his3 between", value1, value2, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_receive_account_out_accounting_his3 not between", value1, value2, "refundReceiveAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoIsNull() {
            addCriterion("refund_receive_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoIsNotNull() {
            addCriterion("refund_receive_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoEqualTo(String value) {
            addCriterion("refund_receive_fee_account_no =", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoNotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_no <>", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoGreaterThan(String value) {
            addCriterion("refund_receive_fee_account_no >", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_no >=", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoLessThan(String value) {
            addCriterion("refund_receive_fee_account_no <", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_no <=", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoLike(String value) {
            addCriterion("refund_receive_fee_account_no like", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoNotLike(String value) {
            addCriterion("refund_receive_fee_account_no not like", value, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoIn(List<String> values) {
            addCriterion("refund_receive_fee_account_no in", values, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoNotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_no not in", values, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_no between", value1, value2, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_no not between", value1, value2, "refundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoIsNull() {
            addCriterion("refund_receive_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoIsNotNull() {
            addCriterion("refund_receive_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("refund_receive_fee_account_merchant_no =", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_merchant_no <>", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("refund_receive_fee_account_merchant_no >", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_merchant_no >=", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoLessThan(String value) {
            addCriterion("refund_receive_fee_account_merchant_no <", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_merchant_no <=", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoLike(String value) {
            addCriterion("refund_receive_fee_account_merchant_no like", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoNotLike(String value) {
            addCriterion("refund_receive_fee_account_merchant_no not like", value, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("refund_receive_fee_account_merchant_no in", values, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_merchant_no not in", values, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_merchant_no between", value1, value2, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_merchant_no not between", value1, value2, "refundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtIsNull() {
            addCriterion("refund_receive_fee_account_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtIsNotNull() {
            addCriterion("refund_receive_fee_account_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtEqualTo(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt =", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtNotEqualTo(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt <>", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtGreaterThan(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt >", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt >=", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtLessThan(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt <", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_receive_fee_account_in_accounting_amt <=", value, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtIn(List<Long> values) {
            addCriterion("refund_receive_fee_account_in_accounting_amt in", values, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtNotIn(List<Long> values) {
            addCriterion("refund_receive_fee_account_in_accounting_amt not in", values, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("refund_receive_fee_account_in_accounting_amt between", value1, value2, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_receive_fee_account_in_accounting_amt not between", value1, value2, "refundReceiveFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeIsNull() {
            addCriterion("refund_receive_fee_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeIsNotNull() {
            addCriterion("refund_receive_fee_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type =", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type <>", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type >", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type >=", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeLessThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type <", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type <=", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeLike(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type like", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeNotLike(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_type not like", value, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeIn(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_type in", values, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_type not in", values, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_type between", value1, value2, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_type not between", value1, value2, "refundReceiveFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1IsNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1IsNotNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1EqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 =", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 <>", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 >", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 >=", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1LessThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 <", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 <=", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1Like(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 like", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1NotLike(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 not like", value, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1In(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 in", values, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 not in", values, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 between", value1, value2, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his1 not between", value1, value2, "refundReceiveFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2IsNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2IsNotNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2EqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 =", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 <>", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 >", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 >=", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2LessThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 <", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 <=", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2Like(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 like", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2NotLike(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 not like", value, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2In(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 in", values, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 not in", values, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 between", value1, value2, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his2 not between", value1, value2, "refundReceiveFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3IsNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3IsNotNull() {
            addCriterion("refund_receive_fee_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3EqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 =", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 <>", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 >", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 >=", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3LessThan(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 <", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 <=", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3Like(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 like", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3NotLike(String value) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 not like", value, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3In(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 in", values, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 not in", values, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 between", value1, value2, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundReceiveFeeAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_receive_fee_account_in_accounting_his3 not between", value1, value2, "refundReceiveFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoIsNull() {
            addCriterion("refund_pay_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoIsNotNull() {
            addCriterion("refund_pay_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoEqualTo(String value) {
            addCriterion("refund_pay_fee_account_no =", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoNotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_no <>", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoGreaterThan(String value) {
            addCriterion("refund_pay_fee_account_no >", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_no >=", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoLessThan(String value) {
            addCriterion("refund_pay_fee_account_no <", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_no <=", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoLike(String value) {
            addCriterion("refund_pay_fee_account_no like", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoNotLike(String value) {
            addCriterion("refund_pay_fee_account_no not like", value, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoIn(List<String> values) {
            addCriterion("refund_pay_fee_account_no in", values, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoNotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_no not in", values, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_no between", value1, value2, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_no not between", value1, value2, "refundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoIsNull() {
            addCriterion("refund_pay_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoIsNotNull() {
            addCriterion("refund_pay_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("refund_pay_fee_account_merchant_no =", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_merchant_no <>", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("refund_pay_fee_account_merchant_no >", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_merchant_no >=", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoLessThan(String value) {
            addCriterion("refund_pay_fee_account_merchant_no <", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_merchant_no <=", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoLike(String value) {
            addCriterion("refund_pay_fee_account_merchant_no like", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoNotLike(String value) {
            addCriterion("refund_pay_fee_account_merchant_no not like", value, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("refund_pay_fee_account_merchant_no in", values, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_merchant_no not in", values, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_merchant_no between", value1, value2, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_merchant_no not between", value1, value2, "refundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtIsNull() {
            addCriterion("refund_pay_fee_account_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtIsNotNull() {
            addCriterion("refund_pay_fee_account_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtEqualTo(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt =", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtNotEqualTo(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt <>", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtGreaterThan(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt >", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt >=", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtLessThan(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt <", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_fee_account_in_accounting_amt <=", value, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtIn(List<Long> values) {
            addCriterion("refund_pay_fee_account_in_accounting_amt in", values, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtNotIn(List<Long> values) {
            addCriterion("refund_pay_fee_account_in_accounting_amt not in", values, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("refund_pay_fee_account_in_accounting_amt between", value1, value2, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_fee_account_in_accounting_amt not between", value1, value2, "refundPayFeeAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeIsNull() {
            addCriterion("refund_pay_fee_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeIsNotNull() {
            addCriterion("refund_pay_fee_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type =", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type <>", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type >", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type >=", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeLessThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type <", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type <=", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeLike(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type like", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeNotLike(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_type not like", value, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeIn(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_type in", values, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_type not in", values, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_type between", value1, value2, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_type not between", value1, value2, "refundPayFeeAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1IsNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1IsNotNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1EqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 =", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 <>", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 >", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 >=", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1LessThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 <", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 <=", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1Like(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 like", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1NotLike(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 not like", value, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1In(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 in", values, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 not in", values, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 between", value1, value2, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his1 not between", value1, value2, "refundPayFeeAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2IsNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2IsNotNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2EqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 =", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 <>", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 >", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 >=", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2LessThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 <", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 <=", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2Like(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 like", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2NotLike(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 not like", value, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2In(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 in", values, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 not in", values, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 between", value1, value2, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his2 not between", value1, value2, "refundPayFeeAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3IsNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3IsNotNull() {
            addCriterion("refund_pay_fee_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3EqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 =", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 <>", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 >", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 >=", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3LessThan(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 <", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 <=", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3Like(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 like", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3NotLike(String value) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 not like", value, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3In(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 in", values, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 not in", values, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 between", value1, value2, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayFeeAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_pay_fee_account_in_accounting_his3 not between", value1, value2, "refundPayFeeAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtIsNull() {
            addCriterion("refund_pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtIsNotNull() {
            addCriterion("refund_pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtEqualTo(Long value) {
            addCriterion("refund_pay_amt =", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtNotEqualTo(Long value) {
            addCriterion("refund_pay_amt <>", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtGreaterThan(Long value) {
            addCriterion("refund_pay_amt >", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_amt >=", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtLessThan(Long value) {
            addCriterion("refund_pay_amt <", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_amt <=", value, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtIn(List<Long> values) {
            addCriterion("refund_pay_amt in", values, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtNotIn(List<Long> values) {
            addCriterion("refund_pay_amt not in", values, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtBetween(Long value1, Long value2) {
            addCriterion("refund_pay_amt between", value1, value2, "refundPayAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_amt not between", value1, value2, "refundPayAmt");
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

        public Criteria andRefundPayProfitLossAmtIsNull() {
            addCriterion("refund_pay_profit_loss_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtIsNotNull() {
            addCriterion("refund_pay_profit_loss_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_amt =", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtNotEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_amt <>", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtGreaterThan(Long value) {
            addCriterion("refund_pay_profit_loss_amt >", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_amt >=", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtLessThan(Long value) {
            addCriterion("refund_pay_profit_loss_amt <", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_profit_loss_amt <=", value, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_amt in", values, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtNotIn(List<Long> values) {
            addCriterion("refund_pay_profit_loss_amt not in", values, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_amt between", value1, value2, "refundPayProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayProfitLossAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_profit_loss_amt not between", value1, value2, "refundPayProfitLossAmt");
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

        public Criteria andExternalRefundChannelPayFeeAmtIsNull() {
            addCriterion("external_refund_channel_pay_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtIsNotNull() {
            addCriterion("external_refund_channel_pay_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt =", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtNotEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt <>", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtGreaterThan(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt >", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt >=", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtLessThan(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt <", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_pay_fee_amt <=", value, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtIn(List<Long> values) {
            addCriterion("external_refund_channel_pay_fee_amt in", values, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtNotIn(List<Long> values) {
            addCriterion("external_refund_channel_pay_fee_amt not in", values, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_pay_fee_amt between", value1, value2, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelPayFeeAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_pay_fee_amt not between", value1, value2, "externalRefundChannelPayFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtIsNull() {
            addCriterion("external_refund_channel_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtIsNotNull() {
            addCriterion("external_refund_channel_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtEqualTo(Long value) {
            addCriterion("external_refund_channel_fee_amt =", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtNotEqualTo(Long value) {
            addCriterion("external_refund_channel_fee_amt <>", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtGreaterThan(Long value) {
            addCriterion("external_refund_channel_fee_amt >", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_fee_amt >=", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtLessThan(Long value) {
            addCriterion("external_refund_channel_fee_amt <", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtLessThanOrEqualTo(Long value) {
            addCriterion("external_refund_channel_fee_amt <=", value, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtIn(List<Long> values) {
            addCriterion("external_refund_channel_fee_amt in", values, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtNotIn(List<Long> values) {
            addCriterion("external_refund_channel_fee_amt not in", values, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_fee_amt between", value1, value2, "externalRefundChannelFeeAmt");
            return (Criteria) this;
        }

        public Criteria andExternalRefundChannelFeeAmtNotBetween(Long value1, Long value2) {
            addCriterion("external_refund_channel_fee_amt not between", value1, value2, "externalRefundChannelFeeAmt");
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

        public Criteria andGmtSuccessExternalRefundIsNull() {
            addCriterion("gmt_success_external_refund is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundIsNotNull() {
            addCriterion("gmt_success_external_refund is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundEqualTo(Date value) {
            addCriterion("gmt_success_external_refund =", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundNotEqualTo(Date value) {
            addCriterion("gmt_success_external_refund <>", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundGreaterThan(Date value) {
            addCriterion("gmt_success_external_refund >", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_external_refund >=", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundLessThan(Date value) {
            addCriterion("gmt_success_external_refund <", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_external_refund <=", value, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundIn(List<Date> values) {
            addCriterion("gmt_success_external_refund in", values, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundNotIn(List<Date> values) {
            addCriterion("gmt_success_external_refund not in", values, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundBetween(Date value1, Date value2) {
            addCriterion("gmt_success_external_refund between", value1, value2, "gmtSuccessExternalRefund");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessExternalRefundNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_external_refund not between", value1, value2, "gmtSuccessExternalRefund");
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

        public Criteria andRefundPayAccountMerchantNoIsNull() {
            addCriterion("refund_pay_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoIsNotNull() {
            addCriterion("refund_pay_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoEqualTo(String value) {
            addCriterion("refund_pay_account_merchant_no =", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoNotEqualTo(String value) {
            addCriterion("refund_pay_account_merchant_no <>", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoGreaterThan(String value) {
            addCriterion("refund_pay_account_merchant_no >", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_merchant_no >=", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoLessThan(String value) {
            addCriterion("refund_pay_account_merchant_no <", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_merchant_no <=", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoLike(String value) {
            addCriterion("refund_pay_account_merchant_no like", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoNotLike(String value) {
            addCriterion("refund_pay_account_merchant_no not like", value, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoIn(List<String> values) {
            addCriterion("refund_pay_account_merchant_no in", values, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoNotIn(List<String> values) {
            addCriterion("refund_pay_account_merchant_no not in", values, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_pay_account_merchant_no between", value1, value2, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_merchant_no not between", value1, value2, "refundPayAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtIsNull() {
            addCriterion("refund_pay_account_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtIsNotNull() {
            addCriterion("refund_pay_account_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtEqualTo(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt =", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtNotEqualTo(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt <>", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtGreaterThan(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt >", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt >=", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtLessThan(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt <", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("refund_pay_account_in_accounting_amt <=", value, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtIn(List<Long> values) {
            addCriterion("refund_pay_account_in_accounting_amt in", values, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtNotIn(List<Long> values) {
            addCriterion("refund_pay_account_in_accounting_amt not in", values, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("refund_pay_account_in_accounting_amt between", value1, value2, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("refund_pay_account_in_accounting_amt not between", value1, value2, "refundPayAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeIsNull() {
            addCriterion("refund_pay_account_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeIsNotNull() {
            addCriterion("refund_pay_account_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_type =", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_type <>", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeGreaterThan(String value) {
            addCriterion("refund_pay_account_out_accounting_type >", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_type >=", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeLessThan(String value) {
            addCriterion("refund_pay_account_out_accounting_type <", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_type <=", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeLike(String value) {
            addCriterion("refund_pay_account_out_accounting_type like", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeNotLike(String value) {
            addCriterion("refund_pay_account_out_accounting_type not like", value, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeIn(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_type in", values, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_type not in", values, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_type between", value1, value2, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_type not between", value1, value2, "refundPayAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1IsNull() {
            addCriterion("refund_pay_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1IsNotNull() {
            addCriterion("refund_pay_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 =", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 <>", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 >", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 >=", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1LessThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 <", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 <=", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1Like(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 like", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1NotLike(String value) {
            addCriterion("refund_pay_account_out_accounting_his1 not like", value, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1In(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his1 in", values, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his1 not in", values, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his1 between", value1, value2, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his1 not between", value1, value2, "refundPayAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2IsNull() {
            addCriterion("refund_pay_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2IsNotNull() {
            addCriterion("refund_pay_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 =", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 <>", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 >", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 >=", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2LessThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 <", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 <=", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2Like(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 like", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2NotLike(String value) {
            addCriterion("refund_pay_account_out_accounting_his2 not like", value, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2In(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his2 in", values, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his2 not in", values, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his2 between", value1, value2, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his2 not between", value1, value2, "refundPayAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3IsNull() {
            addCriterion("refund_pay_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3IsNotNull() {
            addCriterion("refund_pay_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 =", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 <>", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 >", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 >=", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3LessThan(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 <", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 <=", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3Like(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 like", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3NotLike(String value) {
            addCriterion("refund_pay_account_out_accounting_his3 not like", value, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3In(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his3 in", values, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_pay_account_out_accounting_his3 not in", values, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his3 between", value1, value2, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_out_accounting_his3 not between", value1, value2, "refundPayAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeIsNull() {
            addCriterion("refund_pay_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeIsNotNull() {
            addCriterion("refund_pay_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_type =", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_type <>", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("refund_pay_account_in_accounting_type >", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_type >=", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeLessThan(String value) {
            addCriterion("refund_pay_account_in_accounting_type <", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_type <=", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeLike(String value) {
            addCriterion("refund_pay_account_in_accounting_type like", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeNotLike(String value) {
            addCriterion("refund_pay_account_in_accounting_type not like", value, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeIn(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_type in", values, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_type not in", values, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_type between", value1, value2, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_type not between", value1, value2, "refundPayAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1IsNull() {
            addCriterion("refund_pay_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1IsNotNull() {
            addCriterion("refund_pay_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1EqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 =", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 <>", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 >", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 >=", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1LessThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 <", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 <=", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1Like(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 like", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1NotLike(String value) {
            addCriterion("refund_pay_account_in_accounting_his1 not like", value, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1In(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his1 in", values, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his1 not in", values, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his1 between", value1, value2, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his1 not between", value1, value2, "refundPayAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2IsNull() {
            addCriterion("refund_pay_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2IsNotNull() {
            addCriterion("refund_pay_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2EqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 =", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 <>", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 >", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 >=", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2LessThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 <", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 <=", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2Like(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 like", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2NotLike(String value) {
            addCriterion("refund_pay_account_in_accounting_his2 not like", value, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2In(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his2 in", values, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his2 not in", values, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his2 between", value1, value2, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his2 not between", value1, value2, "refundPayAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3IsNull() {
            addCriterion("refund_pay_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3IsNotNull() {
            addCriterion("refund_pay_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3EqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 =", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 <>", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 >", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 >=", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3LessThan(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 <", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 <=", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3Like(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 like", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3NotLike(String value) {
            addCriterion("refund_pay_account_in_accounting_his3 not like", value, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3In(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his3 in", values, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("refund_pay_account_in_accounting_his3 not in", values, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his3 between", value1, value2, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundPayAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("refund_pay_account_in_accounting_his3 not between", value1, value2, "refundPayAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossIsNull() {
            addCriterion("refund_extend_profit_loss is null");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossIsNotNull() {
            addCriterion("refund_extend_profit_loss is not null");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossEqualTo(String value) {
            addCriterion("refund_extend_profit_loss =", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossNotEqualTo(String value) {
            addCriterion("refund_extend_profit_loss <>", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossGreaterThan(String value) {
            addCriterion("refund_extend_profit_loss >", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossGreaterThanOrEqualTo(String value) {
            addCriterion("refund_extend_profit_loss >=", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossLessThan(String value) {
            addCriterion("refund_extend_profit_loss <", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossLessThanOrEqualTo(String value) {
            addCriterion("refund_extend_profit_loss <=", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossLike(String value) {
            addCriterion("refund_extend_profit_loss like", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossNotLike(String value) {
            addCriterion("refund_extend_profit_loss not like", value, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossIn(List<String> values) {
            addCriterion("refund_extend_profit_loss in", values, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossNotIn(List<String> values) {
            addCriterion("refund_extend_profit_loss not in", values, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossBetween(String value1, String value2) {
            addCriterion("refund_extend_profit_loss between", value1, value2, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andRefundExtendProfitLossNotBetween(String value1, String value2) {
            addCriterion("refund_extend_profit_loss not between", value1, value2, "refundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoIsNull() {
            addCriterion("cancel_refund_pay_acconut_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoIsNotNull() {
            addCriterion("cancel_refund_pay_acconut_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_no =", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_no <>", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoGreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_no >", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_no >=", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoLessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_no <", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_no <=", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoLike(String value) {
            addCriterion("cancel_refund_pay_acconut_no like", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoNotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_no not like", value, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_no in", values, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_no not in", values, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_no between", value1, value2, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_no not between", value1, value2, "cancelRefundPayAcconutNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoIsNull() {
            addCriterion("cancel_refund_pay_acconut_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoIsNotNull() {
            addCriterion("cancel_refund_pay_acconut_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no =", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no <>", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoGreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no >", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no >=", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoLessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no <", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no <=", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoLike(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no like", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoNotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_merchant_no not like", value, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_merchant_no in", values, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_merchant_no not in", values, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_merchant_no between", value1, value2, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutMerchantNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_merchant_no not between", value1, value2, "cancelRefundPayAcconutMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtIsNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtIsNotNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtEqualTo(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt =", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt <>", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtGreaterThan(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt >", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt >=", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtLessThan(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt <", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt <=", value, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtIn(List<Long> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt in", values, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt not in", values, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt between", value1, value2, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_amt not between", value1, value2, "cancelRefundPayAcconutOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeIsNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeIsNotNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type =", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type <>", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeGreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type >", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type >=", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeLessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type <", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type <=", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeLike(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type like", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeNotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type not like", value, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type in", values, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type not in", values, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type between", value1, value2, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_type not between", value1, value2, "cancelRefundPayAcconutOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1IsNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 =", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 <>", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 >", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 >=", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 <", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 <=", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1Like(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 like", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 not like", value, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 in", values, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 not in", values, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 between", value1, value2, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his1 not between", value1, value2, "cancelRefundPayAcconutOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2IsNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 =", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 <>", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 >", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 >=", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 <", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 <=", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2Like(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 like", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 not like", value, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 in", values, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 not in", values, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 between", value1, value2, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his2 not between", value1, value2, "cancelRefundPayAcconutOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3IsNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 =", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 <>", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 >", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 >=", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 <", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 <=", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3Like(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 like", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 not like", value, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 in", values, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 not in", values, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 between", value1, value2, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_out_accounting_his3 not between", value1, value2, "cancelRefundPayAcconutOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeIsNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeIsNotNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type =", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type <>", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeGreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type >", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type >=", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeLessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type <", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type <=", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeLike(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type like", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeNotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type not like", value, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type in", values, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type not in", values, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type between", value1, value2, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_type not between", value1, value2, "cancelRefundPayAcconutInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1IsNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 =", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 <>", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 >", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 >=", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 <", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 <=", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1Like(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 like", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 not like", value, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 in", values, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 not in", values, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 between", value1, value2, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his1 not between", value1, value2, "cancelRefundPayAcconutInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2IsNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 =", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 <>", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 >", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 >=", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 <", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 <=", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2Like(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 like", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 not like", value, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 in", values, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 not in", values, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 between", value1, value2, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his2 not between", value1, value2, "cancelRefundPayAcconutInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3IsNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3IsNotNull() {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3EqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 =", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 <>", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3GreaterThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 >", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 >=", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3LessThan(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 <", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 <=", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3Like(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 like", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3NotLike(String value) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 not like", value, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3In(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 in", values, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 not in", values, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 between", value1, value2, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayAcconutInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_acconut_in_accounting_his3 not between", value1, value2, "cancelRefundPayAcconutInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoIsNull() {
            addCriterion("cancel_refund_pay_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoIsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_no =", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_no <>", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoGreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_no >", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_no >=", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoLessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_no <", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_no <=", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_no like", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoNotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_no not like", value, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_no in", values, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_no not in", values, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_no between", value1, value2, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_no not between", value1, value2, "cancelRefundPayFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoIsNull() {
            addCriterion("cancel_refund_pay_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoIsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no =", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no <>", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no >", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no >=", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoLessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no <", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no <=", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no like", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoNotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no not like", value, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no in", values, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no not in", values, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no between", value1, value2, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_merchant_no not between", value1, value2, "cancelRefundPayFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtIsNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtIsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtEqualTo(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt =", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtNotEqualTo(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt <>", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtGreaterThan(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt >", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt >=", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtLessThan(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt <", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt <=", value, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtIn(List<Long> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt in", values, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtNotIn(List<Long> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt not in", values, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt between", value1, value2, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_amt not between", value1, value2, "cancelRefundPayFeeAccountOutAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeIsNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeIsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type =", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeNotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type <>", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeGreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type >", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type >=", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeLessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type <", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type <=", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type like", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeNotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type not like", value, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type in", values, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeNotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type not in", values, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type between", value1, value2, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_type not between", value1, value2, "cancelRefundPayFeeAccountOutAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1IsNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1IsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1EqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 =", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 <>", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1GreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 >", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 >=", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1LessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 <", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 <=", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1Like(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 like", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1NotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 not like", value, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1In(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 in", values, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 not in", values, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his1 not between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2IsNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2IsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2EqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 =", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 <>", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2GreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 >", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 >=", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2LessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 <", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 <=", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2Like(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 like", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2NotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 not like", value, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2In(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 in", values, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 not in", values, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his2 not between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3IsNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3IsNotNull() {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3EqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 =", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3NotEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 <>", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3GreaterThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 >", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 >=", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3LessThan(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 <", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 <=", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3Like(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 like", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3NotLike(String value) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 not like", value, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3In(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 in", values, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3NotIn(List<String> values) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 not in", values, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3Between(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundPayFeeAccountOutAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_pay_fee_account_out_accounting_his3 not between", value1, value2, "cancelRefundPayFeeAccountOutAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoIsNull() {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoIsNotNull() {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoEqualTo(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no =", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no <>", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoGreaterThan(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no >", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no >=", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoLessThan(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no <", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no <=", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoLike(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no like", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoNotLike(String value) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no not like", value, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoIn(List<String> values) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no in", values, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no not in", values, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no between", value1, value2, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossLedgerNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_profit_loss_ledger_no not between", value1, value2, "cancelRefundReceiveProfitLossLedgerNo");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossIsNull() {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss is null");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossIsNotNull() {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss is not null");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossEqualTo(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss =", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossNotEqualTo(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss <>", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossGreaterThan(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss >", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss >=", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossLessThan(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss <", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossLessThanOrEqualTo(Date value) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss <=", value, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossIn(List<Date> values) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss in", values, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossNotIn(List<Date> values) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss not in", values, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossBetween(Date value1, Date value2) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss between", value1, value2, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andGmtEffectCancelRefundReceiveGainLossNotBetween(Date value1, Date value2) {
            addCriterion("gmt_effect_cancel_refund_receive_gain_loss not between", value1, value2, "gmtEffectCancelRefundReceiveGainLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtIsNull() {
            addCriterion("cancel_refund_receive_profit_loss_amt is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtIsNotNull() {
            addCriterion("cancel_refund_receive_profit_loss_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtEqualTo(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt =", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtNotEqualTo(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt <>", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtGreaterThan(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt >", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt >=", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtLessThan(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt <", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtLessThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_profit_loss_amt <=", value, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtIn(List<Long> values) {
            addCriterion("cancel_refund_receive_profit_loss_amt in", values, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtNotIn(List<Long> values) {
            addCriterion("cancel_refund_receive_profit_loss_amt not in", values, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_profit_loss_amt between", value1, value2, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveProfitLossAmtNotBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_profit_loss_amt not between", value1, value2, "cancelRefundReceiveProfitLossAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoIsNull() {
            addCriterion("cancel_refund_receive_account_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoIsNotNull() {
            addCriterion("cancel_refund_receive_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_no =", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_no <>", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoGreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_no >", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_no >=", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoLessThan(String value) {
            addCriterion("cancel_refund_receive_account_no <", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_no <=", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoLike(String value) {
            addCriterion("cancel_refund_receive_account_no like", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoNotLike(String value) {
            addCriterion("cancel_refund_receive_account_no not like", value, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_no in", values, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_no not in", values, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_no between", value1, value2, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_no not between", value1, value2, "cancelRefundReceiveAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoIsNull() {
            addCriterion("cancel_refund_receive_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoIsNotNull() {
            addCriterion("cancel_refund_receive_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no =", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no <>", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoGreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no >", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no >=", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoLessThan(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no <", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no <=", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoLike(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no like", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoNotLike(String value) {
            addCriterion("cancel_refund_receive_account_merchant_no not like", value, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_merchant_no in", values, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_merchant_no not in", values, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_merchant_no between", value1, value2, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_merchant_no not between", value1, value2, "cancelRefundReceiveAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtIsNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtIsNotNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtEqualTo(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt =", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtNotEqualTo(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt <>", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtGreaterThan(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt >", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt >=", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtLessThan(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt <", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt <=", value, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtIn(List<Long> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt in", values, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtNotIn(List<Long> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt not in", values, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt between", value1, value2, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_amt not between", value1, value2, "cancelRefundReceiveAccountInAccountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeIsNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeIsNotNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type =", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type <>", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeGreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type >", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type >=", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeLessThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type <", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type <=", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeLike(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type like", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeNotLike(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_type not like", value, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_type in", values, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_type not in", values, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_type between", value1, value2, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingTypeNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_type not between", value1, value2, "cancelRefundReceiveAccountInAccountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1IsNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1IsNotNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1EqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 =", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 <>", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1GreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 >", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 >=", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1LessThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 <", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 <=", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1Like(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 like", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1NotLike(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 not like", value, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1In(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 in", values, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 not in", values, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 between", value1, value2, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis1NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his1 not between", value1, value2, "cancelRefundReceiveAccountInAccountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2IsNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2IsNotNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2EqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 =", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 <>", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2GreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 >", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 >=", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2LessThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 <", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 <=", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2Like(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 like", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2NotLike(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 not like", value, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2In(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 in", values, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 not in", values, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 between", value1, value2, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis2NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his2 not between", value1, value2, "cancelRefundReceiveAccountInAccountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3IsNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3IsNotNull() {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3EqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 =", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 <>", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3GreaterThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 >", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 >=", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3LessThan(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 <", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 <=", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3Like(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 like", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3NotLike(String value) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 not like", value, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3In(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 in", values, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 not in", values, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 between", value1, value2, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveAccountInAccountingHis3NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_account_in_accounting_his3 not between", value1, value2, "cancelRefundReceiveAccountInAccountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoIsNull() {
            addCriterion("cancel_refund_receive_fee_account_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoIsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_no =", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_no <>", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoGreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_no >", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_no >=", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoLessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_no <", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_no <=", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_no like", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoNotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_no not like", value, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_no in", values, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_no not in", values, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_no between", value1, value2, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_no not between", value1, value2, "cancelRefundReceiveFeeAccountNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoIsNull() {
            addCriterion("cancel_refund_receive_fee_account_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoIsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no =", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no <>", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoGreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no >", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no >=", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoLessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no <", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no <=", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no like", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoNotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no not like", value, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no in", values, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no not in", values, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no between", value1, value2, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountMerchantNoNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_merchant_no not between", value1, value2, "cancelRefundReceiveFeeAccountMerchantNo");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtIsNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtIsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtEqualTo(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt =", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtNotEqualTo(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt <>", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtGreaterThan(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt >", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt >=", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtLessThan(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt <", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtLessThanOrEqualTo(Long value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt <=", value, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtIn(List<Long> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt in", values, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtNotIn(List<Long> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt not in", values, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingAmtNotBetween(Long value1, Long value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_amt not between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingAmt");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeIsNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeIsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type =", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeNotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type <>", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeGreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type >", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type >=", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeLessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type <", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type <=", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type like", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeNotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type not like", value, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type in", values, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeNotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type not in", values, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingTypeNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_type not between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingType");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1IsNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1IsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1EqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 =", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 <>", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1GreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 >", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 >=", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1LessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 <", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 <=", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1Like(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 like", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1NotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 not like", value, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1In(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 in", values, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 not in", values, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis1NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his1 not between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis1");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2IsNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2IsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2EqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 =", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 <>", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2GreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 >", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 >=", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2LessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 <", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 <=", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2Like(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 like", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2NotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 not like", value, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2In(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 in", values, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 not in", values, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis2NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his2 not between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis2");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3IsNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3IsNotNull() {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3EqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 =", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3NotEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 <>", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3GreaterThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 >", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3GreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 >=", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3LessThan(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 <", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3LessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 <=", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3Like(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 like", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3NotLike(String value) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 not like", value, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3In(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 in", values, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3NotIn(List<String> values) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 not in", values, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3Between(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundReceiveFeeAccountOutAcountingHis3NotBetween(String value1, String value2) {
            addCriterion("cancel_refund_receive_fee_account_out_acounting_his3 not between", value1, value2, "cancelRefundReceiveFeeAccountOutAcountingHis3");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossIsNull() {
            addCriterion("cancel_refund_extend_profit_loss is null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossIsNotNull() {
            addCriterion("cancel_refund_extend_profit_loss is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossEqualTo(String value) {
            addCriterion("cancel_refund_extend_profit_loss =", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossNotEqualTo(String value) {
            addCriterion("cancel_refund_extend_profit_loss <>", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossGreaterThan(String value) {
            addCriterion("cancel_refund_extend_profit_loss >", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_refund_extend_profit_loss >=", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossLessThan(String value) {
            addCriterion("cancel_refund_extend_profit_loss <", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossLessThanOrEqualTo(String value) {
            addCriterion("cancel_refund_extend_profit_loss <=", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossLike(String value) {
            addCriterion("cancel_refund_extend_profit_loss like", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossNotLike(String value) {
            addCriterion("cancel_refund_extend_profit_loss not like", value, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossIn(List<String> values) {
            addCriterion("cancel_refund_extend_profit_loss in", values, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossNotIn(List<String> values) {
            addCriterion("cancel_refund_extend_profit_loss not in", values, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossBetween(String value1, String value2) {
            addCriterion("cancel_refund_extend_profit_loss between", value1, value2, "cancelRefundExtendProfitLoss");
            return (Criteria) this;
        }

        public Criteria andCancelRefundExtendProfitLossNotBetween(String value1, String value2) {
            addCriterion("cancel_refund_extend_profit_loss not between", value1, value2, "cancelRefundExtendProfitLoss");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_single_payment_refund
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