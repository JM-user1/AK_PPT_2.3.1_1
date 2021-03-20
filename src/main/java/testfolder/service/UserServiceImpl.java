package testfolder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testfolder.dao.UserDao;
import testfolder.dao.UserDaoImpl;
import testfolder.model.User;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional
  public List<User> allUser() {
    return userDao.allUser();
  }

  @Override
  @Transactional
  public void add(User user) {
    userDao.add(user);
  }

  @Override
  public void delete(int id) {
    userDao.delete(id);
  }

  @Override
  public void edit(int id, User user) {
    userDao.edit(id, user);
  }

  @Override
  public User getById(int id) {
    return userDao.getById(id);
  }
}
