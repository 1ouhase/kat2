package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.User;
import net.iouhase.kat2.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping("/login/post")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        List<User> users = userService.isValidUser(user);
        if (!users.isEmpty()) {
            return "redirect:/home/" + users.get(0).getId();
        } else {
            return "redirect:/login/error";
        }
    }
}