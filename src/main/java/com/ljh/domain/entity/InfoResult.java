package com.ljh.domain.entity;

public class InfoResult {

	private Integer code = 0;
	private String msg = "success";

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

}
