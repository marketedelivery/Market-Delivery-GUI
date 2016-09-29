package br.com.marketedelivery.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public Teste() {
	}
	public static EntityManagerFactory emf;
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("teste");
		
		System.out.println("banco gerado");
		emf.close();
	}

}
