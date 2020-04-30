package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.IDAOCompte;
import model.Compte;

public class Test_spring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
        IDAOCompte daoCompte = myContext.getBean(IDAOCompte.class);

        for (Compte c : daoCompte.findAll()) {
            System.out.println(c);
        }
    }

}