package com.htc.service;

import com.htc.dao.CommodityDao;
import com.htc.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificPageService {
    @Autowired
    private CommodityDao commodityDao;

    public List<Commodity> getAllGoods(){
        return commodityDao.selectAll();
    }

    public Commodity getGoodById(int goodsId){
        return commodityDao.selectAllById(goodsId);
    }
}
