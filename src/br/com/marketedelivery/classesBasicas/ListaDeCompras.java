package br.com.marketedelivery.classesBasicas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_lista")
public class ListaDeCompras implements Serializable
{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private int codigo;
	@Column(name ="nome")
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Column(name = "qtd_itens",length=12)
	private int qtd;
	@ManyToOne
	private Usuario usuario;
	
	
	public ListaDeCompras() {
		super();
	}


	public ListaDeCompras(int codigo, String nome, Date dataCriacao, Tipo tipo, int qtd, Usuario usuario) 
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.tipo = tipo;
		this.qtd = qtd;
		this.usuario = usuario;
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


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
