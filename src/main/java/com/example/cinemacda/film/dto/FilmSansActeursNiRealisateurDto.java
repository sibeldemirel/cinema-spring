package com.example.cinemacda.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmSansActeursNiRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
    private int duree;
}
