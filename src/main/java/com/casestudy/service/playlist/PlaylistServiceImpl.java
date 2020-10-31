package com.casestudy.service.playlist;

import com.casestudy.model.Playlist;
import com.casestudy.repository.playlist.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepo playlistRepo;

    @Override
    public Iterable<Playlist> findAll() {
       Iterable<Playlist> playlists = playlistRepo.findAll();
        return playlists;
    }

    @Override
    public Playlist save(Playlist playlist) {
        playlistRepo.save(playlist);
        return playlist;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
       Optional<Playlist> playlist = playlistRepo.findById(id);
        return playlist;
    }

    @Override
    public void remove(Long id) {
        playlistRepo.deleteById(id);
    }
}
