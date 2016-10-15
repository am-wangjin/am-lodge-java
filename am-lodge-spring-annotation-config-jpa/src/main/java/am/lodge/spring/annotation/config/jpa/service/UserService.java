package am.lodge.spring.annotation.config.jpa.service;

import am.lodge.spring.annotation.config.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
}
