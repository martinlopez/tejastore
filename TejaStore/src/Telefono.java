public class Telefono {

	private String tipo;

	private String nombre;

	private String nro;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", nombre=" + nombre + ", nro=" + nro
				+ "]";
	}


}
