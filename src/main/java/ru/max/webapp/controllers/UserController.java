package ru.max.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;

/**
 * @author Serov Maxim
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "one/showUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id ,
                           Model model) {
        model.addAttribute("user", userService.readUser(id));
        return "one/showUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "one/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }
}
