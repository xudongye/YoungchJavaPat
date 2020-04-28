package com.youngch.pat.log.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.common.dao.PageQueryResult;
import com.youngch.pat.log.service.AdminLogService;
import com.youngch.pat.log.service.DeviceRunLogService;
import com.youngch.pat.log.model.DeviceRunLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/4/22 13:33
 */
@Api(tags = "ai-log")
@RestController
@RequestMapping(value = "/v1/report")
public class LogWriteController {

    @Autowired
    private AdminLogService adminLogService;

    @Autowired
    private DeviceRunLogService deviceRunLogService;

    @ApiOperation(value = "智慧酒店服务器日志系统", httpMethod = "GET")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity test(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam(required = false) String devId,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageQueryResult<DeviceRunLog> result = deviceRunLogService.page(devId, pageNum, pageSize);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ApiOperation(value = "智慧酒店服务器日志系统", httpMethod = "POST")
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/octet-stream")
    public void onLogWrite(HttpServletRequest request,
                           HttpServletResponse response) {

        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String json = "";
            while ((json = br.readLine()) != null) {
                sb.append(json);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            String targetJson = sb.toString();
            System.out.println(targetJson);

            DeviceRunLog runLog = new ObjectMapper().readValue(targetJson, DeviceRunLog.class);

            deviceRunLogService.save(runLog);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
