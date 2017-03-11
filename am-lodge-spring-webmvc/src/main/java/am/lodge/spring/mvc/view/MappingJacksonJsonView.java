package am.lodge.spring.mvc.view;

import am.lodge.commons.model.mvc.ResponseResult;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

public class MappingJacksonJsonView extends MappingJackson2JsonView{

  @Override
  protected Object filterModel(Map<String, Object> model){
    ResponseResult result = new ResponseResult();
    Object data = super.filterModel(model);
    if(data instanceof Map && !CollectionUtils.isEmpty((Map)data)){
      Map map = (Map)data;
      if(map.size() == 1){
        data = map.values().iterator().next();
        if(data instanceof ResponseResult){
          return data;
        }
        result.setData(data);
        return result;
      }
    }
    result.setData(data);
    return result;
  }
}
