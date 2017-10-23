package am.lodge.commons.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author am
 */
public class ObjectMethodHandlerRegister {

  private static Map<String, ObjectMethodHandler> handlers = new HashMap<>();

  public static String DEFAULT_HANDLER = "DEFAULT_HANDLER";

  static {
    handlers.put(DEFAULT_HANDLER, new ObjectMonthReflectionHandler());
  }

  public static ObjectMethodHandler getHandler(String key){
    return handlers.get(key);
  }

  public static void register(String key, ObjectMethodHandler handler){
    handlers.put(key, handler);
  }
}
