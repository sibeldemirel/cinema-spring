package com.example.cinemacda.salle;

import com.example.cinemacda.salle.dto.SalleNameCapTechDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salles")
@RestController
public class SalleController {
    private final SalleService salleService;

    private final ObjectMapper salleMapper;

    public SalleController(SalleService salleService, ObjectMapper salleMapper) {
        this.salleService = salleService;
        this.salleMapper = salleMapper;
    }

    @GetMapping
    public List<SalleNameCapTechDto> findAll(){
        return salleService.findall().stream().map(
                salle -> salleMapper.convertValue(salle, SalleNameCapTechDto.class)
        ).toList();
    }

    @PostMapping
    public Salle save(@RequestBody Salle salle){
        return salleService.save(salle);
    }

   /* @GetMapping
    public List<Salle> findAll() {
        return salleService.findall();
    }*/
}
