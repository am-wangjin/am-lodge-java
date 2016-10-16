package am.lodge.spring.annotation.config.jpa.test;

import am.lodge.spring.annotation.config.jpa.model.User;
import am.lodge.spring.annotation.config.jpa.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by am on 16-10-16.
 */
public class UserTest extends AbstractTestCase{

  @Autowired
  private UserService userService;

  private static String id;

  @Test
  public void test1(){
    User user = new User();
    user.setName("刘备");
    user.setPassword("123");
    user.setStatus(1);
    userService.save(user);
    id = user.getId().toString();
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
    System.out.println("status=" + user.getStatus());
  }

  @Test
  public void test3(){
    int count = userService.findAll().size();
    System.out.println("查询成功");
    System.out.println("count=" + count);
  }
}
