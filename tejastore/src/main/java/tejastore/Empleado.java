package tejastore;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Table;

import org.datanucleus.util.NucleusLogger;

import sun.util.calendar.BaseCalendar.Date;

@Entity
@Table(name="EMPLEADO")
public class Empleado extends Persona {
	
	public Empleado() {
		super();
	}
	
	public Empleado(Tipo_Id t_id,
					long nro_id,
					String nombre,
					String apellido,
					String calle,
					Integer nro,
					Integer piso,
					Integer dpto,
					Localidad loc,
					long tel_cel,
					long tel_fijo,
					String email,
					String cuil,
					Date fecha_nac
					){
		super(t_id,nro_id,nombre,apellido,calle,nro,piso,dpto,loc,tel_cel,tel_fijo,email,cuil,fecha_nac);
		
	}
	@Override
	public String toString() {
		return "Empleado []";
	}
	

	/* 
	 * Métodos para la implementación de ABM empleado
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
			if(super.getId() != 0)
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
			if(super.getId()!= 0)
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
