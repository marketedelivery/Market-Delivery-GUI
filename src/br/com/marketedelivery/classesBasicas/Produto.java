package br.com.marketedelivery.classesBasicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nome",length=12)
	private String nome;
	@Column(name = "marca",length=12)
	private String marca;
	@Column(name = "qtdEstoque",length=12)
	private int qtdEstoque;
	@Column(name = "valorUnitario",length=12)
	private Double valorUnitario;
	@OneToMany
	private List<Item> itens;
	
	public Produto(int codigo, String nome, String marca, int qtdEstoque,
			Double valorUnitario, List<Item> itens) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.qtdEstoque = qtdEstoque;
		this.valorUnitario = valorUnitario;
		this.itens = itens;
	}
	public Produto() {
		super();
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
		
}