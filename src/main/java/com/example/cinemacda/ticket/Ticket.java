package com.example.cinemacda.ticket;

import com.example.cinemacda.seance.Seance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Seance seance;
    @Column(nullable = false)
    private String nomClient;
    @Column(nullable = false)
    private int nbPlaces;
}
