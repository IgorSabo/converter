package com.unusual.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by MC on 27.9.2019..
 */
@Entity
@Getter
@Setter
public class Gig {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "repertoar_id", referencedColumnName = "id")
    private Repertoar repertoar;

    private String clubName;

    private Date gigDate;
}
