package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cyprian on 2017-03-03.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("greeting", "Witaj w sklepie internetowym");
        model.addAttribute("tagline", "Cypowym najlepszym");
        return "welcome";

    }

}
