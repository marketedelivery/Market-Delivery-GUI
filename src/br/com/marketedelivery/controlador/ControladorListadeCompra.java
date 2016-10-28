package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactoryListadeCompras;
import br.com.marketedelivery.IDAO.IListaDeComprasDAO;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Usuario;

public class ControladorListadeCompra 
{
	IListaDeComprasDAO listaDAO;

	public void cadastrarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.inserir(lista);
	}
	
	public void atualizarLista(ListaDeCompras lista)
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO.alterar(lista);
	}
	
	public List<ListaDeCompras>listarTodasListas()
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
	
	public List<ListaDeCompras> buscaListaPorUsuario(Usuario usuario) 
	{
		listaDAO = DAOFactoryListadeCompras.getListaDAO();
		List<ListaDeCompras> retorno = listaDAO.buscaListaPorUsuario(usuario);
		return retorno;
	}
	
}
