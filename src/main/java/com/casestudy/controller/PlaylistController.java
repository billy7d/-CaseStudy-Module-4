package com.casestudy.controller;

import com.casestudy.model.Playlist;
import com.casestudy.model.Song;
import com.casestudy.service.playlist.PlaylistService;
import com.casestudy.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    SongService songService;

    @Autowired
    PlaylistService playlistService;


    @ModelAttribute("songs")
    public Iterable<Song> getSongs(){
        return songService.findAll();
    }

    @GetMapping("")
    public String showList(Model model){
        Iterable<Playlist> playlists = playlistService.findAll();
        model.addAttribute("playlist",playlists);
        return "playlist/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("playlist",new Playlist());
        return "playlist/create";
    }

    @PostMapping("/create")
    public String createPlaylist(Playlist playlist){
        playlistService.save(playlist);
        return "redirect:/playlists";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        playlistService.remove(id);
        return "redirect:/playlists";
    }
}
