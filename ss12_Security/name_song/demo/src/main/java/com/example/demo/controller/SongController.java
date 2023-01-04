package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("song", songList);
        return "/index";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute(value = "song") Song song,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        songService.save(song);
        return "redirect:/list";
    }
}
