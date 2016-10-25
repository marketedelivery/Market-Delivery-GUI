package br.com.marketedelivery.managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Usuario;

@SessionScoped
@ManagedBean(name = "loginMB")
public class LoginMB extends AbstractMB implements Serializable
{
	Usuario usuarioMB;
	public static int codigoUsuario;
	private static final long serialVersionUID = 1L;

	Usuario usuario;

	private Usuario usuarioLogado;

	IFachada fachada;

	String menssagem;

	public Usuario getUsuario()
	{
		if (usuario == null)
		{
			return usuario = new Usuario();
		} else
		{
			usuarioLogado = usuario;
			return usuario;
		}
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public IFachada getFachada()
	{
		if (fachada == null)
		{
			return fachada = new Fachada();
		} else
		{
			return fachada;
		}
	}

	public String getMenssagem()
	{
		return menssagem;
	}

	public void setMenssagem(String menssagem)
	{
		this.menssagem = menssagem;
	}

	public void setFachada(IFachada fachada)
	{
		this.fachada = fachada;
	}

	private HttpServletRequest getRequest()
	{
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public void inserirUsuario(Usuario us)
	{}

	/**
	 * Efetua logout do usu�rio do sistema
	 */
	public String getLogOut()
	{
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml?faces-redirect=true";
	}

	/**
	 * Efetua logout do usu�rio do sistema
	 */
	public String efetuarLogout()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/pages/public/principal.xhtml?faces-redirect=true";
	}

	public String efetuarLogin()
	{
		Usuario user = new Usuario();
		user = getFachada().pesquisarPorEmail(usuario);
		try
		{
			
			String email = user.getEmail();
			String senha = user.getSenha();
			codigoUsuario = user.getCodigo();
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
			{
				this.usuarioLogado = user;
				displayInfoMessageToUser("Cliente logado no sistema de compras online");
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
				request.getSession().setAttribute("usuario", user);
				return "/pages/protected/minhasListas.xhtml?faces-redirect=true";
			
				
			} else if (usuario.getEmail().equals(email) && usuario.getSenha() != senha)
			{
				menssagem = "Email ou Senha incorretos, Por Favor verifique seus dados e tente navamente";
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						"Email ou Senha incorretos, Por Favor verifique seus dados e tente navamente"));
				return null;
			}
		}
		catch (Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email n�o cadastrado"));
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public String sairDoSistema()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/pages/public/login.xhtml?faces-redirect=true";
	}

//	public String getFilmesEmCartaz()
//	{
//		Client c = Client.create();
//		WebResource wr = c.resource("http://localhost:8080/WebServiceRest/rest/service/cadastrarUsuario");
//		return wr.get(String.class);
//	}

	/**
	 * @return the usuarioLogado
	 */
	public Usuario getUsuarioLogado()
	{
		return usuarioLogado;
	}
	

	/**
	 * @param usuarioLogado the usuarioLogado to set
	 */
	public void setUsuarioLogado(Usuario usuarioLogado)
	{
		this.usuarioLogado = usuarioLogado;
	}
}