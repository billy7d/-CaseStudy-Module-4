package com.casestudy.controller;

import com.casestudy.model.Song;
import com.casestudy.service.song.SongService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

@Controller
@RequestMapping("/songs")
public class SongController {

    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";

    @Autowired
    private SongService songService;

    @GetMapping("")
    public String showList(Model model){
        Iterable<Song> songs = songService.findAll();
        model.addAttribute("songs",songs);
        return "song/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("song",new Song());
        return "song/create";
    }

    @PostMapping("/create")
    public String saveSong(Song song){
        MultipartFile multipartFile = song.getMp3();
        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        try{
            File mp3File = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(mp3File);

            Map responseMp3 = cloudinary.uploader().upload(mp3File,  ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseMp3);
            String urlMp3 = jsonObject.getString("url");
            song.setLinkMp3(urlMp3);
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id,Model model){
        Song song = songService.findById(id).get();
        model.addAttribute("song",song);
        return "song/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSong(Song song){
        MultipartFile multipartFile = song.getMp3();
        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        try{
            File mp3File = File.createTempFile("test",multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(mp3File);

            Map responseMp3 = cloudinary.uploader().upload(mp3File,ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseMp3);
            String urlMp3 = jsonObject.getString("url");
            song.setLinkMp3(urlMp3);
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id){
        songService.remove(id);
        return "redirect:/songs";
    }



}
