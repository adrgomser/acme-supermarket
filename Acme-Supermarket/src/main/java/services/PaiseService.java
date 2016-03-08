package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Consumer;
import domain.Paise;


import repositories.PaiseRepository;

@Service
@Transactional
public class PaiseService {

	@Autowired
	private PaiseRepository paiseRepository;
	
	
//Supporting Services
	@Autowired
	private ConsumerService consumerService;

	
	//Constructor
	
	public PaiseService(){
		super();
	}

	
	public Paise create(){
		Paise result;
		result= new Paise();
		result.setCode(generateRandomCode());
		return result;
	}
	
	private String generateRandomCode() {
		String letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r=new Random();
		List<Paise> paises=findAll();
		String code="";
		boolean res=false;
		while(!res){
		Paise aux=null;
		code="";
		code+=letras.charAt(r.nextInt(letras.length()-1));
		code+=letras.charAt(r.nextInt(letras.length()-1));
		code+="-";
		code+=(int)Math.random()*10;
		code+=(int)Math.random()*10;
		code+=(int)Math.random()*10;
		code+=(int)Math.random()*10;
		code+=(int)Math.random()*10;
		for(Paise p:paises){
			if(p.getCode().equalsIgnoreCase(code)){
				aux=p;
				break;
			}
		}
		if(aux==null){
			res=true;
		}
		}
		return code;
	}


	public Paise findOne(int paiseId) {
		Paise result;

		result = paiseRepository.findOne(paiseId);
	

		return result;
	}
	
	public List<Paise> findAll(){
		return paiseRepository.findAll();
	}
	public List<Paise> findAllButAssigned(){
		List<Paise> paises= paiseRepository.findAll();
		List<Paise> res=new ArrayList<Paise>();
		for(Paise p:paises){
			if(!p.isAssigned()){
				res.add(p);
			}
		}
		return res;
	}
	
		
	public Collection<Paise> showAll(){
		//Administrator administrator=administratorService.findByPrincipal();
		//Assert.notNull(administrator);
		return paiseRepository.findAll();
	}
	public void save(Paise c){
		//Administrator administrator=administratorService.findByPrincipal();
		//Assert.notNull(administrator);
		paiseRepository.save(c);
	}
	public void delete(Paise c){
		//Administrator administrator=administratorService.findByPrincipal();
		//Assert.notNull(administrator);
		if(c.isAssigned()){
		Collection<Consumer> consumers=consumerService.findAll();
		for(Consumer c1:consumers){
			if(c1.getPaises().contains(c)){
				c1.getPaises().remove(c);
				consumerService.save(c1);
			}
		}
		}
		
		paiseRepository.delete(c);
		
	}
	
}
	