package ru.max.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Serov Maxim
 */
@Controller
@RequestMapping("/")
public class UserController {
//    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/users",method = RequestMethod.GET)
//    public String showUsers(Model model) {
//        model.addAttribute("users", userService.listUsers());
//        return "one/showUsers";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showUser(@PathVariable("id") long id,
//                           Model model) {
//        model.addAttribute("user", userService.readUser(id));
//        return "one/showUser";
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "one/new";
//    }
//
//    @RequestMapping(value = "/",method = RequestMethod.POST)
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.create(user);
//        return "redirect:/one/showUsers";
//    }
//
//    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
//    public String editUser(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.readUser(id));
//        return "one/edit";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
//        userService.update(id, user);
//        return "redirect:/one/showUsers";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.delete(id);
//        return "redirect:/one/showUsers";
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!!!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "two/hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "two/login";
    }


}
