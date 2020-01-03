package com.youngch.pat.beyond.hepler;

import com.youngch.pat.beyond.model.request.ApiReqModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReqCommonHelper {

    public static final ApiReqModel getCommonRequestModel(String method, String bizContent) {
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = format.format(now);
        ApiReqModel responseModel = new ApiReqModel();
        responseModel.setChannelKey("Web");
        responseModel.setSignType("MD5");
        responseModel.setFormat("json");
        responseModel.setCharset("utf-8");
        responseModel.setVersion("1.0");
        responseModel.setTimestamp(timeStamp);
        responseModel.setBizContent(bizContent);
        responseModel.setMethod(method);

        return responseModel;
    }
}
