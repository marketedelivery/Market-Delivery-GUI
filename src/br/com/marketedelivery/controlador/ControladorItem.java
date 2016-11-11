package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryItem;
import br.com.marketedelivery.IDAO.IItemDAO;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Produto;

public class ControladorItem
{
	private IItemDAO itemDAO;

	public void cadastrarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.inserir(item);
	}

	public void atualizarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.alterar(item);
	}

	public List<Item> listarTodosItens()
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		return itemDAO.consultarTodos();
	}

	public void removerProdutoItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.remover(item);
	}

	public Item buscarItemProduto(Produto produto)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		return itemDAO.buscarItemProduto(produto);
	}

	public List<Item> consultarItensPorLista(ListaDeCompras lista)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		return itemDAO.consultarItensPorLista(lista);
	}
}