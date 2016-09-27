package br.com.marketedelivery.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;
	@OneToOne
	private ListaDeCompras lista;
	
	public Pedido(int codigo, ListaDeCompras lista) {
		super();
		this.codigo = codigo;
		this.lista = lista;
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

}
