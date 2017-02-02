package am.lodge.spring.mvc.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by am on 16-11-13.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "am.lodge.spring.mvc.test.controller",
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
public class MvcConfig{
}
