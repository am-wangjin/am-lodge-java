package am.lodge.sso.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by am on 16-11-13.
 */
@Controller
@RequestMapping("login")
public class LoginCtrl{

  @RequestMapping("/index")
  public String index(Model model){
    return "index";
  }

  @RequestMapping()
  @ResponseBody
  public Map<String, String> login(){
    Map<String, String> result = new HashMap();
    result.put("state", "1");
    result.put("data", "登录成功");
    if(1 == 1)
      throw new RuntimeException("测试异常");
    return result;
  }
}
