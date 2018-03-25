package com.ljh.service;

import java.util.List;

import com.ljh.domain.entity.po.Brand;

public interface BrandService {

    List<Brand> findAll();

    Brand findById(Long id);

    int save(Brand brand);

    int edit(Brand brand);

    int delete(long id);
}
