package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Igor on 4/10/2020.
 */
@Embeddable
@Getter
@Setter
public class SongsPerRepertoarId implements Serializable {

    @Column(name = "song_id")
    private Long songId;

    @Column(name = "repertoar_id")
    private Long repertoarId;

    public SongsPerRepertoarId() {
    }

    public SongsPerRepertoarId(Long songId, Long repertoarId) {
        this.songId = songId;
        this.repertoarId = repertoarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        SongsPerRepertoarId that = (SongsPerRepertoarId) o;
        return Objects.equals(songId, that.songId) &&
                Objects.equals(repertoarId, that.repertoarId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, repertoarId);
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getRepertoarId() {
        return repertoarId;
    }

    public void setRepertoarId(Long repertoarId) {
        this.repertoarId = repertoarId;
    }
}
