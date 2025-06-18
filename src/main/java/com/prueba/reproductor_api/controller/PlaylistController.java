package com.prueba.reproductor_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.reproductor_api.model.Playlist;
import com.prueba.reproductor_api.service.PlaylistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
    
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist created = playlistService.createPlaylist(playlist);
        URI location = URI.create("/lists" + created.getName());
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping
    public ResponseEntity<Iterable<Playlist>> getAllPlaylists() {
        Iterable<Playlist> playlists = playlistService.getAllPlaylists();
        return ResponseEntity.ok(playlists);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Playlist> getPlaylistByName(@PathVariable String name) {
        Playlist playlist = playlistService.getPlaylistByName(name);
        return ResponseEntity.ok(playlist);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlaylistByName(@PathVariable String name) {
        playlistService.deletePlaylistByName(name);
        return ResponseEntity.noContent().build();
    }
}
