package br.com.marketedelivery.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.marketedelivery.util.ValidarEmail;

public class Teste 
{
	public static void main(String[] args) 
	{
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd_market");
//		EntityManager em = emf.createEntityManager();
//	    EntityTransaction et = em.getTransaction();
//	    
//		et.begin();
//        et.commit();
//		em.close();
//		emf.close();
		
		String email = "melquizedek.jc@gmail.com";
		ValidarEmail tE = new ValidarEmail();
		System.out.println(tE.emailValido(email));
        }	
}
