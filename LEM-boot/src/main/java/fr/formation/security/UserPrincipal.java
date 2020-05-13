package fr.formation.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.formation.model.Compte;

public class UserPrincipal implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Compte compte;

	public UserPrincipal(Compte compte) {
		if (compte == null) {
			throw new UsernameNotFoundException("Le compte n'existe pas");
		}
		this.compte = compte;
	}
	
	public String spec() {
		return "Spécificités";
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
		
		if (this.compte.getLogin().contentEquals("Kodo")) {
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return roles;
	}

	@Override
	public String getPassword() {
		return this.compte.getPassword();
	}

	@Override
	public String getUsername() {
		return this.compte.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
	
	

}
