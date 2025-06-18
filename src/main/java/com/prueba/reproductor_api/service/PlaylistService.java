package com.prueba.reproductor_api.service;

import java.util.List;

import com.prueba.reproductor_api.model.Playlist;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    List<Playlist> getAllPlaylists();
    Playlist getPlaylistByName(String name);
    void deletePlaylistByName(String name);
}
