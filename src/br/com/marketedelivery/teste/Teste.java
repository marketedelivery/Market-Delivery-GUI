package br.com.marketedelivery.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

import br.com.marketedelivery.DAO.EntityManagerProducer;

public class Teste {
	public static EntityManagerFactory emf;
	public static EntityManagerFactory emf2;
	public static EntityManagerProducer emp = new EntityManagerProducer();
		//em.persist(s);
		em.getTransaction().commit();
		em.close();

	}
}
