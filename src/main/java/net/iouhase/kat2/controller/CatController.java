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
        cats.add(new Cat(2, "Karin", "White", 15));
        cats.add(new Cat(3, "Walter", "Black", 15));
        model.addAttribute("cats", cats);
        return "cat";
    }
    @GetMapping("/editCat")
    public String editCat() {
        return "editCat";
    }
}
