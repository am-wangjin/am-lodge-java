package am.lodge.spring.annotation.config.jpa.inheritance.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by am on 16-10-16.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Shoe extends Goods{

  private String colour;

  public String getColour(){
    return colour;
  }

  public void setColour(String colour){
    this.colour = colour;
  }
}
