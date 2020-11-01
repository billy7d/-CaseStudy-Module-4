package com.casestudy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Song.class)
    private List<Song> songPlaylist;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongPlaylist() {
        return songPlaylist;
    }



    public void setSongPlaylist(List<Song> songPlaylist) {
        this.songPlaylist = songPlaylist;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getSongLinkMp3() {
        for (Song song : songPlaylist) {
            return song.getLinkMp3();
        }
        return null;
    }
}
