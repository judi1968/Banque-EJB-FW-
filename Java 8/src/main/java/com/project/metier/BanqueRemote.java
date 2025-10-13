package metier;

import java.time.LocalDateTime;
import java.util.List;

import metier.entities.VMontantPersonne;

import jakarta.ejb.Remote;
import metier.entities.Compte;

@Remote
public interface BanqueRemote {
    public Compte addCompte(Compte cp);
    public Compte getCompte(Long code);
    public List<Compte> listComptes();
    public void verser(Long code, double mt);
    public void retirer(Long code, double mt);
    public void virement(Long cp1, Long cp2, double mt);
	public void addMouvementCourant(Integer idPersonne, Double montantEntrer, Double montantSortie, LocalDateTime dateMouvement ) throws Exception;
    public double getMontantActuelByPersonneId(int idPersonne) throws Exception;
    public List<VMontantPersonne> findAllMontantActuelle() throws Exception;
}
