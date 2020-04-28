package com.youngch.pat.log.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/4/22 13:08
 */
@Document
public class AdminLog implements Serializable {

    @Id
    private String id;
    private String yearMonth;
    private List<String> contents = new LinkedList<>();


    @PersistenceConstructor
    public AdminLog(String yearMonth, List<String> contents) {
        this.yearMonth = yearMonth;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
}
