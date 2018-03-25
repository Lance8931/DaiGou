package com.ljh.service;

import java.util.List;

import com.ljh.domain.entity.po.Customer;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    int save(Customer brand);

    int edit(Customer brand);

    int delete(long id);

    List<Customer> findALLButOne(Long id);
}
