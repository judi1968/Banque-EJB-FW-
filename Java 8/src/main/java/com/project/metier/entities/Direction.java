package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;

public class Direction implements Serializable {

    private int id;

    private String libelle;

    private Integer niveau;

    // --- Constructeurs ---
    public Direction() {}

    public Direction(String libelle, Integer niveau) {
        this.libelle = libelle;
        this.niveau = niveau;
    }

    // --- Getters / Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }
}
