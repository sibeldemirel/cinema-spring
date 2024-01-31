package com.example.cinemacda.acteur.dto;

import com.example.cinemacda.film.Film;
import com.example.cinemacda.film.dto.FilmReduitDto;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurWithFilmDto {
    private Integer id;

    private String nom;

    private String prenom;

    private List<FilmReduitDto> films = new ArrayList<>();
}
