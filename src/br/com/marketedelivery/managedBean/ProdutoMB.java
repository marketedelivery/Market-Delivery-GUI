package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.marketedelivery.DAO.FacesUtil;
import br.com.marketedelivery.DAO.ProdutoDAO;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Produto;

@ViewScoped
@ManagedBean(name = "produtoMB")
public class ProdutoMB implements Serializable {

	private Supermercado supermercado = new Supermercado();
	private Supermercado supermercadoSelecionado;
	private Produto produto;
	// private Endereco endereco;
	private IFachada fachada;
	private List<Produto> listar;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	private List<Supermercado> listaSupermercado;

	@ManagedProperty("#{themeService}")
	private SupermercadoMB supermercadoMB;

	@PostConstruct
	public void init() {
		listaSupermercado = getFachada().listarSupermercado();

	}

	Produto produtoCadastro;

	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public IFachada getFachada() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<Produto> getListar() {
		return listar;
	}

	public void setListar(List<Produto> listar) {
		this.listar = listar;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public List<Supermercado> getListarProdutos() {
		if (supermercado.getCodigo() != 0) {

			supermercadoSelecionado.setCodigo(supermercado.getCodigo());
			listaSupermercado = getFachada().listarProdutoPorSupermercado(supermercadoSelecionado);
			return listaSupermercado;
		}
		return null;
	}

	public List<Supermercado> getListaSupermercado() {

		return listaSupermercado;
	}

	public Supermercado getSupermercadoSelecionado() {
		if (supermercadoSelecionado == null) {
			return supermercadoSelecionado = new Supermercado();
		}
		return supermercadoSelecionado;
	}

	public void setSupermercadoSelecionado(Supermercado supermercadoSelecionado) {
		this.supermercadoSelecionado = supermercadoSelecionado;
	}

	public void setSupermercadoMB(SupermercadoMB supermercadoMB) {
		this.supermercadoMB = supermercadoMB;
	}

	public SupermercadoMB getSupermercadoMB() {
		if (supermercadoMB == null) {
			supermercadoMB = new SupermercadoMB();
		}
		return supermercadoMB;
	}

	// public void salvar()
	// {
	// try
	// {
	// produto.setEndereco(endereco);
	// fachada = getFachada();
	// fachada.CadastrarProduto(produto);
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage("Cadastro realizado com Sucesso"));
	// } catch (Exception e)
	// {
	// FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro
	// ao cadastrar, tente novamente mais tarde"));
	// System.out.println(e.getMessage());
	// }
	//
	// }

	// public void listarProduto()
	// {
	// IFachada fachada = getFachada();
	// listar = fachada.ListarTodosProdutos();
	// }

	// Responsável em carregar uma lista de dados na tela do cadastro de
	// produtos
	public void carregarPesquisa() {
		try {
			// fachada.ListarTodosProdutos();
			// listaProdutos = fachada.ListarTodosProdutos();
			IFachada fachada = getFachada();
			listaProdutos = fachada.ListarTodosProdutos();
		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos" + ex.getMessage());
		}
	}

	@PostConstruct
	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("prodcod");
			// int codigo_pessoa = 0;
			if (valor != null) {
				// int codigo = Integer.parseInt(valor);
				produto = fachada.pesquisarPorCodigo(produto);
			}

		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos" + ex.getMessage());
		}
	}
}
