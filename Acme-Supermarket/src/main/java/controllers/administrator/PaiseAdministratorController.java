/* AdministratorController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Paise;

import services.PaiseService;

@Controller
@RequestMapping("/paise/administrator")
public class PaiseAdministratorController extends AbstractController {

	// Services ------------------------------------------------------------
	@Autowired
	private PaiseService paiseService;
	
	// Constructors -----------------------------------------------------------
	
	public PaiseAdministratorController() {
		super();
	}
	
	// Create Paise
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)	
	public ModelAndView createPaise(){
		Paise paise;
		ModelAndView result;
		
		paise = paiseService.create();
		result = createPaiseModelAndView(paise);
		
		return result;
	}
	// Listing Paise
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listPaise(){
		ModelAndView result;
		Collection<Paise> paises;
		
		paises = paiseService.findAll();
		
		result = new ModelAndView("paise/list");
		result.addObject("paises",paises);
		result.addObject("requestURI", "paise/administrator/list.do");
		
		return result;
	}
	
	//EDITION METHODS
	
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int paiseId){
		ModelAndView result;
		Paise paise;
		
		paise = paiseService.findOne(paiseId);
		Assert.notNull(paise);
		result = createEditModelAndView(paise);
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Paise paise,BindingResult binding){
		ModelAndView result;
		
			try{
				System.out.println(paise.getCode());
				System.out.println(paise.getTitle());
				System.out.println(paise.getMoney());
				paise.setUsed(false);
				paise.setAssigned(false);

				paiseService.save(paise);
				result = new ModelAndView("redirect:list.do");
			}catch(Throwable oops){
				result = createEditModelAndView(paise,"paise.commit.error");
			}
		
		return result;
	}
	
	@RequestMapping(value = "/edit" , method = RequestMethod.POST,params = "delete")
	public ModelAndView delete(Paise paise,BindingResult binding){
		ModelAndView result;
		
		try{
			paiseService.delete(paise);
			result = new ModelAndView("redirect:list.do");
		} catch(Throwable oops) {
			result = createEditModelAndView(paise,"paise.commit.error");
		}
		return result;
	}
	
	
	//ANCILLARY METHODS
	
	protected ModelAndView createPaiseModelAndView(Paise paise) {
		ModelAndView result;
		
		result = new ModelAndView("paise/administrator/edit");
		result.addObject("paise", paise);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Paise paise){
		ModelAndView result;
		
		result = createEditModelAndView(paise,null);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Paise paise, String message) {
		ModelAndView result;
		
		
		
		result = new ModelAndView("paise/administrator/edit");
		result.addObject("requestURI","/paise/administrator/edit.do");
		result.addObject("paise",paise);
		
		return result;
	}
	
}