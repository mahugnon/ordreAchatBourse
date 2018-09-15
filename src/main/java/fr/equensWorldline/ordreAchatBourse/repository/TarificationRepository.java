package fr.equensWorldline.ordreAchatBourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import fr.equensWorldline.ordreAchatBourse.entities.Tarification;

public interface TarificationRepository extends JpaRepository<Tarification, Long> {
	@Query(value = "select t from Tarification t" + " where t.minCond<?1" + " and t.maxCond>?1" + " and t.etat=true")
	public Tarification findTarif(double prixNet);
@Query(value="select * from tarification t where t.type=?1 order by t.id desc limit 1",
		nativeQuery=true)
	public Tarification findTarif(String type);
}
