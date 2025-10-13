package com.project.model;

public class MontantPersonneDTO {
    private int idPersonne;
    private double montantActuelle;

    public MontantPersonneDTO() {}

    public MontantPersonneDTO(int idPersonne, double montantActuelle) {
        this.idPersonne = idPersonne;
        this.montantActuelle = montantActuelle;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public double getMontantActuelle() {
        return montantActuelle;
    }

    public void setMontantActuelle(double montantActuelle) {
        this.montantActuelle = montantActuelle;
    }
}
