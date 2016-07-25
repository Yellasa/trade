package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeProfitLossLedgerLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeProfitLossLedgerLogExample() {
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

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
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

        public Criteria andGmtTradeCreatedIsNull() {
            addCriterion("gmt_trade_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedIsNotNull() {
            addCriterion("gmt_trade_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedEqualTo(Date value) {
            addCriterion("gmt_trade_created =", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedNotEqualTo(Date value) {
            addCriterion("gmt_trade_created <>", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedGreaterThan(Date value) {
            addCriterion("gmt_trade_created >", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_trade_created >=", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedLessThan(Date value) {
            addCriterion("gmt_trade_created <", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_trade_created <=", value, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedIn(List<Date> values) {
            addCriterion("gmt_trade_created in", values, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedNotIn(List<Date> values) {
            addCriterion("gmt_trade_created not in", values, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_trade_created between", value1, value2, "gmtTradeCreated");
            return (Criteria) this;
        }

        public Criteria andGmtTradeCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_trade_created not between", value1, value2, "gmtTradeCreated");
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

        public Criteria andCreateReqTypeIsNull() {
            addCriterion("create_req_type is null");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeIsNotNull() {
            addCriterion("create_req_type is not null");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeEqualTo(String value) {
            addCriterion("create_req_type =", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeNotEqualTo(String value) {
            addCriterion("create_req_type <>", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeGreaterThan(String value) {
            addCriterion("create_req_type >", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("create_req_type >=", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeLessThan(String value) {
            addCriterion("create_req_type <", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeLessThanOrEqualTo(String value) {
            addCriterion("create_req_type <=", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeLike(String value) {
            addCriterion("create_req_type like", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeNotLike(String value) {
            addCriterion("create_req_type not like", value, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeIn(List<String> values) {
            addCriterion("create_req_type in", values, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeNotIn(List<String> values) {
            addCriterion("create_req_type not in", values, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeBetween(String value1, String value2) {
            addCriterion("create_req_type between", value1, value2, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqTypeNotBetween(String value1, String value2) {
            addCriterion("create_req_type not between", value1, value2, "createReqType");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoIsNull() {
            addCriterion("create_req_no is null");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoIsNotNull() {
            addCriterion("create_req_no is not null");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoEqualTo(String value) {
            addCriterion("create_req_no =", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoNotEqualTo(String value) {
            addCriterion("create_req_no <>", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoGreaterThan(String value) {
            addCriterion("create_req_no >", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoGreaterThanOrEqualTo(String value) {
            addCriterion("create_req_no >=", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoLessThan(String value) {
            addCriterion("create_req_no <", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoLessThanOrEqualTo(String value) {
            addCriterion("create_req_no <=", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoLike(String value) {
            addCriterion("create_req_no like", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoNotLike(String value) {
            addCriterion("create_req_no not like", value, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoIn(List<String> values) {
            addCriterion("create_req_no in", values, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoNotIn(List<String> values) {
            addCriterion("create_req_no not in", values, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoBetween(String value1, String value2) {
            addCriterion("create_req_no between", value1, value2, "createReqNo");
            return (Criteria) this;
        }

        public Criteria andCreateReqNoNotBetween(String value1, String value2) {
            addCriterion("create_req_no not between", value1, value2, "createReqNo");
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

        public Criteria andEffectiveReqTypeIsNull() {
            addCriterion("effective_req_type is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeIsNotNull() {
            addCriterion("effective_req_type is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeEqualTo(String value) {
            addCriterion("effective_req_type =", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeNotEqualTo(String value) {
            addCriterion("effective_req_type <>", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeGreaterThan(String value) {
            addCriterion("effective_req_type >", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("effective_req_type >=", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeLessThan(String value) {
            addCriterion("effective_req_type <", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeLessThanOrEqualTo(String value) {
            addCriterion("effective_req_type <=", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeLike(String value) {
            addCriterion("effective_req_type like", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeNotLike(String value) {
            addCriterion("effective_req_type not like", value, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeIn(List<String> values) {
            addCriterion("effective_req_type in", values, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeNotIn(List<String> values) {
            addCriterion("effective_req_type not in", values, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeBetween(String value1, String value2) {
            addCriterion("effective_req_type between", value1, value2, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqTypeNotBetween(String value1, String value2) {
            addCriterion("effective_req_type not between", value1, value2, "effectiveReqType");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoIsNull() {
            addCriterion("effective_req_no is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoIsNotNull() {
            addCriterion("effective_req_no is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoEqualTo(String value) {
            addCriterion("effective_req_no =", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoNotEqualTo(String value) {
            addCriterion("effective_req_no <>", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoGreaterThan(String value) {
            addCriterion("effective_req_no >", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoGreaterThanOrEqualTo(String value) {
            addCriterion("effective_req_no >=", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoLessThan(String value) {
            addCriterion("effective_req_no <", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoLessThanOrEqualTo(String value) {
            addCriterion("effective_req_no <=", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoLike(String value) {
            addCriterion("effective_req_no like", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoNotLike(String value) {
            addCriterion("effective_req_no not like", value, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoIn(List<String> values) {
            addCriterion("effective_req_no in", values, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoNotIn(List<String> values) {
            addCriterion("effective_req_no not in", values, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoBetween(String value1, String value2) {
            addCriterion("effective_req_no between", value1, value2, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andEffectiveReqNoNotBetween(String value1, String value2) {
            addCriterion("effective_req_no not between", value1, value2, "effectiveReqNo");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveIsNull() {
            addCriterion("gmt_effective is null");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveIsNotNull() {
            addCriterion("gmt_effective is not null");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveEqualTo(Date value) {
            addCriterion("gmt_effective =", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveNotEqualTo(Date value) {
            addCriterion("gmt_effective <>", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveGreaterThan(Date value) {
            addCriterion("gmt_effective >", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_effective >=", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveLessThan(Date value) {
            addCriterion("gmt_effective <", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveLessThanOrEqualTo(Date value) {
            addCriterion("gmt_effective <=", value, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveIn(List<Date> values) {
            addCriterion("gmt_effective in", values, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveNotIn(List<Date> values) {
            addCriterion("gmt_effective not in", values, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveBetween(Date value1, Date value2) {
            addCriterion("gmt_effective between", value1, value2, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andGmtEffectiveNotBetween(Date value1, Date value2) {
            addCriterion("gmt_effective not between", value1, value2, "gmtEffective");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeIsNull() {
            addCriterion("fail_req_type is null");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeIsNotNull() {
            addCriterion("fail_req_type is not null");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeEqualTo(String value) {
            addCriterion("fail_req_type =", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeNotEqualTo(String value) {
            addCriterion("fail_req_type <>", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeGreaterThan(String value) {
            addCriterion("fail_req_type >", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fail_req_type >=", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeLessThan(String value) {
            addCriterion("fail_req_type <", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeLessThanOrEqualTo(String value) {
            addCriterion("fail_req_type <=", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeLike(String value) {
            addCriterion("fail_req_type like", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeNotLike(String value) {
            addCriterion("fail_req_type not like", value, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeIn(List<String> values) {
            addCriterion("fail_req_type in", values, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeNotIn(List<String> values) {
            addCriterion("fail_req_type not in", values, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeBetween(String value1, String value2) {
            addCriterion("fail_req_type between", value1, value2, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqTypeNotBetween(String value1, String value2) {
            addCriterion("fail_req_type not between", value1, value2, "failReqType");
            return (Criteria) this;
        }

        public Criteria andFailReqNoIsNull() {
            addCriterion("fail_req_no is null");
            return (Criteria) this;
        }

        public Criteria andFailReqNoIsNotNull() {
            addCriterion("fail_req_no is not null");
            return (Criteria) this;
        }

        public Criteria andFailReqNoEqualTo(String value) {
            addCriterion("fail_req_no =", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoNotEqualTo(String value) {
            addCriterion("fail_req_no <>", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoGreaterThan(String value) {
            addCriterion("fail_req_no >", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoGreaterThanOrEqualTo(String value) {
            addCriterion("fail_req_no >=", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoLessThan(String value) {
            addCriterion("fail_req_no <", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoLessThanOrEqualTo(String value) {
            addCriterion("fail_req_no <=", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoLike(String value) {
            addCriterion("fail_req_no like", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoNotLike(String value) {
            addCriterion("fail_req_no not like", value, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoIn(List<String> values) {
            addCriterion("fail_req_no in", values, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoNotIn(List<String> values) {
            addCriterion("fail_req_no not in", values, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoBetween(String value1, String value2) {
            addCriterion("fail_req_no between", value1, value2, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andFailReqNoNotBetween(String value1, String value2) {
            addCriterion("fail_req_no not between", value1, value2, "failReqNo");
            return (Criteria) this;
        }

        public Criteria andGmtFailedIsNull() {
            addCriterion("gmt_failed is null");
            return (Criteria) this;
        }

        public Criteria andGmtFailedIsNotNull() {
            addCriterion("gmt_failed is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFailedEqualTo(Date value) {
            addCriterion("gmt_failed =", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedNotEqualTo(Date value) {
            addCriterion("gmt_failed <>", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedGreaterThan(Date value) {
            addCriterion("gmt_failed >", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_failed >=", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedLessThan(Date value) {
            addCriterion("gmt_failed <", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_failed <=", value, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedIn(List<Date> values) {
            addCriterion("gmt_failed in", values, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedNotIn(List<Date> values) {
            addCriterion("gmt_failed not in", values, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedBetween(Date value1, Date value2) {
            addCriterion("gmt_failed between", value1, value2, "gmtFailed");
            return (Criteria) this;
        }

        public Criteria andGmtFailedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_failed not between", value1, value2, "gmtFailed");
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

        public Criteria andProfitLossAttr1IsNull() {
            addCriterion("profit_loss_attr_1 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1IsNotNull() {
            addCriterion("profit_loss_attr_1 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1EqualTo(String value) {
            addCriterion("profit_loss_attr_1 =", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1NotEqualTo(String value) {
            addCriterion("profit_loss_attr_1 <>", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1GreaterThan(String value) {
            addCriterion("profit_loss_attr_1 >", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_1 >=", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1LessThan(String value) {
            addCriterion("profit_loss_attr_1 <", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_1 <=", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1Like(String value) {
            addCriterion("profit_loss_attr_1 like", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1NotLike(String value) {
            addCriterion("profit_loss_attr_1 not like", value, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1In(List<String> values) {
            addCriterion("profit_loss_attr_1 in", values, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1NotIn(List<String> values) {
            addCriterion("profit_loss_attr_1 not in", values, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1Between(String value1, String value2) {
            addCriterion("profit_loss_attr_1 between", value1, value2, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr1NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_1 not between", value1, value2, "profitLossAttr1");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2IsNull() {
            addCriterion("profit_loss_attr_2 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2IsNotNull() {
            addCriterion("profit_loss_attr_2 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2EqualTo(String value) {
            addCriterion("profit_loss_attr_2 =", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2NotEqualTo(String value) {
            addCriterion("profit_loss_attr_2 <>", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2GreaterThan(String value) {
            addCriterion("profit_loss_attr_2 >", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_2 >=", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2LessThan(String value) {
            addCriterion("profit_loss_attr_2 <", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_2 <=", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2Like(String value) {
            addCriterion("profit_loss_attr_2 like", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2NotLike(String value) {
            addCriterion("profit_loss_attr_2 not like", value, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2In(List<String> values) {
            addCriterion("profit_loss_attr_2 in", values, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2NotIn(List<String> values) {
            addCriterion("profit_loss_attr_2 not in", values, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2Between(String value1, String value2) {
            addCriterion("profit_loss_attr_2 between", value1, value2, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr2NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_2 not between", value1, value2, "profitLossAttr2");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3IsNull() {
            addCriterion("profit_loss_attr_3 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3IsNotNull() {
            addCriterion("profit_loss_attr_3 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3EqualTo(String value) {
            addCriterion("profit_loss_attr_3 =", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3NotEqualTo(String value) {
            addCriterion("profit_loss_attr_3 <>", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3GreaterThan(String value) {
            addCriterion("profit_loss_attr_3 >", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_3 >=", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3LessThan(String value) {
            addCriterion("profit_loss_attr_3 <", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_3 <=", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3Like(String value) {
            addCriterion("profit_loss_attr_3 like", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3NotLike(String value) {
            addCriterion("profit_loss_attr_3 not like", value, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3In(List<String> values) {
            addCriterion("profit_loss_attr_3 in", values, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3NotIn(List<String> values) {
            addCriterion("profit_loss_attr_3 not in", values, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3Between(String value1, String value2) {
            addCriterion("profit_loss_attr_3 between", value1, value2, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr3NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_3 not between", value1, value2, "profitLossAttr3");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4IsNull() {
            addCriterion("profit_loss_attr_4 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4IsNotNull() {
            addCriterion("profit_loss_attr_4 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4EqualTo(String value) {
            addCriterion("profit_loss_attr_4 =", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4NotEqualTo(String value) {
            addCriterion("profit_loss_attr_4 <>", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4GreaterThan(String value) {
            addCriterion("profit_loss_attr_4 >", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_4 >=", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4LessThan(String value) {
            addCriterion("profit_loss_attr_4 <", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_4 <=", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4Like(String value) {
            addCriterion("profit_loss_attr_4 like", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4NotLike(String value) {
            addCriterion("profit_loss_attr_4 not like", value, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4In(List<String> values) {
            addCriterion("profit_loss_attr_4 in", values, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4NotIn(List<String> values) {
            addCriterion("profit_loss_attr_4 not in", values, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4Between(String value1, String value2) {
            addCriterion("profit_loss_attr_4 between", value1, value2, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr4NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_4 not between", value1, value2, "profitLossAttr4");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5IsNull() {
            addCriterion("profit_loss_attr_5 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5IsNotNull() {
            addCriterion("profit_loss_attr_5 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5EqualTo(String value) {
            addCriterion("profit_loss_attr_5 =", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5NotEqualTo(String value) {
            addCriterion("profit_loss_attr_5 <>", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5GreaterThan(String value) {
            addCriterion("profit_loss_attr_5 >", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_5 >=", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5LessThan(String value) {
            addCriterion("profit_loss_attr_5 <", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_5 <=", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5Like(String value) {
            addCriterion("profit_loss_attr_5 like", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5NotLike(String value) {
            addCriterion("profit_loss_attr_5 not like", value, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5In(List<String> values) {
            addCriterion("profit_loss_attr_5 in", values, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5NotIn(List<String> values) {
            addCriterion("profit_loss_attr_5 not in", values, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5Between(String value1, String value2) {
            addCriterion("profit_loss_attr_5 between", value1, value2, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr5NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_5 not between", value1, value2, "profitLossAttr5");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6IsNull() {
            addCriterion("profit_loss_attr_6 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6IsNotNull() {
            addCriterion("profit_loss_attr_6 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6EqualTo(String value) {
            addCriterion("profit_loss_attr_6 =", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6NotEqualTo(String value) {
            addCriterion("profit_loss_attr_6 <>", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6GreaterThan(String value) {
            addCriterion("profit_loss_attr_6 >", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_6 >=", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6LessThan(String value) {
            addCriterion("profit_loss_attr_6 <", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_6 <=", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6Like(String value) {
            addCriterion("profit_loss_attr_6 like", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6NotLike(String value) {
            addCriterion("profit_loss_attr_6 not like", value, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6In(List<String> values) {
            addCriterion("profit_loss_attr_6 in", values, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6NotIn(List<String> values) {
            addCriterion("profit_loss_attr_6 not in", values, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6Between(String value1, String value2) {
            addCriterion("profit_loss_attr_6 between", value1, value2, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr6NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_6 not between", value1, value2, "profitLossAttr6");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7IsNull() {
            addCriterion("profit_loss_attr_7 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7IsNotNull() {
            addCriterion("profit_loss_attr_7 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7EqualTo(String value) {
            addCriterion("profit_loss_attr_7 =", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7NotEqualTo(String value) {
            addCriterion("profit_loss_attr_7 <>", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7GreaterThan(String value) {
            addCriterion("profit_loss_attr_7 >", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_7 >=", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7LessThan(String value) {
            addCriterion("profit_loss_attr_7 <", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_7 <=", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7Like(String value) {
            addCriterion("profit_loss_attr_7 like", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7NotLike(String value) {
            addCriterion("profit_loss_attr_7 not like", value, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7In(List<String> values) {
            addCriterion("profit_loss_attr_7 in", values, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7NotIn(List<String> values) {
            addCriterion("profit_loss_attr_7 not in", values, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7Between(String value1, String value2) {
            addCriterion("profit_loss_attr_7 between", value1, value2, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr7NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_7 not between", value1, value2, "profitLossAttr7");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8IsNull() {
            addCriterion("profit_loss_attr_8 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8IsNotNull() {
            addCriterion("profit_loss_attr_8 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8EqualTo(String value) {
            addCriterion("profit_loss_attr_8 =", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8NotEqualTo(String value) {
            addCriterion("profit_loss_attr_8 <>", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8GreaterThan(String value) {
            addCriterion("profit_loss_attr_8 >", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_8 >=", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8LessThan(String value) {
            addCriterion("profit_loss_attr_8 <", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_8 <=", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8Like(String value) {
            addCriterion("profit_loss_attr_8 like", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8NotLike(String value) {
            addCriterion("profit_loss_attr_8 not like", value, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8In(List<String> values) {
            addCriterion("profit_loss_attr_8 in", values, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8NotIn(List<String> values) {
            addCriterion("profit_loss_attr_8 not in", values, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8Between(String value1, String value2) {
            addCriterion("profit_loss_attr_8 between", value1, value2, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr8NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_8 not between", value1, value2, "profitLossAttr8");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9IsNull() {
            addCriterion("profit_loss_attr_9 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9IsNotNull() {
            addCriterion("profit_loss_attr_9 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9EqualTo(String value) {
            addCriterion("profit_loss_attr_9 =", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9NotEqualTo(String value) {
            addCriterion("profit_loss_attr_9 <>", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9GreaterThan(String value) {
            addCriterion("profit_loss_attr_9 >", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_9 >=", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9LessThan(String value) {
            addCriterion("profit_loss_attr_9 <", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_9 <=", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9Like(String value) {
            addCriterion("profit_loss_attr_9 like", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9NotLike(String value) {
            addCriterion("profit_loss_attr_9 not like", value, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9In(List<String> values) {
            addCriterion("profit_loss_attr_9 in", values, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9NotIn(List<String> values) {
            addCriterion("profit_loss_attr_9 not in", values, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9Between(String value1, String value2) {
            addCriterion("profit_loss_attr_9 between", value1, value2, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr9NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_9 not between", value1, value2, "profitLossAttr9");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10IsNull() {
            addCriterion("profit_loss_attr_10 is null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10IsNotNull() {
            addCriterion("profit_loss_attr_10 is not null");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10EqualTo(String value) {
            addCriterion("profit_loss_attr_10 =", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10NotEqualTo(String value) {
            addCriterion("profit_loss_attr_10 <>", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10GreaterThan(String value) {
            addCriterion("profit_loss_attr_10 >", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10GreaterThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_10 >=", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10LessThan(String value) {
            addCriterion("profit_loss_attr_10 <", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10LessThanOrEqualTo(String value) {
            addCriterion("profit_loss_attr_10 <=", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10Like(String value) {
            addCriterion("profit_loss_attr_10 like", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10NotLike(String value) {
            addCriterion("profit_loss_attr_10 not like", value, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10In(List<String> values) {
            addCriterion("profit_loss_attr_10 in", values, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10NotIn(List<String> values) {
            addCriterion("profit_loss_attr_10 not in", values, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10Between(String value1, String value2) {
            addCriterion("profit_loss_attr_10 between", value1, value2, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andProfitLossAttr10NotBetween(String value1, String value2) {
            addCriterion("profit_loss_attr_10 not between", value1, value2, "profitLossAttr10");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrIsNull() {
            addCriterion("income_incr is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrIsNotNull() {
            addCriterion("income_incr is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrEqualTo(Long value) {
            addCriterion("income_incr =", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrNotEqualTo(Long value) {
            addCriterion("income_incr <>", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrGreaterThan(Long value) {
            addCriterion("income_incr >", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrGreaterThanOrEqualTo(Long value) {
            addCriterion("income_incr >=", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrLessThan(Long value) {
            addCriterion("income_incr <", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrLessThanOrEqualTo(Long value) {
            addCriterion("income_incr <=", value, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrIn(List<Long> values) {
            addCriterion("income_incr in", values, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrNotIn(List<Long> values) {
            addCriterion("income_incr not in", values, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrBetween(Long value1, Long value2) {
            addCriterion("income_incr between", value1, value2, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeIncrNotBetween(Long value1, Long value2) {
            addCriterion("income_incr not between", value1, value2, "incomeIncr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrIsNull() {
            addCriterion("income_decr is null");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrIsNotNull() {
            addCriterion("income_decr is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrEqualTo(Long value) {
            addCriterion("income_decr =", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrNotEqualTo(Long value) {
            addCriterion("income_decr <>", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrGreaterThan(Long value) {
            addCriterion("income_decr >", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrGreaterThanOrEqualTo(Long value) {
            addCriterion("income_decr >=", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrLessThan(Long value) {
            addCriterion("income_decr <", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrLessThanOrEqualTo(Long value) {
            addCriterion("income_decr <=", value, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrIn(List<Long> values) {
            addCriterion("income_decr in", values, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrNotIn(List<Long> values) {
            addCriterion("income_decr not in", values, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrBetween(Long value1, Long value2) {
            addCriterion("income_decr between", value1, value2, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andIncomeDecrNotBetween(Long value1, Long value2) {
            addCriterion("income_decr not between", value1, value2, "incomeDecr");
            return (Criteria) this;
        }

        public Criteria andCostIncrIsNull() {
            addCriterion("cost_incr is null");
            return (Criteria) this;
        }

        public Criteria andCostIncrIsNotNull() {
            addCriterion("cost_incr is not null");
            return (Criteria) this;
        }

        public Criteria andCostIncrEqualTo(Long value) {
            addCriterion("cost_incr =", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrNotEqualTo(Long value) {
            addCriterion("cost_incr <>", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrGreaterThan(Long value) {
            addCriterion("cost_incr >", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrGreaterThanOrEqualTo(Long value) {
            addCriterion("cost_incr >=", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrLessThan(Long value) {
            addCriterion("cost_incr <", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrLessThanOrEqualTo(Long value) {
            addCriterion("cost_incr <=", value, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrIn(List<Long> values) {
            addCriterion("cost_incr in", values, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrNotIn(List<Long> values) {
            addCriterion("cost_incr not in", values, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrBetween(Long value1, Long value2) {
            addCriterion("cost_incr between", value1, value2, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostIncrNotBetween(Long value1, Long value2) {
            addCriterion("cost_incr not between", value1, value2, "costIncr");
            return (Criteria) this;
        }

        public Criteria andCostDecrIsNull() {
            addCriterion("cost_decr is null");
            return (Criteria) this;
        }

        public Criteria andCostDecrIsNotNull() {
            addCriterion("cost_decr is not null");
            return (Criteria) this;
        }

        public Criteria andCostDecrEqualTo(Long value) {
            addCriterion("cost_decr =", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrNotEqualTo(Long value) {
            addCriterion("cost_decr <>", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrGreaterThan(Long value) {
            addCriterion("cost_decr >", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrGreaterThanOrEqualTo(Long value) {
            addCriterion("cost_decr >=", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrLessThan(Long value) {
            addCriterion("cost_decr <", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrLessThanOrEqualTo(Long value) {
            addCriterion("cost_decr <=", value, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrIn(List<Long> values) {
            addCriterion("cost_decr in", values, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrNotIn(List<Long> values) {
            addCriterion("cost_decr not in", values, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrBetween(Long value1, Long value2) {
            addCriterion("cost_decr between", value1, value2, "costDecr");
            return (Criteria) this;
        }

        public Criteria andCostDecrNotBetween(Long value1, Long value2) {
            addCriterion("cost_decr not between", value1, value2, "costDecr");
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