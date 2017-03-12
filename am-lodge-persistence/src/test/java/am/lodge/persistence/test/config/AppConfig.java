package am.lodge.persistence.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by am on 16-10-15.
 */
@Configuration
@Import(HibernateConfig.class)
@ComponentScan(basePackages = {"am.lodge"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
@EnableTransactionManagement
public class AppConfig{
}
