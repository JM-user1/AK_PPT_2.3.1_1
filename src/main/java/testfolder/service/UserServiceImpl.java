package testfolder.service;

import java.util.List;
import testfolder.dao.UserDao;
import testfolder.dao.UserDaoImpl;
import testfolder.model.User;

public class UserServiceImpl implements UserService{

  private UserDao userDao = new UserDaoImpl();

  @Override
  public List<User> allUser() {
    return userDao.allUser();
  }

  @Override
  public void add(User user) {
    userDao.add(user);
  }

  @Override
  public void delete(User user) {
    userDao.delete(user);
  }

  @Override
  public void edit(User user) {
    userDao.edit(user);
  }

  @Override
  public User getById(int id) {
    return userDao.getById(id);
  }
}
