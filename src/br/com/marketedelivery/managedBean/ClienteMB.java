package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.camada.classesBasicas.Cliente;

@ViewScoped
@ManagedBean(name="clienteMB")
public class ClienteMB extends AbstractMB implements Serializable{

	public ClienteMB() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	Cliente cliente;

	List<Cliente> listaCliente;

	public Cliente getCliente() {

		return cliente;

	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;

	}
	
	public void inserirCliente(){
		// chama o servidor para inserir o cliente
		try{
			closeDialog();
			displayInfoMessageToUser("Cliente Cadastrado com Sucesso");
			listaDeCliente();

		}catch(Exception e){
			keepDialogOpen();
			displayErrorMessageToUser("Desculpa, não foi possivel cadastrar o cliente");

			e.printStackTrace();

		}
}

	public void alterarCliente(){
	// chama o servidor para inserir o cliente

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

	public void reiniciarCliente(){

		cliente = new Cliente();

	}
	
}
