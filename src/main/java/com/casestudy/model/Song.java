package com.casestudy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Data

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String singer;

    private String producer;

    private String description;

    private String linkImg;

    @Transient
    private MultipartFile img;

    private String linkMp3;

    @Transient
    private MultipartFile mp3;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "songPlaylist")
    private List<Playlist> songInPlaylist;

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkMp3() {
        return linkMp3;
    }

    public void setLinkMp3(String linkMp3) {
        this.linkMp3 = linkMp3;
    }

    public MultipartFile getMp3() {
        return mp3;
    }

    public void setMp3(MultipartFile mp3) {
        this.mp3 = mp3;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Playlist> getSongInPlaylist() {
        return songInPlaylist;
    }

    public void setSongInPlaylist(List<Playlist> songInPlaylist) {
        this.songInPlaylist = songInPlaylist;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getPlaylistName(){
        for (Playlist playlist:songInPlaylist){
            return playlist.getName();
        }
        return null;
    }

    @Override
    public String toString() {
        return
                "Song:" + name + '\'' +
                ", Singer:" + singer + '\'' +
                ", Producer:" + producer + '\'' +
                ", Description:" + description + '\'' +
                ", Category:" + category ;
    }
}
