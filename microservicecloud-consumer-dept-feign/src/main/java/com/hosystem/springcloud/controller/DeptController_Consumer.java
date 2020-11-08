package com.hosystem.springcloud.controller;

import com.hosystem.springcloud.entities.Dept;
import com.hosystem.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController //注:这里一定不能忘记注解@RestController 否则出现404;
public class DeptController_Consumer {

    //注：如果出现could not autowired no beans of 'DeptClientService' type found. 我们只需要将@autowired改成@Resource即可
    @Resource
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }
}