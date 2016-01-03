package tejastore;
public class Domicilio extends Localidad {

	private String calle;

	private Integer nro;

	private Integer piso;

	private Integer departamento;

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

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", nro=" + nro + ", piso=" + piso
				+ ", departamento=" + departamento + "]";
	}

}
