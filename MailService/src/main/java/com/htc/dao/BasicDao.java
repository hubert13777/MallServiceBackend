package com.htc.dao;

import com.htc.entity.Basic;
import com.htc.entity.Commodity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BasicDao {
    @Select("select * from Basic;")
    public List<Basic> selectAll();
    
    @Select("select * from Basic where goodsId = #{id};")
    public Basic selectAllById(int id);
}
