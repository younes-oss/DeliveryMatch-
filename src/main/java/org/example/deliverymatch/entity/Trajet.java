package org.example.deliverymatch.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trajets")
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conducteur_id", nullable = false)
    private User conducteur;

    @Column(name = "lieu_depart", nullable = false)
    private String lieuDepart;

    @ElementCollection
    @CollectionTable(name = "trajet_etapes_intermediaires")
    @Column(name = "etape")
    private List<String> etapesIntermediaires;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "longueur_max", nullable = false)
    private double longueurMax;

    @Column(name = "largeur_max", nullable = false)
    private double largeurMax;

    @Column(name = "hauteur_max", nullable = false)
    private double hauteurMax;

    @Column(name = "type_marchandise", nullable = false)
    private String typeMarchandise;

    @Column(name = "capacite_disponible", nullable = false)
    private double capaciteDisponible;

    @Column(name = "date_depart", nullable = false)
    private LocalDateTime dateDepart;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Column(name = "actif")
    private boolean actif = true;

    // Constructeurs
    public Trajet() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getConducteur() { return conducteur; }
    public void setConducteur(User conducteur) { this.conducteur = conducteur; }

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