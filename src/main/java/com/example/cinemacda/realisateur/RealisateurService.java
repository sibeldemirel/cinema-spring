package com.example.cinemacda.realisateur;


import com.example.cinemacda.film.Film;
import com.example.cinemacda.film.FilmService;
import com.example.cinemacda.film.dto.FilmOfRea;
import com.example.cinemacda.realisateur.dto.RealisateurAvecFilmsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private  final FilmService filmService;
    private final ObjectMapper objectMapper;



    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService, ObjectMapper objectMapper) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    public List<Realisateur> findAll(){
        return realisateurRepository.findAll();
    }

    public Realisateur save(Realisateur realisateur){
        return realisateurRepository.save(realisateur);
    }

    public Realisateur findById(Integer id){
        return realisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Réalisateur non trouvé")
        );
    }

    public void deleteById(Integer id){
        Realisateur realisateur = this.findById(id);

        List<Film> filmAvecRea =  filmService.findAllByRealisateurId(id);
        filmAvecRea.forEach(
                film -> {
                    film.setRealisateur(null);
                    filmService.save(film);
                }
        );

        realisateurRepository.delete(realisateur);
    }

    public Realisateur update(Realisateur realisateur){
        return realisateurRepository.save(realisateur);
    }

    public RealisateurAvecFilmsDto findRealisateurWithFilm(Integer id) {
        // On récupère le réalisateur demandé
        Realisateur realisateur = this.findById(id);
        // On récupère la liste des films de ce réal en faisant appel au serivce Films
        List<Film> filmsDuRealisateur = filmService.findAllByRealisateurId(id);

        // On créé une instance à partir de notre DTO
        RealisateurAvecFilmsDto realisateurAvecFilmsDto = new RealisateurAvecFilmsDto();

        // On récupère les valeurs du réalisateurs et on les affecte
        // à notre objet
        realisateurAvecFilmsDto.setId(realisateur.getId());
        realisateurAvecFilmsDto.setNom(realisateur.getNom());
        realisateurAvecFilmsDto.setPrenom(realisateur.getPrenom());

        realisateurAvecFilmsDto.setFilms(
                // On convertir la liste de film en notre DTO FilmMini
                // pour ne pas avoir d'erreur de type
                filmsDuRealisateur.stream().map(
                        film -> objectMapper.convertValue(film, FilmOfRea.class)
                ).toList()
        );

        // Puis on retourne l'objet qu'on a fabriqué
        return realisateurAvecFilmsDto;
    }

    public List<Film> findFilmsByRealisateurId(Integer id) {
        return filmService.findAllByRealisateurId(id);
    }

}
