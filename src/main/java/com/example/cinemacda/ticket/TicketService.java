package com.example.cinemacda.ticket;

import com.example.cinemacda.seance.Seance;
import com.example.cinemacda.seance.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SeanceService seanceService;

    public TicketService(TicketRepository ticketRepository, SeanceService seanceService) {
        this.ticketRepository = ticketRepository;
        this.seanceService = seanceService;
    }

    public List<Ticket> findAll(){return ticketRepository.findAll();}

    public Ticket save(Ticket ticket){
        //verif existance seance
        //verif places restantes
        //déduire places achetées
        //enregistrer seance
        seanceService.findById(ticket.getSeance().getId());
        Seance disponibility = seanceService.findById(ticket.getNbPlaces());
        int placesRestantes = disponibility.getPlaceDispo() - ticket.getNbPlaces();
        ticket.setNbPlaces(placesRestantes);
        return ticketRepository.save(ticket);
    }

    public Ticket findById(Integer id){
        return ticketRepository.findById(id)
            .orElseThrow(
                    ()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Le ticket n'a pas été trouvé"
                    )
            );
    }

    public void deleteById(Integer id){
        ticketRepository.deleteById(id);
    }

    public Ticket update(Ticket ticket){
        return ticketRepository.save(ticket);}
}
