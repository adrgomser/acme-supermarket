package services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.CreditCard;

import repositories.CreditCardRepository;

@Service
@Transactional
public class CreditCardService {
		// Managed repository -----------------------------------------------------

		@Autowired
		private CreditCardRepository creditCardRepository;
		public CreditCardService(){
			super();
		}

		
		public CreditCard create(){
			//Administrator administrator=administratorService.findByPrincipal();
			//Assert.notNull(administrator);
			CreditCard result;
			result= new CreditCard();
			return result;
		}
		public CreditCard findOne(int creditCardId) {
			CreditCard result;

			result = creditCardRepository.findOne(creditCardId);
		

			return result;
		}
		
		public List<CreditCard> findAll(){
			return creditCardRepository.findAll();
		}
			
		public Collection<CreditCard> showAll(){
			//Administrator administrator=administratorService.findByPrincipal();
			//Assert.notNull(administrator);
			return creditCardRepository.findAll();
		}
		public void save(CreditCard c){
			//Administrator administrator=administratorService.findByPrincipal();
			//Assert.notNull(administrator);
			creditCardRepository.save(c);
		}
		public void delete(CreditCard c){
			//Administrator administrator=administratorService.findByPrincipal();
			//Assert.notNull(administrator);
			creditCardRepository.delete(c);
			
		}

}
