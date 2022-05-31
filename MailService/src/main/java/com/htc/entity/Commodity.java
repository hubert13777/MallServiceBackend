package com.htc.entity;

import org.springframework.stereotype.Repository;

@Repository("commodity")
public class Commodity {
    private int goodsId;            // NOT NULL COMMENT '商品id'
    private String goodsName;       // varchar(20) NOT NULL DEFAULT '临时商品'
    private String message;         // varchar(60) DEFAULT NULL COMMENT '商品信息'
    private String tabs;            // varchar(60) DEFAULT NULL COMMENT '标签'
    private String description;     // varchar(40) DEFAULT NULL COMMENT '宣传描述'
    private float price;            // decimal(10,2) unsigned NOT NULL DEFAULT '99.99'
    private String pictureUrl1;     // varchar(80) DEFAULT NULL,
    private String pictureUrl2;     // varchar(80) DEFAULT NULL,
    private String pictureUrl3;     // varchar(80) DEFAULT NULL,
    private String specification;   // varchar(100) DEFAULT NULL COMMENT '细节',
    private String generateInformation; // varchar(40) DEFAULT NULL,
    private String iconUrl;         // varchar(80) DEFAULT NULL,
    
    
}
