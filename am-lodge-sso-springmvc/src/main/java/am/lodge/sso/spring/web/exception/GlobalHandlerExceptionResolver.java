package am.lodge.sso.spring.web.exception;

import am.lodge.commons.model.mvc.ResponseResult;
import am.lodge.commons.servlet.ServletUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by am on 16-11-20.
 */
public class GlobalHandlerExceptionResolver extends AbstractHandlerExceptionResolver{

  private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

  @Override
  protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e){
    logger.info("GlobalHandlerExceptionResolver:捕获异常");
    logger.error(e.getMessage(), e);
    ResponseResult model = new ResponseResult();
    model.setData(e.getMessage());
    model.setState(ResponseResult.STATE_ERROR);
    ObjectMapper om = new ObjectMapper();
    try{
      ServletUtils.writeResponse(response, om.writeValueAsString(model));
    } catch (JsonProcessingException ex){
      logger.error(ex.getMessage(), ex);
      throw new RuntimeException(ex);
    }
    return new ModelAndView();
  }
}
