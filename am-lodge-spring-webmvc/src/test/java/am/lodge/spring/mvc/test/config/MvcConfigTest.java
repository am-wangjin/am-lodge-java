package am.lodge.spring.mvc.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Created by am on 17-2-3.
 */
@Configuration
@ComponentScan(basePackages = "am.lodge.spring.mvc.test.controller",
    useDefaultFilters = false,
    includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
@Import(MvcConfig.class)
public class MvcConfigTest{
}
