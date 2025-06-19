package org.example.deliverymatch.dto;

import org.example.deliverymatch.entity.Role;

public class RegisterRequest {
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Role role;

    public RegisterRequest() {}

    public RegisterRequest(String email, String password, String nom, String prenom, Role role) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
} 