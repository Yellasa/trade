package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeReqLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeReqLogExample() {
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

        public Criteria andReqNoIsNull() {
            addCriterion("req_no is null");
            return (Criteria) this;
        }

        public Criteria andReqNoIsNotNull() {
            addCriterion("req_no is not null");
            return (Criteria) this;
        }

        public Criteria andReqNoEqualTo(String value) {
            addCriterion("req_no =", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoNotEqualTo(String value) {
            addCriterion("req_no <>", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoGreaterThan(String value) {
            addCriterion("req_no >", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoGreaterThanOrEqualTo(String value) {
            addCriterion("req_no >=", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoLessThan(String value) {
            addCriterion("req_no <", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoLessThanOrEqualTo(String value) {
            addCriterion("req_no <=", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoLike(String value) {
            addCriterion("req_no like", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoNotLike(String value) {
            addCriterion("req_no not like", value, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoIn(List<String> values) {
            addCriterion("req_no in", values, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoNotIn(List<String> values) {
            addCriterion("req_no not in", values, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoBetween(String value1, String value2) {
            addCriterion("req_no between", value1, value2, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqNoNotBetween(String value1, String value2) {
            addCriterion("req_no not between", value1, value2, "reqNo");
            return (Criteria) this;
        }

        public Criteria andReqIpIsNull() {
            addCriterion("req_ip is null");
            return (Criteria) this;
        }

        public Criteria andReqIpIsNotNull() {
            addCriterion("req_ip is not null");
            return (Criteria) this;
        }

        public Criteria andReqIpEqualTo(String value) {
            addCriterion("req_ip =", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotEqualTo(String value) {
            addCriterion("req_ip <>", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpGreaterThan(String value) {
            addCriterion("req_ip >", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpGreaterThanOrEqualTo(String value) {
            addCriterion("req_ip >=", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLessThan(String value) {
            addCriterion("req_ip <", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLessThanOrEqualTo(String value) {
            addCriterion("req_ip <=", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpLike(String value) {
            addCriterion("req_ip like", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotLike(String value) {
            addCriterion("req_ip not like", value, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpIn(List<String> values) {
            addCriterion("req_ip in", values, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotIn(List<String> values) {
            addCriterion("req_ip not in", values, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpBetween(String value1, String value2) {
            addCriterion("req_ip between", value1, value2, "reqIp");
            return (Criteria) this;
        }

        public Criteria andReqIpNotBetween(String value1, String value2) {
            addCriterion("req_ip not between", value1, value2, "reqIp");
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

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNull() {
            addCriterion("service_code is null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNotNull() {
            addCriterion("service_code is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeEqualTo(String value) {
            addCriterion("service_code =", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotEqualTo(String value) {
            addCriterion("service_code <>", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThan(String value) {
            addCriterion("service_code >", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("service_code >=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThan(String value) {
            addCriterion("service_code <", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("service_code <=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLike(String value) {
            addCriterion("service_code like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotLike(String value) {
            addCriterion("service_code not like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIn(List<String> values) {
            addCriterion("service_code in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotIn(List<String> values) {
            addCriterion("service_code not in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeBetween(String value1, String value2) {
            addCriterion("service_code between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotBetween(String value1, String value2) {
            addCriterion("service_code not between", value1, value2, "serviceCode");
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

        public Criteria andReqDateTimeIsNull() {
            addCriterion("req_date_time is null");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeIsNotNull() {
            addCriterion("req_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeEqualTo(Date value) {
            addCriterion("req_date_time =", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeNotEqualTo(Date value) {
            addCriterion("req_date_time <>", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeGreaterThan(Date value) {
            addCriterion("req_date_time >", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("req_date_time >=", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeLessThan(Date value) {
            addCriterion("req_date_time <", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("req_date_time <=", value, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeIn(List<Date> values) {
            addCriterion("req_date_time in", values, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeNotIn(List<Date> values) {
            addCriterion("req_date_time not in", values, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeBetween(Date value1, Date value2) {
            addCriterion("req_date_time between", value1, value2, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andReqDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("req_date_time not between", value1, value2, "reqDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeIsNull() {
            addCriterion("res_date_time is null");
            return (Criteria) this;
        }

        public Criteria andResDateTimeIsNotNull() {
            addCriterion("res_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andResDateTimeEqualTo(Date value) {
            addCriterion("res_date_time =", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotEqualTo(Date value) {
            addCriterion("res_date_time <>", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeGreaterThan(Date value) {
            addCriterion("res_date_time >", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("res_date_time >=", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeLessThan(Date value) {
            addCriterion("res_date_time <", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("res_date_time <=", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeIn(List<Date> values) {
            addCriterion("res_date_time in", values, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotIn(List<Date> values) {
            addCriterion("res_date_time not in", values, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeBetween(Date value1, Date value2) {
            addCriterion("res_date_time between", value1, value2, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("res_date_time not between", value1, value2, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeIsNull() {
            addCriterion("req_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeIsNotNull() {
            addCriterion("req_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeEqualTo(Long value) {
            addCriterion("req_cost_time =", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotEqualTo(Long value) {
            addCriterion("req_cost_time <>", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeGreaterThan(Long value) {
            addCriterion("req_cost_time >", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("req_cost_time >=", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeLessThan(Long value) {
            addCriterion("req_cost_time <", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeLessThanOrEqualTo(Long value) {
            addCriterion("req_cost_time <=", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeIn(List<Long> values) {
            addCriterion("req_cost_time in", values, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotIn(List<Long> values) {
            addCriterion("req_cost_time not in", values, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeBetween(Long value1, Long value2) {
            addCriterion("req_cost_time between", value1, value2, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotBetween(Long value1, Long value2) {
            addCriterion("req_cost_time not between", value1, value2, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqStatusIsNull() {
            addCriterion("req_status is null");
            return (Criteria) this;
        }

        public Criteria andReqStatusIsNotNull() {
            addCriterion("req_status is not null");
            return (Criteria) this;
        }

        public Criteria andReqStatusEqualTo(String value) {
            addCriterion("req_status =", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotEqualTo(String value) {
            addCriterion("req_status <>", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusGreaterThan(String value) {
            addCriterion("req_status >", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusGreaterThanOrEqualTo(String value) {
            addCriterion("req_status >=", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusLessThan(String value) {
            addCriterion("req_status <", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusLessThanOrEqualTo(String value) {
            addCriterion("req_status <=", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusLike(String value) {
            addCriterion("req_status like", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotLike(String value) {
            addCriterion("req_status not like", value, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusIn(List<String> values) {
            addCriterion("req_status in", values, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotIn(List<String> values) {
            addCriterion("req_status not in", values, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusBetween(String value1, String value2) {
            addCriterion("req_status between", value1, value2, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andReqStatusNotBetween(String value1, String value2) {
            addCriterion("req_status not between", value1, value2, "reqStatus");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNull() {
            addCriterion("result_code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("result_code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("result_code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("result_code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("result_code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("result_code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("result_code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("result_code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("result_code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("result_code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("result_code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("result_code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("result_code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("result_code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("err_code is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("err_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("err_code =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("err_code <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("err_code >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("err_code >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("err_code <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("err_code <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("err_code like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("err_code not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("err_code in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("err_code not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("err_code between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("err_code not between", value1, value2, "errCode");
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

        public Criteria andReqExtendField1IsNull() {
            addCriterion("req_extend_field_1 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1IsNotNull() {
            addCriterion("req_extend_field_1 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1EqualTo(String value) {
            addCriterion("req_extend_field_1 =", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1NotEqualTo(String value) {
            addCriterion("req_extend_field_1 <>", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1GreaterThan(String value) {
            addCriterion("req_extend_field_1 >", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_1 >=", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1LessThan(String value) {
            addCriterion("req_extend_field_1 <", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_1 <=", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1Like(String value) {
            addCriterion("req_extend_field_1 like", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1NotLike(String value) {
            addCriterion("req_extend_field_1 not like", value, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1In(List<String> values) {
            addCriterion("req_extend_field_1 in", values, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1NotIn(List<String> values) {
            addCriterion("req_extend_field_1 not in", values, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1Between(String value1, String value2) {
            addCriterion("req_extend_field_1 between", value1, value2, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField1NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_1 not between", value1, value2, "reqExtendField1");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2IsNull() {
            addCriterion("req_extend_field_2 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2IsNotNull() {
            addCriterion("req_extend_field_2 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2EqualTo(String value) {
            addCriterion("req_extend_field_2 =", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2NotEqualTo(String value) {
            addCriterion("req_extend_field_2 <>", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2GreaterThan(String value) {
            addCriterion("req_extend_field_2 >", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_2 >=", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2LessThan(String value) {
            addCriterion("req_extend_field_2 <", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_2 <=", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2Like(String value) {
            addCriterion("req_extend_field_2 like", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2NotLike(String value) {
            addCriterion("req_extend_field_2 not like", value, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2In(List<String> values) {
            addCriterion("req_extend_field_2 in", values, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2NotIn(List<String> values) {
            addCriterion("req_extend_field_2 not in", values, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2Between(String value1, String value2) {
            addCriterion("req_extend_field_2 between", value1, value2, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField2NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_2 not between", value1, value2, "reqExtendField2");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3IsNull() {
            addCriterion("req_extend_field_3 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3IsNotNull() {
            addCriterion("req_extend_field_3 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3EqualTo(String value) {
            addCriterion("req_extend_field_3 =", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3NotEqualTo(String value) {
            addCriterion("req_extend_field_3 <>", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3GreaterThan(String value) {
            addCriterion("req_extend_field_3 >", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_3 >=", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3LessThan(String value) {
            addCriterion("req_extend_field_3 <", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_3 <=", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3Like(String value) {
            addCriterion("req_extend_field_3 like", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3NotLike(String value) {
            addCriterion("req_extend_field_3 not like", value, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3In(List<String> values) {
            addCriterion("req_extend_field_3 in", values, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3NotIn(List<String> values) {
            addCriterion("req_extend_field_3 not in", values, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3Between(String value1, String value2) {
            addCriterion("req_extend_field_3 between", value1, value2, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField3NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_3 not between", value1, value2, "reqExtendField3");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4IsNull() {
            addCriterion("req_extend_field_4 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4IsNotNull() {
            addCriterion("req_extend_field_4 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4EqualTo(String value) {
            addCriterion("req_extend_field_4 =", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4NotEqualTo(String value) {
            addCriterion("req_extend_field_4 <>", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4GreaterThan(String value) {
            addCriterion("req_extend_field_4 >", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_4 >=", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4LessThan(String value) {
            addCriterion("req_extend_field_4 <", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_4 <=", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4Like(String value) {
            addCriterion("req_extend_field_4 like", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4NotLike(String value) {
            addCriterion("req_extend_field_4 not like", value, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4In(List<String> values) {
            addCriterion("req_extend_field_4 in", values, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4NotIn(List<String> values) {
            addCriterion("req_extend_field_4 not in", values, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4Between(String value1, String value2) {
            addCriterion("req_extend_field_4 between", value1, value2, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField4NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_4 not between", value1, value2, "reqExtendField4");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5IsNull() {
            addCriterion("req_extend_field_5 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5IsNotNull() {
            addCriterion("req_extend_field_5 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5EqualTo(String value) {
            addCriterion("req_extend_field_5 =", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5NotEqualTo(String value) {
            addCriterion("req_extend_field_5 <>", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5GreaterThan(String value) {
            addCriterion("req_extend_field_5 >", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_5 >=", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5LessThan(String value) {
            addCriterion("req_extend_field_5 <", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_5 <=", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5Like(String value) {
            addCriterion("req_extend_field_5 like", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5NotLike(String value) {
            addCriterion("req_extend_field_5 not like", value, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5In(List<String> values) {
            addCriterion("req_extend_field_5 in", values, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5NotIn(List<String> values) {
            addCriterion("req_extend_field_5 not in", values, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5Between(String value1, String value2) {
            addCriterion("req_extend_field_5 between", value1, value2, "reqExtendField5");
            return (Criteria) this;
        }

        public Criteria andReqExtendField5NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_5 not between", value1, value2, "reqExtendField5");
            return (Criteria) this;
        }
    }

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