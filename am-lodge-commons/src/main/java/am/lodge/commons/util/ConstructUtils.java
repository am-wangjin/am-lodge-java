package am.lodge.commons.util;

import java.util.*;

/**
 * Created by am on 17-2-3.
 */
public class ConstructUtils {
  private static final int MAP_PAIR_LEN = 2;

  public static <K, V> Map<K, V> map(Object... args) {
    if (args == null || args.length == 0) {
      return new HashMap<>();
    }

    if (args.length % MAP_PAIR_LEN != 0) {
      throw new RuntimeException("数组长度必须为2的倍数");
    }

    Map<K, V> result = new HashMap<>(args.length / MAP_PAIR_LEN);
    for (int i = 0; i < args.length - 1; i += MAP_PAIR_LEN) {
      result.put((K) args[i], (V) args[i + 1]);
    }
    return result;
  }

  public static <T> List<T> list(T... args) {
    if (args == null || args.length == 0) {
      return new ArrayList();
    }

    List<T> result = new ArrayList(args.length);
    for (T o : args) {
      result.add(o);
    }
    return result;
  }

  public static <T> Set<T> set(T... args) {
    if (args == null || args.length == 0) {
      return new HashSet<>();
    }

    Set<T> result = new HashSet<>(args.length);
    for (T o : args) {
      result.add(o);
    }
    return result;
  }
}
