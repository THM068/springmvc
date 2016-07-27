package com.mvc.configurator

import com.mvc.interceptors.GlobalInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by tm1c14 on 27/07/2016.
 */
@Configuration
@EnableWebMvc
class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new GlobalInterceptor())
    }
}
