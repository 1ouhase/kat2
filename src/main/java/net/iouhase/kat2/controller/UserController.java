package net.iouhase.kat.controller;

import net.iouhase.kat.model.User;
import net.iouhase.kat.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/user")
    public String user(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/editUser")
    public String editUser() {
        return "editUser";
    }
    @GetMapping("/editUserAdmin")
    public String editUserAdmin() {
        return "editUserAdmin";
    }
}