public class Articulo {

	private String codigo;

	private String nombre;

	private Integer stock_max;

	private Integer stock_min;

	private float precio_compra;

	private float precio_venta;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock_max() {
		return stock_max;
	}

	public void setStock_max(Integer stock_max) {
		this.stock_max = stock_max;
	}

	public Integer getStock_min() {
		return stock_min;
	}

	public void setStock_min(Integer stock_min) {
		this.stock_min = stock_min;
	}

	public float getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre
				+ ", stock_max=" + stock_max + ", stock_min=" + stock_min
				+ ", precio_compra=" + precio_compra + ", precio_venta="
				+ precio_venta + "]";
	}
	

}
