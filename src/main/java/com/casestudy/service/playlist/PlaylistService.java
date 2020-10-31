package com.casestudy.service.playlist;

import com.casestudy.model.Playlist;

import java.util.Optional;

public interface PlaylistService {
    Iterable<Playlist> findAll();

    Playlist save(Playlist playlist);

    Optional<Playlist> findById(Long id);

    void remove (Long id);
}
