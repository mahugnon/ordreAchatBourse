package fr.equensWorldline.ordreAchatBourse.metier;

import fr.equensWorldline.ordreAchatBourse.entities.Client;
import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;

public interface IMetierClient {
public CompteBanquaire creerCompte(CompteBanquaire cp);
public CompteBanquaire updateCompte(CompteBanquaire cp);
public Client findClient(Long idClient);
public Client creerClient(Client client,CompteBanquaire cp);
public CompteBanquaire findCompteClient(Long codeCl,Long numComp);
}
