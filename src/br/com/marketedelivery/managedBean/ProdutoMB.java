package br.com.marketedelivery.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

@ViewScoped
@ManagedBean(name = "produtoMB")
public class ProdutoMB implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Produto produto;

	private IFachada fachada;

	private List<Supermercado> todosSupermercados;

	private List<Produto> todosProdutos;

	private List<Produto> produtosFiltrados;

	private final int EXTRA_ID = 1;

	private final int CARREFOUR_ID = 2;

	private final int BOMPRECO_ID = 3;

	public Produto getProduto()
	{
		if (produto == null)
		{
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}

	public IFachada getFachada()
	{
		if (fachada == null)
		{
			return fachada = new Fachada();
		} else
		{
			return fachada;
		}
	}

	public List<Supermercado> getTodosSupermercados()
	{
		return todosSupermercados;
	}

	public void setTodosSupermercados(List<Supermercado> todosSupermercados)
	{
		this.todosSupermercados = todosSupermercados;
	}

	public List<Produto> getTodosProdutos()
	{
		return todosProdutos;
	}

	public void setTodosProdutos(List<Produto> todosProdutos)
	{
		this.todosProdutos = todosProdutos;
	}

	public List<Supermercado> getListarTodosSupermercado()
	{
		todosSupermercados = getFachada().listarTodosSupermercados();
		return todosSupermercados;
	}

	public List<Produto> getProdutosFiltrados()
	{
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados)
	{
		this.produtosFiltrados = produtosFiltrados;
	}

	public List<Produto> getListarTodosProdutos()
	{
		// Para consulta atrav�s do Web Service
		if (getProduto().getSupermercado().getCodigo() == EXTRA_ID)
		{
			todosProdutos = consultarTodosProdutosExtra();
		} else
		{
			if (getProduto().getSupermercado().getCodigo() == CARREFOUR_ID)
			{
				todosProdutos = consultarTodosProdutosCarrefour();
			} else
			{
				if (getProduto().getSupermercado().getCodigo() == BOMPRECO_ID)
				{
					todosProdutos = consultarTodosProdutosBompreco();
				}
			}
		}
		return todosProdutos;
		// Para consulta atrav�s da fachada
		/*
		 * todosProdutos =
		 * getFachada().buscarProdutoPorSupermercado(getProduto().
		 * getSupermercado()); return todosProdutos;
		 */
	}

	public void listar()
	{
		// Atrav�s do Web Service
		getListarTodosProdutos();
		// Atrav�s da Fachada
		// getCarregarProduto();
	}

	public List<Produto> getCarregarProduto()
	{
		List<Produto> listaProdutos = getFachada().listarTodosProdutos();
		return listaProdutos;
	}

	public void cadastrarProduto() throws IOException
	{
		try
		{
			Produto temp = new Produto();
			temp.setMarca(produto.getMarca());
			temp.setNome(produto.getNome());
			temp.setQtdEstoque(produto.getQtdEstoque());
			temp.setTipo(produto.getTipo());
			temp.setValorUnitario(produto.getValorUnitario());
			temp.setSupermercado(produto.getSupermercado());
			if (produto.getCaminhoImagem() != null)
			{
				Path origem = Paths.get(produto.getCaminhoImagem());
				Path destino = Paths.get("C:/ImagemMarketeDelivery/" + temp.getNome() + "-" + temp.getMarca() + "-"
						+ temp.getTipo() + ".png");
				Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
				temp.setImagem(destino.toString());
				getFachada().cadastrarProduto(temp);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto cadastrado com Sucesso"));
			} else
			{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("O campo da imgem n�o pode ser invalido"));
				return;
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao cadastrar");
			e.printStackTrace();
		}
	}

	public void uploadFoto(FileUploadEvent eventoCarregar)
	{
		try
		{
			UploadedFile arquivoCarregado = eventoCarregar.getFile();
			Path arquivoTemporario = Files.createTempFile(null, null);
			Files.copy(arquivoCarregado.getInputstream(), arquivoTemporario, StandardCopyOption.REPLACE_EXISTING);
			produto.setCaminhoImagem(arquivoTemporario.toString());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Imagem carregada com sucesso"));
		}
		catch (IOException e)
		{
			System.out.println("Erro ao carregar a foto");
			e.printStackTrace();
		}
	}

	public void remover(Produto produto)
	{
		try
		{
			getFachada().removerProduto(produto);
			Path origem = Paths.get("C:/ImagemMarketeDelivery/" + produto.getNome() + "-" + produto.getMarca() + "-"
					+ produto.getTipo() + ".png");
			Files.deleteIfExists(origem);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto removido com sucesso"));
			System.out.println(produto.getImagem());
		}
		catch (IOException e)
		{
			System.out.println("N�o foi possivel remover");
			e.printStackTrace();
		}
	}

	public void atualizarProduto(ActionEvent evento)
	{
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		System.out.println(produto);
	}
	// ----Web Service----

	// M�todos do Supermercado Extra
	public void cadastrarProdutoExtra(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Extra_WS/rest/produto/extra/cadastrarProduto");
		String json = wr.post(String.class);
		System.out.println(json);
	}

	public void atualizarProdutoExtra(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Extra_WS/rest/produto/extra/alterarProduto");
		String json = wr.put(String.class);
		System.out.println(json);
	}

	public List<Produto> consultarTodosProdutosExtra()
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Extra_WS/rest/produto/extra/consultarTodosProdutos");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}

	public Produto pesquisarProdutoPorNomeExtra(String nome)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Extra_WS/rest/produto/extra/pesquisarProdutoPorNome/" + nome);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public List<Produto> consultarProdutosPorTipoExtra(String tipo)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Extra_WS/rest/produto/extra/consultarProdutosPorTipo/" + tipo);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}

	// M�todos do Supermercado Carrefour
	public void cadastrarProdutoCarrefour(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/cadastrarProduto");
		String json = wr.post(String.class);
		System.out.println(json);
	}

	public void atualizarProdutoCarrefour(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/alterarProduto");
		String json = wr.put(String.class);
		System.out.println(json);
	}

	public List<Produto> consultarTodosProdutosCarrefour()
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/consultarTodosProdutos");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}

	public Produto pesquisarProdutoPorNomeCarrefour(String nome)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/pesquisarProdutoPorNome/" + nome);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public List<Produto> consultarProdutosPorTipoCarrefour(String tipo)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Carrefour_WS/rest/produto/carrefour/consultarProdutosPorTipo/" + tipo);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}

	// M�todos do Supermercado Bompre�o
	public void cadastrarProdutoBompreco(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/cadastrarProduto");
		String json = wr.post(String.class);
		System.out.println(json);
	}

	public void atualizarProdutoBompreco(Produto produto)
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/alterarProduto");
		String json = wr.put(String.class);
		System.out.println(json);
	}

	public List<Produto> consultarTodosProdutosBompreco()
	{
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/consultarTodosProdutos");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}

	public Produto pesquisarProdutoPorNomeBompreco(String nome)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/pesquisarProdutoPorNome/" + nome);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public List<Produto> consultarProdutosPorTipoBompreco(String tipo)
	{
		Client c = Client.create();
		WebResource wr = c
				.resource("http://localhost:8080/Bompreco_WS/rest/produto/bompreco/consultarProdutosPorTipo/" + tipo);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		List<Produto> lista = new ArrayList<Produto>();
		lista = gson.fromJson(json, new TypeToken<List<Produto>>()
		{}.getType());
		return lista;
	}
}