package com.youngch.pat.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class PayOrder implements Serializable {
    private Long id;

    @ApiModelProperty(value = "酒店编号")
    private String hotelId;

    @ApiModelProperty(value = "pms订单id号")
    private String pmsOrderId;

    @ApiModelProperty(value = "第三方支付的订单标识")
    private String outTradeNo;

    @ApiModelProperty(value = "退款订单标识")
    private String outRefundTradeNo;

    @ApiModelProperty(value = "是否支付 1.是 0.否")
    private Boolean paid;

    @ApiModelProperty(value = "支付方式：1.alipay 2.wxpay")
    private Integer payType;

    @ApiModelProperty(value = "微信返回支付交易会话id")
    private String prepayId;

    @ApiModelProperty(value = "扫码支付二维码地址 prepayUrl")
    private String codeUrl;

    @ApiModelProperty(value = "交易类型：1.JSAPI、2.NATIVE、3.APP、4.WAP、5.MWEB")
    private String tradeType;

    @ApiModelProperty(value = "订单金额, 单位为分")
    private Integer totalFee;

    @ApiModelProperty(value = "应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额")
    private Integer settlementTotalFee;

    @ApiModelProperty(value = "微信支付订单号")
    private String transactionId;

    @ApiModelProperty(value = "买家ID，为微信openid或者支付宝ID")
    private String buyerId;

    @ApiModelProperty(value = "买家支付宝账号")
    private String buyerLogonId;

    @ApiModelProperty(value = "支付结束时间")
    private Date timeEnd;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getPmsOrderId() {
        return pmsOrderId;
    }

    public void setPmsOrderId(String pmsOrderId) {
        this.pmsOrderId = pmsOrderId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundTradeNo() {
        return outRefundTradeNo;
    }

    public void setOutRefundTradeNo(String outRefundTradeNo) {
        this.outRefundTradeNo = outRefundTradeNo;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hotelId=").append(hotelId);
        sb.append(", pmsOrderId=").append(pmsOrderId);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", outRefundTradeNo=").append(outRefundTradeNo);
        sb.append(", paid=").append(paid);
        sb.append(", payType=").append(payType);
        sb.append(", prepayId=").append(prepayId);
        sb.append(", codeUrl=").append(codeUrl);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", settlementTotalFee=").append(settlementTotalFee);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", buyerLogonId=").append(buyerLogonId);
        sb.append(", timeEnd=").append(timeEnd);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}