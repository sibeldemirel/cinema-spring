package com.example.cinemacda.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmOfRea {
    private String nom;
    private String prenom;
    private LocalDate dateSortie;
}
