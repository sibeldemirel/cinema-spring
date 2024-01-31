package com.example.cinemacda.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmReduitDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
}
