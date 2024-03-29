package com.example.cinemacda.film;

import com.example.cinemacda.acteur.Acteur;
import com.example.cinemacda.acteur.ActeurService;
import com.example.cinemacda.acteur.dto.ActeurIdDto;
import com.example.cinemacda.acteur.dto.ActeurSansFilmDto;
import com.example.cinemacda.film.dto.FilmCompletDto;
import com.example.cinemacda.film.dto.FilmReduitDto;
import com.example.cinemacda.realisateur.dto.RealisateurIdDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    private final ObjectMapper myMapper;

    public FilmController(FilmService filmService, ObjectMapper myMapper) {
        this.filmService = filmService;
        this.myMapper = myMapper;
    }

    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> myMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping("/{id}") // /films/1
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return myMapper.convertValue(film, FilmCompletDto.class);
    }

    @GetMapping("/{id}/acteurs") // /films/1
    public List<ActeurIdDto> findByIdAndActor(@PathVariable Integer id) {
        return filmService.findById(id).getActeurs().stream().map(
                acteur -> myMapper.convertValue(acteur, ActeurIdDto.class)).toList();
    }

    @GetMapping("/{id}/realisateur") // /films/1
    public List<RealisateurIdDto> findByIdAndRea(@PathVariable Integer id) {
        return filmService.findById(id).getActeurs().stream().map(
                acteur -> myMapper.convertValue(acteur, RealisateurIdDto.class)).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @GetMapping("/search") // /film/search?titre=toto
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }

    @PostMapping("/{id}/acteurs")
    public FilmCompletDto addActorToFilm(@PathVariable Integer id, @RequestBody Acteur acteur) {
        Film film = filmService.addActeurToFilm(id, acteur);

        FilmCompletDto filmCompletDto = new FilmCompletDto();
        filmCompletDto.setId(film.getId());
        filmCompletDto.setDuree(film.getDuree());
        filmCompletDto.setRealisateur(film.getRealisateur());
        filmCompletDto.setDateSortie(film.getDateSortie());
        filmCompletDto.setSynopsis(film.getSynopsis());
        filmCompletDto.setActeurs(
                film.getActeurs().stream().map(
                        unmappedActor -> myMapper.convertValue(
                                unmappedActor,
                                ActeurSansFilmDto.class

                        )
                ).toList()
        );

        return filmCompletDto;
    }
}