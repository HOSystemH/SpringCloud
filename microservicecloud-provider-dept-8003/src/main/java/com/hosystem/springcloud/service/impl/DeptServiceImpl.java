package com.hosystem.springcloud.service.impl;

import com.hosystem.springcloud.dao.DeptDao;
import com.hosystem.springcloud.entities.Dept;
import com.hosystem.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService
{
    //注意：这里我们需要将@Autowired 修改成    @Resource否则可能会出现错误
    //Eclipse 使用@Autowired不会错误，
    //但是在IDEA中，我用了@Autowired发现出现'could not autowired no beans of 'DeptDao' type found'错误。我把@Autowired改成了@Resource就解决了
    //如果@Authwired错误了我们可以将@Autowired改成了@Resource就解决了
    @Resource
    private DeptDao dao;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }
}
