package ru.max.webapp.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;

/**
 * @author Serov Maxim
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "one/showUsers";
    }

    @PostMapping
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.delete(id);
    }
}
