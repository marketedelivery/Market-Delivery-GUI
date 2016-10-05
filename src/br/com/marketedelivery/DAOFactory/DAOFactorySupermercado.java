package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.SupermercadoDAO;
import br.com.marketedelivery.IDAO.ISupermercadoDAO;

public class DAOFactorySupermercado 
{
	 private static final EntityManagerFactory factory;
	    
	    public static ISupermercadoDAO supermercadoDAO;
	  
	    static {
	        factory = Persistence.createEntityManagerFactory("bd_market");
	    }
	    
	    public static ISupermercadoDAO getSupermercadoDAO()
	    {
	        supermercadoDAO = new SupermercadoDAO(factory.createEntityManager());
	        return supermercadoDAO;
	    }

	    
	    public static void close() {
	        if (factory != null && factory.isOpen()) {
	            factory.close();
	        }
	    } 
}
