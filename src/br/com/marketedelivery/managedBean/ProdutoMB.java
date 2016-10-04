package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

@ViewScoped
@ManagedBean(name = "produtoMB")
public class ProdutoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto;
	ProdutoMB produtoMB;
	IFachada fachada;
	private Supermercado supermercadoSelecionado;
	private List<Supermercado> listaSupermercado;

	private String nomeProduto;

	@ManagedProperty("#{themeService}")
	private SupermercadoMB supermercadoMB;

	@PostConstruct
	public void init() {
		listaSupermercado = getFachada().listarSupermercado();
		// listaSupermercado = getSupermercadoMB.getListarTodosSupermercados();
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public List<Produto> getListaDeProduto() {
		fachada = new Fachada();
		// getProduto().setNome("macarrao");
		// produtoMB =new ProdutoMB();
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("biscoito wafer", "nestler", 2.50));
		list.add(new Produto("biscoito recheado", "nestler", 2.50));
		list.add(new Produto("biscoito amanteigado", "nestler", 2.50));
		list.add(new Produto("biscoito doce", "nestler", 2.50));
		
		list.add(new Produto("biscoito bonito", "nestler", 2.50));
		list.add(new Produto("biscoito wafer", "nestler", 2.50));

		// return fachada.PesquisarProdutoPorNome(produto);
		// return produtoMB.getLista();
		return list;
	}

	public List<Produto> getLista() {

		/*if (getSupermercadoSelecionado() == null) {
			List<Produto> list = new ArrayList<Produto>();
			list.add(new Produto("nestler", "biscoito wafer", 2.50));
			list.add(new Produto("nestler", "biscoito recheado", 2.50));
			list.add(new Produto("nestler", "biscoito amanteigado", 2.50));
			list.add(new Produto("nestler", "biscoito doce", 2.50));
			list.add(new Produto("nestler", "biscoito feio", 2.50));
			list.add(new Produto("nestler", "biscoito bonito", 2.50));
			list.add(new Produto("nestler", "biscoito wafer", 2.50));
			return list;
		}*/

		// return list;
		
		fachada = new Fachada();
		return fachada.ListarTodosProdutos();
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	
	

	public IFachada getFachada() 
	{
		if(fachada == null )
		{
			fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public List<Supermercado> getListaSupermercado() {
		return listaSupermercado;
	}

	public Supermercado getSupermercadoSelecionado() {
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
}
