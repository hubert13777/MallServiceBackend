package com.htc.entity;

public class Basic {
    private int goodsId;            // NOT NULL COMMENT '商品id'
    private String goodsName;       // varchar(20) NOT NULL DEFAULT '临时商品'
    private float price;            // decimal(10,2) unsigned NOT NULL DEFAULT '99.99'
    private String generateInformation; // varchar(40) DEFAULT NULL
    private String iconUrl;         // varchar(80) DEFAULT NULL

    @Override
    public String toString() {
        return "Basic{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
