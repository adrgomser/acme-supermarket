package controllers.administrator;




import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ConsumerService;
import services.PaiseService;
import controllers.AbstractController;
import domain.Consumer;
import domain.Paise;

@Controller
@RequestMapping("/consumer/administrator")
public class ConsumerAdministratorController extends AbstractController {
	
	// Services ---------------------------------------------------------------

	@Autowired
	private ConsumerService consumerService;
	@Autowired
	private PaiseService paiseService;
	
	// Constructors -----------------------------------------------------------
	
	public ConsumerAdministratorController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mav;
		Collection<Consumer> consumers;

		consumers = consumerService.findAll();

		mav = new ModelAndView("consumer/list");
		mav.addObject("consumers", consumers);
		mav.addObject("requestURI","/consumer/administrator/list.do");


		return mav;
	}
	@RequestMapping(value = "/assign",method = RequestMethod.GET)
	public ModelAndView assign(@RequestParam int consumerId){
		ModelAndView result;
		Consumer consumer;
		
		consumer = consumerService.findOne(consumerId);
		Assert.notNull(consumer);
		result = createEditModelAndView(consumer);
		
		return result;
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Consumer consumer,BindingResult binding){
		ModelAndView result;
		
			try{
				System.out.println("por aqui2");

				consumerService.save(consumer);
				System.out.println("por aqui");
				for(Paise p:consumer.getPaises()){
					p.setAssigned(true);
				}
				result = new ModelAndView("redirect:list.do");
			}catch(Throwable oops){
				result = createEditModelAndView(consumer,"sc.commit.error");
			}
		
		return result;
	}
	
	
	
	//ANCILLARY METHODS
	
	protected ModelAndView createConsumerModelAndView(Consumer consumer) {
		ModelAndView result;
		
		result = new ModelAndView("consumer/administrator/assign");
		result.addObject("consumer", consumer);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Consumer consumer){
		ModelAndView result;
		
		result = createEditModelAndView(consumer,null);
		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Consumer consumer, String message) {
		ModelAndView result;
		
		
		List<Paise> paises=paiseService.findAllButAssigned();
		result = new ModelAndView("consumer/administrator/assign");
		result.addObject("requestURI","/consumer/administrator/assign.do");
		result.addObject("consumer",consumer);
		result.addObject("paises2",paises);
		
		return result;
	}
}
