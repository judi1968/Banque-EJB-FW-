package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;

public class ActionRole implements Serializable {

    private int id;
    private String nomTable;
    private Integer action;
    private Integer role;

    // --- Constructeurs ---
    public ActionRole() {}

    public ActionRole(String nomTable, Integer action, Integer role) {
        this.nomTable = nomTable;
        this.action = action;
        this.role = role;
    }

    // --- Getters / Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTable() {
        return nomTable;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
