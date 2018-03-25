package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljh.domain.entity.po.Brand;

@Mapper
public interface BrandMapper {

    @Select(value = "select id, zh_name as zhName, en_name as enName from brand order by id")
    List<Brand> findAll();

    @Select(value = "select id, en_name as enName, zh_name as zhName from brand where id = #{id}")
    Brand findById(Long id);

    @Insert(value = "insert into brand (en_name,zh_name) values (#{enName}, #{zhName})")
    int save(Brand brand);

    @Update(value = "update brand set en_name=#{enName}, zh_name=#{zhName} where id = #{id}")
    int update(Brand brand);

    @Delete(value = "delete from brand where id=#{id}")
    int delete(Long id);
}
