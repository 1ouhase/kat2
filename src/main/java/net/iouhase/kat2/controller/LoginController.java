package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.User;
import net.iouhase.kat2.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;
    private boolean loginError = false;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginError", loginError);
        return "login";
    }

    @PostMapping("/login/post")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if (userService.isValidUser(user)){
            loginError = false;
            return "redirect:/cat";
        } else {
            loginError = true;
            return "redirect:/login";
        }
    }
}