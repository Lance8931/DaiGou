package com.ljh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljh.domain.entity.InfoResult;
import com.ljh.domain.entity.ListResult;
import com.ljh.domain.entity.dto.PriceLogInfo;
import com.ljh.domain.entity.po.PriceChangeLog;
import com.ljh.service.PriceChangeLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="价格变化有关接口")
@Controller
@RequestMapping("/pricelog")
public class PriceLogController {

    @Autowired
    private PriceChangeLogService logService;

    @ApiOperation(value = "获取价格变化列表", notes = "")
    @GetMapping(value = "/")
    @ResponseBody
    public ListResult<PriceLogInfo> getPriceLogList() {
        List<PriceLogInfo> list = logService.findAll();
        ListResult<PriceLogInfo> result = new ListResult<PriceLogInfo>(list.size(), list);
        return result;
    }
    
    @ApiOperation(value = "获取价格变化列表根据Proid", notes = "")
    @GetMapping(value = "/proid")
    @ResponseBody
    public ListResult<PriceLogInfo> getPriceLogListByProId(Long proId) {
        List<PriceLogInfo> list = logService.findById(proId);
        ListResult<PriceLogInfo> result = new ListResult<PriceLogInfo>(list.size(), list);
        return result;
    }

    @ApiOperation(value = "更新日志价格信息", notes = "根据url的id来指定更新价格，并根据传过来的pricechangelog信息来更新价格日志详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "日志ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "priceChangeLog", value = "需要更新的pricechangelog信息", required = true, dataType = "PriceChangeLog") })
	@PutMapping(value = "/{id}")
	@ResponseBody
	public InfoResult putProduction(@PathVariable(name = "id", required = true) Long id,
			@ModelAttribute(name = "priceChangeLog") PriceChangeLog log) {
    	logService.edit(log);
		return new InfoResult();
	}
    
    @ApiOperation(value = "删除变化日志", notes = "根据url的id来指定删除变化日志")
	@ApiImplicitParam(name = "id", value = "日志ID", required = true, dataType = "Long")
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public InfoResult delete(@PathVariable(name = "id", required = true) Long id) {
    	logService.delete(id);
		return new InfoResult();
	}
}
