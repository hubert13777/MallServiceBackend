package com.htc.service;

import com.htc.config.SpringConfig;
import com.htc.dao.CommodityDao;
import com.htc.entity.Commodity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CommodityServiceTest {
    @Autowired
    private CommodityService commodityService;

    @Test
    public void testCommodity() {
        List<Commodity> goods = commodityService.getAllGoods();
        for(Commodity good:goods){
            System.out.println(good);
        }
//        测试添加数据
//        Commodity good=new Commodity();
//        good.setGoodsName("拖鞋");
//        good.setPrice(19.9f);
//        commodityService.addGood(good);
    }
}
