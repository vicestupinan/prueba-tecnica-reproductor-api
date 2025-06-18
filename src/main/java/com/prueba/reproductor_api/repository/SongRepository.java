package com.prueba.reproductor_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.reproductor_api.model.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
