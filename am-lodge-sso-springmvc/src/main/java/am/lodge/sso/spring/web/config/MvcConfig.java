package am.lodge.sso.spring.web.config;

<<<<<<< HEAD
=======
import am.lodge.sso.spring.web.exception.GlobalHandlerExceptionResolver;
>>>>>>> origin/master
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
<<<<<<< HEAD
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "am.lodge.sso.spring.web.controller", useDefaultFilters = false, includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
public class MvcConfig extends WebMvcConfigurationSupport{

  @Bean
  public ViewResolver JsonResolver() {
    ContentNegotiatingViewResolver c;
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public ViewResolver JspResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    viewResolver.setOrder(2);
    return viewResolver;
  }

  @Bean
  public HandlerAdapter servletHandlerAdapter(){
    return new SimpleServletHandlerAdapter();
  }

  @Override
  protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
    ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
    return initializer;
=======
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
@EnableWebMvc
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
>>>>>>> origin/master
  }
}
