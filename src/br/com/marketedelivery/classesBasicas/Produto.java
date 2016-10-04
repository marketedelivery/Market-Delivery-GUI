package br.com.marketedelivery.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", marca=" + marca + ", qtdEstoque=" + qtdEstoque + ", valorUnitario="
				+ valorUnitario + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	
	public Produto(String nome, String marca, Double valorUnitario) {
		super();
		
		this.nome = nome;
		this.marca = marca;
		
		this.valorUnitario = valorUnitario;
	}
	public Produto(String nome, String marca, Double valorUnitario,int qtdEstoque) {
		super();
		
		this.nome = nome;
		this.marca = marca;
		this.qtdEstoque = qtdEstoque;
		this.valorUnitario = valorUnitario;
	}
	public Produto(int codigo, String nome, String marca, Double valorUnitario,
			int qtdEstoque) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.qtdEstoque = qtdEstoque;
		this.valorUnitario = valorUnitario;
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
			
}
