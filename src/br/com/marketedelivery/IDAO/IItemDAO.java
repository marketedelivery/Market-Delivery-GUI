package br.com.marketedelivery.IDAO;


import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.Produto;

public interface IItemDAO extends IDAOGenerico<Item> 
{
	public Item buscarItemProduto(Produto produto);
}
