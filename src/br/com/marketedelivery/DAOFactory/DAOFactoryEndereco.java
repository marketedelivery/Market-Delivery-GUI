package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.EnderecoDAO;
import br.com.marketedelivery.IDAO.IEnderecoDAO;


public class DAOFactoryEndereco
{
	 
    private static final EntityManagerFactory factory;
    
    public static IEnderecoDAO enderecoDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bancoapk");
    }
    
    public static IEnderecoDAO getEnderecoDAO()
    {
        enderecoDAO = new EnderecoDAO(factory.createEntityManager());
        return enderecoDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
