package br.com.marketedelivery.classesbasicas;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario
{
	// Atributos
	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "email", length = 55, nullable = false)
	private String email;

	@Column(name = "senha", length = 55, nullable = false)
	private String senha;

	@Enumerated(EnumType.STRING)
	private Status status;

	// Construtores
	public Usuario()
	{
		this.email = "";
		this.senha = "";
		this.status = Status.ATIVO;
	}

	/**
	 * @param codigo
	 * @param email
	 * @param senha
	 */
	public Usuario(Integer codigo, String email, String senha, Status status)
	{
		super();
		this.codigo = codigo;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}

	// Métodos
	@Override
	public String toString()
	{
		return "Usuario [email=" + email + ", senha=" + senha + status + "]";
	}

	// Gets e Sets
	public Integer getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}
}