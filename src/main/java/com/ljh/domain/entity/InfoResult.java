package com.ljh.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class InfoResult {

    private Integer code = 0;
    private String msg = "success";
    private Map<String, Object> data = new HashMap<>();

    public InfoResult() {
    }

    public InfoResult(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
