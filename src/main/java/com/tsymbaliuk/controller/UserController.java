package com.tsymbaliuk.controller;

import com.tsymbaliuk.entity.Blog;
import com.tsymbaliuk.entity.User;
import com.tsymbaliuk.service.BlogService;
import com.tsymbaliuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Цымбалюк Сергей on 07.06.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @ModelAttribute("user")
    public User constructUser(){
        return new User();
    }

    @ModelAttribute("blog")
    public Blog constructBlog(){
        return new Blog();
    }

    @RequestMapping("/users")
    public String users (Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail (Model model, @PathVariable int id){
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }

    @RequestMapping("/register")
    public String showRegister(){
        return "user-register";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/account")
    private String account(Model model, Principal principal){
        String name= principal.getName();
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return "user-detail";
    }

    @RequestMapping(value = "/account" , method = RequestMethod.POST)
    public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

}

