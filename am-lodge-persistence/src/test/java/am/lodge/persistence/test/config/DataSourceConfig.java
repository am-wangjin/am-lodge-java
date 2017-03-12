package am.lodge.persistence.test.config;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by am on 16-10-15.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig{

  @Value("${url}")
  private String url;

  @Value("${user}")
  private String user;

  @Value("${password}")
  private String password;

  @Bean
  public DataSource dataSource(){
    return JdbcConnectionPool.create(url, user, password);
  }
}
