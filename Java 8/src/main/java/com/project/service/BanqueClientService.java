package com.project.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import metier.BanqueRemote;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class BanqueClientService {

    private BanqueRemote banqueRemote;

    public BanqueClientService() {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

            Context context = new InitialContext(props);
            banqueRemote = (BanqueRemote) context.lookup("ejb:/BanqueEJB/BK!metier.BanqueRemote");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public BanqueRemote getBanque() {
        return banqueRemote;
    }
}
