package com.ljh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljh.domain.entity.InfoResult;
import com.ljh.domain.entity.ListResult;
import com.ljh.domain.entity.PageBean;
import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.domain.entity.po.Production;
import com.ljh.service.BrandService;
import com.ljh.service.ProductionService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/production")
public class ProductionController {

	@Autowired
	private ProductionService productionService;

	@Autowired
	private BrandService brandService;

	@RequestMapping("/list")
	public String list(ModelMap map) {
		return "production/list";
	}

	@RequestMapping("/add")
	public String add(ModelMap map) {
		map.put("brands", brandService.findAll());
		return "production/add";
	}

	@ApiOperation(value = "获取产品列表", notes = "")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ListResult<ProductionInfo> getProductionList(int currentPage, int pageSize) {
		PageBean<ProductionInfo> r = productionService.getProductionInfoList(currentPage, pageSize);
		ListResult<ProductionInfo> result = new ListResult<ProductionInfo>(r.getTotalNum(), r.getItems());
		return result;
	}

	@ApiOperation(value = "创建产品信息", notes = "根据Production对象创建产品")
	@ApiImplicitParam(name = "production", value = "产品详细实体production", required = true, dataType = "Production")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public InfoResult postProduction(@ModelAttribute Production production) {
		productionService.save(production);
		// 处理"/users/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数外，还可以通过@RequestParam从页面传递参数
		return new InfoResult();
	}

	@ApiOperation(value = "获取产品详细信息", notes = "根据url的id来获取产品详细信息")
	@ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Production getProduction(@PathVariable Long id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		return new Production();
	}

	@ApiOperation(value = "更新产品信息", notes = "根据url的id来指定更新产品，并根据传过来的production信息来更新产品详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "production", value = "需要更新的production信息", required = true, dataType = "Production") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putProduction(@PathVariable Long id, @ModelAttribute Production production) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		Production u = new Production();
		u.setName(production.getName());
		return "success";
	}

	@ApiOperation(value = "删除产品", notes = "根据url的id来指定删除产品")
	@ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteProduction(@PathVariable Long id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		return "success";
	}
}
