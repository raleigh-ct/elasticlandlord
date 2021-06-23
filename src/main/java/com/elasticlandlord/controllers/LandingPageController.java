package com.elasticlandlord.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value="about")
    public String about() {return "about";}
}