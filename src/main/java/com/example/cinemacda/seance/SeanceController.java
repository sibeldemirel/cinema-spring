package com.example.cinemacda.seance;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seances")
@RestController
public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public List<Seance> findAll() {
        return seanceService.findAll();
    }

    @PostMapping
    public Seance save(@RequestBody Seance seance){ return seanceService.save(seance);}


}
