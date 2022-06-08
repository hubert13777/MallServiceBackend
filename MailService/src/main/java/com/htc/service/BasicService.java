package com.htc.service;

import com.htc.dao.BasicDao;
import com.htc.entity.Basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {
    @Autowired
    private BasicDao basicDao;

    /**
     * 获取所有Basic视图中的商品信息
     * @return Basic对象列表
     */
    public List<Basic> getAllGoods() {
        return basicDao.selectAll();
    }

    /**
     * 根据商品id获取Basic视图中的商品信息
     * @param goodsId 商品id
     * @return Basic对象
     */
    public Basic getGoodById(int goodsId) {
        return basicDao.selectgoodById(goodsId);
    }
}
