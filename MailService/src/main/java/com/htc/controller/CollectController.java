package com.htc.controller;

import com.htc.entity.Basic;
import com.htc.entity.Response;
import com.htc.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    /**
     * REST风格，根据用户id返回购物车中的商品内容
     */
    @GetMapping("/list/{userId}")
    public Response<?> sendAllCollect(@PathVariable int userId) {
        List<Basic> collect = collectService.getAllCollect(userId);
        return new Response<List<Basic>>(Response.Code.GET_OK.getNum(), "OK", collect);
    }

    /**
     * 非REST风格，根据用户id返回购物车内容
     *
     * @param userId 用户id
     */
    @GetMapping("/list")
    public Response<?> sendAllCollect2(@RequestParam("userId") int userId) {
        List<Basic> collect = collectService.getAllCollect(userId);
        return new Response<List<Basic>>(Response.Code.GET_OK.getNum(), "OK", collect);
    }

    /**
     * 非REST风格，判断某商品是否已收藏
     */
    @GetMapping("/check")
    public Response<?> isCollected(@RequestParam("userId") int userId, @RequestParam("goodsId") int goodsId) {
        if (collectService.checkCollect(userId, goodsId) == true) {
            return new Response<>(Response.Code.GET_OK.getNum(), "Yes", null);
        } else {
            return new Response<>(Response.Code.GET_OK.getNum(), "No", null);
        }
    }

    /**
     * 添加到购物车，若已存在会提示
     */
    @GetMapping("/add")
    public Response<?> addCollect(@RequestParam("userId") int userId, @RequestParam("goodsId") int goodsId) {
        collectService.addCollect(userId, goodsId);
        return new Response<>(Response.Code.GET_OK.getNum(), "已成功添加到购物车", null);
    }

    /**
     * 将某商品移出购物车
     */
    @GetMapping("/delete")
    public Response<?> deleteCollect(@RequestParam("userId") int userId, @RequestParam("goodsId") int goodsId) {
        collectService.deleteCollect(userId, goodsId);
        return new Response<>(Response.Code.GET_OK.getNum(), "该商品已移出购物车", null);
    }
}
