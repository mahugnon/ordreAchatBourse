package fr.equensWorldline.ordreAchatBourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.equensWorldline.ordreAchatBourse.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
List<Role>findRolesByUsersId(Long id);
}
