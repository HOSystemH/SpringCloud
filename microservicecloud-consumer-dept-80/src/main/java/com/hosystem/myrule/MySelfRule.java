package com.hosystem.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
//        return new RandomRule();//Ribbon默认是轮询，我自定义为随机

        return  new RandomRule_Hosystem();  //自定义每台机器访问5次
    }
}
