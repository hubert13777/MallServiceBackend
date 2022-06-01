package com.htc.dao;

import com.htc.entity.Commodity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommodityDao {
    @Select("select * from commodity;")
    public List<Commodity> selectAll();

    @Select("select * from commodity where goodsId = #{id};")
    public Commodity selectAllById(int id);
}
