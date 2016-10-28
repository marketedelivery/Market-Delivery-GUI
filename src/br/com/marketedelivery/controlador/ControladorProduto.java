package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryProduto;
import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ControladorProduto
{
	private IProdutoDAO produtoDAO;
	
	public void cadastrarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.inserir(produto);
	}
	
	public void atualizarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.alterar(produto);
	}
	
	public List<Produto>listarTodosProdutos()
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.consultarTodos();
	}
	
	public Produto pesquisarProdutoPorNome(Produto produto)
	{
		String nome = produto.getNome();
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarPorNome(nome);
	}
	
	public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarProdutoPorSupermercado(supermercado);
	}
	
	public Produto pesquisarProdutoPorTipo(Produto produto)
	{
		String tipo = produto.getNome();
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarPorNome(tipo);
	}
	
	
}
