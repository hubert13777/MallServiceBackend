package com.htc.dao;

import com.htc.entity.Commodity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {
    @Select("select * from Commodity;")
    public List<Commodity> selectAll();

    @Select("select * from Commodity where goodsId = #{id};")
    public Commodity selectAllById(int id);
}
