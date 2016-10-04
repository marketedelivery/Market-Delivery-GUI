package br.com.marketedelivery.classesBasicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;
	@OneToOne
	private ListaDeCompras lista;
	@OneToMany
	private List<Item> itens;
	
	
	public Pedido(int codigo, ListaDeCompras lista,List<Item> itens) {
		super();
		this.codigo = codigo;
		this.lista = lista;
		this.itens = itens;
	}
	public Pedido() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public ListaDeCompras getLista() {
		return lista;
	}
	public void setLista(ListaDeCompras lista) {
		this.lista = lista;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	

}
