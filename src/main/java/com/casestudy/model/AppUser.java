package com.casestudy.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Data

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String address;

    private String phoneNumber;

    private String img;

    @Transient
    private MultipartFile avatar;

    @OneToMany(targetEntity = Song.class)
    private List<Song> playlist;

    public AppUser() {
    }

    public AppUser(String username,String password, String name, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //    @ManyToOne
//    private AppRole appRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }


    //
//    public AppRole getAppRole() {
//        return appRole;
//    }
//
//    public void setAppRole(AppRole appRole) {
//        this.appRole = appRole;
//    }
}
