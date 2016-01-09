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
@Table(name="Empresa")
public class Empresa {
	

	@Id
	@SequenceGenerator(name="EMPRESA_CODIGO_SEQ", allocationSize=50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPRESA_CODIGO_SEQ")
	
	private long id;
	@Basic
	private String nombre;
	@Basic
	private String cuit;

	
	@Basic
	private String calle;
	@Basic
	private Integer nro;
	@Basic
	private Integer piso;

	@Basic
	private Integer departamento;

	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Column(name="LOCALIDAD")
	private Localidad localidad;
	
	@Basic
	private long tel_fijo;
	@Basic
	private long tel_movil;
	@Basic
	private String email;
	@Basic
	private String descr;
	
	
	
	public Empresa(long id, String nombre, String cuit, String calle,
			Integer nro, Integer piso, Integer departamento,
			Localidad localidad, long tel_fijo, long tel_movil, String email,
			String descr) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cuit = cuit;
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
		this.tel_fijo = tel_fijo;
		this.tel_movil = tel_movil;
		this.email = email;
		this.descr = descr;
	}

	public String getCuit() {
		return cuit;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public long getTel_movil() {
		return tel_movil;
	}

	public void setTel_movil(long tel_movil) {
		this.tel_movil = tel_movil;
	}

	public long getTel_fijo() {
		return tel_fijo;
	}

	public void setTel_fijo(long tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", cuit=" + cuit
				+ ", calle=" + calle + ", nro=" + nro + ", piso=" + piso
				+ ", departamento=" + departamento + ", localidad=" + localidad
				+ ", tel_fijo=" + tel_fijo + ", tel_movil=" + tel_movil
				+ ", email=" + email + ", descr=" + descr + "]";
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
