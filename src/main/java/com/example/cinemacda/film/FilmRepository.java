package com.example.cinemacda.film;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    // SELECT * FROM film WHERE titre like ....
    Optional<Film> findByTitre(String titre);


    Optional<List<Film>> findAllByRealisateurId(Integer id);
}
