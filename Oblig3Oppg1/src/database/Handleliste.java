package database;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "dat108oblig3",name = "Handleliste")
public class Handleliste {
	
	@Id
	private Integer Liste_Id;
	
	@OneToMany(mappedBy = "Vare", fetch = FetchType.EAGER)
	private List<Vare> vareliste;
	
	public Handleliste() {}
	
	public Handleliste(Integer Liste_Id, List<Vare> vareliste) {
		this.Liste_Id = Liste_Id;
		this.vareliste = vareliste;
	}
	
	public List<Vare> getVareliste() {
		return vareliste;
	}
	
	public void setVareliste(List<Vare> vareliste) {
		this.vareliste = vareliste;
	}

}