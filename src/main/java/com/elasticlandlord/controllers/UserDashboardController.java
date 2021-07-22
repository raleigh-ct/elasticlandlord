package com.elasticlandlord.controllers;

import com.elasticlandlord.data.PropertyRepository;
import com.elasticlandlord.data.TenantRepository;
import com.elasticlandlord.model.LeaseType;
import com.elasticlandlord.model.Property;
import com.elasticlandlord.model.PropertyType;
import com.elasticlandlord.model.Tenant;
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

    @Autowired
    private TenantRepository tenantRepository;


    //Display/Add Property Routes
    @GetMapping
    public String displayProperties(Model model) {
        model.addAttribute("title", "All Properties");
        model.addAttribute("properties", propertyRepository.findAll());
        return "home/index";
    }

    @GetMapping("addProperty")
    public String displayAddPropertyForm(Model model) {
        model.addAttribute("title", "Add Property");
        model.addAttribute(new Property());
        model.addAttribute("types", PropertyType.values());
        return "home/addProperty";
    }

    @PostMapping("addProperty")
    public String processAddPropertyForm(@ModelAttribute @Valid Property newProp,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Property");
            return "home/addProperty";
        }

        propertyRepository.save(newProp);
        return "redirect:";
    }

    //Display/Add Tenant Routes
    @GetMapping("viewTenant") // figure out how to link this to individual tenantId, separate route w/ {id}
    public String displayTenants(Model model) {
        model.addAttribute("title", "All Tenants");
        model.addAttribute("tenants", tenantRepository.findAll());
        return "home/viewTenant";
    }

    //Are the "properties" tied in correctly?
    @GetMapping("addTenant")
    public String displayAddTenantForm(Model model) {
        model.addAttribute("title", "Add Tenant");
        model.addAttribute(new Tenant());
        model.addAttribute("types", LeaseType.values());
        model.addAttribute("properties", propertyRepository.findAll());
        return "home/addTenant";
    }

    @PostMapping("addTenant")
    public String processAddTenantForm(@ModelAttribute @Valid Tenant newTenant,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Tenant");
            return "home/addTenant";
        }

        tenantRepository.save(newTenant);
        return "redirect:";
    }
}
