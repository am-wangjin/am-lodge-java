package test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by am on 17-3-17.
 */
public class User {

  private String id;

  private String name;

  @JsonIgnore
  public String getId() {
    return id;
  }

  @JsonProperty
  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
