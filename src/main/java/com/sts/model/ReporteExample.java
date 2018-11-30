package com.sts.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReporteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReporteExample() {
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

        public Criteria andReporteIdIsNull() {
            addCriterion("reporte_id is null");
            return (Criteria) this;
        }

        public Criteria andReporteIdIsNotNull() {
            addCriterion("reporte_id is not null");
            return (Criteria) this;
        }

        public Criteria andReporteIdEqualTo(Integer value) {
            addCriterion("reporte_id =", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdNotEqualTo(Integer value) {
            addCriterion("reporte_id <>", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdGreaterThan(Integer value) {
            addCriterion("reporte_id >", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reporte_id >=", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdLessThan(Integer value) {
            addCriterion("reporte_id <", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdLessThanOrEqualTo(Integer value) {
            addCriterion("reporte_id <=", value, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdIn(List<Integer> values) {
            addCriterion("reporte_id in", values, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdNotIn(List<Integer> values) {
            addCriterion("reporte_id not in", values, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdBetween(Integer value1, Integer value2) {
            addCriterion("reporte_id between", value1, value2, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reporte_id not between", value1, value2, "reporteId");
            return (Criteria) this;
        }

        public Criteria andReporteInfoIsNull() {
            addCriterion("reporte_info is null");
            return (Criteria) this;
        }

        public Criteria andReporteInfoIsNotNull() {
            addCriterion("reporte_info is not null");
            return (Criteria) this;
        }

        public Criteria andReporteInfoEqualTo(String value) {
            addCriterion("reporte_info =", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoNotEqualTo(String value) {
            addCriterion("reporte_info <>", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoGreaterThan(String value) {
            addCriterion("reporte_info >", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoGreaterThanOrEqualTo(String value) {
            addCriterion("reporte_info >=", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoLessThan(String value) {
            addCriterion("reporte_info <", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoLessThanOrEqualTo(String value) {
            addCriterion("reporte_info <=", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoLike(String value) {
            addCriterion("reporte_info like", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoNotLike(String value) {
            addCriterion("reporte_info not like", value, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoIn(List<String> values) {
            addCriterion("reporte_info in", values, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoNotIn(List<String> values) {
            addCriterion("reporte_info not in", values, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoBetween(String value1, String value2) {
            addCriterion("reporte_info between", value1, value2, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteInfoNotBetween(String value1, String value2) {
            addCriterion("reporte_info not between", value1, value2, "reporteInfo");
            return (Criteria) this;
        }

        public Criteria andReporteTimeIsNull() {
            addCriterion("reporte_time is null");
            return (Criteria) this;
        }

        public Criteria andReporteTimeIsNotNull() {
            addCriterion("reporte_time is not null");
            return (Criteria) this;
        }

        public Criteria andReporteTimeEqualTo(Date value) {
            addCriterion("reporte_time =", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeNotEqualTo(Date value) {
            addCriterion("reporte_time <>", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeGreaterThan(Date value) {
            addCriterion("reporte_time >", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reporte_time >=", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeLessThan(Date value) {
            addCriterion("reporte_time <", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeLessThanOrEqualTo(Date value) {
            addCriterion("reporte_time <=", value, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeIn(List<Date> values) {
            addCriterion("reporte_time in", values, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeNotIn(List<Date> values) {
            addCriterion("reporte_time not in", values, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeBetween(Date value1, Date value2) {
            addCriterion("reporte_time between", value1, value2, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andReporteTimeNotBetween(Date value1, Date value2) {
            addCriterion("reporte_time not between", value1, value2, "reporteTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
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