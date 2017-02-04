package am.lodge.spring.mvc.test;

import am.lodge.spring.mvc.test.model.Food;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by am on 17-1-26.
 * http://jinnianshilongnian.iteye.com/blog/2004660
 */
public class FoodTest extends AbstractTest{

  @Test
  public void findAll() throws Exception{
    String content = "{\"state\":\"1\",\"data\":[{\"id\":\"1\",\"name\":\"面包\"},{\"id\":\"2\",\"name\":\"米饭\"}]}";
    MvcResult result = getMockMvc().perform(get("/foods.json"))
        .andExpect(status().isOk())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
    result.getModelAndView().getModel().get("food");
  }

  @Test
  public void findOne() throws Exception{
    String content = "{\"state\":\"1\",\"data\":{\"id\":\"1\",\"name\":\"面包\"}}";
    MvcResult result = getMockMvc().perform(get("/foods/1.json"))
        .andExpect(status().isOk())
        .andDo(mvcResult -> Assert.assertEquals(content, mvcResult.getResponse().getContentAsString()))
        .andReturn();
    Food food = (Food) result.getModelAndView().getModel().get("food");
    Assert.assertNotNull(food);
  }
}
