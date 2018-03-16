package com.ljh.domain.entity;

import java.util.List;

public class ListResult<T> {

	private Integer code = 0;
	private String msg;
	private Integer totalNum;
	private List<T> items;
	
	
	public ListResult(Integer totalNum, List<T> items) {
		super();
		this.totalNum = totalNum;
		this.items = items;
	}

	public ListResult(Integer code, String msg) {
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

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
