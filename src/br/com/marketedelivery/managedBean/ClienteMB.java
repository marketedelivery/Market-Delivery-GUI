package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import br.com.marketedelivery.classesbasicas.Cliente;

@ViewScoped
@ManagedBean(name="clienteMB")
public class ClienteMB extends AbstractMB implements Serializable{

	/**
	 * estou no managed bean cliente ain em contrução
	 * 
	 */
	
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
		try{
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
	public void alterarCliente(){
		
		// chama o servidor para inserir o cliente
		
	}
	public List<Cliente> listaDeCliente(){
		return null;
	}
	
	public List<Cliente> pesquisarCliente(String nome){
		return null;
	}
	public List<Cliente> getListaDeCliente(){
		if (cliente  == null) {
			listaDeCliente();
		}
			return listaCliente;
	}
	public void reiniciarCliente(){
		cliente = new Cliente();
	}
}
