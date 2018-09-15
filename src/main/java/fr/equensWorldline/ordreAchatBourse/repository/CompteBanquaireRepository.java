package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;

public interface CompteBanquaireRepository extends JpaRepository<CompteBanquaire, Long> {
@Query(
	value="select * from compte_banquaire cp "
			+ "where cp.numero_compte=?2 and cp.code_client=?1",
			nativeQuery=true
		)
	public CompteBanquaire findByNumeroCompteByIdCl(Long idCl,Long numCompte);

}
