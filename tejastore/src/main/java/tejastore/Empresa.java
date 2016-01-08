package tejastore;

public class Empresa {

	private String cuit;

	private String email;

	private String nombre;

	private long id;

	private String calle;

	private Integer nro;

	private Integer piso;

	private Integer departamento;

	private long tel_movil;

	private long tel_fijo;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public long getTel_movil() {
		return tel_movil;
	}

	public void setTel_movil(long tel_movil) {
		this.tel_movil = tel_movil;
	}

	public long getTel_fijo() {
		return tel_fijo;
	}

	public void setTel_fijo(long tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	
	public String toString() {
		return "Empresa [cuit=" + cuit + ", email=" + email + ", nombre="
				+ nombre + ", id=" + id + ", calle=" + calle + ", nro=" + nro
				+ ", piso=" + piso + ", departamento=" + departamento
				+ ", tel_movil=" + tel_movil + ", tel_fijo=" + tel_fijo + "]";
	}

}
