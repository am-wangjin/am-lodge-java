package am.lodge.spring.mvc.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by am on 17-1-26.
 */
@Controller
@RequestMapping(value = "/foods")
public class FoodCtl{

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Map<String, Object>> findAll(){
    return new ArrayList();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> findOne(@PathVariable("id") Long id){
    System.out.println(id);
    return new HashMap();
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Long create(@RequestBody Map<String, Object> food){
    System.out.println(food);
    return new Long(1);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public void update(@PathVariable("id") Long id, @RequestBody Map<String, Object> food){
    System.out.println(id);
    System.out.println(food);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Long id){
    System.out.println(id);
  }
}
