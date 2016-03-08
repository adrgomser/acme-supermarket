package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ConsumerService;
import domain.Consumer;
import domain.Paise;

@Controller
@RequestMapping("/paise/consumer")
public class PaiseController extends AbstractController{

	@Autowired
	private ConsumerService consumerService;
	
	
	// Constructors -----------------------------------------------------------
	public PaiseController() {
		super();
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listPaise(){
		ModelAndView result;
		Collection<Paise> paise;
		Consumer c=consumerService.findByPrincipal();
		paise = c.getPaises();
		
		result = new ModelAndView("paise/list");
		result.addObject("paises",paise);
		result.addObject("requestURI", "paise/consumer/list.do");
		
		return result;
	}
}
