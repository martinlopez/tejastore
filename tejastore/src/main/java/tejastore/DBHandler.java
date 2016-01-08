package tejastore;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.datanucleus.metadata.PersistenceUnitMetaData;
import org.datanucleus.api.jpa.JPAEntityManagerFactory;

public class DBHandler {
	
	
	DBHandler(){
		
	}
	
	//Conexion con base de datos en modo produccion.
	
	public static EntityManagerFactory OpenConnectionProd(){
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Produccion");
		return emf;
	}
	
	public static void closeConnectionProd(EntityManagerFactory emf){
		emf.close();
	}
	
	
	//Conexion con base de datos en modo test.
	
	public static EntityManagerFactory OpenConnectionTest(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
		return emf;
	}
	
	public static void closeConnectionTest(EntityManagerFactory emf){
		emf.close();
	}
			
	

}
	