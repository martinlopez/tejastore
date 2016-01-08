package tejastore;

public class Tipo_Id {

	private long id;

	private String descripcion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tipo_Id [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
