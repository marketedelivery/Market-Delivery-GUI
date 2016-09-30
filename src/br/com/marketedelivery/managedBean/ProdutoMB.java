package br.com.marketedelivery.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Produto;
@SessionScoped
@ManagedBean(name="produtoMB")
public class ProdutoMB {

	private Produto produto;
	ProdutoMB produtoMB;
	IFachada fachada;
	public ProdutoMB() {
		produto = new Produto();
		
		
		// TODO Auto-generated constructor stub
	}
	public Produto getProduto(){
		if(produto == null){
			produto =  new Produto();
		}
		return produto;
	}
	public Produto getListaDeProduto(){
		fachada = new Fachada();
		fachada.ListarTodosUsuarios();
		getProduto().setNome("macarrao");
		//produtoMB =new ProdutoMB();
		return fachada.PesquisarProdutoPorNome(produto);
				//return produtoMB.getLista();
	}
	
	public List<Produto> getLista(){
		List<Produto> list = new ArrayList<Produto>();
		list.add(new Produto("nestler", "biscoito wafer", 2.50));
		list.add(new Produto("nestler", "biscoito recheado", 2.50));
		list.add(new Produto("nestler", "biscoito amanteigado", 2.50));
		list.add(new Produto("nestler", "biscoito doce", 2.50));
		list.add(new Produto("nestler", "biscoito feio", 2.50));
		list.add(new Produto("nestler", "biscoito bonito", 2.50));
		list.add(new Produto("nestler", "biscoito wafer", 2.50));
		
		return list;
	
}
}
