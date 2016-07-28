package com.mvc.configurator

import com.mvc.interceptors.GlobalInterceptor
import com.mvc.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by tm1c14 on 27/07/2016.
 */
@Configuration
@EnableWebMvc
class AppConfig extends WebMvcConfigurerAdapter{

    @Autowired
    PersonService personService

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new GlobalInterceptor())
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new  StringToDateConverter())
        PersonConverter personConverter = new PersonConverter()
        personConverter.setPersonService(personService)
        registry.addConverter(personConverter)
    }
}
