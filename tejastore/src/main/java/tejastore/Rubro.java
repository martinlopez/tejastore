package tejastore;

public class Rubro {

	private long id;

	private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rubro [id=" + id + ", nombre=" + nombre + "]";
	}

}
