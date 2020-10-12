package database;

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
	
	public Vare[] hentAlleVarer() {
		// TODO
		return null;
	}

}