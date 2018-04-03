package com.ljh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljh.service.BrandService;
import com.ljh.service.CustomerService;
import com.ljh.service.ProPhotoService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class IndexController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BrandService brandService;

	@Autowired
	private ProPhotoService proPhotoService;

    @RequestMapping("/")
    public String list(ModelMap map) {
        return "production/list";
    }

    @RequestMapping("/pricelog/list")
    public String priceloglist(ModelMap map) {
        return "pricelog/list";
    }
    
    @RequestMapping("/brand/list")
    public String brandlist(ModelMap map) {
        return "brand/list";
    }

    @RequestMapping("/brand/add")
    public String brandadd(ModelMap map) {
        return "brand/add";
    }

    @RequestMapping("/brand/edit")
    public String brandedit(ModelMap map, Integer id) {
        map.put("id", id);
        return "brand/edit";
    }
    
    @RequestMapping("/customer/list")
    public String customerlist(ModelMap map) {
        return "customer/list";
    }

    @RequestMapping("/customer/add")
    public String customeradd(ModelMap map) {
        return "customer/add";
    }

    @RequestMapping("/customer/edit")
    public String customeredit(ModelMap map, Long id) {
        map.put("id", id);
        map.put("customers", customerService.findALLButOne(id));
        return "customer/edit";
    }

	@RequestMapping("/production/list")
	public String productionlist(ModelMap map) {
		return "production/list";
	}

	@RequestMapping("/production/add")
	public String productionadd(ModelMap map) {
		map.put("brands", brandService.findAll());
		return "production/add";
	}

	@RequestMapping("/production/edit")
	public String productionedit(ModelMap map, Long id) {
		map.put("id", id);
		map.put("brands", brandService.findAll());
		return "production/edit";
	}

	@RequestMapping("/production/detail")
	public String productiondetail(ModelMap map, Long id) {
		map.put("id", id);
		map.put("brands", brandService.findAll());
		map.put("photos", proPhotoService.findAllByProId(id));
		return "production/detail";
	}

    @RequestMapping("/prophoto/uploadphoto")
    public String prophotouploadPhoto(ModelMap map, Long proId) {
        map.put("proId", proId);
        return "prophoto/upload";
    }
}
