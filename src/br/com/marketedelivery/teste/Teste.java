package br.com.marketedelivery.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.EntityManagerProducer;

public class Teste 
{
	public static EntityManagerFactory emf;
	public static EntityManagerFactory emf2;
	public static EntityManagerProducer emp = new EntityManagerProducer();
	
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("bancoapk");
		emf2 = Persistence.createEntityManagerFactory("bancoloja");
		emf.close();
		emf2.close();
		System.out.println("banco gerado");
	}

}
