package br.com.marketedelivery.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.Produto;

@ManagedBean
@ViewScoped
public class ItemMB 
{
	private Produto produto;
	private Item item;
	private List<Produto> listaProduto;
    private IFachada fachada;
    
    public void setProduto(Produto produto)
    {
    	this.produto = produto;
    }
    
	public Produto getProduto() 
	{
		if(produto == null)
		{
			return produto;
		}else
		{
			return produto;
		}
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
	public IFachada getFachada() {
		return fachada;
	}
    
	public void produtoDrop(DragDropEvent ddEvent)
	{
		Produto pdt = ((Produto)ddEvent.getData());
		listaProduto.add(pdt);
	}
    
}
