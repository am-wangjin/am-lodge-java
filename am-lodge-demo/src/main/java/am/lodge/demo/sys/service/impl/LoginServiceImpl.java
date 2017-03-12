package am.lodge.demo.sys.service.impl;

import am.lodge.demo.sys.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by am on 17-3-11.
 */
@Service
public class LoginServiceImpl implements LoginService{

  @Override
  public String login(String username, String password){
    return "token";
  }
}
