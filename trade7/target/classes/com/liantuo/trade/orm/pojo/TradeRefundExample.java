package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeRefundExample {
    private Integer start = 0;
    private Integer limit = 0;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeRefundExample() {
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

        public Criteria andRefundAccountNoIsNull() {
            addCriterion("refund_account_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoIsNotNull() {
            addCriterion("refund_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoEqualTo(String value) {
            addCriterion("refund_account_no =", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoNotEqualTo(String value) {
            addCriterion("refund_account_no <>", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoGreaterThan(String value) {
            addCriterion("refund_account_no >", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_account_no >=", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoLessThan(String value) {
            addCriterion("refund_account_no <", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoLessThanOrEqualTo(String value) {
            addCriterion("refund_account_no <=", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoLike(String value) {
            addCriterion("refund_account_no like", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoNotLike(String value) {
            addCriterion("refund_account_no not like", value, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoIn(List<String> values) {
            addCriterion("refund_account_no in", values, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoNotIn(List<String> values) {
            addCriterion("refund_account_no not in", values, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoBetween(String value1, String value2) {
            addCriterion("refund_account_no between", value1, value2, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNoNotBetween(String value1, String value2) {
            addCriterion("refund_account_no not between", value1, value2, "refundAccountNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoIsNull() {
            addCriterion("refund_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoIsNotNull() {
            addCriterion("refund_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoEqualTo(String value) {
            addCriterion("refund_merchant_no =", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoNotEqualTo(String value) {
            addCriterion("refund_merchant_no <>", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoGreaterThan(String value) {
            addCriterion("refund_merchant_no >", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_merchant_no >=", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoLessThan(String value) {
            addCriterion("refund_merchant_no <", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("refund_merchant_no <=", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoLike(String value) {
            addCriterion("refund_merchant_no like", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoNotLike(String value) {
            addCriterion("refund_merchant_no not like", value, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoIn(List<String> values) {
            addCriterion("refund_merchant_no in", values, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoNotIn(List<String> values) {
            addCriterion("refund_merchant_no not in", values, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoBetween(String value1, String value2) {
            addCriterion("refund_merchant_no between", value1, value2, "RefundMerchantNo");
            return (Criteria) this;
        }

        public Criteria andRefundMerchantNoNotBetween(String value1, String value2) {
            addCriterion("refund_merchant_no not between", value1, value2, "RefundMerchantNo");
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

        public Criteria andClearChannelIsNull() {
            addCriterion("clear_channel is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelIsNotNull() {
            addCriterion("clear_channel is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelEqualTo(String value) {
            addCriterion("clear_channel =", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelNotEqualTo(String value) {
            addCriterion("clear_channel <>", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelGreaterThan(String value) {
            addCriterion("clear_channel >", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelGreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel >=", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelLessThan(String value) {
            addCriterion("clear_channel <", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelLessThanOrEqualTo(String value) {
            addCriterion("clear_channel <=", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelLike(String value) {
            addCriterion("clear_channel like", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelNotLike(String value) {
            addCriterion("clear_channel not like", value, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelIn(List<String> values) {
            addCriterion("clear_channel in", values, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelNotIn(List<String> values) {
            addCriterion("clear_channel not in", values, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelBetween(String value1, String value2) {
            addCriterion("clear_channel between", value1, value2, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andClearChannelNotBetween(String value1, String value2) {
            addCriterion("clear_channel not between", value1, value2, "clearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelIsNull() {
            addCriterion("gmt_success_clear_channel is null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelIsNotNull() {
            addCriterion("gmt_success_clear_channel is not null");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelEqualTo(Date value) {
            addCriterion("gmt_success_clear_channel =", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelNotEqualTo(Date value) {
            addCriterion("gmt_success_clear_channel <>", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelGreaterThan(Date value) {
            addCriterion("gmt_success_clear_channel >", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_success_clear_channel >=", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelLessThan(Date value) {
            addCriterion("gmt_success_clear_channel <", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelLessThanOrEqualTo(Date value) {
            addCriterion("gmt_success_clear_channel <=", value, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelIn(List<Date> values) {
            addCriterion("gmt_success_clear_channel in", values, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelNotIn(List<Date> values) {
            addCriterion("gmt_success_clear_channel not in", values, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelBetween(Date value1, Date value2) {
            addCriterion("gmt_success_clear_channel between", value1, value2, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andGmtSuccessClearChannelNotBetween(Date value1, Date value2) {
            addCriterion("gmt_success_clear_channel not between", value1, value2, "gmtSuccessClearChannel");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoIsNull() {
            addCriterion("clear_order_no is null");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoIsNotNull() {
            addCriterion("clear_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoEqualTo(String value) {
            addCriterion("clear_order_no =", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoNotEqualTo(String value) {
            addCriterion("clear_order_no <>", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoGreaterThan(String value) {
            addCriterion("clear_order_no >", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("clear_order_no >=", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoLessThan(String value) {
            addCriterion("clear_order_no <", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoLessThanOrEqualTo(String value) {
            addCriterion("clear_order_no <=", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoLike(String value) {
            addCriterion("clear_order_no like", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoNotLike(String value) {
            addCriterion("clear_order_no not like", value, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoIn(List<String> values) {
            addCriterion("clear_order_no in", values, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoNotIn(List<String> values) {
            addCriterion("clear_order_no not in", values, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoBetween(String value1, String value2) {
            addCriterion("clear_order_no between", value1, value2, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearOrderNoNotBetween(String value1, String value2) {
            addCriterion("clear_order_no not between", value1, value2, "clearOrderNo");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountIsNull() {
            addCriterion("clear_refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountIsNotNull() {
            addCriterion("clear_refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountEqualTo(Long value) {
            addCriterion("clear_refund_amount =", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountNotEqualTo(Long value) {
            addCriterion("clear_refund_amount <>", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountGreaterThan(Long value) {
            addCriterion("clear_refund_amount >", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("clear_refund_amount >=", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountLessThan(Long value) {
            addCriterion("clear_refund_amount <", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountLessThanOrEqualTo(Long value) {
            addCriterion("clear_refund_amount <=", value, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountIn(List<Long> values) {
            addCriterion("clear_refund_amount in", values, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountNotIn(List<Long> values) {
            addCriterion("clear_refund_amount not in", values, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountBetween(Long value1, Long value2) {
            addCriterion("clear_refund_amount between", value1, value2, "clearRefundAmount");
            return (Criteria) this;
        }

        public Criteria andClearRefundAmountNotBetween(Long value1, Long value2) {
            addCriterion("clear_refund_amount not between", value1, value2, "clearRefundAmount");
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

        public Criteria andReceiveMerchantNoIsNull() {
            addCriterion("receive_merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoIsNotNull() {
            addCriterion("receive_merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoEqualTo(String value) {
            addCriterion("receive_merchant_no =", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoNotEqualTo(String value) {
            addCriterion("receive_merchant_no <>", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoGreaterThan(String value) {
            addCriterion("receive_merchant_no >", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("receive_merchant_no >=", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoLessThan(String value) {
            addCriterion("receive_merchant_no <", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("receive_merchant_no <=", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoLike(String value) {
            addCriterion("receive_merchant_no like", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoNotLike(String value) {
            addCriterion("receive_merchant_no not like", value, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoIn(List<String> values) {
            addCriterion("receive_merchant_no in", values, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoNotIn(List<String> values) {
            addCriterion("receive_merchant_no not in", values, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoBetween(String value1, String value2) {
            addCriterion("receive_merchant_no between", value1, value2, "receiveMerchantNo");
            return (Criteria) this;
        }

        public Criteria andReceiveMerchantNoNotBetween(String value1, String value2) {
            addCriterion("receive_merchant_no not between", value1, value2, "receiveMerchantNo");
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

        public Criteria andVersionEqualTo(float value) {
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