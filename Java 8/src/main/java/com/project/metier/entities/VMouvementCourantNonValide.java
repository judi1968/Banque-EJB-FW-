package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class VMouvementCourantNonValide implements Serializable {

  
    private int idMouvement;

  
    private int idPersonne;
 

    private double montantEntrer;


    private double montantSortie;


    private LocalDateTime dateMouvement;

    // --- Constructeurs ---
    public VMouvementCourantNonValide() {
        // Constructeur vide requis par JPA
    }

    public VMouvementCourantNonValide(int idPersonne, double montantEntrer, double montantSortie, LocalDateTime dateMouvement) {
        this.idPersonne = idPersonne;
        this.montantEntrer = montantEntrer;
        this.montantSortie = montantSortie;
        this.dateMouvement = dateMouvement;
    }

    // --- Getters / Setters ---
    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public double getMontantEntrer() {
        return montantEntrer;
    }

    public void setMontantEntrer(double montantEntrer) {
        this.montantEntrer = montantEntrer;
    }

    public double getMontantSortie() {
        return montantSortie;
    }

    public void setMontantSortie(double montantSortie) {
        this.montantSortie = montantSortie;
    }

    public LocalDateTime getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(LocalDateTime dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

  
}
