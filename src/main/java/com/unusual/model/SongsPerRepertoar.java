package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by MC on 26.9.2019..
 */
@Entity
@Getter
@Setter
public class SongsPerRepertoar extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "repertoar_id", nullable = false)
    private Repertoars repertoar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Songs song;

}
