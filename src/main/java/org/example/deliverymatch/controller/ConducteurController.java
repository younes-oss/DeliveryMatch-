package org.example.deliverymatch.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conducteur")
@CrossOrigin(origins = "*")
public class ConducteurController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('CONDUCTEUR')")
    public ResponseEntity<String> conducteurDashboard() {
        return ResponseEntity.ok("Bienvenue dans l'espace conducteur !");
    }

    @GetMapping("/missions")
    @PreAuthorize("hasRole('CONDUCTEUR')")
    public ResponseEntity<String> getMissions() {
        return ResponseEntity.ok("Liste des missions pour le conducteur");
    }
}