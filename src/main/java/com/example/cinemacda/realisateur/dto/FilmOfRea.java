package com.example.cinemacda.realisateur.dto;

import com.example.cinemacda.film.dto.FilmInfoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmOfRea {
    private List<FilmInfoDto> films = new ArrayList<>();

}
