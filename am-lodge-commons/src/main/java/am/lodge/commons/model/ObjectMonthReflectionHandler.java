package am.lodge.commons.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author am
 */
public class ObjectMonthReflectionHandler implements ObjectMethodHandler{

  @Override
  public int hashCode(Object obj) {
    return HashCodeBuilder.reflectionHashCode(obj);
  }

  @Override
  public boolean equals(Object source, Object target) {
    return EqualsBuilder.reflectionEquals(source, target);
  }
}
