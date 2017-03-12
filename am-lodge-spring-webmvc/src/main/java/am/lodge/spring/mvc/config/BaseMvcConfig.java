package am.lodge.spring.mvc.config;

import am.lodge.spring.mvc.servlet.handler.HandlerMethodExceptionResolver;
import am.lodge.spring.mvc.view.MappingJacksonJsonView;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by am on 16-11-13.
 */
public class BaseMvcConfig extends WebMvcConfigurationSupport {

  @Override
  protected void configureViewResolvers(ViewResolverRegistry registry) {
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    view.setServletContext(this.getServletContext());
    view.setApplicationContext(this.getApplicationContext());
    registry.enableContentNegotiation(view);


    InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
    jspResolver.setApplicationContext(this.getApplicationContext());
    jspResolver.setServletContext(this.getServletContext());
    jspResolver.setPrefix("/WEB-INF/views/");
    jspResolver.setSuffix(".jsp");
    jspResolver.setOrder(1);
    registry.viewResolver(jspResolver);
  }

  @Override
  protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    exceptionResolvers.add(new HandlerMethodExceptionResolver());
  }
}
