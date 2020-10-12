package database;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(schema = "dat108oblig3", name = "Vare")
public class Vare {
	
	@Id
	private String vareNavn;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "Liste_Id", referencedColumnName = "Liste_Id")
	private Handleliste handleliste;
	
	public Vare() {}
	
	public Vare(String vareNavn, Handleliste handleliste) {
		this.vareNavn = vareNavn;
		this.handleliste = handleliste;
	}
	
	public String getVareNavn() {
		return vareNavn;
	}
	
	public Handleliste getHandleliste() {
		return handleliste;
	}
	
	@Override
	public String toString() {
		return this.vareNavn;
	}

}