package br.com.marketedelivery.DAOFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.DAO.ProdutoDAO;
import br.com.marketedelivery.IDAO.IProdutoDAO;

public class DAOFactoryProduto 
{
	 
    private static final EntityManagerFactory factory;
    
    public static IProdutoDAO produtoDAO;
  
    static {
        factory = Persistence.createEntityManagerFactory("teste");
    }
    
    public static IProdutoDAO getProdutoDAO()
    {
        produtoDAO = new ProdutoDAO(factory.createEntityManager());
        return produtoDAO;
    }

    
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    } 
}
