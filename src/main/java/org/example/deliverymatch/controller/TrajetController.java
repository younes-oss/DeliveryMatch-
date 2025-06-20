package org.example.deliverymatch.controller;

import org.example.deliverymatch.dto.TrajetDto;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.service.TrajetService;
import org.example.deliverymatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajets")
public class TrajetController {
    @Autowired
    private TrajetService trajetService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<TrajetDto> creerTrajet(@RequestBody TrajetDto trajetDto, Authentication authentication) {
        // Supposons que le username = email
        String email = authentication.getName();
        User conducteur = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        TrajetDto created = trajetService.creerTrajet(trajetDto, conducteur.getId());
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<TrajetDto>> getAllTrajets() {
        return ResponseEntity.ok(trajetService.getAllTrajets());
    }
} 