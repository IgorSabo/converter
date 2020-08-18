package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Igor on 4/10/2020.
 */
@Entity
@Getter
@Setter
public class SongsRepertoar {

    /*@EmbeddedId
    private SongsPerRepertoarId id;*/

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="song_id")
    private Song song;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "repertoar_id" )
    private Repertoar repertoar;/**/

    private Integer position;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        SongsRepertoar that = (SongsRepertoar) o;
        return Objects.equals(song, that.song) &&
                Objects.equals(repertoar, that.repertoar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(song, repertoar);
    }*/

    /*public SongsPerRepertoarId getId() {
        return id;
    }

    public void setId(SongsPerRepertoarId id) {
        this.id = id;
    }*/
}
