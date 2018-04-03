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
	
	@Select(value = "select a.id, a.pro_id as proId, b.name as proName, a.current_price as currentPrice from price_change_log a left outer join production b on a.pro_id = b.id order by a.id")
    List<PriceLogInfo> findAll();

    @Select(value = "select a.id, b.name as proName, a.current_price as currentPrice from price_change_log a left outer join production b on a.pro_id = b.id where a.pro_id = #{proId} order by a.id")
    List<PriceLogInfo> findById(Long proId);

    @Insert(value = "insert into price_change_log (pro_id, current_price) values (#{proId}, #{currentPrice})")
    int save(PriceChangeLog log);

    @Update(value = "update price_change_log set current_price=#{currentPrice} where id = #{id}")
    int update(PriceChangeLog log);

    @Delete(value = "delete from price_change_log where id=#{id}")
    int delete(Long id);

}
