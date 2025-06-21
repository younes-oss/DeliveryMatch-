package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByExpediteur(User expediteur);
} 