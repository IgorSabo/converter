package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class SongSynonymes extends BaseEntity {

    private String bandName;

    private String songTitle;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Songs song;
}
