package com.unusual.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Created by Igor on 4/22/2020.
 */
@Getter
@Setter
public class SongsRepertoarDto {
    private String clubName;
    private Long repertoarId;
    private List<SongDto> songs;
}
