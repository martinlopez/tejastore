package tejastore;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.datanucleus.util.NucleusLogger;

@Entity
@Table(name="TURNO")
public class Turno {

	@Id
	@SequenceGenerator(name="TURNO_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TURNO_CODIGO_SEQ")
	private long id;
	
	@Basic
	private Date h_entrada;
	
	@Basic
	private Date h_salida;
	
	public Turno(){
		this.h_salida = null;
		Calendar currenttime = Calendar.getInstance();
		this.h_entrada= new Date((currenttime.getTime()).getTime());
		 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getH_entrada() {
		return h_entrada;
	}

	public void setH_entrada(Date h_entrada) {
		this.h_entrada = h_entrada;
	}

	public Date getH_salida() {
		return h_salida;
	}

	public void setH_salida(Date h_salida) {
		this.h_salida = h_salida;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", h_entrada=" + h_entrada + ", h_salida="
				+ h_salida + "]";
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
