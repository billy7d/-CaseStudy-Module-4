package com.casestudy.controller;

import com.casestudy.model.AppUser;
import com.casestudy.service.IAppUserService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AppUserController {

//    @Autowired
//    Environment environment;


    @Qualifier("appUserServiceImpl")
    @Autowired
    IAppUserService iAppUserService;

    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";


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
    public String createUser(AppUser appUser) {
        MultipartFile multipartFile = appUser.getAvatar();
        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        try{
            File imgFile = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(imgFile);

            Map responseImg = cloudinary.uploader().upload(imgFile, ObjectUtils.emptyMap());
            JSONObject jsonObject = new JSONObject(responseImg);
            String urlImg = jsonObject.getString("url");        //link img
            appUser.setImg(urlImg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        iAppUserService.save(appUser);
        return "redirect:/users";
    }



    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id,Model model){
        Optional<AppUser> user = iAppUserService.findOne(id);
        model.addAttribute("user",user);
        return "/user/edit";
    }




    @PostMapping("/edit/{id}")
    public String editUser(AppUser user){
        MultipartFile multipartFile = user.getAvatar();
        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        try{
            File imgFile = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(imgFile);

            Map responseImg = cloudinary.uploader().upload(imgFile, ObjectUtils.emptyMap());
            JSONObject jsonObject = new JSONObject(responseImg);
            String urlImg = jsonObject.getString("url");        //link img
            user.setImg(urlImg);

        } catch (IOException e) {
            e.printStackTrace();
        }
        iAppUserService.save(user);
        return "redirect:/users";
    }

//    @GetMapping("/delete/{id}")
//    public String showDeleteUserForm(@PathVariable("id") Long id,Model model){
//        model.addAttribute("delUser",iAppUserService.findOne(id));
//        return "/user/delete";
//    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        iAppUserService.remove(id);
        return "redirect:/users";
    }

}


//Upload bang Multipartfile
//    @PostMapping("/create")
//    public String createUser(AppUser appUser){
//        MultipartFile multipartFile = appUser.getAvatar();
//        String img= multipartFile.getOriginalFilename();
//        appUser.setImg(img);
//        String fileUpload = environment.getProperty("file_upload").toString();
//        try{
//            FileCopyUtils.copy(multipartFile.getBytes(),new File(fileUpload + img));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        iAppUserService.save(appUser);
//        return "redirect:/users";
//    }


//    @PostMapping("/edit/{id}")
//    public String editUser(AppUser user){
//        MultipartFile multipartFile = user.getAvatar();
//        String img= multipartFile.getOriginalFilename();
//        user.setImg(img);
//        String fileUpload = environment.getProperty("file_upload").toString();
//        try{
//            FileCopyUtils.copy(multipartFile.getBytes(),new File(fileUpload + img));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        iAppUserService.save(user);
//        return "redirect:/users";
//    }