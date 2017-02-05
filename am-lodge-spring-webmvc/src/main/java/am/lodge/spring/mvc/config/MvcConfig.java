package am.lodge.spring.mvc.config;

import am.lodge.spring.mvc.view.MappingJacksonJsonView;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by am on 16-11-13.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport{

  protected void configureViewResolvers(ViewResolverRegistry registry) {
    registry.order(1);
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    view.setApplicationContext(this.getApplicationContext());
    view.setServletContext(this.getServletContext());
    registry.enableContentNegotiation(view);

    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setApplicationContext(this.getApplicationContext());
    viewResolver.setServletContext(this.getServletContext());
    viewResolver.setOrder(2);
    registry.viewResolver(viewResolver);
  }
}
