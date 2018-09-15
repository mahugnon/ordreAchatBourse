package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.equensWorldline.ordreAchatBourse.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	AppUser findByUsername(String name);
}
