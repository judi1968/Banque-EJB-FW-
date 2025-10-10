package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personnes")
public class Personnes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Integer et non int

    private String nom;

    // Constructeurs
    public Personnes() {}
    public Personnes(String nom) { this.nom = nom; }

    // Getters / Setters
    public Integer getId() { return id; }  // Integer ici
    public void setId(Integer id) { this.id = id; }  // Integer ici

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
