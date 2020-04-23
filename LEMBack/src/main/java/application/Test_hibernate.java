package application;

import dao.IDAOCompte;
import dao.IDAOOffre;
import dao.jpa.DAOJPA;

public class Test_hibernate {
	public static void main(String[] args) {
		IDAOOffre daoOffre = ApplicationContext.getDaoOffre();
		IDAOCompte daoCompte = ApplicationContext.getDaoCompte();
	
		DAOJPA.close();
	}
}
