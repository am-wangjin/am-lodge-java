package am.lodge.spring.mvc.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

import static am.lodge.commons.util.CollectionUtils.list;

/**
 * Created by am on 16-11-13.
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements ApplicationContextAware, ServletContextAware{
  private ApplicationContext applicationContext;
  private ServletContext servletContext;
  private ContentNegotiationManager contentNegotiationManager;

  @Bean
  public ContentNegotiationManager mvcContentNegotiationManager(){
    if(this.contentNegotiationManager == null){
      ContentNegotiationManagerFactoryBean factory = new ContentNegotiationManagerFactoryBean();
      factory.setServletContext(this.servletContext);
      factory.setIgnoreAcceptHeader(true);
      factory.addMediaType("json", MediaType.APPLICATION_JSON);
      try{
        factory.afterPropertiesSet();
        this.contentNegotiationManager = factory.getObject();
      }catch(Exception ex){
        throw new BeanInitializationException("Could not create ContentNegotiationManager", ex);
      }
    }
    return this.contentNegotiationManager;
  }

  @Bean
  public RequestMappingHandlerMapping requestMappingHandlerMapping(){
    RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
    handlerMapping.setContentNegotiationManager(this.mvcContentNegotiationManager());
    return handlerMapping;
  }

  @Bean
  public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
    RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
    adapter.setContentNegotiationManager(this.mvcContentNegotiationManager());
    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.applicationContext).build();
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
    adapter.getMessageConverters().add(converter);
    return adapter;
  }

  @Bean
  public ViewResolver viewResolver(){
    ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
    viewResolver.setContentNegotiationManager(this.mvcContentNegotiationManager());
    viewResolver.setOrder(1);
    MappingJackson2JsonView view = new MappingJackson2JsonView();
    view.setServletContext(this.servletContext);
    view.setApplicationContext(this.applicationContext);
    viewResolver.setDefaultViews(list(view));
    return viewResolver;
  }

  @Override
  public void setServletContext(ServletContext servletContext){
    this.servletContext = servletContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
    this.applicationContext = applicationContext;
  }
}
