package fr.equensWorldline.ordreAchatBourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value= {"/login"},method=RequestMethod.GET)
public ModelAndView login() {
	ModelAndView model=new ModelAndView("login");
	return model;
}
	@RequestMapping(value="/admin")
public ModelAndView hello() {
	return new ModelAndView("adminPage");
}

}
