package com.casestudy.controller;

import com.casestudy.model.AppUser;
import com.casestudy.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@Controller
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    IAppUserService iAppUserService;


    @GetMapping("")
    public String showAllUsers(Model model){
        Iterable<AppUser> users = iAppUserService.findAll();
        model.addAttribute("users",users);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model){
        model.addAttribute("user",new AppUser());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@RequestBody AppUser appUser){
        iAppUserService.save(appUser);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteUserForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("delUser",iAppUserService.findOne(id));
        return "delete";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        iAppUserService.remove(id);
        return "redirect:/user";
    }

}
