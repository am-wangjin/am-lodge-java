package am.lodge.spring.mvc.test;

import am.lodge.spring.mvc.test.config.ApplicationConfig;
import am.lodge.spring.mvc.test.config.MvcConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by am on 17-1-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(name = "parent", classes = {ApplicationConfig.class}),
        @ContextConfiguration(name = "child", classes = {MvcConfig.class})
})
public class WebMvcTest{

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void testView() throws Exception {
    MvcResult result = mockMvc.perform(get("/foods/1.json"))
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
    Assert.assertNotNull(result.getModelAndView().getModel().get("food"));
  }
}
