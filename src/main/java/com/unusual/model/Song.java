package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String bandName;

    private String songTitle;

    @Lob
    private String text;

    @Lob
    private String chords;

    @OneToMany(mappedBy = "song",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SongsRepertoar> repertoars = new ArrayList<>();

}
