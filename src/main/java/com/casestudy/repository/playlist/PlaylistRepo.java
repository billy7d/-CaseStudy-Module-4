package com.casestudy.repository.playlist;


import com.casestudy.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist,Long> {

}
