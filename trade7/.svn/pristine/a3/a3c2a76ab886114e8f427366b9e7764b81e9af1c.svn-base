package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeLedgerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeLedgerExample() {
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

        public Criteria andClearChannelAttr1IsNull() {
            addCriterion("clear_channel_attr_1 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1IsNotNull() {
            addCriterion("clear_channel_attr_1 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1EqualTo(String value) {
            addCriterion("clear_channel_attr_1 =", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1NotEqualTo(String value) {
            addCriterion("clear_channel_attr_1 <>", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1GreaterThan(String value) {
            addCriterion("clear_channel_attr_1 >", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_1 >=", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1LessThan(String value) {
            addCriterion("clear_channel_attr_1 <", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_1 <=", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1Like(String value) {
            addCriterion("clear_channel_attr_1 like", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1NotLike(String value) {
            addCriterion("clear_channel_attr_1 not like", value, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1In(List<String> values) {
            addCriterion("clear_channel_attr_1 in", values, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1NotIn(List<String> values) {
            addCriterion("clear_channel_attr_1 not in", values, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1Between(String value1, String value2) {
            addCriterion("clear_channel_attr_1 between", value1, value2, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr1NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_1 not between", value1, value2, "clearChannelAttr1");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2IsNull() {
            addCriterion("clear_channel_attr_2 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2IsNotNull() {
            addCriterion("clear_channel_attr_2 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2EqualTo(String value) {
            addCriterion("clear_channel_attr_2 =", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2NotEqualTo(String value) {
            addCriterion("clear_channel_attr_2 <>", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2GreaterThan(String value) {
            addCriterion("clear_channel_attr_2 >", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_2 >=", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2LessThan(String value) {
            addCriterion("clear_channel_attr_2 <", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_2 <=", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2Like(String value) {
            addCriterion("clear_channel_attr_2 like", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2NotLike(String value) {
            addCriterion("clear_channel_attr_2 not like", value, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2In(List<String> values) {
            addCriterion("clear_channel_attr_2 in", values, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2NotIn(List<String> values) {
            addCriterion("clear_channel_attr_2 not in", values, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2Between(String value1, String value2) {
            addCriterion("clear_channel_attr_2 between", value1, value2, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr2NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_2 not between", value1, value2, "clearChannelAttr2");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3IsNull() {
            addCriterion("clear_channel_attr_3 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3IsNotNull() {
            addCriterion("clear_channel_attr_3 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3EqualTo(String value) {
            addCriterion("clear_channel_attr_3 =", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3NotEqualTo(String value) {
            addCriterion("clear_channel_attr_3 <>", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3GreaterThan(String value) {
            addCriterion("clear_channel_attr_3 >", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_3 >=", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3LessThan(String value) {
            addCriterion("clear_channel_attr_3 <", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_3 <=", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3Like(String value) {
            addCriterion("clear_channel_attr_3 like", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3NotLike(String value) {
            addCriterion("clear_channel_attr_3 not like", value, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3In(List<String> values) {
            addCriterion("clear_channel_attr_3 in", values, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3NotIn(List<String> values) {
            addCriterion("clear_channel_attr_3 not in", values, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3Between(String value1, String value2) {
            addCriterion("clear_channel_attr_3 between", value1, value2, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr3NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_3 not between", value1, value2, "clearChannelAttr3");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4IsNull() {
            addCriterion("clear_channel_attr_4 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4IsNotNull() {
            addCriterion("clear_channel_attr_4 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4EqualTo(String value) {
            addCriterion("clear_channel_attr_4 =", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4NotEqualTo(String value) {
            addCriterion("clear_channel_attr_4 <>", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4GreaterThan(String value) {
            addCriterion("clear_channel_attr_4 >", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_4 >=", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4LessThan(String value) {
            addCriterion("clear_channel_attr_4 <", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_4 <=", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4Like(String value) {
            addCriterion("clear_channel_attr_4 like", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4NotLike(String value) {
            addCriterion("clear_channel_attr_4 not like", value, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4In(List<String> values) {
            addCriterion("clear_channel_attr_4 in", values, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4NotIn(List<String> values) {
            addCriterion("clear_channel_attr_4 not in", values, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4Between(String value1, String value2) {
            addCriterion("clear_channel_attr_4 between", value1, value2, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr4NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_4 not between", value1, value2, "clearChannelAttr4");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5IsNull() {
            addCriterion("clear_channel_attr_5 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5IsNotNull() {
            addCriterion("clear_channel_attr_5 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5EqualTo(String value) {
            addCriterion("clear_channel_attr_5 =", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5NotEqualTo(String value) {
            addCriterion("clear_channel_attr_5 <>", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5GreaterThan(String value) {
            addCriterion("clear_channel_attr_5 >", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_5 >=", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5LessThan(String value) {
            addCriterion("clear_channel_attr_5 <", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_5 <=", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5Like(String value) {
            addCriterion("clear_channel_attr_5 like", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5NotLike(String value) {
            addCriterion("clear_channel_attr_5 not like", value, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5In(List<String> values) {
            addCriterion("clear_channel_attr_5 in", values, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5NotIn(List<String> values) {
            addCriterion("clear_channel_attr_5 not in", values, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5Between(String value1, String value2) {
            addCriterion("clear_channel_attr_5 between", value1, value2, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr5NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_5 not between", value1, value2, "clearChannelAttr5");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6IsNull() {
            addCriterion("clear_channel_attr_6 is null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6IsNotNull() {
            addCriterion("clear_channel_attr_6 is not null");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6EqualTo(String value) {
            addCriterion("clear_channel_attr_6 =", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6NotEqualTo(String value) {
            addCriterion("clear_channel_attr_6 <>", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6GreaterThan(String value) {
            addCriterion("clear_channel_attr_6 >", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6GreaterThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_6 >=", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6LessThan(String value) {
            addCriterion("clear_channel_attr_6 <", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6LessThanOrEqualTo(String value) {
            addCriterion("clear_channel_attr_6 <=", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6Like(String value) {
            addCriterion("clear_channel_attr_6 like", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6NotLike(String value) {
            addCriterion("clear_channel_attr_6 not like", value, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6In(List<String> values) {
            addCriterion("clear_channel_attr_6 in", values, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6NotIn(List<String> values) {
            addCriterion("clear_channel_attr_6 not in", values, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6Between(String value1, String value2) {
            addCriterion("clear_channel_attr_6 between", value1, value2, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andClearChannelAttr6NotBetween(String value1, String value2) {
            addCriterion("clear_channel_attr_6 not between", value1, value2, "clearChannelAttr6");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIsNull() {
            addCriterion("payment_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIsNotNull() {
            addCriterion("payment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountEqualTo(Long value) {
            addCriterion("payment_amount =", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotEqualTo(Long value) {
            addCriterion("payment_amount <>", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountGreaterThan(Long value) {
            addCriterion("payment_amount >", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_amount >=", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountLessThan(Long value) {
            addCriterion("payment_amount <", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountLessThanOrEqualTo(Long value) {
            addCriterion("payment_amount <=", value, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountIn(List<Long> values) {
            addCriterion("payment_amount in", values, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotIn(List<Long> values) {
            addCriterion("payment_amount not in", values, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountBetween(Long value1, Long value2) {
            addCriterion("payment_amount between", value1, value2, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentAmountNotBetween(Long value1, Long value2) {
            addCriterion("payment_amount not between", value1, value2, "paymentAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNull() {
            addCriterion("receive_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIsNotNull() {
            addCriterion("receive_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountEqualTo(Long value) {
            addCriterion("receive_amount =", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotEqualTo(Long value) {
            addCriterion("receive_amount <>", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThan(Long value) {
            addCriterion("receive_amount >", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("receive_amount >=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThan(Long value) {
            addCriterion("receive_amount <", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountLessThanOrEqualTo(Long value) {
            addCriterion("receive_amount <=", value, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountIn(List<Long> values) {
            addCriterion("receive_amount in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotIn(List<Long> values) {
            addCriterion("receive_amount not in", values, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountBetween(Long value1, Long value2) {
            addCriterion("receive_amount between", value1, value2, "receiveAmount");
            return (Criteria) this;
        }

        public Criteria andReceiveAmountNotBetween(Long value1, Long value2) {
            addCriterion("receive_amount not between", value1, value2, "receiveAmount");
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

        public Criteria andThirdTradeNoIsNull() {
            addCriterion("third_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoIsNotNull() {
            addCriterion("third_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoEqualTo(String value) {
            addCriterion("third_trade_no =", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoNotEqualTo(String value) {
            addCriterion("third_trade_no <>", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoGreaterThan(String value) {
            addCriterion("third_trade_no >", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("third_trade_no >=", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoLessThan(String value) {
            addCriterion("third_trade_no <", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoLessThanOrEqualTo(String value) {
            addCriterion("third_trade_no <=", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoLike(String value) {
            addCriterion("third_trade_no like", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoNotLike(String value) {
            addCriterion("third_trade_no not like", value, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoIn(List<String> values) {
            addCriterion("third_trade_no in", values, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoNotIn(List<String> values) {
            addCriterion("third_trade_no not in", values, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoBetween(String value1, String value2) {
            addCriterion("third_trade_no between", value1, value2, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andThirdTradeNoNotBetween(String value1, String value2) {
            addCriterion("third_trade_no not between", value1, value2, "thirdTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoIsNull() {
            addCriterion("payment_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoIsNotNull() {
            addCriterion("payment_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoEqualTo(String value) {
            addCriterion("payment_trade_no =", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoNotEqualTo(String value) {
            addCriterion("payment_trade_no <>", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoGreaterThan(String value) {
            addCriterion("payment_trade_no >", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("payment_trade_no >=", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoLessThan(String value) {
            addCriterion("payment_trade_no <", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoLessThanOrEqualTo(String value) {
            addCriterion("payment_trade_no <=", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoLike(String value) {
            addCriterion("payment_trade_no like", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoNotLike(String value) {
            addCriterion("payment_trade_no not like", value, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoIn(List<String> values) {
            addCriterion("payment_trade_no in", values, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoNotIn(List<String> values) {
            addCriterion("payment_trade_no not in", values, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoBetween(String value1, String value2) {
            addCriterion("payment_trade_no between", value1, value2, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andPaymentTradeNoNotBetween(String value1, String value2) {
            addCriterion("payment_trade_no not between", value1, value2, "paymentTradeNo");
            return (Criteria) this;
        }

        public Criteria andExtendField1IsNull() {
            addCriterion("extend_field_1 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField1IsNotNull() {
            addCriterion("extend_field_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField1EqualTo(String value) {
            addCriterion("extend_field_1 =", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1NotEqualTo(String value) {
            addCriterion("extend_field_1 <>", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1GreaterThan(String value) {
            addCriterion("extend_field_1 >", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_1 >=", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1LessThan(String value) {
            addCriterion("extend_field_1 <", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1LessThanOrEqualTo(String value) {
            addCriterion("extend_field_1 <=", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1Like(String value) {
            addCriterion("extend_field_1 like", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1NotLike(String value) {
            addCriterion("extend_field_1 not like", value, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1In(List<String> values) {
            addCriterion("extend_field_1 in", values, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1NotIn(List<String> values) {
            addCriterion("extend_field_1 not in", values, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1Between(String value1, String value2) {
            addCriterion("extend_field_1 between", value1, value2, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField1NotBetween(String value1, String value2) {
            addCriterion("extend_field_1 not between", value1, value2, "extendField1");
            return (Criteria) this;
        }

        public Criteria andExtendField2IsNull() {
            addCriterion("extend_field_2 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField2IsNotNull() {
            addCriterion("extend_field_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField2EqualTo(String value) {
            addCriterion("extend_field_2 =", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2NotEqualTo(String value) {
            addCriterion("extend_field_2 <>", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2GreaterThan(String value) {
            addCriterion("extend_field_2 >", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_2 >=", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2LessThan(String value) {
            addCriterion("extend_field_2 <", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2LessThanOrEqualTo(String value) {
            addCriterion("extend_field_2 <=", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2Like(String value) {
            addCriterion("extend_field_2 like", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2NotLike(String value) {
            addCriterion("extend_field_2 not like", value, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2In(List<String> values) {
            addCriterion("extend_field_2 in", values, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2NotIn(List<String> values) {
            addCriterion("extend_field_2 not in", values, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2Between(String value1, String value2) {
            addCriterion("extend_field_2 between", value1, value2, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField2NotBetween(String value1, String value2) {
            addCriterion("extend_field_2 not between", value1, value2, "extendField2");
            return (Criteria) this;
        }

        public Criteria andExtendField3IsNull() {
            addCriterion("extend_field_3 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField3IsNotNull() {
            addCriterion("extend_field_3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField3EqualTo(String value) {
            addCriterion("extend_field_3 =", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3NotEqualTo(String value) {
            addCriterion("extend_field_3 <>", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3GreaterThan(String value) {
            addCriterion("extend_field_3 >", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_3 >=", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3LessThan(String value) {
            addCriterion("extend_field_3 <", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3LessThanOrEqualTo(String value) {
            addCriterion("extend_field_3 <=", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3Like(String value) {
            addCriterion("extend_field_3 like", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3NotLike(String value) {
            addCriterion("extend_field_3 not like", value, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3In(List<String> values) {
            addCriterion("extend_field_3 in", values, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3NotIn(List<String> values) {
            addCriterion("extend_field_3 not in", values, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3Between(String value1, String value2) {
            addCriterion("extend_field_3 between", value1, value2, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField3NotBetween(String value1, String value2) {
            addCriterion("extend_field_3 not between", value1, value2, "extendField3");
            return (Criteria) this;
        }

        public Criteria andExtendField4IsNull() {
            addCriterion("extend_field_4 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField4IsNotNull() {
            addCriterion("extend_field_4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField4EqualTo(String value) {
            addCriterion("extend_field_4 =", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4NotEqualTo(String value) {
            addCriterion("extend_field_4 <>", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4GreaterThan(String value) {
            addCriterion("extend_field_4 >", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_4 >=", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4LessThan(String value) {
            addCriterion("extend_field_4 <", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4LessThanOrEqualTo(String value) {
            addCriterion("extend_field_4 <=", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4Like(String value) {
            addCriterion("extend_field_4 like", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4NotLike(String value) {
            addCriterion("extend_field_4 not like", value, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4In(List<String> values) {
            addCriterion("extend_field_4 in", values, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4NotIn(List<String> values) {
            addCriterion("extend_field_4 not in", values, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4Between(String value1, String value2) {
            addCriterion("extend_field_4 between", value1, value2, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField4NotBetween(String value1, String value2) {
            addCriterion("extend_field_4 not between", value1, value2, "extendField4");
            return (Criteria) this;
        }

        public Criteria andExtendField5IsNull() {
            addCriterion("extend_field_5 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField5IsNotNull() {
            addCriterion("extend_field_5 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField5EqualTo(String value) {
            addCriterion("extend_field_5 =", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5NotEqualTo(String value) {
            addCriterion("extend_field_5 <>", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5GreaterThan(String value) {
            addCriterion("extend_field_5 >", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_5 >=", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5LessThan(String value) {
            addCriterion("extend_field_5 <", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5LessThanOrEqualTo(String value) {
            addCriterion("extend_field_5 <=", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5Like(String value) {
            addCriterion("extend_field_5 like", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5NotLike(String value) {
            addCriterion("extend_field_5 not like", value, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5In(List<String> values) {
            addCriterion("extend_field_5 in", values, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5NotIn(List<String> values) {
            addCriterion("extend_field_5 not in", values, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5Between(String value1, String value2) {
            addCriterion("extend_field_5 between", value1, value2, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField5NotBetween(String value1, String value2) {
            addCriterion("extend_field_5 not between", value1, value2, "extendField5");
            return (Criteria) this;
        }

        public Criteria andExtendField6IsNull() {
            addCriterion("extend_field_6 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField6IsNotNull() {
            addCriterion("extend_field_6 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField6EqualTo(String value) {
            addCriterion("extend_field_6 =", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6NotEqualTo(String value) {
            addCriterion("extend_field_6 <>", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6GreaterThan(String value) {
            addCriterion("extend_field_6 >", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_6 >=", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6LessThan(String value) {
            addCriterion("extend_field_6 <", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6LessThanOrEqualTo(String value) {
            addCriterion("extend_field_6 <=", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6Like(String value) {
            addCriterion("extend_field_6 like", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6NotLike(String value) {
            addCriterion("extend_field_6 not like", value, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6In(List<String> values) {
            addCriterion("extend_field_6 in", values, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6NotIn(List<String> values) {
            addCriterion("extend_field_6 not in", values, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6Between(String value1, String value2) {
            addCriterion("extend_field_6 between", value1, value2, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField6NotBetween(String value1, String value2) {
            addCriterion("extend_field_6 not between", value1, value2, "extendField6");
            return (Criteria) this;
        }

        public Criteria andExtendField7IsNull() {
            addCriterion("extend_field_7 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField7IsNotNull() {
            addCriterion("extend_field_7 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField7EqualTo(String value) {
            addCriterion("extend_field_7 =", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7NotEqualTo(String value) {
            addCriterion("extend_field_7 <>", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7GreaterThan(String value) {
            addCriterion("extend_field_7 >", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_7 >=", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7LessThan(String value) {
            addCriterion("extend_field_7 <", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7LessThanOrEqualTo(String value) {
            addCriterion("extend_field_7 <=", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7Like(String value) {
            addCriterion("extend_field_7 like", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7NotLike(String value) {
            addCriterion("extend_field_7 not like", value, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7In(List<String> values) {
            addCriterion("extend_field_7 in", values, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7NotIn(List<String> values) {
            addCriterion("extend_field_7 not in", values, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7Between(String value1, String value2) {
            addCriterion("extend_field_7 between", value1, value2, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField7NotBetween(String value1, String value2) {
            addCriterion("extend_field_7 not between", value1, value2, "extendField7");
            return (Criteria) this;
        }

        public Criteria andExtendField8IsNull() {
            addCriterion("extend_field_8 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField8IsNotNull() {
            addCriterion("extend_field_8 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField8EqualTo(String value) {
            addCriterion("extend_field_8 =", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8NotEqualTo(String value) {
            addCriterion("extend_field_8 <>", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8GreaterThan(String value) {
            addCriterion("extend_field_8 >", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_8 >=", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8LessThan(String value) {
            addCriterion("extend_field_8 <", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8LessThanOrEqualTo(String value) {
            addCriterion("extend_field_8 <=", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8Like(String value) {
            addCriterion("extend_field_8 like", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8NotLike(String value) {
            addCriterion("extend_field_8 not like", value, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8In(List<String> values) {
            addCriterion("extend_field_8 in", values, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8NotIn(List<String> values) {
            addCriterion("extend_field_8 not in", values, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8Between(String value1, String value2) {
            addCriterion("extend_field_8 between", value1, value2, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField8NotBetween(String value1, String value2) {
            addCriterion("extend_field_8 not between", value1, value2, "extendField8");
            return (Criteria) this;
        }

        public Criteria andExtendField9IsNull() {
            addCriterion("extend_field_9 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField9IsNotNull() {
            addCriterion("extend_field_9 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField9EqualTo(String value) {
            addCriterion("extend_field_9 =", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9NotEqualTo(String value) {
            addCriterion("extend_field_9 <>", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9GreaterThan(String value) {
            addCriterion("extend_field_9 >", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_9 >=", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9LessThan(String value) {
            addCriterion("extend_field_9 <", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9LessThanOrEqualTo(String value) {
            addCriterion("extend_field_9 <=", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9Like(String value) {
            addCriterion("extend_field_9 like", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9NotLike(String value) {
            addCriterion("extend_field_9 not like", value, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9In(List<String> values) {
            addCriterion("extend_field_9 in", values, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9NotIn(List<String> values) {
            addCriterion("extend_field_9 not in", values, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9Between(String value1, String value2) {
            addCriterion("extend_field_9 between", value1, value2, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField9NotBetween(String value1, String value2) {
            addCriterion("extend_field_9 not between", value1, value2, "extendField9");
            return (Criteria) this;
        }

        public Criteria andExtendField10IsNull() {
            addCriterion("extend_field_10 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField10IsNotNull() {
            addCriterion("extend_field_10 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField10EqualTo(String value) {
            addCriterion("extend_field_10 =", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10NotEqualTo(String value) {
            addCriterion("extend_field_10 <>", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10GreaterThan(String value) {
            addCriterion("extend_field_10 >", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_10 >=", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10LessThan(String value) {
            addCriterion("extend_field_10 <", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10LessThanOrEqualTo(String value) {
            addCriterion("extend_field_10 <=", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10Like(String value) {
            addCriterion("extend_field_10 like", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10NotLike(String value) {
            addCriterion("extend_field_10 not like", value, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10In(List<String> values) {
            addCriterion("extend_field_10 in", values, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10NotIn(List<String> values) {
            addCriterion("extend_field_10 not in", values, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10Between(String value1, String value2) {
            addCriterion("extend_field_10 between", value1, value2, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField10NotBetween(String value1, String value2) {
            addCriterion("extend_field_10 not between", value1, value2, "extendField10");
            return (Criteria) this;
        }

        public Criteria andExtendField11IsNull() {
            addCriterion("extend_field_11 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField11IsNotNull() {
            addCriterion("extend_field_11 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField11EqualTo(String value) {
            addCriterion("extend_field_11 =", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11NotEqualTo(String value) {
            addCriterion("extend_field_11 <>", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11GreaterThan(String value) {
            addCriterion("extend_field_11 >", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_11 >=", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11LessThan(String value) {
            addCriterion("extend_field_11 <", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11LessThanOrEqualTo(String value) {
            addCriterion("extend_field_11 <=", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11Like(String value) {
            addCriterion("extend_field_11 like", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11NotLike(String value) {
            addCriterion("extend_field_11 not like", value, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11In(List<String> values) {
            addCriterion("extend_field_11 in", values, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11NotIn(List<String> values) {
            addCriterion("extend_field_11 not in", values, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11Between(String value1, String value2) {
            addCriterion("extend_field_11 between", value1, value2, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField11NotBetween(String value1, String value2) {
            addCriterion("extend_field_11 not between", value1, value2, "extendField11");
            return (Criteria) this;
        }

        public Criteria andExtendField12IsNull() {
            addCriterion("extend_field_12 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField12IsNotNull() {
            addCriterion("extend_field_12 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField12EqualTo(String value) {
            addCriterion("extend_field_12 =", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12NotEqualTo(String value) {
            addCriterion("extend_field_12 <>", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12GreaterThan(String value) {
            addCriterion("extend_field_12 >", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_12 >=", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12LessThan(String value) {
            addCriterion("extend_field_12 <", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12LessThanOrEqualTo(String value) {
            addCriterion("extend_field_12 <=", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12Like(String value) {
            addCriterion("extend_field_12 like", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12NotLike(String value) {
            addCriterion("extend_field_12 not like", value, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12In(List<String> values) {
            addCriterion("extend_field_12 in", values, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12NotIn(List<String> values) {
            addCriterion("extend_field_12 not in", values, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12Between(String value1, String value2) {
            addCriterion("extend_field_12 between", value1, value2, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField12NotBetween(String value1, String value2) {
            addCriterion("extend_field_12 not between", value1, value2, "extendField12");
            return (Criteria) this;
        }

        public Criteria andExtendField13IsNull() {
            addCriterion("extend_field_13 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField13IsNotNull() {
            addCriterion("extend_field_13 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField13EqualTo(String value) {
            addCriterion("extend_field_13 =", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13NotEqualTo(String value) {
            addCriterion("extend_field_13 <>", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13GreaterThan(String value) {
            addCriterion("extend_field_13 >", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_13 >=", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13LessThan(String value) {
            addCriterion("extend_field_13 <", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13LessThanOrEqualTo(String value) {
            addCriterion("extend_field_13 <=", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13Like(String value) {
            addCriterion("extend_field_13 like", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13NotLike(String value) {
            addCriterion("extend_field_13 not like", value, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13In(List<String> values) {
            addCriterion("extend_field_13 in", values, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13NotIn(List<String> values) {
            addCriterion("extend_field_13 not in", values, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13Between(String value1, String value2) {
            addCriterion("extend_field_13 between", value1, value2, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField13NotBetween(String value1, String value2) {
            addCriterion("extend_field_13 not between", value1, value2, "extendField13");
            return (Criteria) this;
        }

        public Criteria andExtendField14IsNull() {
            addCriterion("extend_field_14 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField14IsNotNull() {
            addCriterion("extend_field_14 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField14EqualTo(String value) {
            addCriterion("extend_field_14 =", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14NotEqualTo(String value) {
            addCriterion("extend_field_14 <>", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14GreaterThan(String value) {
            addCriterion("extend_field_14 >", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_14 >=", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14LessThan(String value) {
            addCriterion("extend_field_14 <", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14LessThanOrEqualTo(String value) {
            addCriterion("extend_field_14 <=", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14Like(String value) {
            addCriterion("extend_field_14 like", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14NotLike(String value) {
            addCriterion("extend_field_14 not like", value, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14In(List<String> values) {
            addCriterion("extend_field_14 in", values, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14NotIn(List<String> values) {
            addCriterion("extend_field_14 not in", values, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14Between(String value1, String value2) {
            addCriterion("extend_field_14 between", value1, value2, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField14NotBetween(String value1, String value2) {
            addCriterion("extend_field_14 not between", value1, value2, "extendField14");
            return (Criteria) this;
        }

        public Criteria andExtendField15IsNull() {
            addCriterion("extend_field_15 is null");
            return (Criteria) this;
        }

        public Criteria andExtendField15IsNotNull() {
            addCriterion("extend_field_15 is not null");
            return (Criteria) this;
        }

        public Criteria andExtendField15EqualTo(String value) {
            addCriterion("extend_field_15 =", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15NotEqualTo(String value) {
            addCriterion("extend_field_15 <>", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15GreaterThan(String value) {
            addCriterion("extend_field_15 >", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15GreaterThanOrEqualTo(String value) {
            addCriterion("extend_field_15 >=", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15LessThan(String value) {
            addCriterion("extend_field_15 <", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15LessThanOrEqualTo(String value) {
            addCriterion("extend_field_15 <=", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15Like(String value) {
            addCriterion("extend_field_15 like", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15NotLike(String value) {
            addCriterion("extend_field_15 not like", value, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15In(List<String> values) {
            addCriterion("extend_field_15 in", values, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15NotIn(List<String> values) {
            addCriterion("extend_field_15 not in", values, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15Between(String value1, String value2) {
            addCriterion("extend_field_15 between", value1, value2, "extendField15");
            return (Criteria) this;
        }

        public Criteria andExtendField15NotBetween(String value1, String value2) {
            addCriterion("extend_field_15 not between", value1, value2, "extendField15");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_ledger
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