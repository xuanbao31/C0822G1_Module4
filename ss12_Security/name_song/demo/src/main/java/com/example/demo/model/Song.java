package com.example.demo.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 800)
    private String name;

    @Size(max = 300)
    private String singer;

    @Size(max = 1000)
    private String kind;

    public Song() {
    }

    public Song(int id, @NotNull @Size(max = 800) String name, @NotNull @Size(max = 300) String singer, @NotNull @Size(max = 1000) String kind) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String name = song.getName();
        String singer = song.getSinger();
        String kind = song.getKind();
        if (!name.matches("^[0-9A-Za-z]*$")) {
            errors.rejectValue("name", "name.matches", "nhap sai ten");
        }
        if (!singer.matches("^[0-9A-Za-z ]+$")) {
            errors.rejectValue("singer", "singer.matches", "haha");
        }
        if (!kind.matches("^[0-9A-Za-z, ]+$")) {
            errors.rejectValue("kind", "kind.matches", "haha");
        }
    }
}
