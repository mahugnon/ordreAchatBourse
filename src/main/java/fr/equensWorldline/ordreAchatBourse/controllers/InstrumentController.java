package fr.equensWorldline.ordreAchatBourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.equensWorldline.ordreAchatBourse.entities.Instrument;
import fr.equensWorldline.ordreAchatBourse.metier.IOpMetierImpl;
import fr.equensWorldline.ordreAchatBourse.repository.InstrumentRepository;

@RestController
public class InstrumentController {
	@Autowired
	IOpMetierImpl metier;
	@RequestMapping(value="/client/instrument/{codeISBN}",method=RequestMethod.GET)
	@ResponseBody
public Instrument findInstrument(@PathVariable("codeISBN")Long codeISBN) {
		return metier.findInstrument(codeISBN);
	}
}
