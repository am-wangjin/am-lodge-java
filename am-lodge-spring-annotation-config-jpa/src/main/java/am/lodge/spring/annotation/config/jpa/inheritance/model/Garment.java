package am.lodge.spring.annotation.config.jpa.inheritance.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by am on 16-10-16.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Garment extends Goods{

  private Integer size;

  public Integer getSize(){
    return size;
  }

  public void setSize(Integer size){
    this.size = size;
  }
}
