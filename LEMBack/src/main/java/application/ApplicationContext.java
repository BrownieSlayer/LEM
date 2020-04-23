package application;


public class ApplicationContext {
		private static IDAOOffre daoOffre;
		private static IDAOCompte daoCompte;
		
		public static IDAOOffre getDaoOffre()
		{
			if (daoOffre == null)
			{
				daoOffre = new DAOOffreJpa();
			}
			return daoOffre;
		}
		
		
		public static IDAOCompte getDaoCompte()
		{
			if (daoCompte == null)
			{
				daoCompte = new DAOCompteJpa();
			}
			return daoCompte;
		}
}
