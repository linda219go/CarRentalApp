package com.example.CarRentalApp.controller;

import com.example.CarRentalApp.entity.Car;
import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.service.CarService;
import com.example.CarRentalApp.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    User user = new User();

    @GetMapping("/cars")
    public String showCarPage(final Model model, Principal principal){
        Car car = new Car();
        model.addAttribute("car",car);
        if(principal != null){
            String name = principal.getName(); //get logged in username
            user = userService.findUser(name);
            Long userId = user.getId();
            model.addAttribute("username", name);
            model.addAttribute("userid", userId);
            return "/car/cars";
        }else{
            return "/error/must_login";
        }

//        return "/car/cars";
    }

    @PostMapping("/rentacar")
    public String rentACar(@ModelAttribute("car") Car car){

        car.setUser(user);
        carService.rentACar(car);
        return "redirect:/myaccount";
    }


}
