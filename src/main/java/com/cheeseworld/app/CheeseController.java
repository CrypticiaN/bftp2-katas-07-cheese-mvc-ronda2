package com.cheeseworld.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheeseController {

    private final CheeseRepository cheeseRepository;

    @Autowired
    public CheeseController(CheeseRepository cheeseRepository) {
        this.cheeseRepository = cheeseRepository;
    }

    @GetMapping("/cheese/all")
    String allCheese(Model model) {
        model.addAttribute("cheeses", cheeseRepository.findAll());
        return "catalog";
    }


}
