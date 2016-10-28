package br.com.marketedelivery.teste;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.marketedelivery.util.ValidarCpf;
*/import br.com.marketedelivery.util.ValidarEmail;

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
//		String cpf= "12345678974";
//		ValidarCpf validar = new ValidarCpf();
//		System.out.println(cpf);
//		System.out.println(validar.validarCpf(cpf));
		
		String email = "melquizedek@.com.br";
		System.out.println(ValidarEmail.emailValido(email));
		System.out.println(ValidarEmail.isEmailValid(email));
        }	
}
