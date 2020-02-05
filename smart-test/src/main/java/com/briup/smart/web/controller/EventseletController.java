package com.briup.smart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventseletController {
	@RequestMapping("/index")
    public String index(){
        return "index";
	}
}
