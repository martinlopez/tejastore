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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.datanucleus.util.NucleusLogger;

import sun.util.calendar.BaseCalendar.Date;

@Entity
@Table(name="Persona")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Persona {

	@Id
	@SequenceGenerator(name="PERSONA_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_CODIGO_SEQ")
	private long id;

	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="TIPO_ID")
	private Tipo_Id t_id;
	
	@Basic
	protected long nro_id;

	@Basic
	protected String nombre;
	@Basic
	private String apellido;

	
	@Basic
	private String calle;
	@Basic
	private Integer nro;
	@Basic
	private Integer piso;
	@Basic
	private Integer departamento;
	
	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="LOC_ID")
	private Localidad localidad;
	
	@Basic
	private long tel_movil;
	
	@Basic
	private long tel_fijo;
	
	@Basic
	private String email;
	
	@Basic
	private String cuil;
	
	@Basic
	private Date fecha_nacimiento;
	
	public Persona(){
		
	}
	
	public Persona(Tipo_Id t_id, long nro_id, String nombre,
			String apellido, String calle, Integer nro, Integer piso,
			Integer departamento, Localidad localidad, long tel_movil,
			long tel_fijo, String email, String cuil, Date fecha_nac) {
		super();
		
		this.t_id = t_id;
		this.nro_id = nro_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
		this.tel_movil = tel_movil;
		this.tel_fijo = tel_fijo;
		this.email = email;
		this.cuil = cuil;
		this.fecha_nacimiento = fecha_nac;
	}

	public Tipo_Id getT_id() {
		return t_id;
	}

	public void setT_id(Tipo_Id t_id) {
		this.t_id = t_id;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public long getNro_id() {
		return nro_id;
	}

	public void setNro_id(long nro_id) {
		this.nro_id = nro_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public long getTel_fijo() {
		return tel_fijo;
	}

	public void setTel_fijo(long tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	public long getTel_movil() {
		return tel_movil;
	}

	public void setTel_movil(long tel_movil) {
		this.tel_movil = tel_movil;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", t_id=" + t_id + ", nro_id=" + nro_id
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", calle="
				+ calle + ", nro=" + nro + ", piso=" + piso + ", departamento="
				+ departamento + ", localidad=" + localidad + ", tel_movil="
				+ tel_movil + ", tel_fijo=" + tel_fijo + ", email=" + email
				+ ", cuil=" + cuil + ", fecha_nacimiento=" + fecha_nacimiento
				+ "]";
	}
	

	/* 
	 * Métodos para la implementación de ABM Persona
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
