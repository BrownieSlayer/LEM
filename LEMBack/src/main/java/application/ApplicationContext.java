package application;

import dao.IDAOCompte;
import dao.IDAOOffre;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOOffreJPA;

public class ApplicationContext {
		private static IDAOOffre daoOffre;
		private static IDAOCompte daoCompte;
		
		public static IDAOOffre getDaoOffre()
		{
			if (daoOffre == null)
			{
				daoOffre = new DAOOffreJPA();
			}
			return daoOffre;
		}
		
		
		public static IDAOCompte getDaoCompte()
		{
			if (daoCompte == null)
			{
				daoCompte = new DAOCompteJPA();
			}
			return daoCompte;
		}
		
}
