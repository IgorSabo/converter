package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class NewSongSuggestions extends BaseEntity {

    private String bandName;

    private String title;

    private String youTubeLink;

    @Lob
    private String comment;

    private Boolean status;
}
