package org.example.deliverymatch.dto;

public class DemandeDto {
    private Long id;
    private Long trajetId;
    private double longueur;
    private double largeur;
    private double hauteur;
    private double poids;
    private String typeColis;
    // Pas besoin d'exposer l'expéditeur côté client
    // Statut et date en lecture seule
    private String statut;
    private String dateCreation;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTrajetId() { return trajetId; }
    public void setTrajetId(Long trajetId) { this.trajetId = trajetId; }
    public double getLongueur() { return longueur; }
    public void setLongueur(double longueur) { this.longueur = longueur; }
    public double getLargeur() { return largeur; }
    public void setLargeur(double largeur) { this.largeur = largeur; }
    public double getHauteur() { return hauteur; }
    public void setHauteur(double hauteur) { this.hauteur = hauteur; }
    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }
    public String getTypeColis() { return typeColis; }
    public void setTypeColis(String typeColis) { this.typeColis = typeColis; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }
} 