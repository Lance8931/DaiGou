package com.ljh.domain.mapper.prodiver;

import org.apache.ibatis.jdbc.SQL;

import com.ljh.domain.entity.po.Production;

public class ProductionProdiver {

	public String selectSelective(Production p) {
		return new SQL() {{
			SELECT("*");
			FROM("production");
			if (p.getBrandId() != null) {
				WHERE("brand_id=#{brandId}");
			}
			if (p.getBuyAddress() != null) {
				WHERE("buy_address=#{buyAddress}");
			}
			if (p.getBuyPrice() != null) {
				WHERE("buy_price=#{buyPrice}");
			}
			if (p.getId() != null) {
				WHERE("id=#{id}");
			}
			if (p.getName() != null) {
				WHERE("buy_address=#{buyAddress}");
			}
			if (p.getOriginalPrice() != null) {
				WHERE("original_price=#{originalPrice}");
			}
			if (p.getSpec() != null) {
				WHERE("spec=#{spec}");
			}
		}}.toString();
	}
}
