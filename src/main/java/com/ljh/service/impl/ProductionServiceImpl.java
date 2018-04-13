package com.ljh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ljh.domain.entity.PageBean;
import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.domain.entity.po.Production;
import com.ljh.domain.mapper.ProductionMapper;
import com.ljh.service.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public PageBean<ProductionInfo> getProductionInfoList(int currentPage, int pageSize) {
        Page<ProductionInfo> page = PageHelper.startPage(currentPage, pageSize);
        List<ProductionInfo> items = productionMapper.findAllInfo();
        PageBean<ProductionInfo> pageData = new PageBean<>(currentPage, pageSize, Integer.parseInt(page.getTotal()+""));
        pageData.setItems(items);
        return pageData;
    }

    @Override
    public Production findProductionById(long id) {
        return productionMapper.findById(id);
    }

    @Override
    public void save(Production p) {
        productionMapper.insertByProduction(p);
    }

    @Override
    public void edit(Production p) {
        productionMapper.update(p);
    }

    @Override
    public void delete(long id) {
        productionMapper.delete(id);
    }

}
