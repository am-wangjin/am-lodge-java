package am.lodge.commons.model;

import java.io.Serializable;

/**
 * @author am
 */
public abstract class AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  public AbstractEntity() {
  }

  public int hashCode() {
    return 0;
  }

  public boolean equals(Object obj) {
    return false;
  }
}

