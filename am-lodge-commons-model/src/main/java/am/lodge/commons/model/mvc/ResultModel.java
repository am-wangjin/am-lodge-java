package am.lodge.commons.model.mvc;

import java.io.Serializable;

/**
 * Created by am on 16-11-20.
 */
public class ResultModel implements Serializable{

  public final static String STATE_ERROR = "-1";

  private String state;

  private Object data;

  public String getState(){
    return state;
  }

  public void setState(String state){
    this.state = state;
  }

  public Object getData(){
    return data;
  }

  public void setData(Object data){
    this.data = data;
  }
}
