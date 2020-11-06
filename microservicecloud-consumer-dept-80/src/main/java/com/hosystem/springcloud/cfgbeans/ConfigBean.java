package com.hosystem.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //boot ---> spring applicationContext.xml === @Configuration配置 ConfigBean = applicationContext.xml
{
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}

//applicationContext.xml  ---> @Configuration public class ConfigBean {}
//<bean id=UserService" class="com.hosystem.tmall.UserServiceImple>
