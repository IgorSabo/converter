package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class Repertoars extends BaseEntity {

    @OneToMany(mappedBy = "repertoar")
    private Set<SongsPerRepertoar> songsPerRepertoar;

    private String clubName;

    private Date gigDate;
}
