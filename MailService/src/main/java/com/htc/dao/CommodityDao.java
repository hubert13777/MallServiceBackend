package com.htc.dao;

import com.htc.entity.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {
    @Select("select * from Commodity;")
    public List<Commodity> selectAll();

    @Select("select * from Commodity where goodsId = #{id};")
    public Commodity selectAllById(int id);

    @Insert("insert into Commodity (goodsId, goodsName, message, tabs, description," +
            "price, pictureUrl1, pictureUrl2, pictureUrl3, specification, generateInformation, iconUrl) " +
            "values (#{goodsId},#{goodsName},#{message},#{tabs},#{description},#{price},#{pictureUrl1},#{pictureUrl2}," +
            "#{pictureUrl3},#{specification},#{generateInformation},#{iconUrl});")
    public void insertGood(Commodity commodity);

    @Delete("delete from Commodity where goodsId=#{goodsId};")
    public void deleteById(int goodsId);
}
