package br.com.marketedelivery.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.Fachada.Fachada;
import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Usuario;

@SessionScoped
@ManagedBean(name = "loginMB")
public class Login extends AbstractMB implements Serializable
{
	Usuario usuarioMB;

	private static final long serialVersionUID = 1L;
	Usuario usuario;
	IFachada fachada;

	public Usuario getUsuario() 
	{
		if (usuario == null) {
			return usuario = new Usuario();
		} else {
			return usuario;
		}
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public IFachada getFachada() {
		if (fachada == null) {
			return fachada = new Fachada();
		} else {
			return fachada;
		}
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public void inserirUsuario(Usuario us) {

	}

	/**
	 * Efetua logout do usu�rio do sistema
	 */
	public String getLogOut() {
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml";
	}

	/**
	 * Efetua logout do usu�rio do sistema
	 */
	public String efetuarLogout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/pages/public/principal.xhtml";
	}

	public String efetuarLogin() {
		Usuario user = new Usuario();
		user = getFachada().pesquisarPorEmail(usuario);
		String email = user.getEmail();
		String senha = user.getSenha();
		if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
		{
			displayInfoMessageToUser("Cliente logado no sistema de compras online");
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			request.getSession().setAttribute("usuario", user);
			return "/pages/protected/produtoPesquisa.xhtml";
		} else 
		{
			// Cria uma mensagem.
			//FacesMessage msg = new FacesMessage("Usu�rio ou senha inv�lido!");
			//return "/pages/public/clientePesquisa.xhtml";
			// Obt�m a instancia atual do FacesContext e adiciona a mensagem de
			// erro nele.
			displayErrorMessageToUser("Digite seu Email ou Senha");
			return null;
		}
		
	}
	public String sairDoSistema(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/pages/public/login.xhtml";
	}
	public String getFilmesEmCartaz() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/WebServiceRest/rest/service/cadastrarUsuario");
		return wr.get(String.class);
	}

}
