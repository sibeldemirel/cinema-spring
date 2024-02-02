package com.example.cinemacda.seance;

import com.example.cinemacda.film.Film;
import com.example.cinemacda.salle.Salle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="seances")
public class Seance {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Integer placeDispo;
    @Column(nullable = false)
    private Float prix;

    @OneToOne
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
