package ru.max.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;

import javax.validation.Valid;

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
        return "one/showUsers";
    }

    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") long id,
                           Model model) {
        model.addAttribute("user", userService.findById(id));
        return "one/showUser";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "one/new";
    }

    @PostMapping(value = "/new")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "one/new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login1";
    }


}
