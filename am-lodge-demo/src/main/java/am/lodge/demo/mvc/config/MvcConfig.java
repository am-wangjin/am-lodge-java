package am.lodge.demo.mvc.config;

import am.lodge.spring.mvc.config.BaseMvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by am on 17-2-3.
 */
@Configuration
@ComponentScan(basePackages = "am.lodge.demo.*.controller",
    useDefaultFilters = false,
    includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
public class MvcConfig extends BaseMvcConfig{
}
