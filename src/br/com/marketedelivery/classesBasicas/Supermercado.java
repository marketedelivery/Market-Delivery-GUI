package br.com.marketedelivery.classesBasicas;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_supermercado")
public class Supermercado {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nome")
	private String nome;
	@OneToMany
	private List<Produto> produtos;
	
	
	public Supermercado(String nome, int codigo, List<Produto> produtos) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.produtos = produtos;
	}
	
	public Supermercado() {
		super();
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
