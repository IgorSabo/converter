package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class NewSongSuggestions {

    @Id
    @GeneratedValue
    private Long id;

    private String bandName;

    private String title;

    private String youTubeLink;

    @Lob
    private String comment;

    private Boolean status;
}
