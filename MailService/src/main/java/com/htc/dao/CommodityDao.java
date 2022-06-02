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
    public void insertGood(@Param("goodsId") int id, @Param("goodsName") String goodsName, @Param("message") String message,
                           @Param("tabs") String tabs, @Param("description") String description, @Param("price") float price,
                           @Param("pictureUrl1") String pictureUrl1, @Param("pictureUrl2") String pictureUrl2, @Param("pictureUrl3") String pictureUrl3,
                           @Param("specification") String specification, @Param("generateInformation") String generateInformation,
                           @Param("iconUrl") String iconUrl);
    
    @Delete("delete from Commodity where goodsId=#{goodsId};")
    public void deleteById(int goodsId);
}
