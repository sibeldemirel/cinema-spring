package com.example.cinemacda.salle;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findall() {return salleRepository.findAll();}

    public Salle save(Salle salle) {return salleRepository.saveAndFlush(salle);}
    public Salle findById(Integer id){
        return salleRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Salle Non trouvée"
                        )
                );
    }

    public Salle findByNom(String nom){
        return salleRepository.findByNom(nom)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Salle Non trouvée"
                        )
                );
    }

    public void deleteById(Integer id){salleRepository.deleteById(id);}

    public Salle update(Salle salle){return salleRepository.save(salle);}


}
