package org.example.deliverymatch.controller;

import org.example.deliverymatch.dto.DemandeDto;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.service.DemandeService;
import org.example.deliverymatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @PreAuthorize("hasRole('EXPÉDITEUR')")
    public ResponseEntity<DemandeDto> creerDemande(@RequestBody DemandeDto demandeDto, Authentication authentication) {
        String email = authentication.getName();
        User expediteur = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Expéditeur non trouvé"));
        DemandeDto created = demandeService.creerDemande(demandeDto, expediteur.getId());
        return ResponseEntity.ok(created);
    }
} 