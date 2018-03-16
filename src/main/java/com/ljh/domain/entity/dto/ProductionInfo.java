package com.ljh.domain.entity.dto;

public class ProductionInfo {

	private Long proId;
	private String proName;
	private String zhName;
	private String enName;
	private String spec;
	private Double orgiPrice;
	private Double buyPrice;
	private String buyAddress;

	public ProductionInfo() {
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getOrgiPrice() {
		return orgiPrice;
	}

	public void setOrgiPrice(Double orgiPrice) {
		this.orgiPrice = orgiPrice;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyAddress() {
		return buyAddress;
	}

	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}

}
