package com.yohanna.songlist.facade;

import com.yohanna.songlist.entity.Song;
import com.yohanna.songlist.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SongFacade {

    @Autowired
    private SongService songService;

    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    public Optional<Song> getSongById(Long id) {
        return songService.getSongById(id);
    }

    public Song createSong(Song song) {
        return songService.createSong(song);
    }

    public Optional<Song> updateSong(Long id, Song songDetails) {
        return songService.updateSong(id, songDetails);
    }

    public boolean deleteSong(Long id) {
        return songService.deleteSong(id);
    }
}

