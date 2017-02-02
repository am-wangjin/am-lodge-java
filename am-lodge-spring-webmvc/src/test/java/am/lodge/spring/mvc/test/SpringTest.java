package am.lodge.spring.mvc.test;

import am.lodge.spring.mvc.test.config.ApplicationConfig;
import am.lodge.spring.mvc.test.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by am on 17-1-26.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationConfig.class},
        loader = AnnotationConfigContextLoader.class )
public class SpringTest{

  @Test
  public void test(){
    System.out.println("初始化成功");
  }
}
