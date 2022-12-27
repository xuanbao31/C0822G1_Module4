package com.example.form_dang_ky.controller;

import com.example.form_dang_ky.model.User;
import com.example.form_dang_ky.model.UserDto;
import com.example.form_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    private String showList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/list";

    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/createUser")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            return "redirect:/list";
        }
    }
}
