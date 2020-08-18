package com.unusual.controllers;

import com.unusual.dto.SongDto;
import com.unusual.dto.SongsRepertoarDto;
import com.unusual.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Igor on 4/22/2020.
 */
@Controller
public class SongController {

    @Autowired
    SongsService songsService;

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    private @ResponseBody
    SongsRepertoarDto index() {
        return songsService.getAllSongsForToday();
    }

    @RequestMapping(value = "/song/{id}", method = RequestMethod.GET)
    private @ResponseBody
    SongDto getSongById(@PathVariable Long id) {
        return songsService.getSongForId(id);
    }
}
