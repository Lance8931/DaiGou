package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljh.domain.entity.dto.PriceLogInfo;
import com.ljh.domain.entity.po.PriceChangeLog;

@Mapper
public interface PriceChangeLogMapper {
	
	@Select(value = "select id, zh_name as zhName, en_name as enName from brand order by id")
    List<PriceLogInfo> findAll();

    @Select(value = "select id, en_name as enName, zh_name as zhName from brand where id = #{id}")
    List<PriceLogInfo> findById(Long id);

    @Insert(value = "insert into price_change_log (pro_id, current_price) values (#{proId}, #{currentPrice})")
    int save(PriceChangeLog log);

    @Update(value = "update price_change_log set current_price=#{currentPrice} where id = #{id}")
    int update(PriceChangeLog log);

    @Delete(value = "delete from price_change_log where id=#{id}")
    int delete(Long id);

}
