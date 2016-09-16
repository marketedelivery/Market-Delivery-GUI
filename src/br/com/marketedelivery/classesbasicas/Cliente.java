package br.com.marketedelivery.classesbasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;

	
	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "rg")
	private int rg;

	@Column(name = "cpf", length = 11)
	private String cpf;

	@Column(name = "telefone", length = 10)
	private String telefone;

	@Column(name = "celular", length = 11)
	private String celular;

	@Column(name = "email", length = 30)
	private String email;

	private Endereco endereco;
	private Usuario us;
	public Cliente() {
	}

	public Cliente(int codigo, String nome, int rg, String cpf, String telefone, String celular, String email,
			Endereco endereco, Usuario us) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
		this.us = us;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
