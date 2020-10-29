package com.casestudy.controller;

import com.casestudy.model.AppUser;
import com.casestudy.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    IAppUserService iAppUserService;


    @GetMapping("")
    public String showAllUsers(Model model){
        Iterable<AppUser> users = iAppUserService.findAll();
        model.addAttribute("users",users);
        return "/user/index";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model){
        model.addAttribute("user",new AppUser());
        return "/user/create";
    }

    @PostMapping("/create")
    public String createUser(AppUser appUser){
        iAppUserService.save(appUser);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@RequestParam Long id,Model model){
        Optional<AppUser> user = iAppUserService.findOne(id);
        model.addAttribute("user",user);
        return "/user/edit";
    }

    @PostMapping("/edit")
    public String editUser(AppUser appUser){
        iAppUserService.save(appUser);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteUserForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("delUser",iAppUserService.findOne(id));
        return "/user/delete";
    }



    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id){
        iAppUserService.remove(id);
        return "redirect:/user";
    }

}
