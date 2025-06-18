package com.prueba.reproductor_api.service;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.prueba.reproductor_api.model.Playlist;
import com.prueba.reproductor_api.model.Song;
import com.prueba.reproductor_api.repository.PlaylistRepository;

import jakarta.persistence.EntityNotFoundException;

public class PlaylistServiceImplTest {

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistServiceImpl playlistService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPlaylist_success() {
        Playlist playlist = Playlist.builder()
                .name("Nombre prueba")
                .description("Descripcion prueba")
                .songs(List.of(
                        Song.builder().title("Titulo prueba").artist("Artista prueba").album("Album prueba").releaseYear("2000").genre("Genero prueba").build()
                ))
                .build();

        when(playlistRepository.save(playlist)).thenReturn(playlist);

        Playlist result = playlistService.createPlaylist(playlist);

        assertThat(result).isEqualTo(playlist);
        assertThat(result.getName()).isEqualTo("Nombre prueba");
        verify(playlistRepository, times(1)).save(playlist);
    }

    @Test
    void getPlaylistByName_found() {
        Playlist playlist = Playlist.builder().name("Nombre prueba").build();
        when(playlistRepository.findByName("Nombre prueba")).thenReturn(Optional.of(playlist));

        Playlist result = playlistService.getPlaylistByName("Nombre prueba");

        assertThat(result.getName()).isEqualTo("Nombre prueba");
    }

    @Test
    void getPlaylistByName_notFound() {
        when(playlistRepository.findByName("No Existe")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> playlistService.getPlaylistByName("No Existe"))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Playlist no encontrada");
    }

    @Test
    void deletePlaylistByName_success() {
        when(playlistRepository.existsByName("Nombre prueba")).thenReturn(true);

        playlistService.deletePlaylistByName("Nombre prueba");

        verify(playlistRepository).deleteByName("Nombre prueba");
    }

    @Test
    void deletePlaylistByName_notFound() {
        when(playlistRepository.existsByName("No Existe")).thenReturn(false);

        assertThatThrownBy(() -> playlistService.deletePlaylistByName("No Existe"))
            .isInstanceOf(EntityNotFoundException.class)
            .hasMessageContaining("Playlist no encontrada");
    }
}
