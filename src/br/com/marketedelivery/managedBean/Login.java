package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.marketedelivery.classesBasicas.Usuario;


@SessionScoped
@ManagedBean(name="loginMB")
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	Login usuarioMB;
	private String email;
	private String senha;
	
	// GET  E SET
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
	
	// FIM GET E SET
	
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	public void inserirUsuario(Usuario us){
		
	}
	/**
	  * Efetua logout do usuário do sistema */
		public String getLogOut() {
			getRequest().getSession().invalidate();
			return "/pages/public/login.xhtml";
   }
	    /**
		  * Efetua logout do usuário do sistema */
		public String getEfetuarLogout(){
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
