package com.hosystem.springcloud.controller;

import com.hosystem.springcloud.entities.Dept;
import com.hosystem.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeptController
{
    @Autowired
    private DeptService service;

    //注：如果Autowired显示 could not autowired.there is more than one bean of 'DiscoveryClient' type; 使用一下两种方法都行
    //方法1:那么只需要添加@Qualifier("discoveryClient")即可
    //方法2::当然也可以修改成 private DiscoveryClient discoveryClient; 但是我们也需要修改discovery()方法中client为discoveryClient
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
