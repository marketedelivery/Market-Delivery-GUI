package br.com.marketedelivery.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.IDAO.IClienteDAO;
import br.com.marketedelivery.IDAO.ISupermercadoDao;

public class DaoFactory 
{
    private static final EntityManagerFactory factory;
	public static IClienteDAO clienteDAO;
	public static ISupermercadoDao supermercadoDAO;
    
    static{
    	factory = Persistence.createEntityManagerFactory("testeBD");
    }
	
	public static IClienteDAO getClienteDao()
	{
		clienteDAO = new ClienteDAO(factory.createEntityManager());
		return clienteDAO;
	}
	
	public static ISupermercadoDao getSupermercadoDao()
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
