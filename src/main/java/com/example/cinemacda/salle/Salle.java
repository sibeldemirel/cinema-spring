package com.example.cinemacda.salle;

import com.example.cinemacda.seance.Seance;
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
@Table(name="salle")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Salle {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private int capacity;

    private String equipement;

    @OneToMany(mappedBy = "salle")
    private List<Seance> seances = new ArrayList<>();
}
