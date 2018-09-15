package fr.equensWorldline.ordreAchatBourse.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.equensWorldline.ordreAchatBourse.entities.AppUser;
import fr.equensWorldline.ordreAchatBourse.repository.RoleRepository;

public class MyPrincipale implements UserDetails{
private AppUser user;
@Autowired
private RoleRepository roleRepository;
public MyPrincipale(AppUser user) {
	super();
	this.user = user;
}

public MyPrincipale() {
	super();
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
Collection<GrantedAuthority>authorities=new ArrayList<>();
	roleRepository.findRolesByUsersId(user.getId()).forEach(r->{
		authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
	});
     return authorities;
}

@Override
public String getPassword() {
	return user.getPassword();
}

@Override
public String getUsername() {
	return user.getUsername();
}

@Override
public boolean isAccountNonExpired() {
	return true;
}

@Override
public boolean isAccountNonLocked() {
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	return true;
}

@Override
public boolean isEnabled() {
	return user.isActived();
}

public AppUser getUser() {
	return user;
}

public void setUser(AppUser user) {
	this.user = user;
}
	
}
