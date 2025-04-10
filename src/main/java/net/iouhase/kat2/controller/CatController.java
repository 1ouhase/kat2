package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.Cat;
import net.iouhase.kat2.usecase.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cat")
    public String cat(Model model) {
        List<Cat> cats = catService.findAll();
        model.addAttribute("cats", cats);
        return "cat";
    }
    @GetMapping("/addCat")
    public String addCat(@PathVariable int id, Model model) {
        Cat cat = new Cat();
        cat.setId(id);
        model.addAttribute("cat", catService.findById(cat));
        return "addCat";
    }
    @GetMapping("/home")
    public String home(Model model) {
        List<Cat> cats = catService.findAll();
        model.addAttribute("cats", cats);
        return "home";
    }
    @GetMapping("/editCat/{id}")
    public String edit(@PathVariable int id, Model model) {
        Cat cat = new Cat();
        cat.setId(id);
        model.addAttribute("cat", catService.findById(cat));
        return "editCat";
    }

    @GetMapping("/deleteCat/{id}")
    public String deleteCat(@PathVariable int id) {
        Cat cat = new Cat();
        cat.setId(id);
        catService.delete(cat);
        return "redirect:/cat";
    }
    @PostMapping("/saveCat/{id}")
    public String update(@RequestParam String name, @RequestParam String race, @RequestParam int alder, @PathVariable int id) {
        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);
        cat.setRace(race);
        cat.setAge(alder);
        catService.update(cat);
        return "redirect:/cat";
    }
    @PostMapping("/createCat/{id}")
    public String create(@RequestParam String name, @RequestParam String race, @RequestParam int alder, @PathVariable int id) {
        Cat cat = new Cat();
        cat.setId(id);
        cat.setName(name);
        cat.setRace(race);
        cat.setAge(alder);
        catService.update(cat);
        return "redirect:/cat";
    }
}