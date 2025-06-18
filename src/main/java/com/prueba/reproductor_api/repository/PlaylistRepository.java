package com.prueba.reproductor_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.reproductor_api.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Playlist findByName(String name);

    void deleteByName(String name);
}
