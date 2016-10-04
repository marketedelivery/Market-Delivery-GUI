package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.marketedelivery.DAO.FacesUtil;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Usuario;

@RequestScoped
@ViewScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Endereco endereco;
	private IFachada fachada;
	private List<Usuario> listar;
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrados;

	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public IFachada getFachada() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public List<Usuario> getListar() {
		return listar;
	}

	public void setListar(List<Usuario> listar) {
		this.listar = listar;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}

	public void salvar() 
	{
		try 
		{
			usuario.setEndereco(endereco);
			fachada = getFachada();
			fachada.CadastrarUsuario(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado com Sucesso"));
		} catch (Exception e) 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao cadastrar, tente novamente mais tarde"));
			System.out.println(e.getMessage());
		}
		
	}

	// public void listarUsuario()
	// {
	// IFachada fachada = getFachada();
	// listar = fachada.ListarTodosUsuarios();
	// }

	// Responsável em carregar uma lista de dados na tela do cadastro de
	// usuarios
	public void carregarPesquisa() {
		try {
			//fachada.ListarTodosUsuarios();
			//listaUsuarios = fachada.ListarTodosUsuarios();
			 IFachada fachada = getFachada();
			 listaUsuarios = fachada.ListarTodosUsuarios();
		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os usuarios" + ex.getMessage());
		}
	}

	@PostConstruct
	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("clicod");
			// int codigo_pessoa = 0;
			if (valor != null) {
				//int codigo = Integer.parseInt(valor);
				usuario = fachada.pesquisarPorCodigo(usuario);
			}

		} catch (Exception ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os usuarios" + ex.getMessage());
		}
	}
}