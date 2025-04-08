package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.User;
import net.iouhase.kat2.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login/post")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return userService.isValidUser(user) ? "redirect:/cat" : "redirect:/";
    }
}