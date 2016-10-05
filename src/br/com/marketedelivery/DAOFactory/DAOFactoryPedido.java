package br.com.marketedelivery.DAOFactory;




import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.PedidoDAO;
import br.com.marketedelivery.IDAO.IPedidoDAO;

public class DAOFactoryPedido 
{
	 
    private static final EntityManagerFactory factory;
    
    public static IPedidoDAO pedidoDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bd_market");
    }
    
    public static IPedidoDAO getPedidoDAO()
    {
        pedidoDAO = new PedidoDAO(factory.createEntityManager());
        return pedidoDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
