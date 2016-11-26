package br.com.marketedelivery.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.classesBasicas.Produto;

@ManagedBean
@ViewScoped
public class VisualizarPrecoMB {
	private List<Produto> listatemp;
	Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListatemp() {
		return listatemp;
	}

	public void visualizarPreco(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produto");
		pesquisarProdutoPorNome(produto);
	}

	public List<Produto> pesquisarProdutoPorNome(Produto produto) {
		listatemp = new ArrayList<Produto>();
		Produto temp1 = pesquisarProdutoComParametrosBompreco(produto.getNome(), produto.getTipo(), produto.getMarca());
		Produto temp2 = pesquisarProdutoComParametrosCarrefour(produto.getNome(), produto.getTipo(),produto.getMarca());
		Produto temp3 = pesquisarProdutoComParametrosExtra(produto.getNome(), produto.getTipo(), produto.getMarca());
		listatemp.clear();
		listatemp.add(temp1);
		listatemp.add(temp2);
		listatemp.add(temp3);
		return null;

	}

	public Produto pesquisarProdutoComParametrosExtra(String nome, String tipo, String marca) {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Extra_WS/rest/produto/extra/pesquisarProdutoComParametros/"
				+ nome + ", " + tipo + ", " + marca);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>() {
		}.getType());
		return p;
	}

	public Produto pesquisarProdutoComParametrosCarrefour(String nome, String tipo, String marca) {
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/pesquisarProdutoComParametros/"
						+ nome + ", " + tipo + ", " + marca);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>() {
		}.getType());
		return p;
	}

	public Produto pesquisarProdutoComParametrosBompreco(String nome, String tipo, String marca) {
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/pesquisarProdutoComParametros/"
						+ nome + ", " + tipo + ", " + marca);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>() {
		}.getType());
		return p;
	}
}