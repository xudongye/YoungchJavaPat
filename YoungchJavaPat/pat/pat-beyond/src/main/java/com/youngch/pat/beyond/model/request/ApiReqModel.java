package com.youngch.pat.beyond.model.request;

import lombok.Data;

@Data
public class ApiReqModel {

    private String ChannelKey;

    private String Method;

    private String BizContent;

    private String Sign;

    private String SignType;

    private String Format;

    private String Charset;

    private String Version;

    private String Timestamp;

}
