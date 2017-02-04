package am.lodge.spring.mvc.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by am on 17-2-4.
 */
public class RedirectTest extends AbstractTest{

  @Test
  public void redirect() throws Exception{
    getMockMvc().perform(get("/redirect"))
        .andDo(MockMvcResultHandlers.print())
        .andDo(mvcResult -> Assert.assertEquals(HttpStatus.FOUND.value(), mvcResult.getResponse().getStatus()))
        .andReturn();
  }

}
