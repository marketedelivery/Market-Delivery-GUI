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
public class ItemMB 
{
	private Produto produto;
	private Item item;
	private List<Produto> listaProduto;
	private List<Produto> todosProdutos;
	private List<Produto> produtosFiltrados;
    private IFachada fachada;
    private List<Supermercado>listaTodoSupermercado;
    private double valorTotal;
    private int qtd;

    
    @PostConstruct
    public void init()
    {
    	listaProduto = new ArrayList<Produto>();
    }
    
    public void setProduto(Produto produto)
    {
    	this.produto = produto;
    }
    
	public Produto getProduto() 
	{
		if(produto == null)
		{
			return produto = new Produto();
		}else
		{
			return produto;
		}
	}
	
	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) 
	{
		this.qtd = qtd;
	}
	
	public Item getItem() 
	{
		if(item == null)
		{
			item = new Item();
		}
		else
		{
			return item;
		}
		return item;
	}
	
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	
	public IFachada getFachada() 
	{
		if(fachada == null)
		{
			return fachada = new Fachada();
		}else
		{
			return fachada;
		}
	}

	public List<Produto> getTodosProdutos() {
		return todosProdutos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void produtoOnDrop(DragDropEvent ddEvent)
	{
		Produto pdt = ((Produto)ddEvent.getData());
		listaProduto.add(pdt);
	}

	public List<Supermercado> getListaTodoSupermercado() 
	{
		listaTodoSupermercado = getFachada().listarTodosSupermercados();
		return listaTodoSupermercado;
	}
	public void listar()
	{
		todosProdutos = getFachada().buscarProdutoPorSupermercado(getProduto().getSupermercado());
	}
	
	public void casdastrarLista()
	{
		List<Produto>listaCadastrar = new ArrayList<Produto>();
		Produto pdt = new Produto();
		Item it = getItem();
		double qtd = getItem().getQtdProduto();
		double valor =  getItem().getPrecoTotal();
		
		System.out.println(qtd);
		System.out.println(valor);
		for(int i = -1;i > listaProduto.size();i++)
		{
			pdt = listaCadastrar.get(i);
			
			
		}
	}
}
