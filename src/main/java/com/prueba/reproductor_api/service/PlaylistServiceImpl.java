package com.prueba.reproductor_api.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.prueba.reproductor_api.model.Playlist;
import com.prueba.reproductor_api.repository.PlaylistRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        try {
            return playlistRepository.save(playlist);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Ya existe una playlist con ese nombre");
        }
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

    @Transactional
    @Override
    public void deletePlaylistByName(String name) {
        if (!playlistRepository.existsByName(name)) {
            throw new EntityNotFoundException("Playlist no encontrada");
        }
        playlistRepository.deleteByName(name);
    }
}
