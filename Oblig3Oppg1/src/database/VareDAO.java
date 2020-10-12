package database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VareDAO {
	
	@PersistenceContext(name = "varePU")
	private EntityManager em;
	
	public void leggTilVare(Vare vare) {
		em.persist(vare);
	}
	
	public void slettVare(Vare vare) {
		em.remove(vare);
	}
	
	public List<Vare> getVareliste() {
		Handleliste handleliste = em.find(Handleliste.class, 1);
		return handleliste.getVareliste();
	}
	
	public Handleliste getHandleliste(Integer id) {
		return em.find(Handleliste.class, id);
	}
	
	public Vare getVare(String vareNavn) {
		return em.find(Vare.class, vareNavn);
	}

}