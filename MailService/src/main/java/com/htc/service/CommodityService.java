package com.htc.service;

import com.htc.dao.CommodityDao;
import com.htc.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    /**
     * 获取所有商品信息
     * @return Commodity集合
     */
    public List<Commodity> getAllGoods(){
        return commodityDao.selectAll();
    }

    /**
     * 根据商品ID获取指定商品信息
     * @param goodsId
     * @return Commodity对象
     */
    public Commodity getGoodById(int goodsId){
        return commodityDao.selectAllById(goodsId);
    }

    /**
     * 插入单个商品信息
     * @param commodity 商品类对象
     * @return true表示插入成功
     */
    public boolean addGood(Commodity commodity){
        commodityDao.insertGood(commodity);
        return true;
    }
}
