package br.com.marketedelivery.classesbasicas;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Marca
{
	// Atributos
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_marca")
	private String nome;

	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;

	// Construtores
	public Marca()
	{
		super();
		this.nome = "";
		this.dataCriacao = Calendar.getInstance();
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param dataCriacao
	 */
	public Marca(Integer codigo, String nome, Calendar dataCriacao)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
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

	public Calendar getDataCriacao()
	{
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}
}