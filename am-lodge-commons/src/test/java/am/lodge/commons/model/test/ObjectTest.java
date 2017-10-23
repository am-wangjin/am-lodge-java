package am.lodge.commons.model.test;

import org.junit.Test;

/**
 * @author am
 */
public class ObjectTest {

  @Test
  public void test1(){
    User u1 = new User(null, null);
    User u2 = new User(null, null);
    System.out.println(u1.equals(u2));
  }
}
