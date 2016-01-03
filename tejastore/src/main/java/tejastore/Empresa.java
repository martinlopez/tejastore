package tejastore;
public class Empresa {

	private String cuit;

	private String email;

	private String nombre;

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empresa [cuit=" + cuit + ", email=" + email + ", nombre="
				+ nombre + "]";
	}

}
