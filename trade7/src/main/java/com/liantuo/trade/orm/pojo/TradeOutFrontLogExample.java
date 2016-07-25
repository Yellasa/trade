package com.liantuo.trade.orm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeOutFrontLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeOutFrontLogExample() {
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

        public Criteria andReqCostTimeEqualTo(String value) {
            addCriterion("req_cost_time =", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotEqualTo(String value) {
            addCriterion("req_cost_time <>", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeGreaterThan(String value) {
            addCriterion("req_cost_time >", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeGreaterThanOrEqualTo(String value) {
            addCriterion("req_cost_time >=", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeLessThan(String value) {
            addCriterion("req_cost_time <", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeLessThanOrEqualTo(String value) {
            addCriterion("req_cost_time <=", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeLike(String value) {
            addCriterion("req_cost_time like", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotLike(String value) {
            addCriterion("req_cost_time not like", value, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeIn(List<String> values) {
            addCriterion("req_cost_time in", values, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotIn(List<String> values) {
            addCriterion("req_cost_time not in", values, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeBetween(String value1, String value2) {
            addCriterion("req_cost_time between", value1, value2, "reqCostTime");
            return (Criteria) this;
        }

        public Criteria andReqCostTimeNotBetween(String value1, String value2) {
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

        public Criteria andReqExtendField6IsNull() {
            addCriterion("req_extend_field_6 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6IsNotNull() {
            addCriterion("req_extend_field_6 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6EqualTo(String value) {
            addCriterion("req_extend_field_6 =", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6NotEqualTo(String value) {
            addCriterion("req_extend_field_6 <>", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6GreaterThan(String value) {
            addCriterion("req_extend_field_6 >", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_6 >=", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6LessThan(String value) {
            addCriterion("req_extend_field_6 <", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_6 <=", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6Like(String value) {
            addCriterion("req_extend_field_6 like", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6NotLike(String value) {
            addCriterion("req_extend_field_6 not like", value, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6In(List<String> values) {
            addCriterion("req_extend_field_6 in", values, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6NotIn(List<String> values) {
            addCriterion("req_extend_field_6 not in", values, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6Between(String value1, String value2) {
            addCriterion("req_extend_field_6 between", value1, value2, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField6NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_6 not between", value1, value2, "reqExtendField6");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7IsNull() {
            addCriterion("req_extend_field_7 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7IsNotNull() {
            addCriterion("req_extend_field_7 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7EqualTo(String value) {
            addCriterion("req_extend_field_7 =", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7NotEqualTo(String value) {
            addCriterion("req_extend_field_7 <>", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7GreaterThan(String value) {
            addCriterion("req_extend_field_7 >", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_7 >=", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7LessThan(String value) {
            addCriterion("req_extend_field_7 <", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_7 <=", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7Like(String value) {
            addCriterion("req_extend_field_7 like", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7NotLike(String value) {
            addCriterion("req_extend_field_7 not like", value, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7In(List<String> values) {
            addCriterion("req_extend_field_7 in", values, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7NotIn(List<String> values) {
            addCriterion("req_extend_field_7 not in", values, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7Between(String value1, String value2) {
            addCriterion("req_extend_field_7 between", value1, value2, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField7NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_7 not between", value1, value2, "reqExtendField7");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8IsNull() {
            addCriterion("req_extend_field_8 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8IsNotNull() {
            addCriterion("req_extend_field_8 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8EqualTo(String value) {
            addCriterion("req_extend_field_8 =", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8NotEqualTo(String value) {
            addCriterion("req_extend_field_8 <>", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8GreaterThan(String value) {
            addCriterion("req_extend_field_8 >", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_8 >=", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8LessThan(String value) {
            addCriterion("req_extend_field_8 <", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_8 <=", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8Like(String value) {
            addCriterion("req_extend_field_8 like", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8NotLike(String value) {
            addCriterion("req_extend_field_8 not like", value, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8In(List<String> values) {
            addCriterion("req_extend_field_8 in", values, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8NotIn(List<String> values) {
            addCriterion("req_extend_field_8 not in", values, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8Between(String value1, String value2) {
            addCriterion("req_extend_field_8 between", value1, value2, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField8NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_8 not between", value1, value2, "reqExtendField8");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9IsNull() {
            addCriterion("req_extend_field_9 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9IsNotNull() {
            addCriterion("req_extend_field_9 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9EqualTo(String value) {
            addCriterion("req_extend_field_9 =", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9NotEqualTo(String value) {
            addCriterion("req_extend_field_9 <>", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9GreaterThan(String value) {
            addCriterion("req_extend_field_9 >", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_9 >=", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9LessThan(String value) {
            addCriterion("req_extend_field_9 <", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_9 <=", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9Like(String value) {
            addCriterion("req_extend_field_9 like", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9NotLike(String value) {
            addCriterion("req_extend_field_9 not like", value, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9In(List<String> values) {
            addCriterion("req_extend_field_9 in", values, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9NotIn(List<String> values) {
            addCriterion("req_extend_field_9 not in", values, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9Between(String value1, String value2) {
            addCriterion("req_extend_field_9 between", value1, value2, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField9NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_9 not between", value1, value2, "reqExtendField9");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10IsNull() {
            addCriterion("req_extend_field_10 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10IsNotNull() {
            addCriterion("req_extend_field_10 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10EqualTo(String value) {
            addCriterion("req_extend_field_10 =", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10NotEqualTo(String value) {
            addCriterion("req_extend_field_10 <>", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10GreaterThan(String value) {
            addCriterion("req_extend_field_10 >", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_10 >=", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10LessThan(String value) {
            addCriterion("req_extend_field_10 <", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_10 <=", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10Like(String value) {
            addCriterion("req_extend_field_10 like", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10NotLike(String value) {
            addCriterion("req_extend_field_10 not like", value, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10In(List<String> values) {
            addCriterion("req_extend_field_10 in", values, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10NotIn(List<String> values) {
            addCriterion("req_extend_field_10 not in", values, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10Between(String value1, String value2) {
            addCriterion("req_extend_field_10 between", value1, value2, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField10NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_10 not between", value1, value2, "reqExtendField10");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11IsNull() {
            addCriterion("req_extend_field_11 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11IsNotNull() {
            addCriterion("req_extend_field_11 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11EqualTo(String value) {
            addCriterion("req_extend_field_11 =", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11NotEqualTo(String value) {
            addCriterion("req_extend_field_11 <>", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11GreaterThan(String value) {
            addCriterion("req_extend_field_11 >", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_11 >=", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11LessThan(String value) {
            addCriterion("req_extend_field_11 <", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_11 <=", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11Like(String value) {
            addCriterion("req_extend_field_11 like", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11NotLike(String value) {
            addCriterion("req_extend_field_11 not like", value, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11In(List<String> values) {
            addCriterion("req_extend_field_11 in", values, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11NotIn(List<String> values) {
            addCriterion("req_extend_field_11 not in", values, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11Between(String value1, String value2) {
            addCriterion("req_extend_field_11 between", value1, value2, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField11NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_11 not between", value1, value2, "reqExtendField11");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12IsNull() {
            addCriterion("req_extend_field_12 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12IsNotNull() {
            addCriterion("req_extend_field_12 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12EqualTo(String value) {
            addCriterion("req_extend_field_12 =", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12NotEqualTo(String value) {
            addCriterion("req_extend_field_12 <>", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12GreaterThan(String value) {
            addCriterion("req_extend_field_12 >", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_12 >=", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12LessThan(String value) {
            addCriterion("req_extend_field_12 <", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_12 <=", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12Like(String value) {
            addCriterion("req_extend_field_12 like", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12NotLike(String value) {
            addCriterion("req_extend_field_12 not like", value, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12In(List<String> values) {
            addCriterion("req_extend_field_12 in", values, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12NotIn(List<String> values) {
            addCriterion("req_extend_field_12 not in", values, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12Between(String value1, String value2) {
            addCriterion("req_extend_field_12 between", value1, value2, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField12NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_12 not between", value1, value2, "reqExtendField12");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13IsNull() {
            addCriterion("req_extend_field_13 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13IsNotNull() {
            addCriterion("req_extend_field_13 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13EqualTo(String value) {
            addCriterion("req_extend_field_13 =", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13NotEqualTo(String value) {
            addCriterion("req_extend_field_13 <>", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13GreaterThan(String value) {
            addCriterion("req_extend_field_13 >", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_13 >=", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13LessThan(String value) {
            addCriterion("req_extend_field_13 <", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_13 <=", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13Like(String value) {
            addCriterion("req_extend_field_13 like", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13NotLike(String value) {
            addCriterion("req_extend_field_13 not like", value, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13In(List<String> values) {
            addCriterion("req_extend_field_13 in", values, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13NotIn(List<String> values) {
            addCriterion("req_extend_field_13 not in", values, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13Between(String value1, String value2) {
            addCriterion("req_extend_field_13 between", value1, value2, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField13NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_13 not between", value1, value2, "reqExtendField13");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14IsNull() {
            addCriterion("req_extend_field_14 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14IsNotNull() {
            addCriterion("req_extend_field_14 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14EqualTo(String value) {
            addCriterion("req_extend_field_14 =", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14NotEqualTo(String value) {
            addCriterion("req_extend_field_14 <>", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14GreaterThan(String value) {
            addCriterion("req_extend_field_14 >", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_14 >=", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14LessThan(String value) {
            addCriterion("req_extend_field_14 <", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_14 <=", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14Like(String value) {
            addCriterion("req_extend_field_14 like", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14NotLike(String value) {
            addCriterion("req_extend_field_14 not like", value, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14In(List<String> values) {
            addCriterion("req_extend_field_14 in", values, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14NotIn(List<String> values) {
            addCriterion("req_extend_field_14 not in", values, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14Between(String value1, String value2) {
            addCriterion("req_extend_field_14 between", value1, value2, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField14NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_14 not between", value1, value2, "reqExtendField14");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15IsNull() {
            addCriterion("req_extend_field_15 is null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15IsNotNull() {
            addCriterion("req_extend_field_15 is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15EqualTo(String value) {
            addCriterion("req_extend_field_15 =", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15NotEqualTo(String value) {
            addCriterion("req_extend_field_15 <>", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15GreaterThan(String value) {
            addCriterion("req_extend_field_15 >", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15GreaterThanOrEqualTo(String value) {
            addCriterion("req_extend_field_15 >=", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15LessThan(String value) {
            addCriterion("req_extend_field_15 <", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15LessThanOrEqualTo(String value) {
            addCriterion("req_extend_field_15 <=", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15Like(String value) {
            addCriterion("req_extend_field_15 like", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15NotLike(String value) {
            addCriterion("req_extend_field_15 not like", value, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15In(List<String> values) {
            addCriterion("req_extend_field_15 in", values, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15NotIn(List<String> values) {
            addCriterion("req_extend_field_15 not in", values, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15Between(String value1, String value2) {
            addCriterion("req_extend_field_15 between", value1, value2, "reqExtendField15");
            return (Criteria) this;
        }

        public Criteria andReqExtendField15NotBetween(String value1, String value2) {
            addCriterion("req_extend_field_15 not between", value1, value2, "reqExtendField15");
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