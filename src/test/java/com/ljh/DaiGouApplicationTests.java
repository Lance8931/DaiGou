package com.ljh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ljh.domain.entity.PageBean;
import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.service.ProductionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaiGouApplicationTests {

	@Test
	public void contextLoads() {
	}

	
	@Autowired
	private ProductionService productionService;
	
	@Test
	public void test1() throws Exception {
		PageBean<ProductionInfo> pInfos = productionService.getProductionInfoList(1, 1);
		System.out.println(pInfos.getItems().get(0).getProName());
	}
}
