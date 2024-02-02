package com.example.cinemacda.seance;

import com.example.cinemacda.film.FilmService;
import com.example.cinemacda.salle.Salle;
import com.example.cinemacda.salle.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    private final FilmService filmService;
    private final SalleService salleService;

    public SeanceService(SeanceRepository seanceRepository, FilmService filmService, SalleService salleService) {
        this.seanceRepository = seanceRepository;
        this.filmService = filmService;
        this.salleService = salleService;
    }

    public List<Seance> findAll(){return seanceRepository.findAll();}

    public Seance save(Seance seance){
        filmService.findById(seance.getFilm().getId());
        Salle mySalle = salleService.findById(seance.getSalle().getId());

        int theCapacity = mySalle.getCapacity();

        seance.setPlaceDispo(theCapacity);

        return seanceRepository.save(seance);
    }

    public Seance findById(Integer id){
        return seanceRepository.findById(id)
                .orElseThrow(
                        ()-> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Seance non trouvée"
                        )
                );
    }

    public void deleteById(Integer id){
        seanceRepository.deleteById(id);
    }

    public Seance update(Seance seance){return seanceRepository.save(seance);}
    
}
