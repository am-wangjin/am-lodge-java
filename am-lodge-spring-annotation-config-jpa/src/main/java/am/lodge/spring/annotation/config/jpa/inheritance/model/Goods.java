package am.lodge.spring.annotation.config.jpa.inheritance.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by am on 16-10-16.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Goods implements Serializable{
  private String id;

  private String name;

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
}
