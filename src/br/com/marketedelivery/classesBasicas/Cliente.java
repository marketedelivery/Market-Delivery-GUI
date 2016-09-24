package br.com.marketedelivery.classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.marketedelivery.classesBasicas.Endereco;

@Entity
@Table(name = "cliente")
public class Cliente
{
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@Column(name = "telefone", length = 10, nullable = true)
	private String telefone;

	@Column(name = "celular", length = 11, nullable = false)
	private String celular;

	@OneToOne
	private Usuario usuario;

	@OneToMany(mappedBy= "cliente",cascade = CascadeType.ALL)
	private List<Endereco> endereco;

	public Cliente()
	{
		this.nome = "";
		this.cpf = "";
		this.telefone = "";
		this.celular = "";
		this.usuario = new Usuario();
		this.endereco = new ArrayList<Endereco>();
	}

	public Cliente(int codigo, String nome, String cpf, String telefone, String celular, Usuario usuario,
			List<Endereco> endereco)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.usuario = usuario;
		this.endereco = endereco;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
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

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getCelular()
	{
		return celular;
	}

	public void setCelular(String celular)
	{
		this.celular = celular;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public List<Endereco> getEndereco()
	{
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco)
	{
		this.endereco = endereco;
	}
}