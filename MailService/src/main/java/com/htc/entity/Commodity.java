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
    private String pictureUrl1;     // varchar(80) DEFAULT NULL
    private String pictureUrl2;     // varchar(80) DEFAULT NULL
    private String pictureUrl3;     // varchar(80) DEFAULT NULL
    private String specification;   // varchar(100) DEFAULT NULL COMMENT '细节'
    private String generateInformation; // varchar(40) DEFAULT NULL
    private String iconUrl;         // varchar(80) DEFAULT NULL

    @Override
    public String toString() {
        return "Commodity{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", message='" + message + '\'' +
                ", tabs='" + tabs + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pictureUrl1='" + pictureUrl1 + '\'' +
                ", pictureUrl2='" + pictureUrl2 + '\'' +
                ", pictureUrl3='" + pictureUrl3 + '\'' +
                ", specification='" + specification + '\'' +
                ", generateInformation='" + generateInformation + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
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

    public String getPictureUrl1() {
        return pictureUrl1;
    }

    public void setPictureUrl1(String pictureUrl1) {
        this.pictureUrl1 = pictureUrl1;
    }

    public String getPictureUrl2() {
        return pictureUrl2;
    }

    public void setPictureUrl2(String pictureUrl2) {
        this.pictureUrl2 = pictureUrl2;
    }

    public String getPictureUrl3() {
        return pictureUrl3;
    }

    public void setPictureUrl3(String pictureUrl3) {
        this.pictureUrl3 = pictureUrl3;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getGenerateInformation() {
        return generateInformation;
    }

    public void setGenerateInformation(String generateInformation) {
        this.generateInformation = generateInformation;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
