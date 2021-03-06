package com.hosystem.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.hosystem.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptDao
{


    public boolean addDept(Dept dept);

    public Dept findById(Long id);

//    @Select("select * from dept")
    public List<Dept> findAll();
}
