package br.com.marketedelivery.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.marketedelivery.IDAO.IEnderecoDAO;
import br.com.marketedelivery.IDAO.IListaDeComprasDAO;
import br.com.marketedelivery.IDAO.IPagamentoDAO;
import br.com.marketedelivery.IDAO.IPerfilDAO;
import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.IDAO.ISupermercadoDao;
import br.com.marketedelivery.IDAO.IUsuarioDAO;

public class DaoFactory 
{
    private static final EntityManagerFactory factory;
	public static IUsuarioDAO usuarioDAO;
	public static ISupermercadoDao supermercadoDAO;
	public static IListaDeComprasDAO listadecompraDAO;
	public static IPagamentoDAO pagamentoDAO;
	public static IProdutoDAO produtoDAO;
	public static IEnderecoDAO enderecoDAO;
	public static IPerfilDAO perfilDAO;
	
    
    static{
    	factory = Persistence.createEntityManagerFactory("testeBD");
    }
	
	public static IUsuarioDAO getUsuarioDAO()
	{
		usuarioDAO = new UsuarioDAO(factory.createEntityManager());
		return usuarioDAO;
	}
	
	public static ISupermercadoDao getSupermercadoDao()
	{
		supermercadoDAO = new SupermercadoDAO(factory.createEntityManager());
		return supermercadoDAO;
	}
	
	public static IListaDeComprasDAO getListadecompraDAO() 
	{
		listadecompraDAO = new ListaDeComprasDAO(factory.createEntityManager());
		return listadecompraDAO;
	}

	public static IPagamentoDAO getPagamentoDAO() 
	{
		pagamentoDAO = new PagamentoDAO(factory.createEntityManager());
		return pagamentoDAO;
	}

	public static IProdutoDAO getProdutoDAO() 
	{
		produtoDAO = new ProdutoDAO(factory.createEntityManager());
		return produtoDAO;
	}

	public static IEnderecoDAO getEnderecoDAO() 
	{
		enderecoDAO = new EnderecoDAO(factory.createEntityManager());
		return enderecoDAO;
	}

	public static IPerfilDAO getPerfilDAO() 
	{
		perfilDAO = new PerfilDAO(factory.createEntityManager());
		return perfilDAO;
	}
	
	public static void close()
	{
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
}
