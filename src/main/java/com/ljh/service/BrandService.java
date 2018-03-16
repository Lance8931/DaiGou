package com.ljh.service;

import java.util.List;

import com.ljh.domain.entity.po.Brand;
import com.ljh.domain.entity.po.Production;


public interface BrandService {

	List<Brand> findAll();
	
	void save(Production user);

	void edit(Production user);

	void delete(long id);
}
