package com.casestudy.repository.song;

import com.casestudy.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song,Long> {

}
