package tejastore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localidad {

	@Id
	private Integer id;
	
	private String nombre;
	
	private Provincia prov;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}
	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}

}
