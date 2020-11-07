package com.hosystem.springcloud.controller;

import com.hosystem.springcloud.entities.Dept;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController //注:这里一定不能忘记注解@RestController 否则出现404;
public class DeptController_Consumer {

    /**
     *  使用restTemplate访问restful接口非常的简单;
     *  (url, requestMap, ResponseBean.class)三个参数代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
     */
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    //@SuppressWarnings("unchecked"):压制警告，因为我们使用了过期的方法
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
/**
 *  JDBC    Spring JDBCTemplate
 *          Spring RestTemplate
 */