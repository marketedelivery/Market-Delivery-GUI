package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IItemDAO;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Produto;

public class ControladorItem
{
	private IItemDAO itemDAO;

	public void cadastrarItem(Item item)
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.inserir(item);
		DAOFactory.close();
	}

	public void atualizarItem(Item item)
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.alterar(item);
		DAOFactory.close();
	}

	public List<Item> listarTodosItens()
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		List<Item> lista = itemDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public void removerProdutoItem(Item item)
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		itemDAO.remover(item);
		DAOFactory.close();
	}

	public Item buscarItemProduto(Produto produto)
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		Item i = itemDAO.buscarItemProduto(produto);
		DAOFactory.close();
		return i;
	}

	public List<Item> consultarItensPorLista(ListaDeCompras lista)
	{
		DAOFactory.abrir();
		// itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO = DAOFactory.getItemDAO();
		List<Item> list = itemDAO.consultarItensPorLista(lista);
		DAOFactory.close();
		return list;
	}
}