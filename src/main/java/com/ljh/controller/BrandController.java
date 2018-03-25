package com.ljh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljh.domain.entity.InfoResult;
import com.ljh.domain.entity.ListResult;
import com.ljh.domain.entity.po.Brand;
import com.ljh.service.BrandService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        return "brand/list";
    }

    @RequestMapping("/add")
    public String add(ModelMap map) {
        return "brand/add";
    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, Integer id) {
        map.put("id", id);
        return "brand/edit";
    }

    @ApiOperation(value = "获取牌子列表", notes = "")
    @GetMapping(value = "/")
    @ResponseBody
    public ListResult<Brand> getBrandList() {
        List<Brand> list = brandService.findAll();
        ListResult<Brand> result = new ListResult<Brand>(list.size(), list);
        return result;
    }

    @ApiOperation(value = "创建牌子信息", notes = "根据Brand对象创建牌子")
    @ApiImplicitParam(name = "brand", value = "牌子详细实体brand", required = true, dataType = "Brand")
    @PostMapping(value = "/")
    @ResponseBody
    public InfoResult postBrand(@ModelAttribute Brand brand) {
        brandService.save(brand);
        return new InfoResult();
    }

    @ApiOperation(value = "获取牌子详细信息", notes = "根据url的id来获取牌子详细信息")
    @ApiImplicitParam(name = "id", value = "牌子ID", required = true, dataType = "Long")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public InfoResult getBrand(@PathVariable(name = "id", required = true) Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        InfoResult result = new InfoResult();
        Map<String, Object> map = new HashMap<>();
        map.put("item", brandService.findById(id));
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "更新牌子信息", notes = "根据url的id来指定牌子，并根据传过来的brand信息来更新牌子详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "牌子ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "brand", value = "需要更新的brand信息", required = true, dataType = "Brand") })
    @PutMapping(value = "/{id}")
    @ResponseBody
    public InfoResult putBrand(@PathVariable(name = "id", required = true) Long id, @ModelAttribute(name = "brand") Brand brand) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        brandService.edit(brand);
        return new InfoResult();
    }

    @ApiOperation(value = "删除牌子", notes = "根据url的id来指定删除牌子")
    @ApiImplicitParam(name = "id", value = "牌子ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public InfoResult deleteBrand(@PathVariable(name = "id", required = true) Long id) {
        brandService.delete(id);
        return new InfoResult();
    }

}
