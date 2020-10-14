package database;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VareDAO {
	
	@PersistenceContext(name = "varePU")
	private EntityManager em;
	
	public synchronized void leggTilVare(Vare vare) {
		em.persist(vare);
	}
	
	public synchronized void slettVare(Vare vare) {
		Vare mergeVare = em.merge(vare);
		em.remove(mergeVare);
	}
	
	public List<Vare> getVareliste() {
		return em.createQuery("SELECT v FROM Vare v", Vare.class).getResultList();
	}
	
	public Vare getVare(String vareNavn) {
		return em.find(Vare.class, vareNavn);
	}

}