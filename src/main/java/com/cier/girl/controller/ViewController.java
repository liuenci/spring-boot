package com.cier.girl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("in")
    public String index(){
        return "views/hello";
    }
}
