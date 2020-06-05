package com.youngch.pat.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PayConfig implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "pms酒店编号")
    private String hotelId;

    @ApiModelProperty(value = "进入开发中心，查看已申请的网页/移动支付，查看获取APPID")
    private String appId;

    @ApiModelProperty(value = "微信支付商户id")
    private String wxpayMchId;

    @ApiModelProperty(value = "微信支付证书文件位置")
    private String certLocalPath;

    @ApiModelProperty(value = "微信支付密钥")
    private String wxpayAppKey;

    @ApiModelProperty(value = "支付宝商户应用私钥")
    private String privateKey;

    @ApiModelProperty(value = "支付宝商户应用公钥")
    private String publicKey;

    @ApiModelProperty(value = "支付宝公钥")
    private String alipayPublicKey;

    @ApiModelProperty(value = "支付宝支付网关")
    private String gateWayUrl;

    @ApiModelProperty(value = "交易的具体描述信息")
    private String body;

    @ApiModelProperty(value = "商品的标题/交易标题/订单标题/订单关键字")
    private String subject;

    @ApiModelProperty(value = "支付成功回调地址")
    private String notifyUrl;

    @ApiModelProperty(value = "支付类型：1.alipay 2.wxpay")
    private Integer payType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getWxpayMchId() {
        return wxpayMchId;
    }

    public void setWxpayMchId(String wxpayMchId) {
        this.wxpayMchId = wxpayMchId;
    }

    public String getCertLocalPath() {
        return certLocalPath;
    }

    public void setCertLocalPath(String certLocalPath) {
        this.certLocalPath = certLocalPath;
    }

    public String getWxpayAppKey() {
        return wxpayAppKey;
    }

    public void setWxpayAppKey(String wxpayAppKey) {
        this.wxpayAppKey = wxpayAppKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getGateWayUrl() {
        return gateWayUrl;
    }

    public void setGateWayUrl(String gateWayUrl) {
        this.gateWayUrl = gateWayUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hotelId=").append(hotelId);
        sb.append(", appId=").append(appId);
        sb.append(", wxpayMchId=").append(wxpayMchId);
        sb.append(", certLocalPath=").append(certLocalPath);
        sb.append(", wxpayAppKey=").append(wxpayAppKey);
        sb.append(", privateKey=").append(privateKey);
        sb.append(", publicKey=").append(publicKey);
        sb.append(", alipayPublicKey=").append(alipayPublicKey);
        sb.append(", gateWayUrl=").append(gateWayUrl);
        sb.append(", body=").append(body);
        sb.append(", subject=").append(subject);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", payType=").append(payType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}