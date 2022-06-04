package com.htc.dao;

import com.htc.entity.Basic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicDao {
    @Select("select * from Basic;")
    public List<Basic> selectAll();
    
    @Select("select * from Basic where goodsId = #{id};")
    public Basic selectAllById(int id);
}
