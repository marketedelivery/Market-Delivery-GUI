package br.com.marketedelivery.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class Teste {

	public Teste() {
	}
	
	public static List<Produto> getLista(){
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("arroz", "camil", 3.98, 5000));
		list.add(new Produto("arroz", "tio joao ", 3.75, 5000));
		list.add(new Produto("leite em po", "ninho ", 4.38, 5000));
		list.add(new Produto("biscoito ", "mococa ", 2.50, 5000));
		list.add(new Produto("treloso", "vitarella ", 2.50, 5000));
		list.add(new Produto("arroz", "ki caldo ", 2.50, 5000));
		list.add(new Produto("macarrao ", "eleger ", 2.50, 5000));
		
		return list;
	
}
	public static Supermercado getSupermercado(){
		//List<Supermercado> list = new ArrayList<Supermercado>();
		//list.add(new Supermercado("EXTRA",getLista()));
		Supermercado s = new Supermercado("MARANATA",getLista());
		return s;
				
	}
	public static void main(String[] args) {
		 EntityManagerFactory emf;
		 EntityManager em;
		emf = Persistence.createEntityManagerFactory("teste");
		System.out.println("banco gerado");
		em =  emf.createEntityManager();
		em.getTransaction().begin();
		
		//em.persist(getLista());
		//em.getTransaction().commit();
		
		
		//for (Object o : getLista()) {
			
		   //em.persist(o);
		  //em.flush();
		  // em.clear();
		   // }
		//em.getTransaction().commit();
		
		//em.getTransaction().begin();
		Supermercado s = new Supermercado();
		s.setNome("MARANATA");
		s.setProdutos(getLista());
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
