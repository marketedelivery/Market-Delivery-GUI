package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.marketedelivery.DAO.FacesUtil;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

@ManagedBean(name = "supermercadoMB", eager = true)
@ApplicationScoped
public class SupermercadoMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IFachada fachada;
	Supermercado supermercado;
	private Supermercado supermercadoSelecionado;
	private String nomeProduto;
	private List<Supermercado> listaSupermercados;
	private List<Supermercado> listaSupermercadosFiltrados;
	private List<Supermercado> converterListaSuper;

	@PostConstruct
	public void init() {

	}

	public IFachada getFachada() {
		if (fachada == null) {
			return fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<Produto> listaProtudoDoSupermercado;

	public SupermercadoMB() {
		// TODO Auto-generated constructor stub

	}

	public Supermercado getSupermecado() {
		if (supermercado == null) {
			supermercado = new Supermercado();
		}
		return supermercado;
	}

	public List<Supermercado> getListarTodosSupermercados() {
		converterListaSuper = new ArrayList<Supermercado>();
		converterListaSuper = getFachada().listarTodosSupermercados();
		return converterListaSuper;

	}

	public Supermercado getSupermercadoSelecionado() {
		return supermercadoSelecionado;
	}

	public void setSupermercadoSelecionado(Supermercado supermercadoSelecionado) {
		this.supermercadoSelecionado = supermercadoSelecionado;
	}

	public List<Supermercado> getListaSupermercadosFiltrados() {
		return listaSupermercadosFiltrados;
	}

	public void setListaSupermercadosFiltrados(List<Supermercado> listaSupermercadosFiltrados) {
		this.listaSupermercadosFiltrados = listaSupermercadosFiltrados;
	}

	// Responsável em carregar uma lista de dados na tela do cadastro de
	// supermercados
	public void carregarPesquisa() {
		try {
			// fachada.ListarTodosSupermercados();
			// listaSupermercados = fachada.ListarTodosSupermercados();
			IFachada fachada = getFachada();
			listaSupermercados = fachada.listarTodosSupermercados();
		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os supermercados" + ex.getMessage());
		}
	}

	@PostConstruct
	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("supCod");
			// int codigo_pessoa = 0;
			if (valor != null) {
				//int codigo = Integer.parseInt(valor);
				supermercado = fachada.pesquisarPorCodigo(supermercado);
			}

		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os usuarios" + ex.getMessage());
		}
	}

}
