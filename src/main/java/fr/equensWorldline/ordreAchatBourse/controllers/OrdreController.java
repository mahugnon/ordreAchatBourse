package fr.equensWorldline.ordreAchatBourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/"})
public class OrdreController {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView bienvenue() {
	ModelAndView model= new ModelAndView("client");
	return model;
	}
	
	
	
	
	


}
