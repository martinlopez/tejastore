package tejastore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido a tejaStore...\n Ejemplo de alta y modificacion de art");
		EntityManagerFactory emf = DBHandler.OpenConnection();
		EntityManager em= emf.createEntityManager();
		for (int i=0;i<100;i++){
			Articulo art= new Articulo("Coca-Cola",100,20,(float)14.2,(float)24.2);
			art.alta_ABM(em);
			if (i%2==0){
				art.setPrecio_venta((float)40.00);
				art.modificacion_ABM(em);
			}
		}
		em.close();
		emf.close();
		
	}

}
