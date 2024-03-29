package com.wechatgroupmsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
