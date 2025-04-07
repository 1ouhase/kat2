package net.iouhase.kat2.controller;

import net.iouhase.kat2.model.Cat;
import net.iouhase.kat2.usecase.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/editCat")
    public String editCat() {
        return "editCat";
    }
}
