package com.ljh.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ljh.domain.entity.po.Customer;

@Mapper
public interface CustomerMapper {

    @Select(value = "select id, address, name, phone, referee from customer order by id")
    List<Customer> findAll();

    @Select(value = "select id, address, name, phone, referee from customer where id = #{id}")
    Customer findById(Long id);

    @Insert(value = "insert into customer (address, name, phone, referee) values (#{address}, #{name}, #{phone}, #{referee})")
    int save(Customer customer);

    @Update(value = "update customer set address=#{address}, name=#{name}, phone=#{phone}, referee=#{referee} where id = #{id}")
    int update(Customer customer);

    @Delete(value = "delete from customer where id=#{id}")
    int delete(Long id);
}
