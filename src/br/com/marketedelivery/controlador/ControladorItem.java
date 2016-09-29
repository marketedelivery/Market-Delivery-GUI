package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryItem;
import br.com.marketedelivery.IDAO.IItemDAO;
import br.com.marketedelivery.classesBasicas.Item;

public class ControladorItem 
{
	private IItemDAO itemDAO;
	
	public void CadastrarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.inserir(item);
	}
	
	public void AtualizarItem(Item item)
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		itemDAO.alterar(item);
	}
	
	public List<Item> ListarTodosItem()
	{
		itemDAO = DAOFactoryItem.getItemDAO();
		return itemDAO.consultarTodos();
	}
}