package org.example.deliverymatch.controller;


import org.example.deliverymatch.dto.*;
import org.example.deliverymatch.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Inscription d'un nouvel utilisateur
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(authService.register(request));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Connexion d'un utilisateur
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.authenticate(request).getToken());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}