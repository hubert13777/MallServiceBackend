package com.htc.entity;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CommodityForAndroid {
    private int goodsId;            // NOT NULL COMMENT '商品id'
    private String goodsName;       // varchar(20) NOT NULL DEFAULT '临时商品'
    private String message;         // varchar(60) COMMENT '商品信息'
    private String tabs;            // varchar(60) COMMENT '标签'
    private String description;     // varchar(40) COMMENT '宣传描述'
    private float price;            // decimal(10,2) unsigned NOT NULL DEFAULT '99.99'
    private List<String> pictureUrl;
    private String specification;   // varchar(100) COMMENT '细节'
    
    public CommodityForAndroid(){}
    
    public CommodityForAndroid(Commodity commodity) {
        this.goodsId=commodity.getGoodsId();
        this.goodsName=commodity.getGoodsName();
        this.message=commodity.getMessage();
        this.tabs=commodity.getTabs();
        this.description=commodity.getDescription();
        this.price=commodity.getPrice();
        this.pictureUrl=new LinkedList<>();
        this.pictureUrl.add(commodity.getPictureUrl1());
        this.pictureUrl.add(commodity.getPictureUrl2());
        this.pictureUrl.add(commodity.getPictureUrl3());
        this.specification=commodity.getSpecification();
    }
    
    @Override
    public String toString() {
        return "CommodityForAndroid{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", message='" + message + '\'' +
                ", tabs='" + tabs + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pictureUrl=" + pictureUrl +
                ", specification='" + specification + '\'' +
                '}';
    }
    
    public int getGoodsId() {
        return goodsId;
    }
    
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    
    public String getGoodsName() {
        return goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getTabs() {
        return tabs;
    }
    
    public void setTabs(String tabs) {
        this.tabs = tabs;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public List<String> getPictureUrl() {
        return pictureUrl;
    }
    
    public void setPictureUrl(List<String> pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    
    public String getSpecification() {
        return specification;
    }
    
    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
