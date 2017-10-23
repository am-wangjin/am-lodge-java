package am.lodge.commons.model.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author am
 */
public class ObjectTest {

  @Test
  public void test1(){
    Person u1 = new Person(null, 1);
    Person u2 = new Person(null, 1);
    Assert.assertTrue(u1.equals(u2));
    u1 = new Person("abc", 1);
    u2 = new Person("abc", 1);
    Assert.assertTrue(u1.equals(u2));
    u1 = new Person("abc", 1);
    u2 = new Person("abc", 2);
    Assert.assertTrue(!u1.equals(u2));
  }
}
