package com.example.cinemacda.realisateur;

import com.example.cinemacda.film.Film;
import com.example.cinemacda.film.FilmService;
import com.example.cinemacda.film.dto.FilmSansActeursNiRealisateurDto;
import com.example.cinemacda.realisateur.dto.ReaFilmsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService realisateurService;
    private final FilmService filmService;

    private final ObjectMapper reaMapper;

    public RealisateurController(RealisateurService realisateurService, FilmService filmService, ObjectMapper reaMapper) {
        this.realisateurService = realisateurService;
        this.filmService = filmService;
        this.reaMapper = reaMapper;
    }

    @GetMapping
    public List<Realisateur> findAll() {
        return realisateurService.findAll();
    }

    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @GetMapping("/{id}")
    public ReaFilmsDto findById(@PathVariable Integer id) {
        Realisateur realisateur = realisateurService.findById(id);
        return reaMapper.convertValue(realisateur, ReaFilmsDto.class);
    }

    @GetMapping("/{id}/films")
    public List<FilmSansActeursNiRealisateurDto> findFilmsByRealisateurId(@PathVariable Integer id) {
        List<Film> filmsDuRealisateur = realisateurService.findFilmsByRealisateurId(id);

        return filmsDuRealisateur.stream().map(
                film -> reaMapper.convertValue(film, FilmSansActeursNiRealisateurDto.class)
        ).toList();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        realisateurService.deleteById(id);
    }

    @PutMapping
    public Realisateur update(@RequestBody Realisateur realisateur) {
        return realisateurService.update(realisateur);
    }
}
