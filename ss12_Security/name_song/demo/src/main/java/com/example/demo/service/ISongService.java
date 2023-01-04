package com.example.demo.service;

import com.example.demo.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);
}
