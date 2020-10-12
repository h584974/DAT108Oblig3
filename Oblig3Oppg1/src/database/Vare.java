package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}