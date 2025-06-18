package com.prueba.reproductor_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.reproductor_api.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Optional<Playlist> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);
}
