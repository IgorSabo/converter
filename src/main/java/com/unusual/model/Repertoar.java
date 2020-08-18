package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

/**
 * Created by MC on 26.9.2019..
 */
@Entity
@Getter
@Setter
public class Repertoar {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "repertoar")
    private Gig gig;

    @OneToMany(mappedBy = "repertoar",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SongsRepertoar> songs = new ArrayList<>();

    private int totalSongsNum;



    /*@Autowired
    private SongsPerRepertoarRepository songsPerRepertoarRepository;*/

    public Repertoar() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Repertoar rep = (Repertoar) o;
        return Objects.equals(getId(), rep.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
