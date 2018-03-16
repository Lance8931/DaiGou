package com.ljh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljh.domain.entity.po.Brand;
import com.ljh.domain.entity.po.Production;
import com.ljh.domain.mapper.BrandMapper;
import com.ljh.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public void save(Production user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void edit(Production user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public List<Brand> findAll() {
		return brandMapper.findAll();
	}

}
