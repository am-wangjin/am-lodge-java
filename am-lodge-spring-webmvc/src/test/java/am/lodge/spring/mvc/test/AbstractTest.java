package am.lodge.spring.mvc.test;

import am.lodge.spring.mvc.test.config.ApplicationConfig;
import am.lodge.spring.mvc.test.config.MvcConfigTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by am on 17-2-4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
    @ContextConfiguration(name = "parent", classes = {ApplicationConfig.class}),
    @ContextConfiguration(name = "child", classes = {MvcConfigTest.class})
})
public class AbstractTest{

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  public MockMvc getMockMvc(){
    return this.mockMvc;
  }
}
