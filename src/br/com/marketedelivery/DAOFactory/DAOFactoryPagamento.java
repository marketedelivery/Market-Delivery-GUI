package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.PagamentoDAO;
import br.com.marketedelivery.IDAO.IPagamentoDAO;

public class DAOFactoryPagamento
{
	 
    private static final EntityManagerFactory factory;
    
    public static IPagamentoDAO pagamentoDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("bd_market");
    }
    
    public static IPagamentoDAO getPagamentoDAO()
    {
        pagamentoDAO = new PagamentoDAO(factory.createEntityManager());
        return pagamentoDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
