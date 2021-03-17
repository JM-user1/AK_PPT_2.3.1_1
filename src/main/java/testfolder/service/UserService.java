package testfolder.service;

import java.util.List;
import testfolder.model.User;

public interface UserService {
  List<User> allUser();
  void add(User user);
  void delete(User user);
  void edit(User user);
  User getById(int id);

}
