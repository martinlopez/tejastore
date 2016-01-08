package tejastore;

import java.util.Date;

public class Persona {

	private long nro_id;

	private String nombre;

	private String apellido;

	private Date fecha_nacimiento;

	private String email;

	private long id;

	private String calle;

	private Integer nro;

	private Integer piso;

	private Integer departamento;

	private long tel_fijo;

	private long tel_movil;

	public long getNro_id() {
		return nro_id;
	}

	public void setNro_id(long nro_id) {
		this.nro_id = nro_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public long getTel_fijo() {
		return tel_fijo;
	}

	public void setTel_fijo(long tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	public long getTel_movil() {
		return tel_movil;
	}

	public void setTel_movil(long tel_movil) {
		this.tel_movil = tel_movil;
	}

	@Override
	public String toString() {
		return "Persona [nro_id=" + nro_id + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fecha_nacimiento="
				+ fecha_nacimiento + ", email=" + email + ", id=" + id
				+ ", calle=" + calle + ", nro=" + nro + ", piso=" + piso
				+ ", departamento=" + departamento + ", tel_fijo=" + tel_fijo
				+ ", tel_movil=" + tel_movil + "]";
	}

}
