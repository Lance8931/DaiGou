package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.domain.entity.po.Production;

@Mapper
public interface ProductionMapper {

	@Insert("insert into production"
			+ "(`name`, brand_id, original_price, buy_price, spec, buy_address) values "
			+ "(#{name}, #{brandId}, #{originalPrice}, #{buyPrice}, #{spec}, #{buyAddress})")
	int insertByProduction(Production p);

	@Update("update user set age=#{age} where name=#{name}")
	void update(Production p);

	@Delete("delete from user where id = #{id}")
	void delete(Long id);

	@Select(value = "select p.id as proId, p.name as proName,"
			+ " b.zh_name as zhName, b.en_name as enName, p.spec, p.original_price as orgiPrice, p.buy_price as buyPrice, p.buy_address as buyAddress from production p left join brand b on p.brand_id = b.id")
	List<ProductionInfo> findAllInfo();

	
}
