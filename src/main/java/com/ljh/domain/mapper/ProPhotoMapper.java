package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljh.domain.entity.po.ProPhoto;

@Mapper
public interface ProPhotoMapper {
    @Insert("insert into pro_photo" + "(`name`, pro_id, url) values " + "(#{name}, #{proId}, #{url})")
    int insertByProPhoto(ProPhoto p);

    @Update("update pro_photo set name=#{name}, pro_id=#{proId}, url=#{url} where id=#{id}")
    void update(ProPhoto p);

    @Delete("delete from pro_photo where id = #{id}")
    int delete(Long id);

    @Delete("delete from pro_photo where pro_id = #{proId}")
    int deleteByProId(Long proId);

    @Select(value = "select p.id, p.name, p.pro_id as proId, p.url from pro_photo p where pro_id=#{proId}")
    List<ProPhoto> findAllByProId(Long proId);
}
