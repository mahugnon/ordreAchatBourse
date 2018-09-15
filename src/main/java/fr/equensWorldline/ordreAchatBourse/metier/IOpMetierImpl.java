package fr.equensWorldline.ordreAchatBourse.metier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;
import fr.equensWorldline.ordreAchatBourse.entities.Instrument;
import fr.equensWorldline.ordreAchatBourse.entities.Message;
import fr.equensWorldline.ordreAchatBourse.entities.Ordre;
import fr.equensWorldline.ordreAchatBourse.entities.Tarification;
import fr.equensWorldline.ordreAchatBourse.repository.InstrumentRepository;
import fr.equensWorldline.ordreAchatBourse.repository.MessageRepository;
import fr.equensWorldline.ordreAchatBourse.repository.OrdreRepository;
import fr.equensWorldline.ordreAchatBourse.repository.TarificationRepository;

@Service
public class IOpMetierImpl implements IOpMetier {
	@Autowired
	IMetierClientImpl metierClient;
	@Autowired
	InstrumentRepository instrumentRepository;
	@Autowired
	TarificationRepository tarificarionRepository;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	OrdreRepository ordreRepository;

	@Override
	@Transactional
	public Message operererVente(Long idClient, Long numCompte, Integer quantite, Long codeISBN) {
		CompteBanquaire cp = metierClient.findCompteClient(idClient, numCompte);
		Instrument ins = findInstrument(codeISBN);
		Message m = new Message();

		double prixBrute = ins.getPrix() * quantite;
		double prixNet = 0;
		Tarification tarifier = tarificarionRepository.findTarif(prixBrute);
		if (tarifier.getType().equals("euro")) {
			prixNet = prixBrute - tarifier.getValeurTarif();
		} else {
			prixNet = prixBrute - (prixBrute * tarifier.getValeurTarif());
		}
		cp.setSolde(cp.getSolde() + prixNet);
		metierClient.updateCompte(cp);
		Ordre v = new Ordre();
		v.setTypeOrdre("vente");
		v.setClient(metierClient.findClient(idClient));
		v.setInstrument(ins);
		ordreRepository.save(v);
		m.setCodeISBN(codeISBN);
		m.setMontantBrut(prixBrute);
		m.setMontantNet(prixNet);
		m.setNumCompte(numCompte);
		m.setCodeClient(idClient);
		m.setOrdre(v);
		messageRepository.save(m);
		return m;
	}

	@Override
	@Transactional
	public Message opererAchat(Long idClient, Long numCompte, Integer quantite, Long codeISBN) {
		CompteBanquaire cp = metierClient.findCompteClient(idClient, numCompte);
		Instrument ins = findInstrument(codeISBN);
		double prixBrute = ins.getPrix() * quantite;
		Message m = new Message();
		double prixNet = 0;
		Tarification tarifier = tarificarionRepository.findTarif(prixBrute);
		if (tarifier.getType().equals("euro")) {
			prixNet = prixBrute + tarifier.getValeurTarif();
		} else {
			prixNet = prixBrute + (prixBrute * tarifier.getValeurTarif());
		}
		if (prixNet > cp.getSolde()) {
			throw new RuntimeException("Solde insuffisant");
		} else if (prixNet <= cp.getSolde()) {
			cp.setSolde(cp.getSolde() - prixNet);
			metierClient.updateCompte(cp);
			Ordre a = new Ordre();
			a.setClient(metierClient.findClient(idClient));
			a.setInstrument(ins);
			a.setTypeOrdre("achat");
			ordreRepository.save(a);
			m.setCodeISBN(codeISBN);
			m.setMontantBrut(prixBrute);
			m.setMontantNet(prixNet);
			m.setNumCompte(numCompte);
			m.setCodeClient(idClient);
			m.setOrdre(a);
			messageRepository.save(m);
		}
		return m;

	}

	public Instrument findInstrument(Long codeISBN) {
		Instrument ins = instrumentRepository.findInstrumentByCodeInstrument(codeISBN);
		if (ins == null)
			throw new RuntimeException("Instrument Inexistant");
		return ins;
	}

}
