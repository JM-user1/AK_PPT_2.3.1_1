package testfolder.dao;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;
import testfolder.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao{
//  private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
//  private static Map <Integer, User> users = new HashMap<>();

//  static {
//    User user1 = new User();
//    user1.setId(AUTO_ID.getAndIncrement());
//    user1.setFirstName("Ivan");
//    user1.setLastName("Abramov");
//    user1.setAge(54);
//
//    users.put(user1.getId(),user1);
//  }



  @PersistenceContext(unitName = "entityManagerFactory")
  private EntityManager entityManager;

  @Override
  public List<User> allUser() {
    List<User> users = entityManager.createQuery("SELECT u from User u").getResultList();
    return users;
  }

  @Override
  @Transactional
  public void add(User user) {
//    user.setId(AUTO_ID.getAndIncrement());
//    users.put(user.getId(), user);
//    entityManager.getTransaction().begin();
    entityManager.persist(user);
//    entityManager.getTransaction().commit();
  }

  @Override
  @Transactional
  public void delete(int id) {
//    entityManager.getEntityManagerFactory();
//    entityManager.getTransaction().begin();
    User user = entityManager.find(User.class, id);
    entityManager.remove(user);
//    entityManager.getTransaction().commit();
  }

  @Override
  @Transactional
  public void edit(int id, User editedUser) {
//    entityManager.getEntityManagerFactory();
    User updatedUser = getById(id);
    entityManager.detach(updatedUser);
    updatedUser.setFirstName(editedUser.getFirstName());
    updatedUser.setLastName(editedUser.getLastName());
    updatedUser.setAge(editedUser.getAge());
//    entityManager.getTransaction().begin();
    entityManager.merge(updatedUser);
//    entityManager.getTransaction().commit();
  }

  @Override
  public User getById(int id) {
//    entityManager.getEntityManagerFactory();
    User user = entityManager.find(User.class, id);
    entityManager.detach(user);
    return user;
  }
}
