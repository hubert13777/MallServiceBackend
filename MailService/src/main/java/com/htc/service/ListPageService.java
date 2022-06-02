package com.htc.service;

import com.htc.dao.BasicDao;
import com.htc.entity.Basic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListPageService {
    @Autowired
    private BasicDao basicDao;
    
    public List<Basic> getAllGoods() {
        return basicDao.selectAll();
    }
    
    public Basic getGoodById(int goodsId) {
        return basicDao.selectAllById(goodsId);
    }
}
