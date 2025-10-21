package metier;

import java.util.List;
import jakarta.ejb.Remote;
import metier.entities.Direction;
import metier.entities.ActionRole;
import metier.entities.Utilisateur;

@Remote
public interface SessionRemote {
    // Initialisation / ejbCreate simulé
    public void ejbCreate();

    // Login / logout
    public boolean login(String login, String mdp);
    public void logout();

    // Accès aux données chargées
    public List<Direction> getDirections();
    public List<ActionRole> getActionRoles();
    public Utilisateur getCurrentUser();

    // Nettoyage / ejbRemove simulé
    public void ejbRemove();
}
