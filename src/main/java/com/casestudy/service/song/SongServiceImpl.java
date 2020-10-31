package com.casestudy.service.song;

import com.casestudy.model.Song;
import com.casestudy.repository.song.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepo songRepo;

    @Override
    public Iterable<Song> findAll() {
        Iterable<Song> songs = songRepo.findAll();
        return songs;
    }

    @Override
    public Song save(Song song) {
        songRepo.save(song);
        return song;
    }

    @Override
    public Optional<Song> findById(Long id) {

       Optional<Song> song= songRepo.findById(id);
        return song;
    }

    @Override
    public void remove(Long id) {
        songRepo.deleteById(id);
    }
}
