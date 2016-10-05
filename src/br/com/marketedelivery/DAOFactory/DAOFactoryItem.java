package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.ItemDAO;
import br.com.marketedelivery.IDAO.IItemDAO;

public class DAOFactoryItem 
{
	 private static final EntityManagerFactory factory;
	    
	    public static IItemDAO itemDAO;
	  
	    static {
	        factory = Persistence.createEntityManagerFactory("bd_market");
	    }
	    
	    public static IItemDAO getItemDAO()
	    {
	        itemDAO = new ItemDAO(factory.createEntityManager());
	        return itemDAO;
	    }

	    
	    public static void close() {
	        if (factory != null && factory.isOpen()) {
	            factory.close();
	        }
	    } 
}
