package com.htc.controller;

import com.htc.entity.Basic;
import com.htc.entity.Response;
import com.htc.exception.BusinessException;
import com.htc.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods/basic")
public class BasicController {
    @Autowired
    private BasicService basicService;
    
    @GetMapping
    public Response<?> sendAllGoods() {
        List<Basic> goods = basicService.getAllGoods();
        if (goods == null) throw new BusinessException(Response.Code.BUSINESS_ERROR.getNum(), "未查询到数据，请稍后再试");
        return new Response<List<Basic>>(Response.Code.GET_OK.getNum(), "OK", goods);
    }
    
    @GetMapping("/{goodsId}")
    public Response<?> sendGood(@PathVariable int goodsId) {
        Basic good = basicService.getGoodById(goodsId);
        if (good != null) return new Response<Basic>(Response.Code.GET_OK.getNum(), "OK", good);
        else return new Response<>(Response.Code.GET_ERROR.getNum(), "商品信息为空，可能不存在", null);
    }
    
    // 非REST风格的URL
    @GetMapping("/detail")
    public Response<?> sendGood2(int goodsId) {
        Basic good = basicService.getGoodById(goodsId);
        if (good != null) return new Response<Basic>(Response.Code.GET_OK.getNum(), "OK", good);
        else return new Response<>(Response.Code.GET_ERROR.getNum(), "商品信息为空，可能不存在", null);
    }
}
