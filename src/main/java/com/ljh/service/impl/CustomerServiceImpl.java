package com.ljh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljh.domain.entity.po.Customer;
import com.ljh.domain.mapper.CustomerMapper;
import com.ljh.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int save(Customer customer) {
        return customerMapper.save(customer);
    }

    @Override
    public int edit(Customer customer) {
        return customerMapper.update(customer);
    }

    @Override
    public int delete(long id) {
        return customerMapper.delete(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerMapper.findById(id);
    }

    @Override
    public List<Customer> findALLButOne(Long id) {
        List<Customer> list = findAll();
        list = list.stream().filter((Customer item) -> item.getId() != id).collect(Collectors.toList());
        return list;
    }

}
