package com.avinash.covidproject.vaccination11.controller;



import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.entity.User;
import com.avinash.covidproject.vaccination11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService)
    {
        userService=theUserService;
    }


    @GetMapping("/doctors/list")
    public String listDoctors(Model theModel) {

        // get employees from db
        List<User> theUsers = userService.findAllByStatus();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "doctors";
    }



    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model theModel) {

        // get the user from the service
        UserDto theUser = userService.findById(theId);

        // set user as a model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);

        // send over to our form
        return "registration-form-update";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") UserDto theUser) {

        // save the employee
        userService.save(theUser);

        System.out.println("user"+theUser);

        // use a redirect to prevent duplicate submissions
        return "redirect:/doctors/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {

        UserDto theUser = userService.findById(theId);

        // delete the user
        userService.deleteUser(theId);

        // redirect to
        return "redirect:/admin";
    }
}
