package ru.max.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "one/showUsers";
    }

    @GetMapping(value = "/{username}")
    public String showUser(@PathVariable("username") String username,
                           Model model) {
        model.addAttribute("user", userService.findByUsername(username));
        return "one/showUser";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "one/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{username}/edit")
    public String edit(Model model, @PathVariable("username") String username) {
        model.addAttribute("user", userService.findByUsername(username));
        return "one/edit";
    }

    @PatchMapping(value = "/{username}")
    public String update(@ModelAttribute("user") User user, @PathVariable("username") String username) {
        userService.update(username, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.delete(username);
        return "redirect:/users";
    }

    @GetMapping(value = "/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!!!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "two/hello";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "two/login";
    }


}
