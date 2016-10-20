package br.com.marketedelivery.classesBasicas;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;
	@OneToOne
	private Produto produto;
	@Column(name = "precoTotal",length=12)
	private Double precoTotal;
	@Column(name = "qtdProduto",length=12)
	private int qtdProduto;
	
		
	public Item(int codigo, Double precoTotal, int qtdProduto,Produto produto) {
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.precoTotal = precoTotal;
		this.qtdProduto = qtdProduto;
	}
	
	public Item() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	} 
}
