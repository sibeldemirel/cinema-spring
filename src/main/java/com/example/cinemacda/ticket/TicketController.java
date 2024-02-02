package com.example.cinemacda.ticket;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> findAll(){return ticketService.findAll();}

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket){return ticketService.save(ticket);}
}
