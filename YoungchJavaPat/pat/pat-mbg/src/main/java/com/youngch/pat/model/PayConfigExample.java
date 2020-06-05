package com.youngch.pat.model;

import java.util.ArrayList;
import java.util.List;

public class PayConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayConfigExample() {
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

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(String value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(String value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(String value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(String value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(String value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLike(String value) {
            addCriterion("hotel_id like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotLike(String value) {
            addCriterion("hotel_id not like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<String> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<String> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(String value1, String value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(String value1, String value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIsNull() {
            addCriterion("wxpay_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIsNotNull() {
            addCriterion("wxpay_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdEqualTo(String value) {
            addCriterion("wxpay_mch_id =", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotEqualTo(String value) {
            addCriterion("wxpay_mch_id <>", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdGreaterThan(String value) {
            addCriterion("wxpay_mch_id >", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_mch_id >=", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLessThan(String value) {
            addCriterion("wxpay_mch_id <", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLessThanOrEqualTo(String value) {
            addCriterion("wxpay_mch_id <=", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLike(String value) {
            addCriterion("wxpay_mch_id like", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotLike(String value) {
            addCriterion("wxpay_mch_id not like", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIn(List<String> values) {
            addCriterion("wxpay_mch_id in", values, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotIn(List<String> values) {
            addCriterion("wxpay_mch_id not in", values, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdBetween(String value1, String value2) {
            addCriterion("wxpay_mch_id between", value1, value2, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotBetween(String value1, String value2) {
            addCriterion("wxpay_mch_id not between", value1, value2, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathIsNull() {
            addCriterion("cert_local_path is null");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathIsNotNull() {
            addCriterion("cert_local_path is not null");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathEqualTo(String value) {
            addCriterion("cert_local_path =", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathNotEqualTo(String value) {
            addCriterion("cert_local_path <>", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathGreaterThan(String value) {
            addCriterion("cert_local_path >", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathGreaterThanOrEqualTo(String value) {
            addCriterion("cert_local_path >=", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathLessThan(String value) {
            addCriterion("cert_local_path <", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathLessThanOrEqualTo(String value) {
            addCriterion("cert_local_path <=", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathLike(String value) {
            addCriterion("cert_local_path like", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathNotLike(String value) {
            addCriterion("cert_local_path not like", value, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathIn(List<String> values) {
            addCriterion("cert_local_path in", values, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathNotIn(List<String> values) {
            addCriterion("cert_local_path not in", values, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathBetween(String value1, String value2) {
            addCriterion("cert_local_path between", value1, value2, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andCertLocalPathNotBetween(String value1, String value2) {
            addCriterion("cert_local_path not between", value1, value2, "certLocalPath");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyIsNull() {
            addCriterion("wxpay_app_key is null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyIsNotNull() {
            addCriterion("wxpay_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyEqualTo(String value) {
            addCriterion("wxpay_app_key =", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyNotEqualTo(String value) {
            addCriterion("wxpay_app_key <>", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyGreaterThan(String value) {
            addCriterion("wxpay_app_key >", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_app_key >=", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyLessThan(String value) {
            addCriterion("wxpay_app_key <", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyLessThanOrEqualTo(String value) {
            addCriterion("wxpay_app_key <=", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyLike(String value) {
            addCriterion("wxpay_app_key like", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyNotLike(String value) {
            addCriterion("wxpay_app_key not like", value, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyIn(List<String> values) {
            addCriterion("wxpay_app_key in", values, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyNotIn(List<String> values) {
            addCriterion("wxpay_app_key not in", values, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyBetween(String value1, String value2) {
            addCriterion("wxpay_app_key between", value1, value2, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppKeyNotBetween(String value1, String value2) {
            addCriterion("wxpay_app_key not between", value1, value2, "wxpayAppKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNull() {
            addCriterion("private_key is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("private_key =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("private_key <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("private_key >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("private_key >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("private_key <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("private_key <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("private_key like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("private_key not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("private_key in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("private_key not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("private_key between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("private_key not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNull() {
            addCriterion("public_key is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("public_key =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("public_key <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("public_key >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("public_key >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("public_key <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("public_key <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("public_key like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("public_key not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("public_key in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("public_key not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("public_key between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("public_key not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNull() {
            addCriterion("alipay_public_key is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNotNull() {
            addCriterion("alipay_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyEqualTo(String value) {
            addCriterion("alipay_public_key =", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotEqualTo(String value) {
            addCriterion("alipay_public_key <>", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThan(String value) {
            addCriterion("alipay_public_key >", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_public_key >=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThan(String value) {
            addCriterion("alipay_public_key <", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("alipay_public_key <=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLike(String value) {
            addCriterion("alipay_public_key like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotLike(String value) {
            addCriterion("alipay_public_key not like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIn(List<String> values) {
            addCriterion("alipay_public_key in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotIn(List<String> values) {
            addCriterion("alipay_public_key not in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyBetween(String value1, String value2) {
            addCriterion("alipay_public_key between", value1, value2, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotBetween(String value1, String value2) {
            addCriterion("alipay_public_key not between", value1, value2, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlIsNull() {
            addCriterion("gate_way_url is null");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlIsNotNull() {
            addCriterion("gate_way_url is not null");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlEqualTo(String value) {
            addCriterion("gate_way_url =", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlNotEqualTo(String value) {
            addCriterion("gate_way_url <>", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlGreaterThan(String value) {
            addCriterion("gate_way_url >", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("gate_way_url >=", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlLessThan(String value) {
            addCriterion("gate_way_url <", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlLessThanOrEqualTo(String value) {
            addCriterion("gate_way_url <=", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlLike(String value) {
            addCriterion("gate_way_url like", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlNotLike(String value) {
            addCriterion("gate_way_url not like", value, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlIn(List<String> values) {
            addCriterion("gate_way_url in", values, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlNotIn(List<String> values) {
            addCriterion("gate_way_url not in", values, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlBetween(String value1, String value2) {
            addCriterion("gate_way_url between", value1, value2, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andGateWayUrlNotBetween(String value1, String value2) {
            addCriterion("gate_way_url not between", value1, value2, "gateWayUrl");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
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