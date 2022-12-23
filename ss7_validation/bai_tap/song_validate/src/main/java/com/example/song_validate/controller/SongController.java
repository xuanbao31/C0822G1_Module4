package com.example.song_validate.controller;

import com.example.song_validate.model.Song;
import com.example.song_validate.model.SongDto;
import com.example.song_validate.service.ISongService;
import com.example.song_validate.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/createSong")
    public String save(@Validated @ModelAttribute
                               SongDto songDto,
                       BindingResult bindingResult,
                       Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            return "redirect:/list";
        }
    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            return "redirect:/list";
        }
    }

}
