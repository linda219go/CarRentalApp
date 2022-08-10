package com.example.CarRentalApp.controller;

import com.example.CarRentalApp.entity.Car;
import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.service.CarService;
import com.example.CarRentalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @GetMapping("/register")
    public String register(final Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "/user/new_user";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "/user/register_success";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user",new User());
        return mav;
    }

//    @PostMapping("/login")
//    public void login(@ModelAttribute("user") User user){
//
//        User myUser = userService.login(user.getEmail(), user.getPassword());
//        if (Objects.nonNull(myUser)) {
//            return "redirect:/";
//        }else{
//            return "redirect:/";
//        }
//    }

    @GetMapping("/myaccount")
    public String showMyAccount(Model model, Principal principal) {
        String name = principal.getName(); //get logged in username
        User user = userService.findUser(name);
        Long id = user.getId();
        List<Car> carList = carService.findAllCar(id);
        model.addAttribute("carList",carList);
        model.addAttribute("username", name);
        model.addAttribute("user", user);
        Integer totalCost = 0;
        for (Car car:carList) {
            totalCost += car.getTotalCost();
        }
        model.addAttribute("totalCost", totalCost);

        return "/user/my_account";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:/";
    }

}
