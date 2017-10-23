package am.lodge.commons.model;


import java.io.Serializable;

/**
 * @author am
 */
public class AbstractObject implements Serializable {

  private String methodHandlerKey = ObjectMethodHandlerRegister.DEFAULT_HANDLER;

  @Override
  public int hashCode() {
    return ObjectMethodHandlerRegister.getHandler(methodHandlerKey).hashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return ObjectMethodHandlerRegister.getHandler(methodHandlerKey).equals(this, obj);
  }

  public void setMethodHandlerKey(String methodHandlerKey) {
    this.methodHandlerKey = methodHandlerKey;
  }
}
