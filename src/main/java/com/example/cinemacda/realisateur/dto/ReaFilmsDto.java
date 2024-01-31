package com.example.cinemacda.realisateur.dto;

import com.example.cinemacda.film.dto.FilmReduitDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReaFilmsDto {
    private String nom;
    private String prenom;
    private List<FilmReduitDto> films = new ArrayList<>();
}
