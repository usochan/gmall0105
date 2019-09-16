package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class SkuController {

    @Reference
    SkuService skuService;


      @RequestMapping("saveSkuInfo")
      @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){
           //折中处理，将spuid封装给productid
          pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
          skuService.saveSkuInfo(pmsSkuInfo);
          //处理默认图
          String skuDefaultImage = pmsSkuInfo.getSkuDefaultImg();
          if(StringUtils.isBlank(skuDefaultImage)){
              pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
          }

          return "ok";
    }

}
