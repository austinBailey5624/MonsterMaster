package com.greenwolfgames.monstermaster;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/nature")
    public String showNaturePage(Model model) {
        model.addAttribute("message", "Fire is the nature of passion...");
        return "nature";
    }
}
