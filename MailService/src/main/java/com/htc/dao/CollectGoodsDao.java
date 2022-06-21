package com.htc.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectGoodsDao {
    /**
     * 返回某用户的所有收藏商品id
     * @return goodsId的集合
     */
    @Select("select goodsId from CollectGoods where userId=#{userId};")
    List<Integer> selectByUserId(int userId);

    /**
     * 判断某用户是否收藏某商品
     * @return 1表示已收藏，0表示没有
     */
    @Select("select count(*) from CollectGoods where userId=#{userId} and goodsId=#{goodsId};")
    int selectByUseridGoodsid(@Param("userId") int userId, @Param("goodsId") int goodsId);

    /**
     * 插入新的收藏信息
     */
    @Insert("insert into CollectGoods (userId, goodsId) VALUES (#{userId},#{goodsId});")
    void insertByUseridGoodsid(@Param("userId") int userId, @Param("goodsId") int goodsId);

    /**
     * 删除指定的收藏信息
     * @param userId 用户id
     * @param goodsId 商品id
     */
    @Delete("delete from CollectGoods where userId=#{userId} and goodsId=#{goodsId};")
    void deleteByUseridGoodsid(@Param("userId") int userId, @Param("goodsId") int goodsId);
}
