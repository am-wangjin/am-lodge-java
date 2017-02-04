package am.lodge.spring.mvc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by am on 17-2-4.
 */
@Controller
@RequestMapping(value = "/redirect")
public class RedirectCtl{

  @RequestMapping(method = RequestMethod.GET)
  public String index(){
    return "redirect: http://www.baidu.com";
  }
}
