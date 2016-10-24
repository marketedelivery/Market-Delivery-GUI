package br.com.marketedelivery.managedBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;


@ManagedBean
@ViewScoped
public class ItemMB 
{
	private Produto produto;
	private Item item;
	private ListaDeCompras listaCompras;

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

	public ListaDeCompras getListaCompras() 
	{
		if(listaCompras == null)
		{
			return listaCompras = new ListaDeCompras(); 
		}
		else
		{
			return listaCompras;
		}
	}

	public void setListaCompras(ListaDeCompras listaCompras) {
		this.listaCompras = listaCompras;
	}


	public List<Item> getListaItens() 
	{
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

	public Item getItem() 
	{
		if (item == null) 
		{
			return item = new Item();
		} else 
		{
			return item;
		}
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

//	public void produtoOnDrop(DragDropEvent ddEvent) {
//		Produto pdt = ((Produto) ddEvent.getData());
//		Item it = new Item();
//		it.setProduto(pdt);
//		listaItens.add(it);
//	}

	public List<Supermercado> getListaTodoSupermercado() {
		listaTodoSupermercado = getFachada().listarTodosSupermercados();
		return listaTodoSupermercado;
	}

	public void listar() {
		todosProdutos = getFachada().buscarProdutoPorSupermercado(getProduto().getSupermercado());
	}

	public void adicionarProduto(Produto produto)
	{
		Item it = new Item();
		it.setProduto(produto);
		it.setQtdProduto(1);
		it.setPrecoTotal(produto.getValorUnitario() * it.getQtdProduto());
		System.out.println(it);
		listaItens.add(it);
	}
	
	public void adicionar(Produto produto)
	{
		int podutoPosicao = -1;
		for (int i = 0;i <listaItens.size() && podutoPosicao <0;i++)
		{
			Item itTemp = listaItens.get(i);
			if(itTemp.getProduto().equals(produto))
			{
				podutoPosicao = i;
			}
		}
		Item it = new Item();
		it.setProduto(produto);
		
		if(podutoPosicao < 0)
		{
			it.setQtdProduto(1);
			it.setPrecoTotal(it.getQtdProduto()*it.getProduto().getValorUnitario());
			listaItens.add(it);
		}else 
		{
			Item temp = listaItens.get(podutoPosicao);
			it.setQtdProduto(temp.getQtdProduto()+1);
			it.setPrecoTotal(produto.getValorUnitario() * it.getQtdProduto() );
			listaItens.set(podutoPosicao, it); // substitui o valor q ja esta na lista
		}
		
		System.out.println(listaItens.size());
		System.out.println(it);
		
	}
	
	public void remover(Item item)
	{
		int posicao = -1;
		for(int i=0;i<listaItens.size() && posicao <0 ;i++)
		{
			Item it = listaItens.get(i);
			if(item.getProduto().equals(it.getProduto()))
			{
				listaItens.remove(i);
				System.out.println(listaItens.size());
			}else
			{
				return;
			}
		}
	}
	
	public void criarLista(Item item)
	{
		LoginMB lg = new LoginMB();
		System.out.println(lg.getUsuarioLogado());
		ListaDeCompras lista = new ListaDeCompras();
		lista.setDataCriacao(new Date());
		lista.setNome(item.getLista().getNome());
		lista.setQtd(listaItens.size());
		lista.setTipo(item.getLista().getTipo());
		//lista.setUsuario(usuario);
		System.out.println(lista);
	}
	public void cadastrar(Item item) 
	{
		criarLista(item);
	}
}
