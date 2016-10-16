package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		todosProdutos = getFachada().buscarProdutoPorSupermercado(getProduto().getSupermercado());
		// produtosFiltrados =
		// getFachada().buscarProdutoPorSupermercado(getProduto().getSupermercado());
		return todosProdutos;
	}

	public void listar()
	{
		getListarTodosProdutos();
	}
}
