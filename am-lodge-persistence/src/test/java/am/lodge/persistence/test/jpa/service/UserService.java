package am.lodge.persistence.test.jpa.service;

import am.lodge.persistence.test.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
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
    CriteriaQuery<User> cq = entityManager.getCriteriaBuilder().createQuery(User.class);
    cq.from(User.class);
    return entityManager.createQuery(cq).getResultList();
  }
}
