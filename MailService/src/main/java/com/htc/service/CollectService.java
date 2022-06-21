package com.htc.service;

import com.htc.dao.CollectGoodsDao;
import com.htc.entity.Basic;
import com.htc.entity.Response;
import com.htc.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectGoodsDao collectGoodsDao;

    @Autowired
    private BasicService basicService;

    /**
     * 判断是否已存在该收藏记录
     * @return true表示已存在，false表示没有该记录
     */
    public boolean checkCollect(int userId,int goodsId){
        int num = collectGoodsDao.selectByUseridGoodsid(userId, goodsId);
        if(num>=1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 添加新的收藏记录，若已收藏会直接返回一个业务异常，并提示用户已加入购物车
     */
    public void addCollect(int userId,int goodsId){
        if(checkCollect(userId,goodsId)){  //已存在该收藏记录
            throw new BusinessException(Response.Code.BUSINESS_ERROR.getNum(), "该商品已加入购物车");
        }
        collectGoodsDao.insertByUseridGoodsid(userId,goodsId);
    }

    /**
     * 删除指定的收藏记录，若本就无收藏则返回一个业务异常，提示用户
     */
    public void deleteCollect(int userId,int goodsId){
        if(checkCollect(userId, goodsId)==false){
            throw new BusinessException(Response.Code.BUSINESS_ERROR.getNum(), "购物车中不含此商品，无需移除");
        }
        collectGoodsDao.deleteByUseridGoodsid(userId, goodsId);
    }

    /**
     * 查询某用户的收藏商品
     * @return 返回Basic信息的集合
     */
    public List<Basic> getAllCollect(int userId){
        List<Integer> collectId = collectGoodsDao.selectByUserId(userId);
        List<Basic> res=new LinkedList<>();
        for(int i:collectId){
            Basic temp=basicService.getGoodById(i);
            if(temp!=null){
                res.add(temp);
            }
        }
        return res;
    }
}