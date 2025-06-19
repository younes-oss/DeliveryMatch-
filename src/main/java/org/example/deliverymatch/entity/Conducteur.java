package org.example.deliverymatch.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("CONDUCTEUR")
public class Conducteur extends User {
    
    @OneToMany(mappedBy = "conducteur")
    private List<Trajet> trajets;

    @Column(name = "numero_permis")
    private String numeroPermis;

    @Column(name = "type_vehicule")
    private String typeVehicule;

    @Column(name = "capacite_vehicule")
    private double capaciteVehicule;

    // Constructeurs
    public Conducteur() {
        super();
        setRole(Role.CONDUCTEUR);
    }

    public Conducteur(String email, String password, String nom, String prenom) {
        super(email, password, nom, prenom, Role.CONDUCTEUR);
    }

    // Getters et Setters
    public List<Trajet> getTrajets() { return trajets; }
    public void setTrajets(List<Trajet> trajets) { this.trajets = trajets; }

    public String getNumeroPermis() { return numeroPermis; }
    public void setNumeroPermis(String numeroPermis) { this.numeroPermis = numeroPermis; }

    public String getTypeVehicule() { return typeVehicule; }
    public void setTypeVehicule(String typeVehicule) { this.typeVehicule = typeVehicule; }

    public double getCapaciteVehicule() { return capaciteVehicule; }
    public void setCapaciteVehicule(double capaciteVehicule) { this.capaciteVehicule = capaciteVehicule; }
} 