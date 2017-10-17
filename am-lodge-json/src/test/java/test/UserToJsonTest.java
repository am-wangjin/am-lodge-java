package test;

import am.lodge.json.jackson.DynamicAnnotationIntrospector;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by am on 17-3-17.
 */
public class UserToJsonTest {

  @Test
  public void test() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setAnnotationIntrospector(new DynamicAnnotationIntrospector());
    User user = new User();
    user.setId("123");
    user.setName("名称");
    System.out.println(mapper.writeValueAsString(user));
  }

  @Test
  public void test1() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    User user = mapper.readValue("{\"id\": \"123\"}", User.class);
    System.out.println(user.getId());
  }
}
