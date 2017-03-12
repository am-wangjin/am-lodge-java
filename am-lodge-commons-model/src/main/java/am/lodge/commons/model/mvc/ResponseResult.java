package am.lodge.commons.model.mvc;

import java.io.Serializable;

/**
 * Created by am on 16-11-20.
 */
public class ResponseResult implements Serializable{

  public final static String FAILURE = "0";

  public final static String SUCCESS = "1";

  private String state = SUCCESS;

  private String msg = "";

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

  public String getMsg(){
    return msg;
  }

  public void setMsg(String msg){
    this.msg = msg;
  }
}
