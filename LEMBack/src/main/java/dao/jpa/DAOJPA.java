package dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOJPA {
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("LEMUnit");
	protected final EntityManager em = emf.createEntityManager();
	
	public static void close() {
		emf.close();
	}
}
