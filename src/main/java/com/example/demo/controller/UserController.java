package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    String list(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("user", user);
        return "list.html";
    }

    @GetMapping("create")
    String create(@ModelAttribute UserForm userForm) {
        return "create";
    }

    @PostMapping("create")
    String regist(@ModelAttribute @Validated UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return create(userForm);
        }
        User user = new User();

        BeanUtils.copyProperties(userForm, user);
        userService.insert(user);
        return "redirect:/";
    }

    //編集処理
    @PostMapping(path = "edit", params = "edit")
    String edit(@RequestParam Integer id, @ModelAttribute UserForm userForm) {
        Optional<User> userOpt = userService.selectById(id);
        User user = userOpt.get();
        BeanUtils.copyProperties(user, userForm);
        return "edit";
    }

    //編集完了
    @PostMapping(path = "edit", params = "regist")
    String regist(@RequestParam Integer id, @Validated @ModelAttribute UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return edit(id, userForm);
        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        userService.update(user);
        return "redirect:/";
    }

    //戻るボタン押下時
    @PostMapping(path = "edit", params = "back")
    String back() {
        return "redirect:/";
    }

    //削除
    @PostMapping(path = "edit", params = "delete")
    String delete(@RequestParam Integer id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test(@RequestParam("message") String message, Model model){
        model.addAttribute("sample", message);
        return "test";
    }

    @GetMapping("/test2") 
    public String index() { 
        return "test2"; 
    }

    @PostMapping("/confirm")
    public String test2(@RequestParam("message") String message, Model model){
        model.addAttribute("message", message);
        return "confirm";
    }
}
