package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;

public class MouvementCourantValide implements Serializable {

    private int idMouvement;

    private MouvementCourant mouvementCourant;

    // --- Constructeurs ---
    public MouvementCourantValide() {}

    public MouvementCourantValide(MouvementCourant mouvementCourant) {
        this.mouvementCourant = mouvementCourant;
    }

    // --- Getters / Setters ---
    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public MouvementCourant getMouvementCourant() {
        return mouvementCourant;
    }

    public void setMouvementCourant(MouvementCourant mouvementCourant) {
        this.mouvementCourant = mouvementCourant;
    }
}
