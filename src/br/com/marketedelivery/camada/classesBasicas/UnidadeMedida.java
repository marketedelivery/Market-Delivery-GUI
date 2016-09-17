package br.com.marketedelivery.camada.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="unidadeMedida")
public class UnidadeMedida
{
	// Atributos
	@Id
	@GeneratedValue
	private Integer codigo;

	@Column(name = "nome_medida", length = 55, nullable = false)
	private String nome;
	
	// Construtores

	public UnidadeMedida()
	{
		this.nome = "";
	}

	/**
	 * @param codigo
	 * @param nome
	 */
	public UnidadeMedida(int codigo, String nome)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
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
}