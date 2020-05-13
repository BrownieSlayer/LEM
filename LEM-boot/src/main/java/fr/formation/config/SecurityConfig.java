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
	.antMatchers("/assets/**").permitAll()
	.antMatchers("/joueur/**").hasAnyRole("JOUEUR")
	.antMatchers("/manager/**").hasAnyRole("MANAGER")
	.antMatchers("/**").hasAnyRole("ADMIN")
//	.antMatchers("/**").authenticated()
	.and()
//	.httpBasic()
	.formLogin()
		.loginPage("/connect") //lien ver le getMapping
		.loginProcessingUrl("/connect") //lien du post du form html
//		.defaultSuccessUrl("/") //Page par default apres connection
		.failureUrl("/connect?error=true") //Page d'erreur
		.permitAll()
		;
	}
	
	
	
	
	
	

}
