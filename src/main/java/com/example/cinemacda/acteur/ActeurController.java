package com.example.cinemacda.acteur;

import com.example.cinemacda.acteur.dto.ActeurSansFilmDto;
import com.example.cinemacda.acteur.dto.ActeurWithFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper acteurMapper;


    public ActeurController(ActeurService acteurService, ObjectMapper acteurMapper) {
        this.acteurService = acteurService;
        this.acteurMapper = acteurMapper;
    }


    @GetMapping
    public List<ActeurSansFilmDto> findAll() {
        return acteurService.findAll().stream().map(
                acteur -> acteurMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {
        return acteurService.save(acteur);
    }

    @GetMapping("/{id}") // /films/1
    public ActeurWithFilmDto findById(@PathVariable Integer id) {
        Acteur acteur = acteurService.findById(id);
        return acteurMapper.convertValue(acteur, ActeurWithFilmDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        acteurService.deleteById(id);
    }

    @PutMapping
    public Acteur update(@RequestBody Acteur acteur) {
        return acteurService.update(acteur);
    }

    @GetMapping("/search") // /film/search?titre=toto
    public Acteur findByNom(@RequestParam String nom) {
        return acteurService.findByName(nom);
    }
}
