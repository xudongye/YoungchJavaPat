package com.youngch.pat.chat.model;

import lombok.Data;

import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/1/14 17:09
 */
@Data
public class ChatServerModel {

    private Long id;

    private String cellphone;

    private Date createtime;

    private Boolean deleted;

    private String email;

    private String headimg;

    private Date modifytime;

    private String name;

    private String password;

    private Long roleid;

    private Long customerid;
}
