package com.htc.controller;

import com.htc.entity.Basic;
import com.htc.entity.Commodity;
import com.htc.entity.Response;
import com.htc.exception.BusinessException;
import com.htc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return new Response<Commodity>(Response.Code.GET_OK.getNum(),"OK",goods);
    }

    @GetMapping("/#{goodsId}")
    public Response<?> sendGood(int goodsId){
        Commodity good=commodityService.getGoodById(goodsId);
        if(good!=null) return new Response<Commodity>(Response.Code.GET_OK.getNum(),"OK",good);
        else return new Response<>(Response.Code.GET_ERROR.getNum(),"商品信息为空，可能不存在",null);
    }
}
