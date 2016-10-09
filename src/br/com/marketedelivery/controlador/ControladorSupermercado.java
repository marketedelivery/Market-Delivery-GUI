package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactorySupermercado;
import br.com.marketedelivery.IDAO.ISupermercadoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ControladorSupermercado 
{
	private ISupermercadoDAO supermercadoDAO;
	
	public void cadastrarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		supermercadoDAO.inserir(supermercado);
	}
	
	public void atualizarSupermercado(Supermercado supermercado)
	{
		supermercadoDAO.alterar(supermercado);
	}
	
	public List<Supermercado>listarTodosSupermercados()
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return supermercadoDAO.consultarTodos();
	}
	
	
	public Supermercado pesquisarPorNome(Supermercado supermercado)
	{
		String nome = supermercado.getNome();
		Supermercado retorno = supermercadoDAO.buscarPorNome(nome);
		return retorno;
	}
	
	public Supermercado pesquisarPorCodigo(Supermercado supermercado)
	{
		 supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		 Supermercado sup = supermercadoDAO.consultarPorId(supermercado.getCodigo());
	        return sup;
	}
	
	
	public List<Produto> listaProtudoDoSupermercado(String nomeProduto, String supermercado) {
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return null;
	}
	
	public List<Supermercado> listarProdutoPorSupermercado(Supermercado supermercado)
	{
		supermercadoDAO = DAOFactorySupermercado.getSupermercadoDAO();
		return supermercadoDAO.listarProdutoPorSupermercado(supermercado);
	}
}
