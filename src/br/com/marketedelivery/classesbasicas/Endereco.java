package br.com.marketedelivery.classesbasicas;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco 
{
	@Column(name = "cep")
	private int cep;
	
	@Column(name = "logradouro",length = 30)
	private String logradouro;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "complemento",length = 30)
	private String complemento;
	
	@Column(name = "bairro",length = 30)
	private String bairro;
	
	@Column(name = "cidade",length = 30)
	private String cidade;
	
	@Column(name = "estado",length = 30)
	private String estado;
	
	public Endereco(){}

	public Endereco(int cep, String logradouro, int numero, String complemento, String bairro, String cidade,
			String estado) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
