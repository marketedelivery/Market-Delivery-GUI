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
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.inserir(produto);
	}

	public void atualizarProduto(Produto produto)
	{
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.alterar(produto);
	}

	public List<Produto> listarTodosProdutos()
	{
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		return produtoDAO.consultarTodos();
	}

	public Produto pesquisarProdutoPorNome(Produto produto)
	{
		String nome = produto.getNome();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		return produtoDAO.buscarPorNome(nome);
	}

	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
	{
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		return produtoDAO.buscarProdutoPorSupermercado(supermercado);
	}

	public Produto pesquisarProdutoPorTipo(Produto produto)
	{
		String tipo = produto.getNome();
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		return produtoDAO.buscarPorNome(tipo);
	}

	public void removerProduto(Produto produto)
	{
		// produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO = DAOFactory.getProdutoDAO();
		produtoDAO.remover(produto);
	}
}
