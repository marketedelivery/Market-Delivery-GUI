package br.com.marketedelivery.classesbasicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.marketedelivery.camada.classesBasicas.UnidadeMedida;


@Entity
@Table(name="produto")
public class Produto
{
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_produto", length = 50, nullable = false)
	private String nome;

	@Column(name = "descricao_produto", length = 150, nullable = false)
	private String descricao;

	@ManyToOne
	private Marca marca;

	@ManyToOne
	private UnidadeMedida UnidadeMedida;

	@Column(name = "peso_produto", length = 50, nullable = false)
	private int peso;

	@Column(name = "quantidade_produto", length = 50, nullable = false)
	private int quantidade;

	@Column(name = "inf_Nutri_produto", length = 50, nullable = false)
	private String informacaoNutricional;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_validade_produto", length = 50, nullable = false)
	private Calendar dataValidade;
	
	@Column(name="preco")
	private double preco;

	@Enumerated
	private Status status;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Supermercado supermercado;

	// Construtores
	public Produto()
	{
		this.nome = "";
		this.descricao = "";
		this.descricao = "";
		this.marca = new Marca();
		this.UnidadeMedida = new UnidadeMedida();
		this.informacaoNutricional = "";
		this.dataValidade = Calendar.getInstance();
		this.status = Status.ATIVO;
		this.categoria = new Categoria();
		this.supermercado = new Supermercado();
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param marca
	 * @param unidadeMedida
	 * @param peso
	 * @param quantidade
	 * @param informaçãoNutricional
	 * @param dataValidade
	 * @param status
	 * @param categoria
	 * @param supermercado
	 */
	public Produto(Integer codigo, String nome, String descricao, Marca marca, UnidadeMedida unidadeMedida, int peso,
			int quantidade, String informacaoNutricional, Calendar dataValidade, Status status, Categoria categoria,
			Supermercado supermercado)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		UnidadeMedida = unidadeMedida;
		this.peso = peso;
		this.quantidade = quantidade;
		this.informacaoNutricional = informacaoNutricional;
		this.dataValidade = dataValidade;
		this.status = status;
		this.categoria = categoria;
		this.supermercado = supermercado;
	}

	// Gets e Sets
	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Marca getMarca()
	{
		return marca;
	}

	public void setMarca(Marca marca)
	{
		this.marca = marca;
	}

	public UnidadeMedida getUnidadeMedida()
	{
		return UnidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida)
	{
		this.UnidadeMedida = unidadeMedida;
	}

	public int getPeso()
	{
		return peso;
	}

	public void setPeso(int peso)
	{
		this.peso = peso;
	}

	public int getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}

	public String getInformacaoNutricional()
	{
		return informacaoNutricional;
	}

	public void setInformacaoNutricional(String informacaoNutricional)
	{
		this.informacaoNutricional = informacaoNutricional;
	}

	public Calendar getDataValidade()
	{
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade)
	{
		this.dataValidade = dataValidade;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria()
	{
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	/**
	 * @return the supermercado
	 */
	public Supermercado getSupermercado()
	{
		return supermercado;
	}

	/**
	 * @param supermercado the supermercado to set
	 */
	public void setSupermercado(Supermercado supermercado)
	{
		this.supermercado = supermercado;
	}
}