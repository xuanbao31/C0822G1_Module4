package com.example.song_validate.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "Tối đa 800 kí tự")
    private String name;
    @NotBlank(message = "Không được để trống")
    @Size(max = 300, message = "tối đa 300 kí tự")
    private String singer;
    @NotBlank(message = "Không được để trống")
    @Size(max = 1000,message = "Không vượt quá 1000")
    private String kindMusic;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindMusic() {
        return kindMusic;
    }

    public void setKindMusic(String kindMusic) {
        this.kindMusic = kindMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
