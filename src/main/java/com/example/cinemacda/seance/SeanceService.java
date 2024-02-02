package com.example.cinemacda.seance;

import com.example.cinemacda.salle.Salle;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<Seance> findAll(){return seanceRepository.findAll();}

    public Seance save(Seance seance){return seanceRepository.saveAndFlush(seance);}

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
