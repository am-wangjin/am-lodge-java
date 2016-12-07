package am.lodge.sso.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by am on 16-11-19.
 */
@RestController("logout")
public class LogoutCtrl{

  @RequestMapping(method = RequestMethod.GET)
  public Map<String, String> logout(){
    Map<String, String> result = new HashMap();
    result.put("state", "1");
    result.put("data", "注销成功");
    return result;
  }
}
