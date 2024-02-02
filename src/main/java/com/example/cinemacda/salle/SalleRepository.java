package com.example.cinemacda.salle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
    Optional<Salle> findById(Long id);
    Optional<Salle> findByNom(String nom);

    Optional<Salle> findByEquipement(String equipement);

}
