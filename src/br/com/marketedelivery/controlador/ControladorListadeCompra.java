package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryListadeCompras;
import br.com.marketedelivery.IDAO.IListaDeComprasDAO;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;

public class ControladorListadeCompra 
{
	IListaDeComprasDAO listaDAO;

	public void CadastrarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.inserir(lista);
	}
	
	public void AtualizarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.alterar(lista);
	}
	
	public List<ListaDeCompras>ListarTudo()
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		return listaDAO.consultarTodos();
	}
	
	public ListaDeCompras buscarPorCodigo(ListaDeCompras lista)
	{
		int codigo = lista.getCodigo();
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		ListaDeCompras retorno =listaDAO.consultarPorId(codigo);
		return retorno;
	}
	
}
