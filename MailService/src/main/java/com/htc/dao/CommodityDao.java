package com.htc.dao;

import com.htc.entity.Commodity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {
    @Select("select * from Commodity;")
    List<Commodity> selectAll();

    @Select("select * from Commodity where goodsId = #{id};")
    Commodity selectAllById(int id);

    @Insert("insert into Commodity (goodsId, goodsName, message, tabs, description," +
            "price, pictureUrl1, pictureUrl2, pictureUrl3, specification, generateInformation, iconUrl) " +
            "values (#{goodsId},#{goodsName},#{message},#{tabs},#{description},#{price},#{pictureUrl1},#{pictureUrl2}," +
            "#{pictureUrl3},#{specification},#{generateInformation},#{iconUrl});")
    void insertGood(Commodity commodity);

    @Delete("delete from Commodity where goodsId=#{goodsId};")
    void deleteById(int goodsId);

    @Update("update Commodity set goodsName=#{goodsName} where goodsId=#{id};")
    void updateGoodNameById(@Param("id") int id,@Param("goodsName") String goodsName);
}
