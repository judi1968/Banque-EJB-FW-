package com.project.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class DepotDTO {
    private Integer personneId;
    private Integer action;
    private Double montant;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // HTML5 datetime-local format
    private LocalDateTime dateHeureAction;

    // getters et setters
    public Integer getPersonneId() { return personneId; }
    public void setPersonneId(Integer personneId) { this.personneId = personneId; }

    public Integer getAction() { return action; }
    public void setAction(Integer action) { this.action = action; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public LocalDateTime getDateHeureAction() { return dateHeureAction; }
    public void setDateHeureAction(LocalDateTime dateHeureAction) { this.dateHeureAction = dateHeureAction; }
}
