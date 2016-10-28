package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.marketedelivery.DAO.FacesUtil;
import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Estado;
import br.com.marketedelivery.classesBasicas.Usuario;
import br.com.marketedelivery.util.ValidarCpf;
import br.com.marketedelivery.util.ValidarEmail;

@RequestScoped
@ViewScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioMB implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private Endereco endereco;

	private IFachada fachada;

	private List<Usuario> listar;

	private List<Usuario> listaUsuarios;

	private List<Usuario> listaUsuariosFiltrados;

	ValidarCpf validarCPF = new ValidarCpf();

	public Endereco getEndereco()
	{
		if (endereco == null)
		{
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Usuario getUsuario()
	{
		if (usuario == null)
		{
			usuario = new Usuario();
		}
		return usuario;
	}

	public IFachada getFachada()
	{
		if (fachada == null)
		{
			fachada = new Fachada();
		}
		return fachada;
	}

	public void setFachada(IFachada fachada)
	{
		this.fachada = fachada;
	}

	public List<Usuario> getListar()
	{
		return listar;
	}

	public void setListar(List<Usuario> listar)
	{
		this.listar = listar;
	}

	public List<Usuario> getListaUsuarios()
	{
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios)
	{
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuariosFiltrados()
	{
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados)
	{
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}

	public Estado[] getUFs()
	{
		return Estado.values();
	}

	public void salvar()
	{
		usuario.setEndereco(endereco);
		fachada = getFachada();
		Usuario user = fachada.listarPorCPF(usuario);
		try
		{
			if (validarCPF.validarCpf(usuario.getCpf()) != true && ValidarEmail.emailValido(usuario.getEmail()) != true
					&& user == null)
			{
				fachada.cadastrarUsuario(usuario);
				// FacesContext.getCurrentInstance().getExternalContext().redirect(/*
				// url que vc quer*/);
				FacesContext fc = FacesContext.getCurrentInstance();
				ExternalContext ec = fc.getExternalContext();
				/* Manter a mensagem após o redirect */
				ec.getFlash().setKeepMessages(true);
				NavigationHandler nh = fc.getApplication().getNavigationHandler();
				nh.handleNavigation(fc, null, "/pages/public/login.xhtml?faces-redirect=true");
				/* Manter a mensagem após o ec.redirect */
				// ec.getFlash().setKeepMessages(true);
				//
				// ec.redirect(ec.getRequestContextPath()+"/pages/protected/minhasListas.xhtml?faces-redirect=true");
				// FacesContext.getCurrentInstance().getExternalContext()
				// .redirect("/pages/public/login.xhtml?faces-redirect=true");
			} else if (user != null)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esse cpf já possui cadastro!"));
				return;
			} else if (validarCPF.validarCpf(usuario.getCpf()) == false)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esse cpf Invalido!"));
				return;
			} else if (ValidarEmail.emailValido(usuario.getEmail()) == false)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Esse e-mail Invalido!"));
				return;
			}
			usuario = new Usuario();
			endereco = new Endereco();
		}
		catch (Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Erro ao cadastrar, tente novamente mais tarde"));
			System.out.println(e.getMessage());
		}
	}

	public void carregarPesquisa()
	{
		try
		{
			// fachada.ListarTodosUsuarios();
			// listaUsuarios = fachada.ListarTodosUsuarios();
			IFachada fachada = getFachada();
			listaUsuarios = fachada.listarTodosUsuarios();
		}
		catch (Exception ex)
		{
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os usuarios" + ex.getMessage());
		}
	}

	@PostConstruct
	public void carregarCadastro()
	{
		try
		{
			String valor = FacesUtil.getParam("clicod");
			// int codigo_pessoa = 0;
			if (valor != null)
			{
				// int codigo = Integer.parseInt(valor);
				usuario = fachada.pesquisarPorCodigo(usuario);
			}
		}
		catch (Exception ex)
		{
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os usuarios" + ex.getMessage());
		}
	}

	public void alterar(Usuario usuario)
	{
		{
			fachada = getFachada();
			Usuario u = fachada.listarPorCPF(usuario);
			try
			{
				if (u != null)
				{
					u = usuario;
					fachada.atualizarUsuario(u);
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("Cadastro Alterado com Sucesso"));
				}
			}
			catch (Exception e)
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao Atualizar"));
				System.out.println(e.getMessage());
			}
		}
	}
}