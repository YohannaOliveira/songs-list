package com.yohanna.songlist.service;

import com.yohanna.songlist.entity.Song;
import com.yohanna.songlist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Optional<Song> updateSong(Long id, Song songDetails) {
        return songRepository.findById(id).map(song -> {
            song.setTitle(songDetails.getTitle());
            song.setArtist(songDetails.getArtist());
            song.setAlbum(songDetails.getAlbum());
            song.setReleaseYear(songDetails.getReleaseYear());
            return songRepository.save(song);
        });
    }

    public boolean deleteSong(Long id) {
        return songRepository.findById(id).map(song -> {
            songRepository.delete(song);
            return true;
        }).orElse(false);
    }
}
