package com.gymshop.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControler {

   @GetMapping("userIndex")
    public String index() {

        return "client/site/home";
    }

}