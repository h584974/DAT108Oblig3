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
	
	public Vare() {}
	
	public Vare(String vareNavn) {
		this.vareNavn = vareNavn;
	}
	
	public String getVareNavn() {
		return vareNavn;
	}
	
	// For enkel bruk i utskrift.
	@Override
	public String toString() {
		return this.vareNavn;
	}

}