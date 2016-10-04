package br.com.marketedelivery.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;
	@OneToOne
	private Usuario usuario;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne
	private Pedido pedido;
		
	
	public Pagamento(int codigo, Usuario usuario, Status status, Pedido pedido) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.status = status;
		this.pedido = pedido;
	}
	public Pagamento() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

}
