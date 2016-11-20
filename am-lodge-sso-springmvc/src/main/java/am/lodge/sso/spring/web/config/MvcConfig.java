package am.lodge.sso.spring.web.config;

import am.lodge.sso.spring.web.exception.GlobalHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by am on 16-11-13.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "am.lodge.sso.spring.web.controller", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
public class MvcConfig{

  @Bean
  public ViewResolver resourceViewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/jsp/");
    viewResolver.setSuffix(".jsp");
    viewResolver.setOrder(0);
    return viewResolver;
  }

//  @Bean
//  public HandlerMapping handlerMapping(){
//    RequestMappingHandlerMapping result = new RequestMappingHandlerMapping();
//    return result;
//  }

  @Bean
  public HandlerAdapter handlerAdapter(){
    RequestMappingHandlerAdapter result = new RequestMappingHandlerAdapter();
    HttpMessageConverter o = new MappingJackson2HttpMessageConverter();
    result.getMessageConverters().add(o);
    return result;
  }

  @Bean
  public HandlerExceptionResolver handlerExceptionResolver(){
    HandlerExceptionResolver result = new GlobalHandlerExceptionResolver();
    return result;
  }

  @Bean
  public HandlerAdapter servletHandlerAdapter(){
    return new SimpleServletHandlerAdapter();
  }
}
