package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.UsuarioDAO;
import br.com.marketedelivery.IDAO.IUsuarioDAO;



public abstract class DAOFactoryUsuario
{
    
    private static final EntityManagerFactory factory;
    
    public static IUsuarioDAO usuarioDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bd_market");
    }
    
    public static IUsuarioDAO getUsuarioDAO()
    {
        usuarioDAO = new UsuarioDAO(factory.createEntityManager());
        return usuarioDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
