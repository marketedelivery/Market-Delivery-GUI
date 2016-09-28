package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryProduto;
import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;

public class ControladorProduto
{
	private IProdutoDAO produtoDAO;
	
	public void CadastrarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.inserir(produto);
	}
	
	public void AtualizarProduto(Produto produto)
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		produtoDAO.alterar(produto);
	}
	
	public List<Produto>ListarTodosProdutos()
	{
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.consultarTodos();
	}
	
	public Produto PesquisarProdutoPorNome(Produto produto)
	{
		String nome = produto.getNome();
		produtoDAO = DAOFactoryProduto.getProdutoDAO();
		return produtoDAO.buscarPorNome(nome);
	}
	
	
}
