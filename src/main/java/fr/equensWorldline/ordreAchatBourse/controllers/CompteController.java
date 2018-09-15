package fr.equensWorldline.ordreAchatBourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.equensWorldline.ordreAchatBourse.entities.Client;
import fr.equensWorldline.ordreAchatBourse.entities.CompteBanquaire;
import fr.equensWorldline.ordreAchatBourse.metier.IMetierClientImpl;
@RestController
public class CompteController {
	@Autowired
	IMetierClientImpl metier;
	@ResponseBody
	@RequestMapping(value="/client/compte/{numCp}",method=RequestMethod.GET)
	public CompteBanquaire findClientByID(HttpServletRequest req,@PathVariable("numCp")Long numCp) {
			
		return metier.findCompteClient(new Long(req.getParameter("idCl")), numCp);
	}
}
