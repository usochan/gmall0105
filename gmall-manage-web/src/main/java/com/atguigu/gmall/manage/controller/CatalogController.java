package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin//跨域请求
public class CatalogController {


    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
       List<PmsBaseCatalog1> catalogs =  catalogService.getCatalog1();

        return catalogs;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody                //接收前段的json数据
    public List<PmsBaseCatalog2> getCatalog2(/*@RequestBody*/ String catalog1Id) {
        List<PmsBaseCatalog2> catalog2s =  catalogService.getCatalog2(catalog1Id);

        return catalog2s;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3( String catalog2Id) {
        List<PmsBaseCatalog3> catalog3ss =  catalogService.getCatalog3(catalog2Id);

        return catalog3ss;
    }


}
