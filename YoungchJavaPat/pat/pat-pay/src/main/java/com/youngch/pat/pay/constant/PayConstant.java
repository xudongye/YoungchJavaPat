package com.youngch.pat.pay.constant;

import com.youngch.pat.common.utils.enums.EnumName;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:41
 */
public class PayConstant {
    public enum TradeType implements EnumName {

        NATIVE(1, "二维码支付"),

        JSAPI(2, "wxpay 微信公众号支付"),

        MWEB(3, "wxpay h5 支付"),

        APP(4, "移动app支付"),

        WAP(5, "apipay h5支付"),

        CASH(6, "现金支付");

        TradeType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        private int code;

        private String name;

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    public enum PayType implements EnumName {
        AliPay(1, "AliPay"),
        WxPay(2, "WxPay");

        private int code;

        private String name;

        PayType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum PayStatus implements EnumName {

        Created(0, "created"),
        Paid(1, "paid"),
        Refund(2, "refund");

        private int code;

        private String name;

        PayStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum BusinessType implements EnumName {

        Beyond(1, "Beyond"),
        ZhuZher(2, "Zhuzher");

        private int code;

        private String name;

        BusinessType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
