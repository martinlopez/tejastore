package tejastore;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.javalite.test.jspec.JSpec.the;
import static org.junit.Assert.assertEquals;
public class ArticuloTest {
	EntityManagerFactory emf;
	EntityManager em;

	@Before
	public void before(){
		emf = DBHandler.OpenConnectionTest();
		em= emf.createEntityManager();
	}
	
	@After
	public void after(){
		em.close();
		DBHandler.closeConnectionTest(emf);
	}
	
	@Test
	public void shouldBeValidateCreation(){
		Marca pepsi= new Marca("Pepsi");
		for (int i=0;i<100;i++){
			Articulo art= new Articulo(00000001,"Coca-Cola 2.25 lts",100,20,(float)14.2,(float)24.2,0,pepsi);
			art.alta_ABM(em);
			the(art.getId()).shouldNotBeNull();
			the(art.getId()).shouldNotBeEqual((long)0);
			System.out.println(art.getId());
		}
	
	}
	
	@Test
	public void test() {
		
	}

}
