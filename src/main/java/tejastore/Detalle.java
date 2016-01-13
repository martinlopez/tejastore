package tejastore;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICULO_VENTA")

public class Detalle {

	@Id
	private Articulo articulo;
	@Id
	private Venta venta;
	@Basic
	private Integer cantidad;

	public Detalle(Articulo articulo, Venta venta, Integer cantidad) {
		this.articulo = articulo;
		this.venta = venta;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Detalle [articulo=" + articulo + ", venta=" + venta
				+ ", cantidad=" + cantidad + "]";
	}

}
