package com.casestudy.service.song;

import com.casestudy.model.Song;

import java.util.Optional;

public interface SongService {

    Iterable<Song> findAll();

    Song save(Song song);

    Optional<Song> findById(Long id);

    void remove(Long id);
}
