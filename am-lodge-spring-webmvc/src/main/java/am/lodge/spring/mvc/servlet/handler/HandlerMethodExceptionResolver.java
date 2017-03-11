package am.lodge.spring.mvc.servlet.handler;

import am.lodge.commons.model.mvc.ResponseResult;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by am on 17-3-11.
 */
public class HandlerMethodExceptionResolver extends AbstractHandlerMethodExceptionResolver{

  @Override
  protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request,
                                                         HttpServletResponse response,
                                                         HandlerMethod method,
                                                         Exception e){
    ResponseResult resResult = new ResponseResult();
    resResult.setState(ResponseResult.FAILURE);
    resResult.setMsg(e.getMessage());
    ModelAndView result = new ModelAndView();
    result.addObject(resResult);
    return result;
  }
}
