package am.lodge.commons.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by am on 17-2-3.
 */
public class CollectionUtils{

  public static <T> List<T> list(T... args) {
    if(args == null || args.length == 0) {
      return new ArrayList();
    }

    List<T> result = new ArrayList(args.length);
    for(T o : args) {
      result.add(o);
    }
    return result;
  }
}
