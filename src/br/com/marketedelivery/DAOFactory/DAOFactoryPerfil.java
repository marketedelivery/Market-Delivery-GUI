package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.PerfilDAO;
import br.com.marketedelivery.IDAO.IPerfilDAO;

public class DAOFactoryPerfil
{
	 
    private static final EntityManagerFactory factory;
    
    public static IPerfilDAO perfilDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bd_market");
    }
    
    public static IPerfilDAO getPerfilDAO()
    {
        perfilDAO = new PerfilDAO(factory.createEntityManager());
        return perfilDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
