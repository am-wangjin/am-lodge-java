package am.lodge.spring.annotation.config.jpa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by am on 16-10-15.
 */
@Entity
public class User implements Serializable{

  private String id;

  private String name;

  private String password;

  private String states;

  @Id
  @GeneratedValue(generator = "id-generator")
  @GenericGenerator(name = "id-generator", strategy = "uuid")
  @Column(nullable = false, length = 32)
  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  @Column(nullable = false, length = 32)
  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  @Column(nullable = false, length = 1)
  public String getStates(){
    return states;
  }

  public void setStates(String states){
    this.states = states;
  }
}