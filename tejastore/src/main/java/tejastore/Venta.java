package tejastore;

import java.util.Calendar;
import java.util.Date;

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
@Table(name="VENTA")
public class Venta {

	@Id
	@SequenceGenerator(name="VENTA_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VENTA_CODIGO_SEQ")
	private long id;

	@Basic
	private Date horario;

	@Basic
	private float monto;

	public Venta(float monto){
		Calendar currenttime = Calendar.getInstance();
		this.horario= new Date((currenttime.getTime()).getTime());
		this.monto = monto;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", horario=" + horario + ", monto=" + monto
				+ "]";
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
