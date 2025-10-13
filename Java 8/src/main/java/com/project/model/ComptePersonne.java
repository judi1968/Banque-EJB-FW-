package com.project.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.project.entity.Personnes;

public class ComptePersonne {
    private Personnes personne;
    private double montantCourant;
    private double montantDepot;
    private double montantPret;
    private double montantTotal;

    public ComptePersonne(Personnes personne, double montantCourant, double montantDepot, double montantPret) {
        this.personne = personne;
        this.montantCourant = montantCourant;
        this.montantDepot = montantDepot;
        this.montantPret = montantPret;
        this.montantTotal = montantCourant + montantDepot + montantPret;
    }

    // Getters et Setters
    public Personnes getPersonne() { return personne; }
    public void setPersonne(Personnes personne) { this.personne = personne; }

    public double getMontantCourant() { return montantCourant; }
    public void setMontantCourant(double montantCourant) { this.montantCourant = montantCourant; }

    public double getMontantDepot() { return montantDepot; }
    public void setMontantDepot(double montantDepot) { this.montantDepot = montantDepot; }

    public double getMontantPret() { return montantPret; }
    public void setMontantPret(double montantPret) { this.montantPret = montantPret; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

     private String formatAriary(double montant) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        symbols.setGroupingSeparator(' ');  // Séparateur des milliers
        DecimalFormat df = new DecimalFormat("#,##0.00 'Ar'", symbols);
        return df.format(montant);
    }

    // Méthodes pour retourner chaque montant formaté
    public String getMontantCourantAr() {
        return formatAriary(montantCourant);
    }

    public String getMontantDepotAr() {
        return formatAriary(montantDepot);
    }

    public String getMontantPretAr() {
        return formatAriary(montantPret);
    }

    public String getMontantTotalAr() {
        return formatAriary(montantTotal);
    }
}
