package tejastore;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.datanucleus.util.NucleusLogger;

@Entity
@Table(name = "ARTICULO")

public class Articulo {
	
	
	@Id
	@SequenceGenerator(name="ARTICULO_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTICULO_CODIGO_SEQ")
	private long id;
	
	@Basic
	private long codigo;

	@Basic
	private String nombre;
	
	@Basic
	private Integer stock_max;

	@Basic
	private Integer stock_min;

	@Basic
	private float precio_compra;

	@Basic
	private float precio_venta;
	
	@Basic
	private Integer cantidad;

	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="MARCA_ID")
	private Marca marca;
	
	
	public Articulo(long codigo,
					String nombre,
					Integer stock_max, 
					Integer stock_min, 
					float precio_compra, 
					float precio_venta,
					Integer cantidad,
					Marca marca)
	{
		this.codigo=codigo;
		this.nombre=nombre;
		this.stock_max=stock_max;
		this.stock_min=stock_min;
		this.precio_compra=precio_compra;
		this.precio_venta=precio_venta;
		this.cantidad=cantidad;
		this.marca=marca;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	


	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
			
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", codigo=" + codigo + ", nombre="
				+ nombre + ", stock_max=" + stock_max + ", stock_min="
				+ stock_min + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + ", cantidad=" + cantidad
				+ ", marca=" + marca + "]";
	}



	/* 
	 * Métodos para la implementación de ABM articulo
	 */
	

	public void alta_ABM(EntityManager em){
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();	
			em.persist(this);
			tx.commit();
		}catch(Exception e)
        {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return;
        }finally{
        	if (tx.isActive())
            {
                tx.rollback();
            }
        	
        }
  	}
	
	public void baja_ABM(EntityManager em){
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			if(id != 0)
				em.remove(this);
			tx.commit();
		}catch(Exception e)
        {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return;
        }finally{
        	if (tx.isActive())
                tx.rollback();
        }
	}
	
	public void modificacion_ABM (EntityManager em){
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			if(id != 0)
				em.persist(this);
			tx.commit();
		}catch(Exception e)
        {
            NucleusLogger.GENERAL.error(">> Exception persisting data", e);
            System.err.println("Error persisting data : " + e.getMessage());
            return;
        }finally{
        	if (tx.isActive())
                tx.rollback();
        }
	
	}

}