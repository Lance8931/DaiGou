package com.ljh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljh.domain.entity.ListResult;
import com.ljh.domain.entity.po.Brand;
import com.ljh.service.BrandService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/pricelog")
public class PriceLogController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        return "pricelog/list";
    }

    @ApiOperation(value = "获取价格变化列表", notes = "")
    @GetMapping(value = "/")
    @ResponseBody
    public ListResult<Brand> getPriceLogList(Long proId) {
        List<Brand> list = brandService.findAll();
        ListResult<Brand> result = new ListResult<Brand>(list.size(), list);
        return result;
    }
}
