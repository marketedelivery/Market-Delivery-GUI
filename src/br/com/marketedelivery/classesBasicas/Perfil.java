package br.com.marketedelivery.classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="codigo_perfil")
	private int codigo;
	@Column(name="nome",length=20)
	private String nome;
	
		
	public Perfil(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public Perfil() {
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
	

}
