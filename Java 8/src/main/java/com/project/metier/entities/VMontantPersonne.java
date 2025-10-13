package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;

public class VMontantPersonne implements Serializable {

    private int idPersonne;
    private double montant;

    public VMontantPersonne() {
        super();
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
