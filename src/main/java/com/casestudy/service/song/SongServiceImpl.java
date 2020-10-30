package com.casestudy.service.song;

import com.casestudy.model.Song;
import com.casestudy.repository.song.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private ISongRepo iSongRepo;

    @Override
    public Iterable<Song> findAll() {
        Iterable<Song> songs = iSongRepo.findAll();
        return songs;
    }

    @Override
    public Song save(Song song) {
        iSongRepo.save(song);
        return song;
    }

    @Override
    public Optional<Song> findById(Long id) {

       Optional<Song> song= iSongRepo.findById(id);
        return song;
    }

    @Override
    public void remove(Long id) {
        iSongRepo.deleteById(id);
    }
}
