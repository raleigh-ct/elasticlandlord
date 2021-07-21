package com.elasticlandlord.controllers;

import com.elasticlandlord.data.PropertyRepository;
import com.elasticlandlord.model.Property;
import com.elasticlandlord.model.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class UserDashboardController {

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping
    public String displayProperties(Model model) {
        model.addAttribute("title", "All Properties");
        model.addAttribute("properties", propertyRepository.findAll());
        return "home/index";
    }

    @GetMapping("add")
    public String displayAddPropertyForm(Model model) {
        model.addAttribute("title", "Add Property");
        model.addAttribute(new Property());
        model.addAttribute("types", PropertyType.values());
        return "home/add";
    }

    @PostMapping("add")
    public String processAddPropertyForm(@ModelAttribute @Valid Property newProp,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Property");
            return "home/add";
        }

        propertyRepository.save(newProp);
        return "redirect:";
    }

}
