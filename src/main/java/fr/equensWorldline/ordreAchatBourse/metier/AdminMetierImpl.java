package fr.equensWorldline.ordreAchatBourse.metier;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.equensWorldline.ordreAchatBourse.entities.Tarification;
import fr.equensWorldline.ordreAchatBourse.repository.TarificationRepository;

@Service
public class AdminMetierImpl implements IAdminMetier {
@Autowired
TarificationRepository tarificationRepository;

/* (non-Javadoc)
 * @see fr.equensWorldline.ordreAchatBourse.metier.IAdminMetier#creerTarification(fr.equensWorldline.ordreAchatBourse.entities.Tarification)
 */
@Override
public Tarification creerTarification(Tarification tarification) {
	Tarification t=tarificationRepository.findTarif(tarification.getType());
	t.setEtat(false);
	tarificationRepository.save(t);
	tarification.setDateCreation(new Date());
	tarificationRepository.save(tarification);
	return t;
}
}
