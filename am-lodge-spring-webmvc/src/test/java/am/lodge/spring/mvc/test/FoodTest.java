package am.lodge.spring.mvc.test;

import am.lodge.spring.mvc.test.model.Food;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by am on 17-1-26.
 * http://jinnianshilongnian.iteye.com/blog/2004660
 */
public class FoodTest extends AbstractTest{

  @Test
  public void findAll() throws Exception{
    String content = "{\"state\":\"1\",\"data\":[{\"id\":\"1\",\"name\":\"面包\"},{\"id\":\"2\",\"name\":\"米饭\"}]}";
    getMockMvc().perform(get("/foods.json"))
        .andDo(MockMvcResultHandlers.print())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
  }

  @Test
  public void findOne() throws Exception{
    String content = "{\"state\":\"1\",\"data\":{\"id\":\"1\",\"name\":\"面包\"}}";
    MvcResult result = getMockMvc().perform(get("/foods/1.json"))
        .andDo(MockMvcResultHandlers.print())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
    Food food = (Food) result.getModelAndView().getModel().get("food");
    Assert.assertNotNull(food);
  }

  @Test
  public void create() throws Exception{
    String content = "{\"state\":\"1\",\"data\":{\"id\":\"1\",\"name\":\"面包\"}}";
    getMockMvc().perform(post("/foods.json").param("name", "面包"))
        .andDo(MockMvcResultHandlers.print())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
  }

  @Test
  public void update() throws Exception{
    String content = "{\"state\":\"1\",\"data\":{\"id\":\"1\",\"name\":\"米饭\"}}";
    getMockMvc().perform(put("/foods.json").param("id", "1").param("name", "面包"))
        .andDo(MockMvcResultHandlers.print())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
  }

  @Test
  public void _delete() throws Exception{
    getMockMvc().perform(delete("/foods.json").param("id", "1").param("id", "2"))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
  }
}
