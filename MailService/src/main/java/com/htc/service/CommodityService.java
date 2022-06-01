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

    public List<Commodity> getAllGoods(){
        return commodityDao.selectAll();
    }

    public Commodity getGoodsById(int goodsId){
        return commodityDao.selectAllById(goodsId);
    }
}
