package tejastore;
import java.awt.Image;
public class Config {

	private long id;

	private String nombre;

	private long cuit;

	private long tel_fijo;

	private long tel_movil;

	private Image logo;

	private Float iva;

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

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
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

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {		
		this.logo = logo;
	}

	public Float getIva() {
		return iva;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Config [id=" + id + ", nombre=" + nombre + ", cuit=" + cuit
				+ ", tel_fijo=" + tel_fijo + ", tel_movil=" + tel_movil
				+ ", logo=" + logo + ", iva=" + iva + "]";
	}

}
