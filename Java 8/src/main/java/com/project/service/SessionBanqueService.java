package com.project.service;

import jakarta.annotation.PostConstruct;
import metier.SessionRemote;
import metier.entities.ActionRole;
import metier.entities.Direction;
import metier.entities.Utilisateur;
import org.springframework.stereotype.Service;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

@Service
public class SessionBanqueService {

    private SessionRemote sessionBanque;

    @PostConstruct
    public void init() {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

            Context context = new InitialContext(props);
            sessionBanque = (SessionRemote) context.lookup(
                    "ejb:/BanqueEJB/SessionBanqueEJB!metier.SessionRemote");

            // Initialisation équivalent ejbCreate
            sessionBanque.ejbCreate();

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // Login
    public boolean login(String login, String mdp) {
        System.out.println("wawa");
        if (sessionBanque != null) {
            System.out.println("mbola mety");
            return sessionBanque.login(login, mdp);
        }
        return false;
    }

    // Logout
    public void logout() {
        if (sessionBanque != null) {
            sessionBanque.logout();
            sessionBanque.ejbRemove(); // Nettoyage
        }
    }

    // Récupérer toutes les directions
    public List<Direction> getDirections() {
        if (sessionBanque != null) {
            return sessionBanque.getDirections();
        }
        return null;
    }

    // Récupérer tous les actions roles
    public List<ActionRole> getActionRoles() {
        if (sessionBanque != null) {
            return sessionBanque.getActionRoles();
        }
        return null;
    }

    // Récupérer l'utilisateur connecté
    public Utilisateur getCurrentUser() {
        if (sessionBanque != null) {
            return sessionBanque.getCurrentUser();
        }
        return null;
    }
}
