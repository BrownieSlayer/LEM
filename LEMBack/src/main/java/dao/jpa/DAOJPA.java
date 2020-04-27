package dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOJPA {
	private static EntityManagerFactory emf;
	protected EntityManager em;
	
	public static void close() {
		emf.close();
	}
	
	public DAOJPA() {
		try {			
			Class.forName("com.mysql.jdbc.Driver");	
			if (emf == null)
			{
				emf = Persistence.createEntityManagerFactory("LEMUnit"); 
			}
			em = emf.createEntityManager();
		}catch(Exception e){}
		
	}
	
	public void detach(Object entity) {
		this.em.detach(entity);
	}
}
