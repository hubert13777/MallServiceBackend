package com.htc.controller;

import com.htc.entity.Basic;
import com.htc.entity.Commodity;
import com.htc.service.BasicService;
import com.htc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/android")
public class AndroidController {
    @Autowired
    private BasicService basicService;

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/hello")
    @ResponseBody
    public List<Basic> hello(String name, int age) {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        List<Basic> goods=basicService.getAllGoods();
        return goods;
    }

    @RequestMapping("/toJsonPojo")
    @ResponseBody
    public Basic toJsonPojo(){
        System.out.println("返回Basic对象的json数据");
        Basic res=new Basic();
        res.setGoodsId(9);
        res.setGoodsName("我传我自己");
        return res;
    }
}
