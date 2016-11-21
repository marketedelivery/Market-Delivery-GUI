package br.com.marketedelivery.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Item;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;
import br.com.marketedelivery.classesBasicas.Pedido;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

/**
 * @author Audry Martins
 *
 */
@ManagedBean
@ViewScoped
public class CompararPrecosMB
{
	// Atributos
	private Pedido pedidoSelecionado;

	private List<Pedido> pedidos;

	private List<Pedido> pedidosFiltrados;

	private Pedido pedidoExtra;

	private Pedido pedidoCarrefour;

	private Pedido pedidoBompreco;

	private IFachada fachada;

	private ListaDeCompras lista;

	private List<Item> itens;

	private List<Item> itensDisponiveisExtra;

	private String percentualItensDisponiveisExtra;

	private List<Item> itensIndisponiveisExtra;

	private String percentualItensIndisponiveisExtra;

	private double valorTotalListaExtra;

	private List<Item> itensDisponiveisCarrefour;

	private String percentualItensDisponiveisCarrefour;

	private List<Item> itensIndisponiveisCarrefour;

	private String percentualItensIndisponiveisCarrefour;

	private double valorTotalListaCarrefour;

	private List<Item> itensDisponiveisBompreco;

	private String percentualItensDisponiveisBompreco;

	private List<Item> itensIndisponiveisBompreco;

	private String percentualItensIndisponiveisBompreco;

	private double valorTotalListaBompreco;

	@PostConstruct
	public void init()
	{
		itens = new ArrayList<Item>();
		itensDisponiveisExtra = new ArrayList<Item>();
		itensIndisponiveisExtra = new ArrayList<Item>();
		itensDisponiveisCarrefour = new ArrayList<Item>();
		itensIndisponiveisCarrefour = new ArrayList<Item>();
		itensDisponiveisBompreco = new ArrayList<Item>();
		itensIndisponiveisBompreco = new ArrayList<Item>();
		pedidos = new ArrayList<Pedido>();
		pedidoExtra = new Pedido();
		pedidoCarrefour = new Pedido();
		pedidoBompreco = new Pedido();
	}

	// Métodos
	public Produto pesquisarProdutoComParametrosExtra(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Extra_WS/rest/produto/extra/pesquisarProdutoComParametros/" + nome
				+ ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public Produto pesquisarProdutoComParametrosCarrefour(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Carrefour_WS/rest/produto/carrefour/pesquisarProdutoComParametros/"
				+ nome + ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public Produto pesquisarProdutoComParametrosBompreco(String nome, String tipo, String marca)
	{
		Client c = Client.create();
		String resource = "http://localhost:8080/Bompreco_WS/rest/produto/bompreco/pesquisarProdutoComParametros/"
				+ nome + ", " + tipo + ", " + marca;
		resource = resource.replaceAll(" ", "%20");
		WebResource wr = c.resource(resource);
		String json = wr.get(String.class);
		Gson gson = new Gson();
		Produto p = gson.fromJson(json, new TypeToken<Produto>()
		{}.getType());
		return p;
	}

	public void compararPrecosProdutos()
	{
		if (itens.isEmpty()) itens.addAll(getItens());
		if (!itens.isEmpty())
		{
			List<Produto> produtosExtra = new ArrayList<Produto>();
			List<Produto> produtosCarrefour = new ArrayList<Produto>();
			List<Produto> produtosBompreco = new ArrayList<Produto>();
			for (int i = 0; i < itens.size(); i++)
			{
				Item it = itens.get(i);
				produtosExtra.add(pesquisarProdutoComParametrosExtra(it.getProduto().getNome(),
						it.getProduto().getTipo(), it.getProduto().getMarca()));
				if (produtosExtra.get(i) != null && !produtosExtra.get(i).getNome().equals(""))
				{
					valorTotalListaExtra += it.getPrecoTotal();
					itensDisponiveisExtra.add(it);
				} else
				{
					itensIndisponiveisExtra.add(it);
				}
				produtosCarrefour.add(pesquisarProdutoComParametrosCarrefour(it.getProduto().getNome(),
						it.getProduto().getTipo(), it.getProduto().getMarca()));
				if (produtosCarrefour.get(i) != null && !produtosCarrefour.get(i).getNome().equals(""))
				{
					valorTotalListaCarrefour += it.getPrecoTotal();
					itensDisponiveisCarrefour.add(it);
				} else
				{
					itensIndisponiveisCarrefour.add(it);
				}
				produtosBompreco.add(pesquisarProdutoComParametrosBompreco(it.getProduto().getNome(),
						it.getProduto().getTipo(), it.getProduto().getMarca()));
				if (produtosBompreco.get(i) != null && !produtosBompreco.get(i).getNome().equals(""))
				{
					valorTotalListaBompreco += it.getPrecoTotal();
					itensDisponiveisBompreco.add(it);
				} else
				{
					itensIndisponiveisBompreco.add(it);
				}
			}
		}
	}
	// Gets e Sets

	public List<Item> getItens()
	{
		if (lista != null)
		{
			itens = getFachada().consultarItensPorLista(lista);
		}
		return itens;
	}

	public void setItens(List<Item> itens)
	{
		this.itens = itens;
	}

	public List<Item> getItensDisponiveisExtra()
	{
		return itensDisponiveisExtra;
	}

	public void setItensDisponiveisExtra(List<Item> itensDisponiveisExtra)
	{
		this.itensDisponiveisExtra = itensDisponiveisExtra;
	}

	public List<Item> getItensIndisponiveisExtra()
	{
		return itensIndisponiveisExtra;
	}

	public void setItensIndisponiveisExtra(List<Item> itensIndisponiveisExtra)
	{
		this.itensIndisponiveisExtra = itensIndisponiveisExtra;
	}

	public double getValorTotalListaExtra()
	{
		return valorTotalListaExtra;
	}

	public void setValorTotalListaExtra(double valorTotalListaExtra)
	{
		this.valorTotalListaExtra = valorTotalListaExtra;
	}

	public List<Item> getItensDisponiveisCarrefour()
	{
		return itensDisponiveisCarrefour;
	}

	public void setItensDisponiveisCarrefour(List<Item> itensDisponiveisCarrefour)
	{
		this.itensDisponiveisCarrefour = itensDisponiveisCarrefour;
	}

	public List<Item> getItensIndisponiveisCarrefour()
	{
		return itensIndisponiveisCarrefour;
	}

	public void setItensIndisponiveisCarrefour(List<Item> itensIndisponiveisCarrefour)
	{
		this.itensIndisponiveisCarrefour = itensIndisponiveisCarrefour;
	}

	public double getValorTotalListaCarrefour()
	{
		return valorTotalListaCarrefour;
	}

	public void setValorTotalListaCarrefour(double valorTotalListaCarrefour)
	{
		this.valorTotalListaCarrefour = valorTotalListaCarrefour;
	}

	public List<Item> getItensDisponiveisBompreco()
	{
		return itensDisponiveisBompreco;
	}

	public void setItensDisponiveisBompreco(List<Item> itensDisponiveisBompreco)
	{
		this.itensDisponiveisBompreco = itensDisponiveisBompreco;
	}

	public List<Item> getItensIndisponiveisBompreco()
	{
		return itensIndisponiveisBompreco;
	}

	public void setItensIndisponiveisBompreco(List<Item> itensIndisponiveisBompreco)
	{
		this.itensIndisponiveisBompreco = itensIndisponiveisBompreco;
	}

	public double getValorTotalListaBompreco()
	{
		return valorTotalListaBompreco;
	}

	public void setValorTotalListaBompreco(double valorTotalListaBompreco)
	{
		this.valorTotalListaBompreco = valorTotalListaBompreco;
	}

	public ListaDeCompras getLista()
	{
		return lista;
	}

	public void setLista(ListaDeCompras lista)
	{
		this.lista = lista;
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

	public String getPercentualItensDisponiveisExtra()
	{
		double resultado = 0;
		if (!itensDisponiveisExtra.isEmpty())
		{
			double todo = itens.size();
			double parte = itensDisponiveisExtra.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensDisponiveisExtra = String.valueOf(resultado);
		return percentualItensDisponiveisExtra;
	}

	public void setPercentualItensDisponiveisExtra(String percentualItensDisponiveisExtra)
	{
		this.percentualItensDisponiveisExtra = percentualItensDisponiveisExtra;
	}

	public String getPercentualItensIndisponiveisExtra()
	{
		double resultado = 0;
		if (!itensIndisponiveisExtra.isEmpty())
		{
			double todo = itens.size();
			double parte = itensIndisponiveisExtra.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensIndisponiveisExtra = String.valueOf(resultado);
		return percentualItensIndisponiveisExtra;
	}

	public void setPercentualItensIndisponiveisExtra(String percentualItensIndisponiveisExtra)
	{
		this.percentualItensIndisponiveisExtra = percentualItensIndisponiveisExtra;
	}

	public String getPercentualItensDisponiveisCarrefour()
	{
		double resultado = 0;
		if (!itensDisponiveisCarrefour.isEmpty())
		{
			double todo = itens.size();
			double parte = itensDisponiveisCarrefour.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensDisponiveisCarrefour = String.valueOf(resultado);
		return percentualItensDisponiveisCarrefour;
	}

	public void setPercentualItensDisponiveisCarrefour(String percentualItensDisponiveisCarrefour)
	{
		this.percentualItensDisponiveisCarrefour = percentualItensDisponiveisCarrefour;
	}

	public String getPercentualItensIndisponiveisCarrefour()
	{
		double resultado = 0;
		if (!itensIndisponiveisCarrefour.isEmpty())
		{
			double todo = itens.size();
			double parte = itensIndisponiveisCarrefour.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensIndisponiveisCarrefour = String.valueOf(resultado);
		return percentualItensIndisponiveisCarrefour;
	}

	public void setPercentualItensIndisponiveisCarrefour(String percentualItensIndisponiveisCarrefour)
	{
		this.percentualItensIndisponiveisCarrefour = percentualItensIndisponiveisCarrefour;
	}

	public String getPercentualItensDisponiveisBompreco()
	{
		double resultado = 0;
		if (!itensDisponiveisBompreco.isEmpty())
		{
			double todo = itens.size();
			double parte = itensDisponiveisBompreco.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensDisponiveisBompreco = String.valueOf(resultado);
		return percentualItensDisponiveisBompreco;
	}

	public void setPercentualItensDisponiveisBompreco(String percentualItensDisponiveisBompreco)
	{
		this.percentualItensDisponiveisBompreco = percentualItensDisponiveisBompreco;
	}

	public String getPercentualItensIndisponiveisBompreco()
	{
		double resultado = 0;
		if (!itensIndisponiveisBompreco.isEmpty())
		{
			double todo = itens.size();
			double parte = itensIndisponiveisBompreco.size();
			if (todo != 0 && parte != 0)
			{
				resultado = (parte / todo) * 100;
			}
		}
		percentualItensIndisponiveisBompreco = String.valueOf(resultado);
		return percentualItensIndisponiveisBompreco;
	}

	/**
	 * @return the pedidoExtra
	 */
	public Pedido getPedidoExtra()
	{
		pedidoExtra.setItens(itens);
		pedidoExtra.setItensDisponiveis(itensDisponiveisExtra);
		pedidoExtra.setItensIndisponiveis(itensIndisponiveisExtra);
		pedidoExtra.setLista(lista);
		pedidoExtra.setValorTotalPedido(valorTotalListaExtra);
		pedidoExtra.setQtdDisponiveis(getPercentualItensDisponiveisExtra());
		pedidoExtra.setQtdIndisponiveis(getPercentualItensIndisponiveisExtra());
		return pedidoExtra;
	}

	public void setPedidoExtra(Pedido pedidoExtra)
	{
		this.pedidoExtra = pedidoExtra;
	}

	public Pedido getPedidoCarrefour()
	{
		pedidoCarrefour.setItens(itens);
		pedidoCarrefour.setItensDisponiveis(itensDisponiveisCarrefour);
		pedidoCarrefour.setItensIndisponiveis(itensIndisponiveisCarrefour);
		pedidoCarrefour.setLista(lista);
		pedidoCarrefour.setValorTotalPedido(valorTotalListaCarrefour);
		pedidoCarrefour.setQtdDisponiveis(getPercentualItensDisponiveisCarrefour());
		pedidoCarrefour.setQtdIndisponiveis(getPercentualItensIndisponiveisCarrefour());
		return pedidoCarrefour;
	}

	public void setPedidoCarrefour(Pedido pedidoCarrefour)
	{
		this.pedidoCarrefour = pedidoCarrefour;
	}

	public Pedido getPedidoBompreco()
	{
		pedidoBompreco.setItens(itens);
		pedidoBompreco.setItensDisponiveis(itensDisponiveisBompreco);
		pedidoBompreco.setItensIndisponiveis(itensIndisponiveisBompreco);
		pedidoBompreco.setLista(lista);
		pedidoBompreco.setValorTotalPedido(valorTotalListaBompreco);
		pedidoBompreco.setQtdDisponiveis(getPercentualItensDisponiveisBompreco());
		pedidoBompreco.setQtdIndisponiveis(getPercentualItensIndisponiveisBompreco());
		return pedidoBompreco;
	}

	public void setPedidoBompreco(Pedido pedidoBompreco)
	{
		this.pedidoBompreco = pedidoBompreco;
	}

	public void setPercentualItensIndisponiveisBompreco(String percentualItensIndisponiveisBompreco)
	{
		this.percentualItensIndisponiveisBompreco = percentualItensIndisponiveisBompreco;
	}

	public List<Pedido> getPedidos()
	{
		if (pedidos.isEmpty())
		{
			if (!itens.isEmpty())
			{
				compararPrecosProdutos();
				this.pedidos.add(getPedidoExtra());
				this.pedidos.add(getPedidoCarrefour());
				this.pedidos.add(getPedidoBompreco());
				List<Supermercado> supermercados = getFachada().listarTodosSupermercados();
				for (int i = 0; i < pedidos.size(); i++)
				{
					Pedido p = pedidos.get(i);
					Supermercado s = supermercados.get(i);
					p.setSupermercado(s);
				}
			}
		}
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos)
	{
		this.pedidos = pedidos;
	}

	public Pedido getPedidoSelecionado()
	{
		if (pedidoSelecionado == null)
		{
			pedidoSelecionado = new Pedido();
		}
		return pedidoSelecionado;
	}

	public List<Pedido> getPedidosFiltrados()
	{
		return pedidosFiltrados;
	}

	public void setPedidosFiltrados(List<Pedido> pedidosFiltrados)
	{
		this.pedidosFiltrados = pedidosFiltrados;
	}

	public void setPedidoSelecionado(Pedido pedidoSelecionado)
	{
		this.pedidoSelecionado = pedidoSelecionado;
	}
}