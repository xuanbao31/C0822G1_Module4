package com.example.song_validate.service;

import com.example.song_validate.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);
}
