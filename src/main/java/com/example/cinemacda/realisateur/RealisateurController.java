package com.example.cinemacda.realisateur;

import com.example.cinemacda.film.dto.FilmOfRea;
import com.example.cinemacda.realisateur.dto.ReaFilmsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService realisateurService;

    private final ObjectMapper reaMapper;

    public RealisateurController(RealisateurService realisateurService, ObjectMapper reaMapper) {
        this.realisateurService = realisateurService;
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
    public List<FilmOfRea> findByTitleAndInfo(@PathVariable Integer id) {
        return realisateurService.findById(id).getId().stream().map(
                film -> reaMapper.convertValue(film, FilmOfRea.class)).toList();
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
