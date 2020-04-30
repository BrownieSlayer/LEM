package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //Spring sait qu'il doit manager cette classe
@EnableTransactionManagement //Active l'annotation Transactional
@EnableJpaRepositories("dao")
public class JPAConfig {
	//Bean de config pour acc�der � la BDD
		@Bean
		public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//On affecte les rpopri�t�s
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/esport");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMaxTotal(10);
		
		//On donne cette Datasource � Spring
		return dataSource;
		}
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		//On y affecte les propri�t�s
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("model");
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(this.hibernateProperties());
		return emf;
		}
		
		
		private Properties hibernateProperties() {
			Properties properties = new Properties();
			
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.format_sql", "false");
			return properties;
			}
		
		//Bean de gestion de transactions
		@Bean
		public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
		}
		
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
		}
}
