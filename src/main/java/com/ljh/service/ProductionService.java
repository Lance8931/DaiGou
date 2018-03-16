package com.ljh.service;

import com.ljh.domain.entity.PageBean;
import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.domain.entity.po.Production;

public interface ProductionService {
	PageBean<ProductionInfo> getProductionInfoList(int currentPage, int pageSize);

	Production findProductionById(long id);

	void save(Production user);

	void edit(Production user);

	void delete(long id);
}
