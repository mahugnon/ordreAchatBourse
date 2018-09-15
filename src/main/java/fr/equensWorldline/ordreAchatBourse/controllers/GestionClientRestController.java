package fr.equensWorldline.ordreAchatBourse.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.equensWorldline.ordreAchatBourse.entities.Client;
import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;
import fr.equensWorldline.ordreAchatBourse.entities.Message;
import fr.equensWorldline.ordreAchatBourse.entities.Ordre;
import fr.equensWorldline.ordreAchatBourse.metier.IMetierClientImpl;
import fr.equensWorldline.ordreAchatBourse.metier.IOpMetierImpl;
import fr.equensWorldline.ordreAchatBourse.repository.ClientRepository;

@RestController
public class GestionClientRestController {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	IMetierClientImpl metierClient;
@Autowired
IOpMetierImpl opMetier;
	@RequestMapping(value="/client/{id}",method=RequestMethod.GET)
	@ResponseBody
public Client findClientByID(@PathVariable("id") Long id) {
		Client cl=clientRepository.findClientByIdClient(id);
		if(cl==null) {
			throw new RuntimeException("Je n'arrive pas à trouver ce client.");
		}
	return cl;
}
	@RequestMapping(value="/client/ordre",method=RequestMethod.POST)
	@ResponseBody
	public Message ordenne(HttpServletRequest request,HttpServletResponse response) {
		Message message=null;
		Long idClient=new Long(request.getParameter("idClient"));
		Long idCompte=new Long(request.getParameter("idCompte"));
		Long codeISBN=new Long(request.getParameter("codeISBN"));
		Integer quantite=Integer.parseInt(request.getParameter("quantite"));
		System.out.println(quantite);
		String ordre=request.getParameter("ordre");
		try {
			if(ordre.equals("vente")) {
				message=opMetier.operererVente(idClient, idCompte, quantite, codeISBN);
			}else if(ordre.equals("achat")){
				message=opMetier.opererAchat(idClient, idCompte, quantite, codeISBN);
			
			}
			message.setMsg("succes");
		}catch (Exception e) {
			message=new Message();
			message.setMsg(e.getMessage());
		}
			
		
		return message;
	}
	@RequestMapping(value="/client/nouveau_client",method=RequestMethod.POST)
	@ResponseBody
public String creerClient(HttpServletRequest request,HttpServletResponse response) {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String numeroCompte=request.getParameter("numeroCompte");
		Double solde=Double.parseDouble(request.getParameter("solde"));
		CompteBanquaire cp=new CompteBanquaire(new Long(numeroCompte), solde);
		Client cl=new Client();
		cl.setNom(nom);
		cl.setPrenom(prenom);
		metierClient.creerClient(cl, cp);

		return "succès";
}
	
}
