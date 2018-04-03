package com.ljh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljh.domain.entity.dto.PriceLogInfo;
import com.ljh.domain.entity.po.PriceChangeLog;
import com.ljh.domain.mapper.PriceChangeLogMapper;
import com.ljh.service.PriceChangeLogService;

@Service
public class PriceChangeLogServiceImpl implements PriceChangeLogService {

    @Autowired
    private PriceChangeLogMapper logMapper;

    @Override
    public int save(PriceChangeLog brand) {
        return logMapper.save(brand);
    }

    @Override
    public int edit(PriceChangeLog brand) {
        return logMapper.update(brand);
    }

    @Override
    public int delete(long id) {
        return logMapper.delete(id);
    }

    @Override
    public List<PriceLogInfo> findAll() {
        return logMapper.findAll();
    }

    @Override
    public List<PriceLogInfo> findById(Long id) {
        return logMapper.findById(id);
    }

}
