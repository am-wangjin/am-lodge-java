package am.lodge.spring.annotation.config.jpa.service;

import am.lodge.spring.annotation.config.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by am on 16-10-15.
 */
@Service
public class UserService{

  @Autowired
  private EntityManager entityManager;

  @Transactional
  public void save(User user){
    entityManager.persist(user);
  }

  public User findById(String id){
    return entityManager.find(User.class, id);
  }

  public List<User> findAll(){
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    cq.from(User.class);
    return entityManager.createQuery(cq).getResultList();
  }
}
