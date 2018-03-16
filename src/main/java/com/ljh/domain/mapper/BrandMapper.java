package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ljh.domain.entity.po.Brand;

@Mapper
public interface BrandMapper {

	@Select(value="select id, zh_name as zhName, en_name as enName from brand order by id")
	List<Brand> findAll();
}
