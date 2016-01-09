package tejastore;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Table;

import org.datanucleus.util.NucleusLogger;

@Entity
@Table(name="GASTOS_PERSONA")
public class Gastos_Persona {
	
	@Id
	private Gastos gastos;
	
	@Id
	private Persona pers;

	public Gastos_Persona(Gastos gastos, Persona pers) {
		super();
		this.gastos = gastos;
		this.pers = pers;
	}

	public Gastos getGastos() {
		return gastos;
	}

	public void setGastos(Gastos gastos) {
		this.gastos = gastos;
	}

	public Persona getPers() {
		return pers;
	}

	public void setPers(Persona pers) {
		this.pers = pers;
	}

	@Override
	public String toString() {
		return "Gastos_Persona [gastos=" + gastos + ", pers=" + pers + "]";
	}
	
	
	/* 
	 * Métodos para la implementación de ABM gastos_persona
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
			if  ((gastos!=null)&&(pers!=null))
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
			if ((gastos!=null)&&(pers!=null))
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
