package com.unusual.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Igor on 4/22/2020.
 */
@Getter
@Setter
public class SongDto {

    private Long id;

    private int position;

    private String bandName;

    private String songTitle;

    private String text;

    private String chords;

    public SongDto() {
    }

    public SongDto(Long id, int position, String bandName, String songTitle, String text, String chords) {
        this.id = id;
        this.position = position;
        this.bandName = bandName;
        this.songTitle = songTitle;
        this.text = text;
        this.chords = chords;
    }
}
