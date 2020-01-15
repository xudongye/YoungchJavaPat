package com.youngch.pat.web;

import com.youngch.pat.chat.service.ChatServerService;
import com.youngch.pat.entity.ChatServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/1/14 17:17
 */
@Api(tags = "chat-server")
@RestController
@RequestMapping(value = "/api/youngch/v1/pat/chat")
public class ChatServerController {

    @Autowired
    private ChatServerService chatServerService;

    @ApiOperation(value = "客服聊天模块", notes = "客服聊天获取客服", httpMethod = "GET")
    @RequestMapping(value = "/server/{chatServerId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> searchChat(HttpServletRequest request,
                                                           @PathVariable Long chatServerId) {
        Map<String, Object> responseBody = new HashMap<>();
        ChatServer chatServer = chatServerService.findById(chatServerId);
        responseBody.put("success", true);
        responseBody.put("data", chatServer);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
