package fr.equensWorldline.ordreAchatBourse.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.equensWorldline.ordreAchatBourse.entities.Tarification;
import fr.equensWorldline.ordreAchatBourse.metier.AdminMetierImpl;
import fr.equensWorldline.ordreAchatBourse.metier.IAdminMetier;

@RestController
public class AdminRestController {
	@Autowired 
	AdminMetierImpl metier;
	@RequestMapping(value="/admin/tarif",method=RequestMethod.POST)
	@ResponseBody
public Tarification creerTarif(HttpServletRequest request,HttpServletResponse response){
		String typeTarif=request.getParameter("typeTarif");
		double minCond=Double.parseDouble(request.getParameter("minCond"));
		double maxCond=Double.parseDouble(request.getParameter("maxCond"));
		double valTarif=Double.parseDouble(request.getParameter("valTarif"));
		Tarification t=new Tarification(true, minCond, maxCond, valTarif);
		t.setType(typeTarif);
		t=metier.creerTarification(t);
				
		return t;
}
}
