package com.youngch.pat.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: yexudong
 * @Date: 2020/1/15 15:58
 */
@Data
@Table(name = "test")
public class Test implements Serializable {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 20,isKey = true,isAutoIncrement = true)
    private Long id;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String name;
}
