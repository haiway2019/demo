package com.rey70n.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @author Reyton
 */
@Controller
public class HelloController {
    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}
