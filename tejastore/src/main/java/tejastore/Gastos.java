package tejastore;

import java.util.Date;

public class Gastos {

	private long id;

	private Date fecha_pago;

	private float monto;

	private String descripcion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Gastos [id=" + id + ", fecha_pago=" + fecha_pago + ", monto="
				+ monto + ", descripcion=" + descripcion + "]";
	}

}
