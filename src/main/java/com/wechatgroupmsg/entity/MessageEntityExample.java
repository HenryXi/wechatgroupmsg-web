package com.wechatgroupmsg.entity;

import java.util.ArrayList;
import java.util.List;

public class MessageEntityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table message
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table message
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table message
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public MessageEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table message
     *
     * @mbg.generated
     */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdIsNull() {
            addCriterion("msg_svr_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdIsNotNull() {
            addCriterion("msg_svr_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdEqualTo(String value) {
            addCriterion("msg_svr_id =", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdNotEqualTo(String value) {
            addCriterion("msg_svr_id <>", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdGreaterThan(String value) {
            addCriterion("msg_svr_id >", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_svr_id >=", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdLessThan(String value) {
            addCriterion("msg_svr_id <", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdLessThanOrEqualTo(String value) {
            addCriterion("msg_svr_id <=", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdLike(String value) {
            addCriterion("msg_svr_id like", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdNotLike(String value) {
            addCriterion("msg_svr_id not like", value, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdIn(List<String> values) {
            addCriterion("msg_svr_id in", values, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdNotIn(List<String> values) {
            addCriterion("msg_svr_id not in", values, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdBetween(String value1, String value2) {
            addCriterion("msg_svr_id between", value1, value2, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andMsgSvrIdNotBetween(String value1, String value2) {
            addCriterion("msg_svr_id not between", value1, value2, "msgSvrId");
            return (Criteria) this;
        }

        public Criteria andTalkerIsNull() {
            addCriterion("talker is null");
            return (Criteria) this;
        }

        public Criteria andTalkerIsNotNull() {
            addCriterion("talker is not null");
            return (Criteria) this;
        }

        public Criteria andTalkerEqualTo(String value) {
            addCriterion("talker =", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotEqualTo(String value) {
            addCriterion("talker <>", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThan(String value) {
            addCriterion("talker >", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThanOrEqualTo(String value) {
            addCriterion("talker >=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThan(String value) {
            addCriterion("talker <", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThanOrEqualTo(String value) {
            addCriterion("talker <=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLike(String value) {
            addCriterion("talker like", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotLike(String value) {
            addCriterion("talker not like", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerIn(List<String> values) {
            addCriterion("talker in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotIn(List<String> values) {
            addCriterion("talker not in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerBetween(String value1, String value2) {
            addCriterion("talker between", value1, value2, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotBetween(String value1, String value2) {
            addCriterion("talker not between", value1, value2, "talker");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table message
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table message
     *
     * @mbg.generated
     */
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