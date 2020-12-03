package ru.max.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.service.UserService;

/**
 * @author Serov Maxim
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "showUsers";
    }

    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") long id,
                           Model model) {
        model.addAttribute("user", userService.findById(id));
        return "showUser";
    }
}
