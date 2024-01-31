package com.example.cinemacda.film.dto;

import com.example.cinemacda.acteur.dto.ActeurIdDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurDuFilmDto {
    private List<ActeurIdDto> acteurs = new ArrayList<>();
}
