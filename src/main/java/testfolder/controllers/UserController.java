package testfolder.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testfolder.model.User;
import testfolder.service.UserService;
import testfolder.service.UserServiceImpl;

@Controller
public class UserController {

  private UserService userService = new UserServiceImpl();
// private static User user;
//  static {
//    user = new User();
//    user.setId(1);
//    user.setFirstName("Alexey");
//    user.setLastName("Kuzin");
//    user.setAge(41);
//  }

  @RequestMapping(value = "/",method = RequestMethod.GET)//
  public ModelAndView allUsers(){
    List<User> users = userService.allUser();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("users");
    modelAndView.addObject("userList", users);
    return modelAndView;
  }


  @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
  public ModelAndView editPage(@PathVariable("id") int id){
    User user = userService.getById(id);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("editUser");
    modelAndView.addObject("user", user);
    return modelAndView;
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public ModelAndView editUser(@ModelAttribute("user") User user){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("redirect:/");
    userService.edit(user);
    return modelAndView;
  }


}
