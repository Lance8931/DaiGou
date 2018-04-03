package com.ljh.domain.entity.po;

import java.util.Date;

public class PriceChangeLog {

	private Long id;

	private Double currentPrice;

	private Long proId;
	
	private Date createTime;
	
	public PriceChangeLog() {}
	
	public PriceChangeLog(Double currentPrice, Long proId) {
		this.currentPrice = currentPrice;
		this.proId = proId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
