package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class Songs extends BaseEntity {

    private String bandName;

    private String songTitle;

    @Lob
    private String text;

    @Lob
    private String chords;

    @OneToOne(mappedBy = "song")
    private SongsPerRepertoar songsPerRepertoar;

    @OneToMany(mappedBy = "song")
    private Set<SongSynonymes> synonymes;
}
