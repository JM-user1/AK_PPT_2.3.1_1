package testfolder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import testfolder.model.User;

public class UserDaoImpl implements UserDao{
  private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
  private static Map <Integer, User> users = new HashMap<>();

  static {
    User user1 = new User();
    user1.setId(AUTO_ID.getAndIncrement());
    user1.setFirstName("Ivan");
    user1.setLastName("Abramov");
    user1.setAge(54);

    users.put(user1.getId(),user1);
  }

  @Override
  public List<User> allUser() {
    return new ArrayList<>(users.values());
  }

  @Override
  public void add(User user) {
    user.setId(AUTO_ID.getAndIncrement());
    users.put(user.getId(), user);
  }

  @Override
  public void delete(User user) {

  }

  @Override
  public void edit(User user) {
    users.remove(user.getId());
  }

  @Override
  public User getById(int id) {
    return users.get(id);
  }
}
