package fr.equensWorldline.ordreAchatBourse.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.equensWorldline.ordreAchatBourse.entities.AppUser;
import fr.equensWorldline.ordreAchatBourse.repository.RoleRepository;
import fr.equensWorldline.ordreAchatBourse.repository.AppUserRepository;
@Service
public class UserDetailService implements UserDetailsService{
	@Autowired
AppUserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Je ne vous connais pas, Veillez vous enregistrer");
		}
		Collection<GrantedAuthority>authorities=new ArrayList<>();
		roleRepository.findRolesByUsersId(user.getId()).forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(user.getUsername(),user.getPassword(),authorities);
	}


}
