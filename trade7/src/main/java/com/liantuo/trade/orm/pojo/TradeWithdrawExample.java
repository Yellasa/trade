package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeWithdrawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeWithdrawExample() {
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

        public Criteria andGmtLatestModifiedIsNull() {
            addCriterion("gmt_latest_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedIsNotNull() {
            addCriterion("gmt_latest_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedEqualTo(Date value) {
            addCriterion("gmt_latest_modified =", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedNotEqualTo(Date value) {
            addCriterion("gmt_latest_modified <>", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedGreaterThan(Date value) {
            addCriterion("gmt_latest_modified >", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_latest_modified >=", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedLessThan(Date value) {
            addCriterion("gmt_latest_modified <", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_latest_modified <=", value, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedIn(List<Date> values) {
            addCriterion("gmt_latest_modified in", values, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedNotIn(List<Date> values) {
            addCriterion("gmt_latest_modified not in", values, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_latest_modified between", value1, value2, "gmtLatestModified");
            return (Criteria) this;
        }

        public Criteria andGmtLatestModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_latest_modified not between", value1, value2, "gmtLatestModified");
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

        public Criteria andWithdrawAccountNoIsNull() {
            addCriterion("withdraw_account_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoIsNotNull() {
            addCriterion("withdraw_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoEqualTo(String value) {
            addCriterion("withdraw_account_no =", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoNotEqualTo(String value) {
            addCriterion("withdraw_account_no <>", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoGreaterThan(String value) {
            addCriterion("withdraw_account_no >", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_account_no >=", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoLessThan(String value) {
            addCriterion("withdraw_account_no <", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_account_no <=", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoLike(String value) {
            addCriterion("withdraw_account_no like", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoNotLike(String value) {
            addCriterion("withdraw_account_no not like", value, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoIn(List<String> values) {
            addCriterion("withdraw_account_no in", values, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoNotIn(List<String> values) {
            addCriterion("withdraw_account_no not in", values, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoBetween(String value1, String value2) {
            addCriterion("withdraw_account_no between", value1, value2, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_account_no not between", value1, value2, "withdrawAccountNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoIsNull() {
            addCriterion("withdraw_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoIsNotNull() {
            addCriterion("withdraw_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoEqualTo(String value) {
            addCriterion("withdraw_merchant_no =", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoNotEqualTo(String value) {
            addCriterion("withdraw_merchant_no <>", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoGreaterThan(String value) {
            addCriterion("withdraw_merchant_no >", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_merchant_no >=", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoLessThan(String value) {
            addCriterion("withdraw_merchant_no <", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_merchant_no <=", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoLike(String value) {
            addCriterion("withdraw_merchant_no like", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoNotLike(String value) {
            addCriterion("withdraw_merchant_no not like", value, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoIn(List<String> values) {
            addCriterion("withdraw_merchant_no in", values, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoNotIn(List<String> values) {
            addCriterion("withdraw_merchant_no not in", values, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoBetween(String value1, String value2) {
            addCriterion("withdraw_merchant_no between", value1, value2, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawMerchantNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_merchant_no not between", value1, value2, "withdrawMerchantNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNull() {
            addCriterion("withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNotNull() {
            addCriterion("withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountEqualTo(Long value) {
            addCriterion("withdraw_amount =", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotEqualTo(Long value) {
            addCriterion("withdraw_amount <>", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThan(Long value) {
            addCriterion("withdraw_amount >", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_amount >=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThan(Long value) {
            addCriterion("withdraw_amount <", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_amount <=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIn(List<Long> values) {
            addCriterion("withdraw_amount in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotIn(List<Long> values) {
            addCriterion("withdraw_amount not in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountBetween(Long value1, Long value2) {
            addCriterion("withdraw_amount between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_amount not between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessIsNull() {
            addCriterion("gmt_deduct_success is null");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessIsNotNull() {
            addCriterion("gmt_deduct_success is not null");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessEqualTo(Date value) {
            addCriterion("gmt_deduct_success =", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessNotEqualTo(Date value) {
            addCriterion("gmt_deduct_success <>", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessGreaterThan(Date value) {
            addCriterion("gmt_deduct_success >", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_deduct_success >=", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessLessThan(Date value) {
            addCriterion("gmt_deduct_success <", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessLessThanOrEqualTo(Date value) {
            addCriterion("gmt_deduct_success <=", value, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessIn(List<Date> values) {
            addCriterion("gmt_deduct_success in", values, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessNotIn(List<Date> values) {
            addCriterion("gmt_deduct_success not in", values, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessBetween(Date value1, Date value2) {
            addCriterion("gmt_deduct_success between", value1, value2, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtDeductSuccessNotBetween(Date value1, Date value2) {
            addCriterion("gmt_deduct_success not between", value1, value2, "gmtDeductSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailIsNull() {
            addCriterion("gmt_created_fail is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailIsNotNull() {
            addCriterion("gmt_created_fail is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailEqualTo(Date value) {
            addCriterion("gmt_created_fail =", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailNotEqualTo(Date value) {
            addCriterion("gmt_created_fail <>", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailGreaterThan(Date value) {
            addCriterion("gmt_created_fail >", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created_fail >=", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailLessThan(Date value) {
            addCriterion("gmt_created_fail <", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created_fail <=", value, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailIn(List<Date> values) {
            addCriterion("gmt_created_fail in", values, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailNotIn(List<Date> values) {
            addCriterion("gmt_created_fail not in", values, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailBetween(Date value1, Date value2) {
            addCriterion("gmt_created_fail between", value1, value2, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedFailNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created_fail not between", value1, value2, "gmtCreatedFail");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayIsNull() {
            addCriterion("gmt_first_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayIsNotNull() {
            addCriterion("gmt_first_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayEqualTo(Date value) {
            addCriterion("gmt_first_pay =", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayNotEqualTo(Date value) {
            addCriterion("gmt_first_pay <>", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayGreaterThan(Date value) {
            addCriterion("gmt_first_pay >", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_first_pay >=", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayLessThan(Date value) {
            addCriterion("gmt_first_pay <", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_first_pay <=", value, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayIn(List<Date> values) {
            addCriterion("gmt_first_pay in", values, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayNotIn(List<Date> values) {
            addCriterion("gmt_first_pay not in", values, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayBetween(Date value1, Date value2) {
            addCriterion("gmt_first_pay between", value1, value2, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtFirstPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_first_pay not between", value1, value2, "gmtFirstPay");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessIsNull() {
            addCriterion("gmt_pay_success is null");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessIsNotNull() {
            addCriterion("gmt_pay_success is not null");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessEqualTo(Date value) {
            addCriterion("gmt_pay_success =", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessNotEqualTo(Date value) {
            addCriterion("gmt_pay_success <>", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessGreaterThan(Date value) {
            addCriterion("gmt_pay_success >", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_pay_success >=", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessLessThan(Date value) {
            addCriterion("gmt_pay_success <", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessLessThanOrEqualTo(Date value) {
            addCriterion("gmt_pay_success <=", value, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessIn(List<Date> values) {
            addCriterion("gmt_pay_success in", values, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessNotIn(List<Date> values) {
            addCriterion("gmt_pay_success not in", values, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessBetween(Date value1, Date value2) {
            addCriterion("gmt_pay_success between", value1, value2, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtPaySuccessNotBetween(Date value1, Date value2) {
            addCriterion("gmt_pay_success not between", value1, value2, "gmtPaySuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessIsNull() {
            addCriterion("gmt_refund_success is null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessIsNotNull() {
            addCriterion("gmt_refund_success is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessEqualTo(Date value) {
            addCriterion("gmt_refund_success =", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessNotEqualTo(Date value) {
            addCriterion("gmt_refund_success <>", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessGreaterThan(Date value) {
            addCriterion("gmt_refund_success >", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_success >=", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessLessThan(Date value) {
            addCriterion("gmt_refund_success <", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessLessThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_success <=", value, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessIn(List<Date> values) {
            addCriterion("gmt_refund_success in", values, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessNotIn(List<Date> values) {
            addCriterion("gmt_refund_success not in", values, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_success between", value1, value2, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtRefundSuccessNotBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_success not between", value1, value2, "gmtRefundSuccess");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailIsNull() {
            addCriterion("gmt_last_pay_fail is null");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailIsNotNull() {
            addCriterion("gmt_last_pay_fail is not null");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailEqualTo(Date value) {
            addCriterion("gmt_last_pay_fail =", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailNotEqualTo(Date value) {
            addCriterion("gmt_last_pay_fail <>", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailGreaterThan(Date value) {
            addCriterion("gmt_last_pay_fail >", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_last_pay_fail >=", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailLessThan(Date value) {
            addCriterion("gmt_last_pay_fail <", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailLessThanOrEqualTo(Date value) {
            addCriterion("gmt_last_pay_fail <=", value, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailIn(List<Date> values) {
            addCriterion("gmt_last_pay_fail in", values, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailNotIn(List<Date> values) {
            addCriterion("gmt_last_pay_fail not in", values, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailBetween(Date value1, Date value2) {
            addCriterion("gmt_last_pay_fail between", value1, value2, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtLastPayFailNotBetween(Date value1, Date value2) {
            addCriterion("gmt_last_pay_fail not between", value1, value2, "gmtLastPayFail");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndIsNull() {
            addCriterion("gmt_exception_end is null");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndIsNotNull() {
            addCriterion("gmt_exception_end is not null");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndEqualTo(Date value) {
            addCriterion("gmt_exception_end =", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndNotEqualTo(Date value) {
            addCriterion("gmt_exception_end <>", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndGreaterThan(Date value) {
            addCriterion("gmt_exception_end >", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_exception_end >=", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndLessThan(Date value) {
            addCriterion("gmt_exception_end <", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndLessThanOrEqualTo(Date value) {
            addCriterion("gmt_exception_end <=", value, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndIn(List<Date> values) {
            addCriterion("gmt_exception_end in", values, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndNotIn(List<Date> values) {
            addCriterion("gmt_exception_end not in", values, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndBetween(Date value1, Date value2) {
            addCriterion("gmt_exception_end between", value1, value2, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andGmtExceptionEndNotBetween(Date value1, Date value2) {
            addCriterion("gmt_exception_end not between", value1, value2, "gmtExceptionEnd");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelIsNull() {
            addCriterion("pay_clear_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelIsNotNull() {
            addCriterion("pay_clear_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelEqualTo(String value) {
            addCriterion("pay_clear_channel =", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelNotEqualTo(String value) {
            addCriterion("pay_clear_channel <>", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelGreaterThan(String value) {
            addCriterion("pay_clear_channel >", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelGreaterThanOrEqualTo(String value) {
            addCriterion("pay_clear_channel >=", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelLessThan(String value) {
            addCriterion("pay_clear_channel <", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelLessThanOrEqualTo(String value) {
            addCriterion("pay_clear_channel <=", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelLike(String value) {
            addCriterion("pay_clear_channel like", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelNotLike(String value) {
            addCriterion("pay_clear_channel not like", value, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelIn(List<String> values) {
            addCriterion("pay_clear_channel in", values, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelNotIn(List<String> values) {
            addCriterion("pay_clear_channel not in", values, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelBetween(String value1, String value2) {
            addCriterion("pay_clear_channel between", value1, value2, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayClearChannelNotBetween(String value1, String value2) {
            addCriterion("pay_clear_channel not between", value1, value2, "payClearChannel");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdIsNull() {
            addCriterion("pay_transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdIsNotNull() {
            addCriterion("pay_transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdEqualTo(String value) {
            addCriterion("pay_transaction_id =", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdNotEqualTo(String value) {
            addCriterion("pay_transaction_id <>", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdGreaterThan(String value) {
            addCriterion("pay_transaction_id >", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_transaction_id >=", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdLessThan(String value) {
            addCriterion("pay_transaction_id <", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("pay_transaction_id <=", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdLike(String value) {
            addCriterion("pay_transaction_id like", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdNotLike(String value) {
            addCriterion("pay_transaction_id not like", value, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdIn(List<String> values) {
            addCriterion("pay_transaction_id in", values, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdNotIn(List<String> values) {
            addCriterion("pay_transaction_id not in", values, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdBetween(String value1, String value2) {
            addCriterion("pay_transaction_id between", value1, value2, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andPayTransactionIdNotBetween(String value1, String value2) {
            addCriterion("pay_transaction_id not between", value1, value2, "payTransactionId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoIsNull() {
            addCriterion("withdraw_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoIsNotNull() {
            addCriterion("withdraw_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoEqualTo(String value) {
            addCriterion("withdraw_batch_no =", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoNotEqualTo(String value) {
            addCriterion("withdraw_batch_no <>", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoGreaterThan(String value) {
            addCriterion("withdraw_batch_no >", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_batch_no >=", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoLessThan(String value) {
            addCriterion("withdraw_batch_no <", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_batch_no <=", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoLike(String value) {
            addCriterion("withdraw_batch_no like", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoNotLike(String value) {
            addCriterion("withdraw_batch_no not like", value, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoIn(List<String> values) {
            addCriterion("withdraw_batch_no in", values, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoNotIn(List<String> values) {
            addCriterion("withdraw_batch_no not in", values, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoBetween(String value1, String value2) {
            addCriterion("withdraw_batch_no between", value1, value2, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBatchNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_batch_no not between", value1, value2, "withdrawBatchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberIsNull() {
            addCriterion("withdraw_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberIsNotNull() {
            addCriterion("withdraw_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberEqualTo(String value) {
            addCriterion("withdraw_serial_number =", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberNotEqualTo(String value) {
            addCriterion("withdraw_serial_number <>", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberGreaterThan(String value) {
            addCriterion("withdraw_serial_number >", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_serial_number >=", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberLessThan(String value) {
            addCriterion("withdraw_serial_number <", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("withdraw_serial_number <=", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberLike(String value) {
            addCriterion("withdraw_serial_number like", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberNotLike(String value) {
            addCriterion("withdraw_serial_number not like", value, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberIn(List<String> values) {
            addCriterion("withdraw_serial_number in", values, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberNotIn(List<String> values) {
            addCriterion("withdraw_serial_number not in", values, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberBetween(String value1, String value2) {
            addCriterion("withdraw_serial_number between", value1, value2, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawSerialNumberNotBetween(String value1, String value2) {
            addCriterion("withdraw_serial_number not between", value1, value2, "withdrawSerialNumber");
            return (Criteria) this;
        }

        public Criteria andPayerAccountIsNull() {
            addCriterion("payer_account is null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountIsNotNull() {
            addCriterion("payer_account is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAccountEqualTo(String value) {
            addCriterion("payer_account =", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNotEqualTo(String value) {
            addCriterion("payer_account <>", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountGreaterThan(String value) {
            addCriterion("payer_account >", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("payer_account >=", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountLessThan(String value) {
            addCriterion("payer_account <", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountLessThanOrEqualTo(String value) {
            addCriterion("payer_account <=", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountLike(String value) {
            addCriterion("payer_account like", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNotLike(String value) {
            addCriterion("payer_account not like", value, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountIn(List<String> values) {
            addCriterion("payer_account in", values, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNotIn(List<String> values) {
            addCriterion("payer_account not in", values, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountBetween(String value1, String value2) {
            addCriterion("payer_account between", value1, value2, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerAccountNotBetween(String value1, String value2) {
            addCriterion("payer_account not between", value1, value2, "payerAccount");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNull() {
            addCriterion("payer_name is null");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNotNull() {
            addCriterion("payer_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayerNameEqualTo(String value) {
            addCriterion("payer_name =", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotEqualTo(String value) {
            addCriterion("payer_name <>", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThan(String value) {
            addCriterion("payer_name >", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("payer_name >=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThan(String value) {
            addCriterion("payer_name <", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThanOrEqualTo(String value) {
            addCriterion("payer_name <=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLike(String value) {
            addCriterion("payer_name like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotLike(String value) {
            addCriterion("payer_name not like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameIn(List<String> values) {
            addCriterion("payer_name in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotIn(List<String> values) {
            addCriterion("payer_name not in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameBetween(String value1, String value2) {
            addCriterion("payer_name between", value1, value2, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotBetween(String value1, String value2) {
            addCriterion("payer_name not between", value1, value2, "payerName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountIsNull() {
            addCriterion("withdraw_third_account is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountIsNotNull() {
            addCriterion("withdraw_third_account is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountEqualTo(String value) {
            addCriterion("withdraw_third_account =", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNotEqualTo(String value) {
            addCriterion("withdraw_third_account <>", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountGreaterThan(String value) {
            addCriterion("withdraw_third_account >", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account >=", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountLessThan(String value) {
            addCriterion("withdraw_third_account <", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountLessThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account <=", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountLike(String value) {
            addCriterion("withdraw_third_account like", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNotLike(String value) {
            addCriterion("withdraw_third_account not like", value, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountIn(List<String> values) {
            addCriterion("withdraw_third_account in", values, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNotIn(List<String> values) {
            addCriterion("withdraw_third_account not in", values, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountBetween(String value1, String value2) {
            addCriterion("withdraw_third_account between", value1, value2, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNotBetween(String value1, String value2) {
            addCriterion("withdraw_third_account not between", value1, value2, "withdrawThirdAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameIsNull() {
            addCriterion("withdraw_third_account_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameIsNotNull() {
            addCriterion("withdraw_third_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameEqualTo(String value) {
            addCriterion("withdraw_third_account_name =", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameNotEqualTo(String value) {
            addCriterion("withdraw_third_account_name <>", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameGreaterThan(String value) {
            addCriterion("withdraw_third_account_name >", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account_name >=", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameLessThan(String value) {
            addCriterion("withdraw_third_account_name <", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameLessThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account_name <=", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameLike(String value) {
            addCriterion("withdraw_third_account_name like", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameNotLike(String value) {
            addCriterion("withdraw_third_account_name not like", value, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameIn(List<String> values) {
            addCriterion("withdraw_third_account_name in", values, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameNotIn(List<String> values) {
            addCriterion("withdraw_third_account_name not in", values, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameBetween(String value1, String value2) {
            addCriterion("withdraw_third_account_name between", value1, value2, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountNameNotBetween(String value1, String value2) {
            addCriterion("withdraw_third_account_name not between", value1, value2, "withdrawThirdAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridIsNull() {
            addCriterion("withdraw_third_userid is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridIsNotNull() {
            addCriterion("withdraw_third_userid is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridEqualTo(String value) {
            addCriterion("withdraw_third_userid =", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridNotEqualTo(String value) {
            addCriterion("withdraw_third_userid <>", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridGreaterThan(String value) {
            addCriterion("withdraw_third_userid >", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_third_userid >=", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridLessThan(String value) {
            addCriterion("withdraw_third_userid <", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridLessThanOrEqualTo(String value) {
            addCriterion("withdraw_third_userid <=", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridLike(String value) {
            addCriterion("withdraw_third_userid like", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridNotLike(String value) {
            addCriterion("withdraw_third_userid not like", value, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridIn(List<String> values) {
            addCriterion("withdraw_third_userid in", values, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridNotIn(List<String> values) {
            addCriterion("withdraw_third_userid not in", values, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridBetween(String value1, String value2) {
            addCriterion("withdraw_third_userid between", value1, value2, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdUseridNotBetween(String value1, String value2) {
            addCriterion("withdraw_third_userid not between", value1, value2, "withdrawThirdUserid");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoIsNull() {
            addCriterion("withdraw_third_account_paymemo is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoIsNotNull() {
            addCriterion("withdraw_third_account_paymemo is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoEqualTo(String value) {
            addCriterion("withdraw_third_account_paymemo =", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoNotEqualTo(String value) {
            addCriterion("withdraw_third_account_paymemo <>", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoGreaterThan(String value) {
            addCriterion("withdraw_third_account_paymemo >", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account_paymemo >=", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoLessThan(String value) {
            addCriterion("withdraw_third_account_paymemo <", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_third_account_paymemo <=", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoLike(String value) {
            addCriterion("withdraw_third_account_paymemo like", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoNotLike(String value) {
            addCriterion("withdraw_third_account_paymemo not like", value, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoIn(List<String> values) {
            addCriterion("withdraw_third_account_paymemo in", values, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoNotIn(List<String> values) {
            addCriterion("withdraw_third_account_paymemo not in", values, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoBetween(String value1, String value2) {
            addCriterion("withdraw_third_account_paymemo between", value1, value2, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawThirdAccountPaymemoNotBetween(String value1, String value2) {
            addCriterion("withdraw_third_account_paymemo not between", value1, value2, "withdrawThirdAccountPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeIsNull() {
            addCriterion("withdraw_account_type is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeIsNotNull() {
            addCriterion("withdraw_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeEqualTo(String value) {
            addCriterion("withdraw_account_type =", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeNotEqualTo(String value) {
            addCriterion("withdraw_account_type <>", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeGreaterThan(String value) {
            addCriterion("withdraw_account_type >", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_account_type >=", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeLessThan(String value) {
            addCriterion("withdraw_account_type <", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("withdraw_account_type <=", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeLike(String value) {
            addCriterion("withdraw_account_type like", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeNotLike(String value) {
            addCriterion("withdraw_account_type not like", value, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeIn(List<String> values) {
            addCriterion("withdraw_account_type in", values, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeNotIn(List<String> values) {
            addCriterion("withdraw_account_type not in", values, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeBetween(String value1, String value2) {
            addCriterion("withdraw_account_type between", value1, value2, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountTypeNotBetween(String value1, String value2) {
            addCriterion("withdraw_account_type not between", value1, value2, "withdrawAccountType");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountIsNull() {
            addCriterion("withdraw_bank_account is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountIsNotNull() {
            addCriterion("withdraw_bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountEqualTo(String value) {
            addCriterion("withdraw_bank_account =", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNotEqualTo(String value) {
            addCriterion("withdraw_bank_account <>", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountGreaterThan(String value) {
            addCriterion("withdraw_bank_account >", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_account >=", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountLessThan(String value) {
            addCriterion("withdraw_bank_account <", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_account <=", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountLike(String value) {
            addCriterion("withdraw_bank_account like", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNotLike(String value) {
            addCriterion("withdraw_bank_account not like", value, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountIn(List<String> values) {
            addCriterion("withdraw_bank_account in", values, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNotIn(List<String> values) {
            addCriterion("withdraw_bank_account not in", values, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountBetween(String value1, String value2) {
            addCriterion("withdraw_bank_account between", value1, value2, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_account not between", value1, value2, "withdrawBankAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberIsNull() {
            addCriterion("withdraw_bank_number is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberIsNotNull() {
            addCriterion("withdraw_bank_number is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberEqualTo(String value) {
            addCriterion("withdraw_bank_number =", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberNotEqualTo(String value) {
            addCriterion("withdraw_bank_number <>", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberGreaterThan(String value) {
            addCriterion("withdraw_bank_number >", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_number >=", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberLessThan(String value) {
            addCriterion("withdraw_bank_number <", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_number <=", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberLike(String value) {
            addCriterion("withdraw_bank_number like", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberNotLike(String value) {
            addCriterion("withdraw_bank_number not like", value, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberIn(List<String> values) {
            addCriterion("withdraw_bank_number in", values, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberNotIn(List<String> values) {
            addCriterion("withdraw_bank_number not in", values, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberBetween(String value1, String value2) {
            addCriterion("withdraw_bank_number between", value1, value2, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankNumberNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_number not between", value1, value2, "withdrawBankNumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameIsNull() {
            addCriterion("withdraw_bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameIsNotNull() {
            addCriterion("withdraw_bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameEqualTo(String value) {
            addCriterion("withdraw_bank_account_name =", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameNotEqualTo(String value) {
            addCriterion("withdraw_bank_account_name <>", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameGreaterThan(String value) {
            addCriterion("withdraw_bank_account_name >", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_account_name >=", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameLessThan(String value) {
            addCriterion("withdraw_bank_account_name <", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_account_name <=", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameLike(String value) {
            addCriterion("withdraw_bank_account_name like", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameNotLike(String value) {
            addCriterion("withdraw_bank_account_name not like", value, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameIn(List<String> values) {
            addCriterion("withdraw_bank_account_name in", values, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameNotIn(List<String> values) {
            addCriterion("withdraw_bank_account_name not in", values, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameBetween(String value1, String value2) {
            addCriterion("withdraw_bank_account_name between", value1, value2, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_account_name not between", value1, value2, "withdrawBankAccountName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceIsNull() {
            addCriterion("withdraw_bank_province is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceIsNotNull() {
            addCriterion("withdraw_bank_province is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceEqualTo(String value) {
            addCriterion("withdraw_bank_province =", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceNotEqualTo(String value) {
            addCriterion("withdraw_bank_province <>", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceGreaterThan(String value) {
            addCriterion("withdraw_bank_province >", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_province >=", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceLessThan(String value) {
            addCriterion("withdraw_bank_province <", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_province <=", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceLike(String value) {
            addCriterion("withdraw_bank_province like", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceNotLike(String value) {
            addCriterion("withdraw_bank_province not like", value, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceIn(List<String> values) {
            addCriterion("withdraw_bank_province in", values, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceNotIn(List<String> values) {
            addCriterion("withdraw_bank_province not in", values, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceBetween(String value1, String value2) {
            addCriterion("withdraw_bank_province between", value1, value2, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankProvinceNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_province not between", value1, value2, "withdrawBankProvince");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityIsNull() {
            addCriterion("withdraw_bank_city is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityIsNotNull() {
            addCriterion("withdraw_bank_city is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityEqualTo(String value) {
            addCriterion("withdraw_bank_city =", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityNotEqualTo(String value) {
            addCriterion("withdraw_bank_city <>", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityGreaterThan(String value) {
            addCriterion("withdraw_bank_city >", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_city >=", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityLessThan(String value) {
            addCriterion("withdraw_bank_city <", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_city <=", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityLike(String value) {
            addCriterion("withdraw_bank_city like", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityNotLike(String value) {
            addCriterion("withdraw_bank_city not like", value, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityIn(List<String> values) {
            addCriterion("withdraw_bank_city in", values, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityNotIn(List<String> values) {
            addCriterion("withdraw_bank_city not in", values, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityBetween(String value1, String value2) {
            addCriterion("withdraw_bank_city between", value1, value2, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankCityNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_city not between", value1, value2, "withdrawBankCity");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameIsNull() {
            addCriterion("withdraw_bank_branch_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameIsNotNull() {
            addCriterion("withdraw_bank_branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameEqualTo(String value) {
            addCriterion("withdraw_bank_branch_name =", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameNotEqualTo(String value) {
            addCriterion("withdraw_bank_branch_name <>", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameGreaterThan(String value) {
            addCriterion("withdraw_bank_branch_name >", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_branch_name >=", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameLessThan(String value) {
            addCriterion("withdraw_bank_branch_name <", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_branch_name <=", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameLike(String value) {
            addCriterion("withdraw_bank_branch_name like", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameNotLike(String value) {
            addCriterion("withdraw_bank_branch_name not like", value, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameIn(List<String> values) {
            addCriterion("withdraw_bank_branch_name in", values, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameNotIn(List<String> values) {
            addCriterion("withdraw_bank_branch_name not in", values, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameBetween(String value1, String value2) {
            addCriterion("withdraw_bank_branch_name between", value1, value2, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNameNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_branch_name not between", value1, value2, "withdrawBankBranchName");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoIsNull() {
            addCriterion("withdraw_bank_branch_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoIsNotNull() {
            addCriterion("withdraw_bank_branch_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoEqualTo(String value) {
            addCriterion("withdraw_bank_branch_no =", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoNotEqualTo(String value) {
            addCriterion("withdraw_bank_branch_no <>", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoGreaterThan(String value) {
            addCriterion("withdraw_bank_branch_no >", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_branch_no >=", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoLessThan(String value) {
            addCriterion("withdraw_bank_branch_no <", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_branch_no <=", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoLike(String value) {
            addCriterion("withdraw_bank_branch_no like", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoNotLike(String value) {
            addCriterion("withdraw_bank_branch_no not like", value, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoIn(List<String> values) {
            addCriterion("withdraw_bank_branch_no in", values, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoNotIn(List<String> values) {
            addCriterion("withdraw_bank_branch_no not in", values, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoBetween(String value1, String value2) {
            addCriterion("withdraw_bank_branch_no between", value1, value2, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankBranchNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_branch_no not between", value1, value2, "withdrawBankBranchNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoIsNull() {
            addCriterion("withdraw_bank_paymemo is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoIsNotNull() {
            addCriterion("withdraw_bank_paymemo is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoEqualTo(String value) {
            addCriterion("withdraw_bank_paymemo =", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoNotEqualTo(String value) {
            addCriterion("withdraw_bank_paymemo <>", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoGreaterThan(String value) {
            addCriterion("withdraw_bank_paymemo >", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_paymemo >=", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoLessThan(String value) {
            addCriterion("withdraw_bank_paymemo <", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_bank_paymemo <=", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoLike(String value) {
            addCriterion("withdraw_bank_paymemo like", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoNotLike(String value) {
            addCriterion("withdraw_bank_paymemo not like", value, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoIn(List<String> values) {
            addCriterion("withdraw_bank_paymemo in", values, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoNotIn(List<String> values) {
            addCriterion("withdraw_bank_paymemo not in", values, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoBetween(String value1, String value2) {
            addCriterion("withdraw_bank_paymemo between", value1, value2, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawBankPaymemoNotBetween(String value1, String value2) {
            addCriterion("withdraw_bank_paymemo not between", value1, value2, "withdrawBankPaymemo");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeIsNull() {
            addCriterion("withdraw_charge_fee is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeIsNotNull() {
            addCriterion("withdraw_charge_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeEqualTo(Long value) {
            addCriterion("withdraw_charge_fee =", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeNotEqualTo(Long value) {
            addCriterion("withdraw_charge_fee <>", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeGreaterThan(Long value) {
            addCriterion("withdraw_charge_fee >", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_charge_fee >=", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeLessThan(Long value) {
            addCriterion("withdraw_charge_fee <", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_charge_fee <=", value, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeIn(List<Long> values) {
            addCriterion("withdraw_charge_fee in", values, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeNotIn(List<Long> values) {
            addCriterion("withdraw_charge_fee not in", values, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeBetween(Long value1, Long value2) {
            addCriterion("withdraw_charge_fee between", value1, value2, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_charge_fee not between", value1, value2, "withdrawChargeFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeIsNull() {
            addCriterion("withdraw_charge_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeIsNotNull() {
            addCriterion("withdraw_charge_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeEqualTo(String value) {
            addCriterion("withdraw_charge_fee_type =", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeNotEqualTo(String value) {
            addCriterion("withdraw_charge_fee_type <>", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeGreaterThan(String value) {
            addCriterion("withdraw_charge_fee_type >", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_charge_fee_type >=", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeLessThan(String value) {
            addCriterion("withdraw_charge_fee_type <", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("withdraw_charge_fee_type <=", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeLike(String value) {
            addCriterion("withdraw_charge_fee_type like", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeNotLike(String value) {
            addCriterion("withdraw_charge_fee_type not like", value, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeIn(List<String> values) {
            addCriterion("withdraw_charge_fee_type in", values, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeNotIn(List<String> values) {
            addCriterion("withdraw_charge_fee_type not in", values, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeBetween(String value1, String value2) {
            addCriterion("withdraw_charge_fee_type between", value1, value2, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeTypeNotBetween(String value1, String value2) {
            addCriterion("withdraw_charge_fee_type not between", value1, value2, "withdrawChargeFeeType");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountIsNull() {
            addCriterion("withdraw_charge_fee_account is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountIsNotNull() {
            addCriterion("withdraw_charge_fee_account is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountEqualTo(String value) {
            addCriterion("withdraw_charge_fee_account =", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountNotEqualTo(String value) {
            addCriterion("withdraw_charge_fee_account <>", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountGreaterThan(String value) {
            addCriterion("withdraw_charge_fee_account >", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_charge_fee_account >=", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountLessThan(String value) {
            addCriterion("withdraw_charge_fee_account <", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountLessThanOrEqualTo(String value) {
            addCriterion("withdraw_charge_fee_account <=", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountLike(String value) {
            addCriterion("withdraw_charge_fee_account like", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountNotLike(String value) {
            addCriterion("withdraw_charge_fee_account not like", value, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountIn(List<String> values) {
            addCriterion("withdraw_charge_fee_account in", values, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountNotIn(List<String> values) {
            addCriterion("withdraw_charge_fee_account not in", values, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountBetween(String value1, String value2) {
            addCriterion("withdraw_charge_fee_account between", value1, value2, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andWithdrawChargeFeeAccountNotBetween(String value1, String value2) {
            addCriterion("withdraw_charge_fee_account not between", value1, value2, "withdrawChargeFeeAccount");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoIsNull() {
            addCriterion("pay_third_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoIsNotNull() {
            addCriterion("pay_third_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoEqualTo(String value) {
            addCriterion("pay_third_trade_no =", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoNotEqualTo(String value) {
            addCriterion("pay_third_trade_no <>", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoGreaterThan(String value) {
            addCriterion("pay_third_trade_no >", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_third_trade_no >=", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoLessThan(String value) {
            addCriterion("pay_third_trade_no <", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoLessThanOrEqualTo(String value) {
            addCriterion("pay_third_trade_no <=", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoLike(String value) {
            addCriterion("pay_third_trade_no like", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoNotLike(String value) {
            addCriterion("pay_third_trade_no not like", value, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoIn(List<String> values) {
            addCriterion("pay_third_trade_no in", values, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoNotIn(List<String> values) {
            addCriterion("pay_third_trade_no not in", values, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoBetween(String value1, String value2) {
            addCriterion("pay_third_trade_no between", value1, value2, "payThirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayThirdTradeNoNotBetween(String value1, String value2) {
            addCriterion("pay_third_trade_no not between", value1, value2, "payThirdTradeNo");
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

        public Criteria andLedgerNoIsNull() {
            addCriterion("ledger_no is null");
            return (Criteria) this;
        }

        public Criteria andLedgerNoIsNotNull() {
            addCriterion("ledger_no is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerNoEqualTo(String value) {
            addCriterion("ledger_no =", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoNotEqualTo(String value) {
            addCriterion("ledger_no <>", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoGreaterThan(String value) {
            addCriterion("ledger_no >", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_no >=", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoLessThan(String value) {
            addCriterion("ledger_no <", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoLessThanOrEqualTo(String value) {
            addCriterion("ledger_no <=", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoLike(String value) {
            addCriterion("ledger_no like", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoNotLike(String value) {
            addCriterion("ledger_no not like", value, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoIn(List<String> values) {
            addCriterion("ledger_no in", values, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoNotIn(List<String> values) {
            addCriterion("ledger_no not in", values, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoBetween(String value1, String value2) {
            addCriterion("ledger_no between", value1, value2, "ledgerNo");
            return (Criteria) this;
        }

        public Criteria andLedgerNoNotBetween(String value1, String value2) {
            addCriterion("ledger_no not between", value1, value2, "ledgerNo");
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

        public Criteria andRequestGroupIsNull() {
            addCriterion("request_group is null");
            return (Criteria) this;
        }

        public Criteria andRequestGroupIsNotNull() {
            addCriterion("request_group is not null");
            return (Criteria) this;
        }

        public Criteria andRequestGroupEqualTo(String value) {
            addCriterion("request_group =", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupNotEqualTo(String value) {
            addCriterion("request_group <>", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupGreaterThan(String value) {
            addCriterion("request_group >", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupGreaterThanOrEqualTo(String value) {
            addCriterion("request_group >=", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupLessThan(String value) {
            addCriterion("request_group <", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupLessThanOrEqualTo(String value) {
            addCriterion("request_group <=", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupLike(String value) {
            addCriterion("request_group like", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupNotLike(String value) {
            addCriterion("request_group not like", value, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupIn(List<String> values) {
            addCriterion("request_group in", values, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupNotIn(List<String> values) {
            addCriterion("request_group not in", values, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupBetween(String value1, String value2) {
            addCriterion("request_group between", value1, value2, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andRequestGroupNotBetween(String value1, String value2) {
            addCriterion("request_group not between", value1, value2, "requestGroup");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeIsNull() {
            addCriterion("fail_error_code is null");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeIsNotNull() {
            addCriterion("fail_error_code is not null");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeEqualTo(String value) {
            addCriterion("fail_error_code =", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeNotEqualTo(String value) {
            addCriterion("fail_error_code <>", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeGreaterThan(String value) {
            addCriterion("fail_error_code >", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fail_error_code >=", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeLessThan(String value) {
            addCriterion("fail_error_code <", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeLessThanOrEqualTo(String value) {
            addCriterion("fail_error_code <=", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeLike(String value) {
            addCriterion("fail_error_code like", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeNotLike(String value) {
            addCriterion("fail_error_code not like", value, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeIn(List<String> values) {
            addCriterion("fail_error_code in", values, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeNotIn(List<String> values) {
            addCriterion("fail_error_code not in", values, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeBetween(String value1, String value2) {
            addCriterion("fail_error_code between", value1, value2, "failErrorCode");
            return (Criteria) this;
        }

        public Criteria andFailErrorCodeNotBetween(String value1, String value2) {
            addCriterion("fail_error_code not between", value1, value2, "failErrorCode");
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