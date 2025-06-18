package com.prueba.reproductor_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.reproductor_api.model.Playlist;
import com.prueba.reproductor_api.repository.PlaylistRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        return playlistRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Playlist no encontrada"));
    }

    @Override
    public void deletePlaylistByName(String name) {
        playlistRepository.deleteByName(name);
    }
}
