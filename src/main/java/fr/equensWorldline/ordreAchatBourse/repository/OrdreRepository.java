package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import fr.equensWorldline.ordreAchatBourse.entities.Ordre;
public interface OrdreRepository extends JpaRepository<Ordre, Long> {

}
