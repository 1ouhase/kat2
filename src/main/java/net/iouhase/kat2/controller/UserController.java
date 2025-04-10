package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.User;
import net.iouhase.kat2.model.User;
import net.iouhase.kat2.usecase.UserService;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String admin(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/editUser")
    public String editUser() {
        return "editUser";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @GetMapping("/home/{id}")
    public String home(@PathVariable int id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user", userService.findById(user));
        return "home";
    }

    @GetMapping("/editUser/{id}")
    public String edit(@PathVariable int id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user", userService.findById(user));
        return "editUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("fuck dig stegemand");
        User user = new User();
        user.setId(id);
        userService.delete(user);
        System.out.println(id);
        return "redirect:/admin";
    }

    @PostMapping("/saveUser/{id}")
    public String update(@RequestParam String name, @RequestParam String email, @RequestParam String password, @PathVariable int id) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/createUser")
    public String create(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);
        return "redirect:/admin";
    }
}