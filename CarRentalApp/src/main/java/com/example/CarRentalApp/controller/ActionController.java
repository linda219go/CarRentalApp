package com.example.CarRentalApp.controller;

import com.example.CarRentalApp.entity.Contact;
import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ActionController {
    @Autowired
    ContactService contactService;
    @GetMapping("/contact")
    public String contact(final Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "/contact";
    }
    @PostMapping("/contact")
    public String submitMessage(@ModelAttribute("contact") Contact contactInfo){
        contactService.saveMessage(contactInfo);
        return "/index";
    }

    @RequestMapping("/")
    public String showHomePage(){
        return "/index";
    }

}
