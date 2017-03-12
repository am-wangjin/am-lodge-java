package am.lodge.spring.mvc.config;

import am.lodge.spring.mvc.servlet.handler.HandlerMethodExceptionResolver;
import am.lodge.spring.mvc.view.MappingJacksonJsonView;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

import static am.lodge.commons.util.CollectionUtils.list;

/**
 * Created by am on 16-11-13.
 */
public class BaseMvcConfig extends WebMvcConfigurationSupport{

  @Bean
  @Override
  public ViewResolver mvcViewResolver() {
    ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
    viewResolver.setContentNegotiationManager(this.mvcContentNegotiationManager());
    viewResolver.setOrder(1);
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    view.setServletContext(this.getServletContext());
    view.setApplicationContext(this.getApplicationContext());
    viewResolver.setDefaultViews(list(view));


    InternalResourceViewResolver irvResolver = new InternalResourceViewResolver();
    irvResolver.setApplicationContext(this.getApplicationContext());
    irvResolver.setServletContext(this.getServletContext());
    irvResolver.setOrder(2);
    viewResolver.setViewResolvers(list(irvResolver));
    return viewResolver;
  }

  @Override
  protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    exceptionResolvers.add(new HandlerMethodExceptionResolver());
  }
}
