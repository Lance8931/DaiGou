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
import com.ljh.domain.entity.po.Customer;
import com.ljh.service.CustomerService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        return "customer/list";
    }

    @RequestMapping("/add")
    public String add(ModelMap map) {
        return "customer/add";
    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, Long id) {
        map.put("id", id);
        map.put("customers", customerService.findALLButOne(id));
        return "customer/edit";
    }

    @ApiOperation(value = "获取顾客列表", notes = "")
    @GetMapping(value = "/")
    @ResponseBody
    public ListResult<Customer> getCustomerList() {
        List<Customer> list = customerService.findAllAndReferees();
        ListResult<Customer> result = new ListResult<Customer>(list.size(), list);
        return result;
    }
    
    @ApiOperation(value = "获取顾客列表除了", notes = "")
    @GetMapping(value = "/customerButOneList")
    @ResponseBody
    public ListResult<Customer> getCustomerButOneList(Long id) {
        List<Customer> list = customerService.findALLButOne(id);
        ListResult<Customer> result = new ListResult<Customer>(list.size(), list);
        return result;
    }

    @ApiOperation(value = "创建顾客信息", notes = "根据Customer对象创建顾客")
    @ApiImplicitParam(name = "customer", value = "顾客详细实体customer", required = true, dataType = "Customer")
    @PostMapping(value = "/")
    @ResponseBody
    public InfoResult postCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return new InfoResult();
    }

    @ApiOperation(value = "获取顾客详细信息", notes = "根据url的id来获取顾客详细信息")
    @ApiImplicitParam(name = "id", value = "顾客ID", required = true, dataType = "Long")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public InfoResult getCustomer(@PathVariable(name = "id", required = true) Long id) {
        InfoResult result = new InfoResult();
        Map<String, Object> map = new HashMap<>();
        map.put("item", customerService.findById(id));
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "更新顾客信息", notes = "根据url的id来指定顾客，并根据传过来的customer信息来更新顾客详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "顾客ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "customer", value = "需要更新的customer信息", required = true, dataType = "Customer") })
    @PutMapping(value = "/{id}")
    @ResponseBody
    public InfoResult putCustomer(@PathVariable(name = "id", required = true) Long id, @ModelAttribute(name = "customer") Customer customer) {
        customerService.edit(customer);
        return new InfoResult();
    }

    @ApiOperation(value = "删除顾客", notes = "根据url的id来指定删除顾客")
    @ApiImplicitParam(name = "id", value = "顾客ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public InfoResult deleteCustomer(@PathVariable(name = "id", required = true) Long id) {
        customerService.delete(id);
        return new InfoResult();
    }

}
