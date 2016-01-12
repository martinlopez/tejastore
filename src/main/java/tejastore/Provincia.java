package tejastore;

public class Provincia extends Pais {

	private String nombre;

	private long id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", id=" + id + "]";
	}

}
