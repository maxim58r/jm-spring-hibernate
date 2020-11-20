package ru.max.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
