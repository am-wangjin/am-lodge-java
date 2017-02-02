package am.lodge.spring.mvc.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by am on 17-1-26.
 */
@Configuration
@ComponentScan(basePackages = "am.lodge.spring.mvc.test", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
public class ApplicationConfig{
}
