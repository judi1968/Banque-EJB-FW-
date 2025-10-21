package metier.entities;

import jakarta.persistence.*;
import java.io.Serializable;

public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String login;

    private String mdp;

    private int role;

    private Direction direction;

    // --- Constructeurs ---
    public Utilisateur() {}

    public Utilisateur(String login, String mdp, int role, Direction direction) {
        this.login = login;
        this.mdp = mdp;
        this.role = role;
        this.direction = direction;
    }

    // --- Getters / Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
