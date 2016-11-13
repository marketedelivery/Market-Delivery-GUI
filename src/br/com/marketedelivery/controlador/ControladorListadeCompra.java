package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.DAOFactory.DAOFactory;
import br.com.marketedelivery.IDAO.IListaDeComprasDAO;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Usuario;

public class ControladorListadeCompra
{
	IListaDeComprasDAO listaDAO;

	public void cadastrarLista(ListaDeCompras lista)
	{
		DAOFactory.abrir();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.inserir(lista);
		DAOFactory.close();
	}

	public void atualizarLista(ListaDeCompras lista)
	{
		DAOFactory.abrir();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.alterar(lista);
		DAOFactory.close();
	}

	public List<ListaDeCompras> listarTodasListas()
	{
		DAOFactory.abrir();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		List<ListaDeCompras> lista = listaDAO.consultarTodos();
		DAOFactory.close();
		return lista;
	}

	public ListaDeCompras buscarPorCodigo(ListaDeCompras lista)
	{
		DAOFactory.abrir();
		int codigo = lista.getCodigo();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		ListaDeCompras retorno = listaDAO.consultarPorId(codigo);
		DAOFactory.close();
		return retorno;
	}

	public List<ListaDeCompras> buscaListaPorUsuario(Usuario usuario)
	{
		DAOFactory.abrir();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		List<ListaDeCompras> retorno = listaDAO.buscaListaPorUsuario(usuario);
		DAOFactory.close();
		return retorno;
	}

	public void removerLista(ListaDeCompras lista)
	{
		DAOFactory.abrir();
		// listaDAO = DAOFactoryListadeCompras.getListaDAO();
		listaDAO = DAOFactory.getListaDAO();
		listaDAO.remover(lista);
		DAOFactory.close();
	}
}