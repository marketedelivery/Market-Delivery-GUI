package br.com.marketedelivery.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Usuario;

@ViewScoped
@ManagedBean
public class ListaMB 
{	
	private ListaDeCompras lista;
	private List<ListaDeCompras> listarTodos;
	private List<ListaDeCompras> listaFiltrados;
	private IFachada fachada;		
	
	public ListaDeCompras getLista() {
		return lista;
	}

	public void setLista(ListaDeCompras lista) {
		this.lista = lista;
	}

	public List<ListaDeCompras> getListaFiltrados() {
		return listaFiltrados;
	}

	public void setListaFiltrados(List<ListaDeCompras> listaFiltrados) {
		this.listaFiltrados = listaFiltrados;
	}

	public void setListarTodos(List<ListaDeCompras> listarTodos)
	{
		this.listarTodos = listarTodos;
	}

	public List<ListaDeCompras> getListarTodos()
	{
		return listarTodasLista();
	}
	
	public IFachada getFachada() 
	{
		if(fachada == null)
		{
			return fachada = new Fachada();
		}
		return fachada;
	}

	public List<ListaDeCompras> listarTodasLista()
	{
		Usuario temp = new Usuario();
		temp.setCodigo(LoginMB.codigoUsuario);
		Usuario user = getFachada().pesquisarPorCodigo(temp);
		listarTodos = getFachada().buscaListaPorUsuario(user);
		return listarTodos;
		
	}
}