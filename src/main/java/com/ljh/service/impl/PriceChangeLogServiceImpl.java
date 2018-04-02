package com.ljh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljh.domain.entity.po.Brand;
import com.ljh.domain.mapper.BrandMapper;
import com.ljh.service.BrandService;
import com.ljh.service.PriceChangeLogService;

@Service
public class PriceChangeLogServiceImpl implements PriceChangeLogService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public int save(Brand brand) {
        return brandMapper.save(brand);
    }

    @Override
    public int edit(Brand brand) {
        return brandMapper.update(brand);
    }

    @Override
    public int delete(long id) {
        return brandMapper.delete(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.findById(id);
    }

}
