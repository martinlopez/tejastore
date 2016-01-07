package tejastore;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.datanucleus.metadata.PersistenceUnitMetaData;
import org.datanucleus.api.jpa.JPAEntityManagerFactory;

public class DBHandler {
	
	
	DBHandler(){
		
	}
	
	public static EntityManagerFactory OpenConnection(){
	
/*		PersistenceUnitMetaData pumd = new PersistenceUnitMetaData("dynamic-unit", "RESOURCE_LOCAL", null);
		pumd.addClassName("tejastore.Articulo");
		pumd.setExcludeUnlistedClasses();
		pumd.addProperty("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
		pumd.addProperty("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		pumd.addProperty("javax.persistence.jdbc.user", "postgres");
		pumd.addProperty("javax.persistence.jdbc.password", "postgres");
		pumd.addProperty("datanucleus.schema.autoCreateAll", "true");
		EntityManagerFactory em = new JPAEntityManagerFactory(pumd, null);
	*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tutorial");
		return emf;
	}
	
	public static void closeConnection(EntityManagerFactory em){
		em.close();
	}
	

}
	