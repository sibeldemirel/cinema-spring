package com.example.cinemacda.realisateur.dto;

import com.example.cinemacda.film.dto.FilmOfRea;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurAvecFilmsDto {
    private Integer id;
    private String nom;
    private String prenom;
    private List<FilmOfRea> films = new ArrayList<>();
}
