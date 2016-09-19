package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.marketedelivery.camada.classesBasicas.Usuario;


@SessionScoped
@ManagedBean(name="usuarioMB")
public class UsuarioMB implements Serializable{

	public static final String ENVIAR_NOME = "#{usuarioMB}";
	private static final long serialVersionUID = 1L;
	Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	UsuarioMB usuarioMB;
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
	
	/**
	  * Efetua logout do usu�rio do sistema */
	public String getLogOut() {
       getRequest().getSession().invalidate();
       return "/pages/public/login.xhtml";
   }
	    /**
		  * Efetua logout do usu�rio do sistema */
		public String getEfetuarLogout(){
		    FacesContext fc = FacesContext.getCurrentInstance();
		    HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		    session.invalidate();
		    return "/pages/public/login.xhtml";
		}
	
}
