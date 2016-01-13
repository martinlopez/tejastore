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
@Table(name="LOCALIDAD")
public class Localidad {
	
	@Basic
	private String nombre;
	
	@Id
	@SequenceGenerator(name="LOCALIDAD_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALIDAD_CODIGO_SEQ")
	private long id;

	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="Provincia")
	private Provincia prov_id;
	
	
	public Localidad(String nombre) {
		this.nombre = nombre;
		this.prov_id=null;
	}

	public Localidad(String nombre, Provincia prov) {
		this.nombre = nombre;
		this.prov_id = prov;
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

	public Provincia getProv_id() {
		return prov_id;
	}

	public void setProv_id(Provincia prov_id) {
		this.prov_id = prov_id;
	}


	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + ", id=" + id + "]";
	}
	
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
