package am.lodge.commons.model;

/**
 * @author am
 */
public interface ObjectMethodHandler {

  int hashCode(Object obj);

  boolean equals(Object source, Object target);
}
