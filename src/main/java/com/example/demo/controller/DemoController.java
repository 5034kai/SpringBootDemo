package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String get(){
        return "demo";
    }

    @PostMapping("test")
    String postResult(@RequestParam("val") String responseVal, Model model) {
        //ポイント3
        model.addAttribute("responseVal", responseVal);
        return "result";
    }
}
