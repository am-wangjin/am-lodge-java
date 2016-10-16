package am.lodge.spring.annotation.config.jpa;

import am.lodge.spring.annotation.config.jpa.model.User;
import am.lodge.spring.annotation.config.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by am on 16-10-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class MainTest{

  @Autowired
  private UserService userService;

  private static String id;

  @Test
  public void test1(){
    User user = new User();
    user.setName("刘备");
    user.setPassword("123");
    user.setStateus(1);
    userService.save(user);
    id = user.getId();
    System.out.println("save成功");
    System.out.println("id=" + id);
  }

  @Test
  public void test2(){
    User user = userService.findById(id);
    System.out.println("查询成功");
    System.out.println("id=" + user.getId());
    System.out.println("name=" + user.getName());
    System.out.println("password=" + user.getPassword());
    System.out.println("states=" + user.getStateus());
  }

  @Test
  public void test3(){
    int count = userService.findAll().size();
    System.out.println("查询成功");
    System.out.println("count=" + count);
  }
}
