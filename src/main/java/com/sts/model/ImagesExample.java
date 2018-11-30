package com.sts.model;

import java.util.ArrayList;
import java.util.List;

public class ImagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImagesExample() {
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

        public Criteria andImagesIdIsNull() {
            addCriterion("images_id is null");
            return (Criteria) this;
        }

        public Criteria andImagesIdIsNotNull() {
            addCriterion("images_id is not null");
            return (Criteria) this;
        }

        public Criteria andImagesIdEqualTo(Integer value) {
            addCriterion("images_id =", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotEqualTo(Integer value) {
            addCriterion("images_id <>", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdGreaterThan(Integer value) {
            addCriterion("images_id >", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("images_id >=", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdLessThan(Integer value) {
            addCriterion("images_id <", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdLessThanOrEqualTo(Integer value) {
            addCriterion("images_id <=", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdIn(List<Integer> values) {
            addCriterion("images_id in", values, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotIn(List<Integer> values) {
            addCriterion("images_id not in", values, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdBetween(Integer value1, Integer value2) {
            addCriterion("images_id between", value1, value2, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("images_id not between", value1, value2, "imagesId");
            return (Criteria) this;
        }

        public Criteria andPath1IsNull() {
            addCriterion("path1 is null");
            return (Criteria) this;
        }

        public Criteria andPath1IsNotNull() {
            addCriterion("path1 is not null");
            return (Criteria) this;
        }

        public Criteria andPath1EqualTo(String value) {
            addCriterion("path1 =", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1NotEqualTo(String value) {
            addCriterion("path1 <>", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1GreaterThan(String value) {
            addCriterion("path1 >", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1GreaterThanOrEqualTo(String value) {
            addCriterion("path1 >=", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1LessThan(String value) {
            addCriterion("path1 <", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1LessThanOrEqualTo(String value) {
            addCriterion("path1 <=", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1Like(String value) {
            addCriterion("path1 like", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1NotLike(String value) {
            addCriterion("path1 not like", value, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1In(List<String> values) {
            addCriterion("path1 in", values, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1NotIn(List<String> values) {
            addCriterion("path1 not in", values, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1Between(String value1, String value2) {
            addCriterion("path1 between", value1, value2, "path1");
            return (Criteria) this;
        }

        public Criteria andPath1NotBetween(String value1, String value2) {
            addCriterion("path1 not between", value1, value2, "path1");
            return (Criteria) this;
        }

        public Criteria andPath2IsNull() {
            addCriterion("path2 is null");
            return (Criteria) this;
        }

        public Criteria andPath2IsNotNull() {
            addCriterion("path2 is not null");
            return (Criteria) this;
        }

        public Criteria andPath2EqualTo(String value) {
            addCriterion("path2 =", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotEqualTo(String value) {
            addCriterion("path2 <>", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThan(String value) {
            addCriterion("path2 >", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThanOrEqualTo(String value) {
            addCriterion("path2 >=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThan(String value) {
            addCriterion("path2 <", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThanOrEqualTo(String value) {
            addCriterion("path2 <=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Like(String value) {
            addCriterion("path2 like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotLike(String value) {
            addCriterion("path2 not like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2In(List<String> values) {
            addCriterion("path2 in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotIn(List<String> values) {
            addCriterion("path2 not in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Between(String value1, String value2) {
            addCriterion("path2 between", value1, value2, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotBetween(String value1, String value2) {
            addCriterion("path2 not between", value1, value2, "path2");
            return (Criteria) this;
        }

        public Criteria andPath3IsNull() {
            addCriterion("path3 is null");
            return (Criteria) this;
        }

        public Criteria andPath3IsNotNull() {
            addCriterion("path3 is not null");
            return (Criteria) this;
        }

        public Criteria andPath3EqualTo(String value) {
            addCriterion("path3 =", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotEqualTo(String value) {
            addCriterion("path3 <>", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3GreaterThan(String value) {
            addCriterion("path3 >", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3GreaterThanOrEqualTo(String value) {
            addCriterion("path3 >=", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3LessThan(String value) {
            addCriterion("path3 <", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3LessThanOrEqualTo(String value) {
            addCriterion("path3 <=", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3Like(String value) {
            addCriterion("path3 like", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotLike(String value) {
            addCriterion("path3 not like", value, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3In(List<String> values) {
            addCriterion("path3 in", values, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotIn(List<String> values) {
            addCriterion("path3 not in", values, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3Between(String value1, String value2) {
            addCriterion("path3 between", value1, value2, "path3");
            return (Criteria) this;
        }

        public Criteria andPath3NotBetween(String value1, String value2) {
            addCriterion("path3 not between", value1, value2, "path3");
            return (Criteria) this;
        }

        public Criteria andPath4IsNull() {
            addCriterion("path4 is null");
            return (Criteria) this;
        }

        public Criteria andPath4IsNotNull() {
            addCriterion("path4 is not null");
            return (Criteria) this;
        }

        public Criteria andPath4EqualTo(String value) {
            addCriterion("path4 =", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotEqualTo(String value) {
            addCriterion("path4 <>", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4GreaterThan(String value) {
            addCriterion("path4 >", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4GreaterThanOrEqualTo(String value) {
            addCriterion("path4 >=", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4LessThan(String value) {
            addCriterion("path4 <", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4LessThanOrEqualTo(String value) {
            addCriterion("path4 <=", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4Like(String value) {
            addCriterion("path4 like", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotLike(String value) {
            addCriterion("path4 not like", value, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4In(List<String> values) {
            addCriterion("path4 in", values, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotIn(List<String> values) {
            addCriterion("path4 not in", values, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4Between(String value1, String value2) {
            addCriterion("path4 between", value1, value2, "path4");
            return (Criteria) this;
        }

        public Criteria andPath4NotBetween(String value1, String value2) {
            addCriterion("path4 not between", value1, value2, "path4");
            return (Criteria) this;
        }

        public Criteria andPath5IsNull() {
            addCriterion("path5 is null");
            return (Criteria) this;
        }

        public Criteria andPath5IsNotNull() {
            addCriterion("path5 is not null");
            return (Criteria) this;
        }

        public Criteria andPath5EqualTo(String value) {
            addCriterion("path5 =", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotEqualTo(String value) {
            addCriterion("path5 <>", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5GreaterThan(String value) {
            addCriterion("path5 >", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5GreaterThanOrEqualTo(String value) {
            addCriterion("path5 >=", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5LessThan(String value) {
            addCriterion("path5 <", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5LessThanOrEqualTo(String value) {
            addCriterion("path5 <=", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5Like(String value) {
            addCriterion("path5 like", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotLike(String value) {
            addCriterion("path5 not like", value, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5In(List<String> values) {
            addCriterion("path5 in", values, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotIn(List<String> values) {
            addCriterion("path5 not in", values, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5Between(String value1, String value2) {
            addCriterion("path5 between", value1, value2, "path5");
            return (Criteria) this;
        }

        public Criteria andPath5NotBetween(String value1, String value2) {
            addCriterion("path5 not between", value1, value2, "path5");
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