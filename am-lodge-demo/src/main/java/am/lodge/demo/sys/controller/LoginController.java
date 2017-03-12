package am.lodge.demo.sys.controller;

import am.lodge.demo.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by am on 16-11-13.
 */
@Controller
@RequestMapping("login")
public class LoginController{

  @Autowired
  private LoginService loginService;

  @RequestMapping()
  @ResponseBody
  public String login(String username, String password){
    return loginService.login(username, password);
  }
}
