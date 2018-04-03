package com.ljh.service;

import java.util.List;

import com.ljh.domain.entity.dto.PriceLogInfo;
import com.ljh.domain.entity.po.PriceChangeLog;

public interface PriceChangeLogService {

    List<PriceLogInfo> findAll();

    List<PriceLogInfo> findById(Long id);

    int save(PriceChangeLog price);

    int edit(PriceChangeLog price);

    int delete(long id);
    
}
