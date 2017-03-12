package am.lodge.persistence.test.jpa.inheritance.service;

import am.lodge.persistence.test.jpa.inheritance.model.Garment;
import am.lodge.persistence.test.jpa.inheritance.model.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by am on 16-10-16.
 */
@Service
public class GoodsService{

  @Autowired
  private EntityManager entityManager;

  @Transactional
  public void save(Garment garment){
    entityManager.persist(garment);
  }

  @Transactional
  public void save(Shoe shoe){
    entityManager.persist(shoe);
  }

  public <T> List<T> findAll(Class<T> cls){
    CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(cls);
    cq.from(cls);
    return entityManager.createQuery(cq).getResultList();
  }
}
