package com.ljh.domain.entity.dto;

public class PriceLogInfo {

	private Long id;
	private String proName;
	private Double currentPrice;

	public PriceLogInfo() {
	}

	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getProName() {
		return proName;
	}
	

	public void setProName(String proName) {
		this.proName = proName;
	}
	

	public Double getCurrentPrice() {
		return currentPrice;
	}
	

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
}
