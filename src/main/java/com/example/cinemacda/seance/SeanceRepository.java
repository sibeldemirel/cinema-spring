package com.example.cinemacda.seance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
