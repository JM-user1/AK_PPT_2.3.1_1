package testfolder.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testfolder.model.User;
import testfolder.service.UserService;
import testfolder.service.UserServiceImpl;

import javax.naming.Binding;
import javax.validation.Valid;

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

////+++++++++++++++++++++++++++++++ Было+++++++++++++++++++++++++++
//  @GetMapping("/")
//  public ModelAndView allUsers(){
//    List<User> users = userService.allUser();
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("users");
//    modelAndView.addObject("userList", users);
//    modelAndView.addObject("user", new User());
//    return modelAndView;
//  }
//
//
//
//  @GetMapping("/users")
//  public String newUser(Model model){
//
//    model.addAttribute("user", new User());
//    return "users";
//  }
//
//  @PostMapping("/users")
//  public String create(@ModelAttribute("user") User user){
////    if(user != null){
//      userService.add(user);
////    }
//    return "redirect:/";
//  }
//
//

//  @GetMapping("/edit/{id}")
//  public ModelAndView editPage(@PathVariable("id") int id){
//    User user = userService.getById(id);
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("editUser");
//    modelAndView.addObject("user", user);
//    return modelAndView;
//  }



  //++++++++++++++++++++++++++++++++ Стало +++++++++++++++++++++++++++

  @GetMapping("/")
  public String start(ModelMap modelMap){
    modelMap.addAttribute("users", userService.allUser());
    modelMap.addAttribute("user", new User());
    return "users";
  }

  @PostMapping()
  public String addUser(@ModelAttribute("user") User user){
    userService.add(user);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String editUser(ModelMap modelMap, @PathVariable("id") int id){
    modelMap.addAttribute("user",userService.getById(id));
    return "/editUser";
  }

  @PatchMapping("/edit/{id}")
  public String editUser(@ModelAttribute("user") User user, @PathVariable("id")int id){
    userService.edit(id, user);
    return "redirect:/";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") int id){
    userService.delete(id);
    return "redirect:/";
  }


}
