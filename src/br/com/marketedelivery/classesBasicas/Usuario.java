package br.com.marketedelivery.classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Integer codigo;
	@Column(name = "nome",length=30)
	private String nome;
	@Column(name = "CPF",length=14)
	private String cpf;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
	@Column(name = "telefone_whatsapp",length=14)
	private String telefonewhatsapp;
    @OneToOne
    private Perfil perfil;
	@Column(name = "Telefone",length=14)
	private String telefone;
	@Column(name = "Email",length=30)
	private String email;
	@Column(name = "Senha",length=10)
	private String senha;
	
	
	public Usuario(Integer codigo, String nome, String cpf, Endereco endereco, String telefonewhatsapp, String telefone, Perfil perfil, String email, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefonewhatsapp = telefonewhatsapp;
		this.telefone = telefone;
		this.perfil = perfil;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {
		super();
		endereco = new Endereco();
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneWhatsapp() {
		return telefonewhatsapp;
	}
	public void setTelefoneWhatsapp(String telefonewhatsapp) {
		this.telefonewhatsapp = telefonewhatsapp;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}