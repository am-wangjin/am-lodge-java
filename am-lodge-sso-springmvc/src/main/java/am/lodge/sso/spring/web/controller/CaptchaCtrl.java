package am.lodge.sso.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by am on 16-12-4.
 */
@Controller
@RequestMapping("captcha")
public class CaptchaCtrl{

  public void create(){
    com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet c;
  }
}
