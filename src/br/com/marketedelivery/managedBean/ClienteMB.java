package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.camada.classesBasicas.Cliente;

@ViewScoped
@ManagedBean(name="clienteBean")
public class ClienteMB extends AbstractMB implements Serializable{

	private static final long serialVersionUID = 1L;
	Cliente cliente;
	List<Cliente> listaCliente;
	ClienteMB clienteMB;
	private String confirmaSenha;
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setInserirCliente(Cliente c){
		
		try{
			if(cliente.getUsuario().getSenha().equals(getConfirmaSenha())){
				displayErrorMessageToUser("as senhas não são iguais");
			}
			// chama o servidor para inserir o cliente
			closeDialog();
			displayInfoMessageToUser("Cliente Cadastrado com Sucesso");
			listaDeCliente();

		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("Desculpa, não foi possivel cadastrar o cliente");

			e.printStackTrace();

		}
}

	public void setAlterarCliente(Cliente c){
		// chama o servidor para alterar o cliente

	}
	public List<Cliente> listaDeCliente(){
		
		return null;
	}
	public List<Cliente> pesquisarCliente(String nomeOuCpf){
		return null;
	}public List<Cliente> getListaDeCliente(){
		if (cliente  == null) {
			listaDeCliente();
		}
			return listaCliente;
	}

	public void getReiniciarCliente(){
		cliente = new Cliente();
	}
	
}
