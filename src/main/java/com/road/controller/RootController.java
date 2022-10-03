package com.road.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    
    @RequestMapping(value = {"/", "/web/**"}, method = RequestMethod.GET)
    public String root() {
        return "forward:/index.html";
    }
}
