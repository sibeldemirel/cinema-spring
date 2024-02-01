package com.example.cinemacda.film.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Integer idFuFilm) {
        super("Aucun film avec l'ID " + idFuFilm);
    }
}
