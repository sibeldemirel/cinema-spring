package com.example.cinemacda.film;

import com.example.cinemacda.acteur.Acteur;
import com.example.cinemacda.acteur.ActeurRepository;
import com.example.cinemacda.acteur.ActeurService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActeurService acteurService;

    public FilmService(FilmRepository filmRepository, ActeurRepository acteurRepository, ActeurService acteurService) {
        this.filmRepository = filmRepository;
        this.acteurService = acteurService;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.saveAndFlush(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Film Non trouvé"
                        )
                );
    }

    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }

    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le titre : " + titre
                        )
                );
    }

    public List<Film> findAllByRealisateurId(Integer id){
        return filmRepository.findAllByRealisateurId(id).
                orElseThrow(
                        ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Aucun film ayant ce realisateur"));
    }

    public List<Acteur> findActeursByFilm(Integer id) {
        Film film = this.findById(id);
        return film.getActeurs();
    }
    public Film addActeurToFilm(Integer id, Acteur acteur) {
        Film film = findById(id);
        Acteur acteurTrouve = acteurService.findById(acteur.getId());
        film.getActeurs().add(acteurTrouve);
        return filmRepository.save(film);
    }
}