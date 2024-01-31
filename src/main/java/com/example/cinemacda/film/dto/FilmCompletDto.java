package com.example.cinemacda.film.dto;


import com.example.cinemacda.acteur.dto.ActeurSansFilmDto;
import com.example.cinemacda.realisateur.Realisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmCompletDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private Realisateur realisateur;
    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
}
