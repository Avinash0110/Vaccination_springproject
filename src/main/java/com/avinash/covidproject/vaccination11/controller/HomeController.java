package com.avinash.covidproject.vaccination11.controller;

import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.entity.User;
import com.avinash.covidproject.vaccination11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    @GetMapping("/covid")
    public String mainPage()
    {
        return "main-page";
    }


    // add request mapping for /doctors
    @GetMapping("/doctors")
    public String showDoctors(Model theModel) {

        // get employees from db
        List<User> theUsers = userService.findAllByStatus();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "doctors";
    }

    // add request mapping for /admin

    @GetMapping("/admin")
    public String showAdmin(Model theModel)
    {

        List<User> theUsers = userService.findAllDoctors();

        List<UserDto> allUsers = userService.findAll();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        // add to the spring model
        theModel.addAttribute("allUsers",allUsers);

        return "admin";
    }

}