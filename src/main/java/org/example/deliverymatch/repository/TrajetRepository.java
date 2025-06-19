package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    List<Trajet> findByConducteur(User conducteur);
    List<Trajet> findByActifTrue();
    List<Trajet> findByActifTrueAndDateDepartAfter(LocalDateTime date);
    List<Trajet> findByActifTrueAndLieuDepartContainingAndDestinationContaining(String lieuDepart, String destination);
} 