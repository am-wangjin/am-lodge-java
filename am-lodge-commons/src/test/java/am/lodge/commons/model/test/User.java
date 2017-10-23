package am.lodge.commons.model.test;

import am.lodge.commons.model.AbstractObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author am
 */
public class User extends AbstractObject{

  private String name;

  private String password;

  private Map<String, Object> attr = new HashMap<String, Object>();

  public User(String name, String password){
    setName(name);
    setPassword(password);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAttr(String key, Object value){
    this.attr.put(key, value);
  }

  public Object getAttr(String key){
    return this.attr.get(key);
  }
}
