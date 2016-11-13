package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ControladorProduto
{
	private IProdutoDAO produtoDAO;

	public void cadastrarProduto(Produto produto)
	{
		DAOFactory.abrir();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.inserir(produto);
		DAOFactory.close();
	}

	public void atualizarProduto(Produto produto)
	{
		DAOFactory.abrir();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.alterar(produto);
		DAOFactory.close();
	}

	public List<Produto> listarTodosProdutos()
	{
		DAOFactory.abrir();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public Produto pesquisarProdutoPorNome(Produto produto)
	{
		DAOFactory.abrir();
		String nome = produto.getNome();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.buscarPorNome(nome);
		DAOFactory.close();
		return p;
	}

	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
	{
		DAOFactory.abrir();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		List<Produto> lista = produtoDAO.buscarProdutoPorSupermercado(supermercado);
		DAOFactory.close();
		return lista;
	}

	public Produto pesquisarProdutoPorTipo(Produto produto)
	{
		DAOFactory.abrir();
		String tipo = produto.getNome();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		Produto p = produtoDAO.buscarPorNome(tipo);
		DAOFactory.close();
		return p;
	}

	public void removerProduto(Produto produto)
	{
		DAOFactory.abrir();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.remover(produto);
		DAOFactory.close();
	}
}