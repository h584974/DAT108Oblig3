package database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VareDAO {
	
	@PersistenceContext(name = "varePU")
	private EntityManager em;
	
	// Synkroniserer for � gj�re lagring av ny vare tr�dsikker, og dermed unng� duplikater.
	public synchronized void leggTilVare(Vare vare) {
		em.persist(vare);
	}
	
	// Synkroniserer for � gj�re sletting av vare tr�dsikker, og dermed unng� feil.
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