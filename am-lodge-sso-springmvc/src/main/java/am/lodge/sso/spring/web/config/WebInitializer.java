package am.lodge.sso.spring.web.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by am on 16-11-13.
 */
@Order(1)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

  @Override
  protected Filter[] getServletFilters(){
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);
    return new Filter[]{characterEncodingFilter};
  }

  @Override
  protected Class<?>[] getRootConfigClasses(){
    return new Class<?>[]{AppConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses(){
    return new Class[]{MvcConfig.class};
  }

  @Override
  protected String[] getServletMappings(){
    return new String[]{"/"};
  }
}
