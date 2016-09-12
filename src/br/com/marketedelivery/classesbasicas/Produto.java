package br.com.marketedelivery.classesbasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "descricao", length = 100)
	private String descrição;

	@Column(name = "marca", length = 100)
	private String marca;

	@Column(name = "embalagem", length = 100)
	private String embalagem;

	@Column(name = "gramatura", length = 100)
	private String gramatura;

	@Column(name = "quantidade", length = 100)
	private int quantidade;

	@Column(name = "preco", length = 100)
	private Double preco;

	@Column(name = "nome", length = 100)
	private String dataValidade;

	public Produto() {
		super();
	}

	public Produto(int codigo, String nome, String descrição, String marca, String embalagem, String gramatura,
			int quantidade, Double preco, String dataValidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descrição = descrição;
		this.marca = marca;
		this.embalagem = embalagem;
		this.gramatura = gramatura;
		this.quantidade = quantidade;
		this.preco = preco;
		this.dataValidade = dataValidade;
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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	public String getGramatura() {
		return gramatura;
	}

	public void setGramatura(String gramatura) {
		this.gramatura = gramatura;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
