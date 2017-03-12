package am.lodge.persistence.test;

import am.lodge.persistence.test.jpa.inheritance.model.Garment;
import am.lodge.persistence.test.jpa.inheritance.model.Goods;
import am.lodge.persistence.test.jpa.inheritance.model.Shoe;
import am.lodge.persistence.test.jpa.inheritance.service.GoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by am on 16-10-16.
 */
public class GoodsTest extends AbstractTestCase{

  @Autowired
  private GoodsService goodsService;

  @Test
  public void test1(){
    Shoe shoe = new Shoe();
    shoe.setName("回力鞋");
    shoe.setColour("蓝色");
    goodsService.save(shoe);
  }

  @Test
  public void test2(){
    Garment shoe = new Garment();
    shoe.setName("运动服");
    shoe.setSize(40);
    goodsService.save(shoe);
  }

  @Test
  public void test3(){
    List<Goods> list = goodsService.findAll(Goods.class);
    for(Goods o : list){
      System.out.println("商品名称=" + o.getName());
    }
  }

  @Test
  public void test4(){
    List<Garment> list = goodsService.findAll(Garment.class);
    for(Garment o : list){
      System.out.println("商品名称=" + o.getName());
      System.out.println("尺码=" + o.getSize());
    }
  }

  @Test
  public void test5(){
    List<Shoe> list = goodsService.findAll(Shoe.class);
    for(Shoe o : list){
      System.out.println("商品名称=" + o.getName());
      System.out.println("颜色=" + o.getColour());
    }
  }
}
