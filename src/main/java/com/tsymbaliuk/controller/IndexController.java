package com.tsymbaliuk.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Цымбалюк Сергей on 30.05.2016.
 */
@org.springframework.stereotype.Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
