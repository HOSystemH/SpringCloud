package com.hosystem.springcloud.dao;

import com.hosystem.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao
{


    public boolean addDept(Dept dept);

    public Dept findById(Long id);

//    @Select("select * from dept")
    public List<Dept> findAll();
}
