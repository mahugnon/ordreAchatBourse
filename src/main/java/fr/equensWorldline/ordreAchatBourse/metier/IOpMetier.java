package fr.equensWorldline.ordreAchatBourse.metier;

import fr.equensWorldline.ordreAchatBourse.entities.Instrument;
import fr.equensWorldline.ordreAchatBourse.entities.Message;

public interface IOpMetier {
public Message operererVente(Long idClient,Long numCompte, Integer quantite,Long codeISBN);
public Message opererAchat(Long idClient,Long numCompte, Integer quantite,Long codeISBN);
public Instrument findInstrument(Long codeISBN);
}
