package am.lodge.commons.model.test;

import am.lodge.commons.model.AbstractObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author am
 */
public class Person extends AbstractObject{

  private String name;

  private int age;

  private Map<String, Object> attr = new HashMap<>();

  public Person(String name, int age){
    setName(name);
    setAge(age);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAttr(String key, Object value){
    this.attr.put(key, value);
  }

  public Object getAttr(String key){
    return this.attr.get(key);
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
