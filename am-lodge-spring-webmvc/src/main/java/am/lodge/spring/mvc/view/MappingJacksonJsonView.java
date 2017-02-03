package am.lodge.spring.mvc.view;

import am.lodge.commons.model.mvc.ResponseResult;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

public class MappingJacksonJsonView extends MappingJackson2JsonView{

  @Override
  protected Object filterModel(Map<String, Object> model){
    ResponseResult result = new ResponseResult();
    Object date = super.filterModel(model);
    if(date instanceof Map && !CollectionUtils.isEmpty((Map)date)){
      Map map = (Map)date;
      if(map.size() == 1){
        result.setData(map.values().iterator().next());
        return result;
      }
    }
    result.setData(date);
    return result;
  }
}
