package am.lodge.json.jackson;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * Created by am on 17-3-23.
 */
public class DynamicAnnotationIntrospector extends JacksonAnnotationIntrospector {

  @Override
  protected boolean _isIgnorable(Annotated annotated) {
    System.out.println(annotated);
    return super._isIgnorable(annotated);
  }
}
