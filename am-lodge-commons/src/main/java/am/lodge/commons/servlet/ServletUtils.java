package am.lodge.commons.servlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by am on 16-11-20.
 */
public class ServletUtils{

  public static void writeResponse(HttpServletResponse response, String msg){
    writeResponse(response, msg, "UTF-8");
  }

  public static void writeResponse(HttpServletResponse response, String msg, String encoding){
    response.setContentType("text/html; charset=" + encoding);
    try{
      response.getWriter().write(msg);
    } catch (IOException e){
      throw new RuntimeException(e);
    }
  }
}
