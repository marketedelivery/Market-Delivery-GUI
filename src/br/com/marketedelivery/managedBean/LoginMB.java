package br.com.marketedelivery.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.marketedelivery.classesbasicas.Usuario;



@RequestScoped
@ManagedBean(name="loginMB")
public class LoginMB extends AbstractMB{

	@ManagedProperty(value = UsuarioMB.ENVIAR_NOME)
	private UsuarioMB usuarioMB;
	
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
		 // FIM GET  E  SET
		public String login(){
			/*puxa do controlador para confimar o login
			  verificaLogin(email, senha);
			   */
			Usuario us = new Usuario();
			
			
			if(us != null){
				usuarioMB.setUsuario(us);
				displayInfoMessageToUser("Cliente logado no sistema de compras online");
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
				request.getSession().setAttribute("usuario", us);
				
				return "/pages/public/CadastroCliente.xhtml";
			}
			displayErrorMessageToUser("Digite seu Email ou Senha");
			return null;
		}
		
		
		public void setUsuarioMB(UsuarioMB usuarioMB) {
			this.usuarioMB = usuarioMB;
		}
}
