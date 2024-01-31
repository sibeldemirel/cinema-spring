package com.example.cinemacda.acteur;

import com.example.cinemacda.film.Film;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="acteurs")
public class Acteur {
    @Id
    @GeneratedValue
    private Integer id;

    private String nom;

    private String prenom;

    @ManyToMany
            (mappedBy = "acteurs")

    private List<Film> films = new ArrayList<>();
}
