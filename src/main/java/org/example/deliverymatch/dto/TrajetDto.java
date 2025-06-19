package org.example.deliverymatch.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TrajetDto {
    private Long id;
    private Long conducteurId;
    private String lieuDepart;
    private List<String> etapesIntermediaires;
    private String destination;
    private double longueurMax;
    private double largeurMax;
    private double hauteurMax;
    private String typeMarchandise;
    private double capaciteDisponible;
    private LocalDateTime dateDepart;
    private LocalDateTime dateCreation;
    private boolean actif;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getConducteurId() { return conducteurId; }
    public void setConducteurId(Long conducteurId) { this.conducteurId = conducteurId; }

    public String getLieuDepart() { return lieuDepart; }
    public void setLieuDepart(String lieuDepart) { this.lieuDepart = lieuDepart; }

    public List<String> getEtapesIntermediaires() { return etapesIntermediaires; }
    public void setEtapesIntermediaires(List<String> etapesIntermediaires) { this.etapesIntermediaires = etapesIntermediaires; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getLongueurMax() { return longueurMax; }
    public void setLongueurMax(double longueurMax) { this.longueurMax = longueurMax; }

    public double getLargeurMax() { return largeurMax; }
    public void setLargeurMax(double largeurMax) { this.largeurMax = largeurMax; }

    public double getHauteurMax() { return hauteurMax; }
    public void setHauteurMax(double hauteurMax) { this.hauteurMax = hauteurMax; }

    public String getTypeMarchandise() { return typeMarchandise; }
    public void setTypeMarchandise(String typeMarchandise) { this.typeMarchandise = typeMarchandise; }

    public double getCapaciteDisponible() { return capaciteDisponible; }
    public void setCapaciteDisponible(double capaciteDisponible) { this.capaciteDisponible = capaciteDisponible; }

    public LocalDateTime getDateDepart() { return dateDepart; }
    public void setDateDepart(LocalDateTime dateDepart) { this.dateDepart = dateDepart; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }
}