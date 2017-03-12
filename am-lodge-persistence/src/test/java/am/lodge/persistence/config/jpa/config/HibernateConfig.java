package am.lodge.spring.annotation.config.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by am on 16-10-15.
 */
@Configuration
@PropertySource("classpath:hibernate.properties")
@Import(DataSourceConfig.class)
public class HibernateConfig{

  @Autowired
  private DataSource dataSource;

  @Value("${dialect}")
  private String dialect;

  @Value("${packagesToScan}")
  private String packagesToScan;

  @Value("${hbm2ddl}")
  private String hbm2ddl;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setPackagesToScan(packagesToScan);
    entityManagerFactory.setDataSource(dataSource);
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", dialect);
    jpaProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
    entityManagerFactory.setJpaProperties(jpaProperties);
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setGenerateDdl(true);
    jpaVendorAdapter.setShowSql(true);
    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
    return entityManagerFactory;
  }

  @Bean
  public SharedEntityManagerBean entityManager(){
    SharedEntityManagerBean entityManager = new SharedEntityManagerBean();
    entityManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return entityManager;
  }

  @Bean
  public JpaTransactionManager txManager(){
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return txManager;
  }
}
