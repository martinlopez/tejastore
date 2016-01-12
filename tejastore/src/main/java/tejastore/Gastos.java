package tejastore;

import java.util.Date;

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
@Table(name="GASTOS")
public class Gastos {


	@Id
	@SequenceGenerator(name="GASTOS_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GASTOS_CODIGO_SEQ")
	private long id;
	
	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="TIPO_GASTOS_ID")
	private Tipo_Gasto t_gasto;
	
	@Basic
	private String descripcion;

	@Basic
	private float monto;
	@Basic
	private Date fecha_pago;
	
	

	public Gastos(long id, Tipo_Gasto t_gasto, String descripcion, float monto,
			Date fecha_pago) {
		super();
		this.id = id;
		this.t_gasto = t_gasto;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha_pago = fecha_pago;
	}

	public Tipo_Gasto getT_gasto() {
		return t_gasto;
	}

	public void setT_gasto(Tipo_Gasto t_gasto) {
		this.t_gasto = t_gasto;
	}

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
		return "Gastos [id=" + id + ", t_gasto=" + t_gasto + ", descripcion="
				+ descripcion + ", monto=" + monto + ", fecha_pago="
				+ fecha_pago + "]";
	}
	
	/* 
	 * Métodos para la implementación de ABM Gastos
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
			if(getId() != 0)
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
			if(getId()!= 0)
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
