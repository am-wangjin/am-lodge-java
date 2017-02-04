package am.lodge.spring.mvc.test.controller;

import am.lodge.spring.mvc.test.model.Food;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by am on 17-1-26.
 */
@Controller
@RequestMapping(value = "/foods")
public class FoodCtl{

  @RequestMapping(method = RequestMethod.GET)
  public void findAll(Model model){
    List result = new ArrayList();
    Food food = new Food();
    food.setId("1");
    food.setName("面包");
    result.add(food);
    food = new Food();
    food.setId("2");
    food.setName("米饭");
    result.add(food);
    model.addAttribute(result);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public void findOne(@PathVariable("id") String id, Model model){
    Food food = new Food();
    food.setId(id);
    food.setName("面包");
    model.addAttribute(food);
  }

  @RequestMapping(method = RequestMethod.POST)
  public void create(Food food){
    food.setId("1");
  }

  @RequestMapping(method = RequestMethod.PUT)
  public void update(Food food){
    food.setName("米饭");
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void delete(String[] ids){
  }
}
