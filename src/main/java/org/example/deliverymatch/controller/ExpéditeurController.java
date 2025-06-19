package org.example.deliverymatch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expéditeur")
@CrossOrigin(origins = "*")
public class ExpéditeurController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('EXPÉDITEUR')")
    public ResponseEntity<String> expéditeurDashboard() {
        return ResponseEntity.ok("Bienvenue dans l'espace expéditeur !");
    }

    @GetMapping("/commandes")
    @PreAuthorize("hasRole('EXPÉDITEUR')")
    public ResponseEntity<String> getCommandes() {
        return ResponseEntity.ok("Liste des commandes pour l'expéditeur");
    }
}