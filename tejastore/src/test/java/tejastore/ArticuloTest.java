package tejastore;

import static org.junit.Assert.*;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tejastore.Articulo;
import tejastore.DBHandler;

public class ArticuloTest {
	
	private EntityManagerFactory emf ;
	private EntityManager em;
	
	@Before
	public void before(){
		System.out.println("********** Test Articulo **********");
		this.emf = DBHandler.OpenConnection();
		this.em= emf.createEntityManager();
	}
	
	@After
	public void after(){
		em.close();
		emf.close();
	}
	
	
	@Test
	public void test1() {
		System.out.println("---------- Test 1: alta_ABM ----------");
		Articulo art=new Articulo("1111","PAN DULCE ",3,5,(float)39.50,(float)50,4);
		art.alta_ABM(em);
		Query q = (Query) em.createNativeQuery("SELECT * FROM ARTICULO WHERE ARTICULO.NOMBRE = PAN DULCE");
		//q.setParameter("threshold", value);
		List results = ((javax.persistence.Query) q).getResultList();
		assertNotNull(results);
	}
	
	public void test2() {
		System.out.println("---------- Test 1: baja_ABM ----------");
		Articulo art=new Articulo("2222","GALLETAS SALADAS",3,5,(float)10,(float)15,5);
		art.alta_ABM(em);
		Query q = (Query) em.createNativeQuery("SELECT * FROM ARTICULO WHERE ARTICULO.NOMBRE = GALLETAS SALADAS");
		//q.setParameter("threshold", value);
		List results = ((javax.persistence.Query) q).getResultList();
		assertNotNull(results);
		
		art.baja_ABM(em);
		q = (Query) em.createNativeQuery("SELECT * FROM ARTICULO WHERE ARTICULO.NOMBRE = GALLETAS SALADAS");
		//q.setParameter("threshold", value);
		results = ((javax.persistence.Query) q).getResultList();
		assertNull(results);
		
	}

}