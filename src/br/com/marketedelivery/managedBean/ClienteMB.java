package br.com.marketedelivery.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Cliente;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Usuario;

@ViewScoped
@ManagedBean
public class ClienteMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private IFachada fachada;
	private Endereco endereco;
	private Usuario usuario;
	List<Cliente> listaCliente;
	private String confirmaSenha;
	
	
	public Cliente getCliente() 
	{
		if(cliente==null)
		{
			cliente = new Cliente();
		}
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Endereco getEndereco() 
	{
		if(endereco==null)
		{
			endereco = new Endereco();
		}
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Usuario getUsuario() 
	{
		if(usuario==null)
		{
			usuario = new Usuario();
		}
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}

	public void setCadastrarCliente(Cliente c)
	{
		cliente.getEndereco().add(endereco);
		c = cliente;
		fachada.cadastrarCliente(c);

	}

	public void setAlterarCliente(Cliente c)
	{
	
	}
	public List<Cliente> listaDeCliente(){
		
		return null;
	}
	
	public List<Cliente> pesquisarCliente(String nomeOuCpf)
	{
		return null;
	}
	public List<Cliente> getListaDeCliente()
	{
		if (cliente  == null) {
			listaDeCliente();
		}
			return listaCliente;
	}
}
