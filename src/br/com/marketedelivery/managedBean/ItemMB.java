package br.com.marketedelivery.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

@ManagedBean
@ViewScoped
public class ItemMB {
	private Produto produto;
	private Item item;

	private List<Produto> listaProduto;
	private List<Produto> todosProdutos;
	private List<Produto> produtosFiltrados;
	private List<Item> listaItens;

	private IFachada fachada;
	private List<Supermercado> listaTodoSupermercado;

	@PostConstruct
	public void init() {
		listaProduto = new ArrayList<Produto>();
	}

	public List<Item> getListaItens() {
		if (listaItens == null) {
			listaItens = new ArrayList<Item>();
		}
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		if (produto == null) {
			return produto = new Produto();
		} else {
			return produto;
		}
	}

	public Item getItem() {
		if (item == null) {
			item = new Item();
		} else {
			return item;
		}
		return item;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public IFachada getFachada() {
		if (fachada == null) {
			return fachada = new Fachada();
		} else {
			return fachada;
		}
	}

	public List<Produto> getTodosProdutos() {
		return todosProdutos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void produtoOnDrop(DragDropEvent ddEvent) {
		Produto pdt = ((Produto) ddEvent.getData());
		Item it = new Item();
		it.setProduto(pdt);
		listaItens.add(it);
	}

	public List<Supermercado> getListaTodoSupermercado() {
		listaTodoSupermercado = getFachada().listarTodosSupermercados();
		return listaTodoSupermercado;
	}

	public void listar() {
		todosProdutos = getFachada().buscarProdutoPorSupermercado(getProduto().getSupermercado());
	}

	public void adicionarProduto(Produto produto) {
		Item it = new Item();
		it.setProduto(produto);
		it.setQtdProduto(1);
		it.setPrecoTotal(produto.getValorUnitario() * it.getQtdProduto());
		System.out.println(it);
		listaItens.add(it);
	}
}
