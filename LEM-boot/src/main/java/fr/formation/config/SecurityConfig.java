package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.formation.security.UserConnected;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled=true)
@Profile("!dev")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println(new BCryptPasswordEncoder().encode("mdp"));
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/").permitAll()
	.antMatchers("/assets/**").permitAll()
	.antMatchers("/inscription/**").permitAll()
	.antMatchers("/connect/**").permitAll()
	.antMatchers("/logout/**").permitAll()
	.antMatchers("/joueur/**").hasAnyRole("JOUEUR", "ADMIN")
	.antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
	.antMatchers("/rest/**").permitAll()
	.antMatchers("/api/**").permitAll()
	.antMatchers("/**").hasAnyRole("ADMIN")
//	.antMatchers("/**").authenticated()
	.and()
//	.httpBasic()
	.formLogin()
		.loginPage("/connect") //lien ver le getMapping
		.loginProcessingUrl("/connect") //lien du post du form html
		//.defaultSuccessUrl("/connect") //Page par default apres connection
		.successHandler(new UserConnected())
		.failureUrl("/connect?error=true") //Page d'erreur
		.permitAll()
	.and()
	.logout()
		//.logoutUrl("/connect")
		.logoutSuccessUrl("/connect")
		.permitAll();
		;
	}
	
	
	
	
	
	

}
