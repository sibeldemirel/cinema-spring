package com.example.cinemacda.acteur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    Optional<Acteur> findByNom (String nom);
}
