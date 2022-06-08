package com.htc.controller;

import com.htc.entity.Basic;
import com.htc.entity.Commodity;
import com.htc.entity.CommodityForAndroid;
import com.htc.entity.Response;
import com.htc.exception.BusinessException;
import com.htc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/goods/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public Response<?> sendAllGoods() {
        List<Commodity> goods=commodityService.getAllGoods();
        if(goods==null) throw new BusinessException(Response.Code.BUSINESS_ERROR.getNum(),"未查询到数据，请稍后再试");
        return new Response<List<Commodity>>(Response.Code.GET_OK.getNum(),"OK",goods);
    }
    
    @GetMapping("/android")
    public Response<?> sendAllGoodsToAndroid(){
        List<CommodityForAndroid> goods=commodityService.getAllGoodsForAndroid();
        if(goods==null) throw new BusinessException(Response.Code.BUSINESS_ERROR.getNum(),"未查询到数据，请稍后再试");
        return new Response<List<CommodityForAndroid>>(Response.Code.GET_OK.getNum(),"OK",goods);
    }

    @GetMapping("/{goodsId}")
    public Response<?> sendGood(@PathVariable int goodsId){
        Commodity good=commodityService.getGoodById(goodsId);
        // System.out.println(good);
        if(good!=null) return new Response<Commodity>(Response.Code.GET_OK.getNum(),"OK",good);
        else return new Response<>(Response.Code.GET_ERROR.getNum(),"商品信息为空，可能不存在",null);
    }
    
    // 非REST风格的URL
    @GetMapping("/detail")
    public Response<?> sendGood2(@RequestParam("goodsId") int goodsId){
        try {
            CommodityForAndroid good = commodityService.getGoodByIdForAndroid(goodsId);
            System.out.println(good);
            if (good != null) return new Response<CommodityForAndroid>(Response.Code.GET_OK.getNum(), "OK", good);
            else return new Response<>(Response.Code.GET_ERROR.getNum(), "商品信息为空，可能不存在", null);
        }catch (Exception e){
            e.printStackTrace();
            return new Response<>(Response.Code.SYSTEM_ERROR.getNum(),"系统故障，返回商品信息失败",null);
        }
    }
}
