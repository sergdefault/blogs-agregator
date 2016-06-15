package com.tsymbaliuk.controller;

import com.tsymbaliuk.entity.User;
import com.tsymbaliuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Цымбалюк Сергей on 13.06.2016.
 */
@RequestMapping("/register")
@Controller
public class RegisterController {


    @Autowired
    private UserService userService;

    @RequestMapping
    public String showRegister(){
        return "user-register";
    }

    @ModelAttribute("user")
    public User constructUser(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "user-register";
        }
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String username){
        Boolean available = userService.findOne(username)== null;
        return available.toString();
    }

}
