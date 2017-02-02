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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Created by am on 16-11-13.
 */
@Configuration
@ComponentScan(basePackages = "am.lodge.sso.spring.web.controller", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
public class MvcConfig extends WebMvcConfigurationSupport{

  //开启跨域请求支持
  @Override
  public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/**");
  }

  //json数据返回
  @Bean
  public HandlerAdapter handlerAdapter(){
    RequestMappingHandlerAdapter result = new RequestMappingHandlerAdapter();
    HttpMessageConverter o = new MappingJackson2HttpMessageConverter();
    result.getMessageConverters().add(o);
    return result;
  }

  //统一异常处理
  @Bean
  public HandlerExceptionResolver handlerExceptionResolver(){
    HandlerExceptionResolver result = new GlobalHandlerExceptionResolver();
    return result;
  }

  //设置默认servlet处理
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
    configurer.enable();
  }
}
