package database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VareDAO {
	
	@PersistenceContext(name = "varePU")
	private EntityManager em;
	
	// Synkroniserer for å gjøre lagring av ny vare trådsikker, og dermed unngå duplikater.
	public synchronized void leggTilVare(Vare vare) {
		em.persist(vare);
	}
	
	// Synkroniserer for å gjøre sletting av vare trådsikker, og dermed unngå feil.
	public synchronized void slettVare(Vare vare) {
		Vare mergeVare = em.merge(vare);
		em.remove(mergeVare);
	}
	
	// Returnerer lsite av alle varer.
	public List<Vare> getVareliste() {
		return em.createQuery("SELECT v FROM Vare v", Vare.class).getResultList();
	}
	
	// Returnerer en spesifikk vare.
	public Vare getVare(String vareNavn) {
		return em.find(Vare.class, vareNavn);
	}

}