package fr.equensWorldline.ordreAchatBourse.metier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.equensWorldline.ordreAchatBourse.entities.Client;
import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;
import fr.equensWorldline.ordreAchatBourse.repository.ClientRepository;
import fr.equensWorldline.ordreAchatBourse.repository.CompteBanquaireRepository;

@Service
public class IMetierClientImpl implements IMetierClient {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteBanquaireRepository compteBanquaireRepository;

	@Override
	public CompteBanquaire creerCompte(CompteBanquaire cp) {

		return compteBanquaireRepository.save(cp);
	}

	@Override
	@Transactional
	public Client creerClient(Client client, CompteBanquaire cp) {
		cp.setClient(client);
		clientRepository.save(client);
		creerCompte(cp);
		return client;
	}

	@Override
	@Transactional
	public CompteBanquaire findCompteClient(Long codeCl, Long numComp) {
		CompteBanquaire cp = compteBanquaireRepository.findByNumeroCompteByIdCl(codeCl, numComp);
		if (cp == null) {
			throw new RuntimeException("Compte Inexistant");
		}
		return cp;
	}

	@Override
	public CompteBanquaire updateCompte(CompteBanquaire cp) {
		compteBanquaireRepository.save(cp);
		return cp;
	}

	@Override
	public Client findClient(Long idClient) {
		Client cl=clientRepository.findClientByIdClient(idClient);
		if(cl==null)throw new RuntimeException("Client non trouvé");
		return cl;
	}
}
