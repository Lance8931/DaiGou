package com.ljh.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ljh.domain.entity.InfoResult;
import com.ljh.domain.entity.ListResult;
import com.ljh.domain.entity.PageBean;
import com.ljh.domain.entity.dto.ProductionInfo;
import com.ljh.domain.entity.po.Production;
import com.ljh.service.BrandService;
import com.ljh.service.ProPhotoService;
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

    @Autowired
    private ProPhotoService proPhotoService;

    @Value("${production.uploadphoto.savepath}")
    private String uploadPath;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        return "production/list";
    }

    @RequestMapping("/add")
    public String add(ModelMap map) {
        map.put("brands", brandService.findAll());
        return "production/add";
    }

    @RequestMapping("/edit")
    public String edit(ModelMap map, Long id) {
        map.put("id", id);
        map.put("brands", brandService.findAll());
        return "production/edit";
    }

    @RequestMapping("/detail")
    public String detail(ModelMap map, Long id) {
        map.put("id", id);
        map.put("brands", brandService.findAll());
        map.put("photos", proPhotoService.findAllByProId(id));
        return "production/detail";
    }

    @RequestMapping("/uploadphoto")
    public String uploadPhoto(ModelMap map, Long id) {
        map.put("id", id);
        return "production/uploadphoto";
    }

    @ApiOperation(value = "获取产品列表", notes = "")
    @GetMapping(value = "/")
    @ResponseBody
    public ListResult<ProductionInfo> getProductionList(int currentPage, int pageSize) {
        PageBean<ProductionInfo> r = productionService.getProductionInfoList(currentPage, pageSize);
        ListResult<ProductionInfo> result = new ListResult<ProductionInfo>(r.getTotalNum(), r.getItems());
        return result;
    }

    @ApiOperation(value = "创建产品信息", notes = "根据Production对象创建产品")
    @ApiImplicitParam(name = "production", value = "产品详细实体production", required = true, dataType = "Production")
    @PostMapping(value = "/")
    @ResponseBody
    public InfoResult postProduction(@ModelAttribute Production production) {
        productionService.save(production);
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数外，还可以通过@RequestParam从页面传递参数
        return new InfoResult();
    }

    @ApiOperation(value = "获取产品详细信息", notes = "根据url的id来获取产品详细信息")
    @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public InfoResult getProduction(@PathVariable(name = "id", required = true) Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        InfoResult result = new InfoResult();
        Map<String, Object> map = new HashMap<>();
        map.put("item", productionService.findProductionById(id));
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "更新产品信息", notes = "根据url的id来指定更新产品，并根据传过来的production信息来更新产品详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "production", value = "需要更新的production信息", required = true, dataType = "Production") })
    @PutMapping(value = "/{id}")
    @ResponseBody
    public InfoResult putProduction(@PathVariable(name = "id", required = true) Long id, @ModelAttribute(name = "production") Production production) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        productionService.edit(production);
        return new InfoResult();
    }

    @ApiOperation(value = "删除产品", notes = "根据url的id来指定删除产品")
    @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public InfoResult deleteProduction(@PathVariable(name = "id", required = true) Long id) {
        productionService.delete(id);
        return new InfoResult();
    }

    @PostMapping(value = "/uploadphoto/{id}")
    @ResponseBody
    public InfoResult uploadPhoto(@PathVariable(name = "id", required = true) Long proId, MultipartFile photos, HttpServletRequest request) {
        String filename = photos.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + uploadPath + filename;
        try {
            File newfile = new File(filePath);
            if (!newfile.getParentFile().exists()) {
                newfile.getParentFile().mkdir();
            }
            photos.transferTo(newfile);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new InfoResult();
    }
}
