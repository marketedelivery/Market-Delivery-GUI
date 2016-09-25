package br.com.marketedelivery.Fachada;

import java.util.List;

import br.com.marketedelivery.IFachada.IFachada;
import br.com.marketedelivery.classesBasicas.Cliente;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Supermercado;
import br.com.marketedelivery.controlador.ControladorCliente;
import br.com.marketedelivery.controlador.ControladorEndereco;
import br.com.marketedelivery.controlador.ControladorSupermercado;
import br.com.marketedelivery.controlador.ControladorUsuario;

public class Fachada implements IFachada
{
	private IFachada instancia;
	private ControladorCliente conCliente;
	private ControladorEndereco conEndereco;
	private ControladorSupermercado conSupermercado;
	private ControladorUsuario conUsuario;
	
	 public  IFachada getInstancia()
	    {
	        if (instancia == null)
	        {
	            instancia = new Fachada();
	        }
	        return instancia;
	    }
	 
	 public void cadastrarCliente(Cliente cliente)
	 {
		 conCliente.cadastrarCliente(cliente);
	 }
	 
	 public void atualizarCliente(Cliente cliente)
	 {
		 conCliente.atualizarCliente(cliente);
	 }
	 
	 public List<Cliente>listarTodosClientes()
	 {
		 return conCliente.listarCliente();
	 }
	 
	 public Cliente listarPorNome(Cliente cliente)
	 {
		 return conCliente.listarPorCPF(cliente);
	 }
	 
	 public Cliente listarPorCPF(Cliente cliente)
	 {
		 return conCliente.listarPorNome(cliente);
	 }
	 
	 public void cadastrarSupermercado(Supermercado supermercado)
	 {
		 conSupermercado.cadastrarSupermercado(supermercado);
	 }
	 
	 public void atualizarSupermercado(Supermercado supermercado)
	 {
		 conSupermercado.atualizarSupermercado(supermercado);
	 }
	 
	 public List<Supermercado>listarSupermercado()
	 {
		 return conSupermercado.listarTodosSupermercados();
	 }
	 
	 public Supermercado listarPorCNPJ(Supermercado supermercado)
	 {
		 return conSupermercado.pesquisarPorCNPJ(supermercado);
	 }
	 
	 public Supermercado listarPorNome(Supermercado supermercado)
	 {
		 return conSupermercado.pesquisarPorNome(supermercado);
	 }

	 public void cadastrarEndereco(Endereco endereco)
	 {
		 conEndereco.cadastrarEndereco(endereco);
	 }
	 
	 public void atualizarEndereco(Endereco endereco)
	 {
		 conEndereco.atualizarEndereco(endereco);
	 }
	 
	 public List<Endereco>listarEndereco()
	 {
		 return conEndereco.listarTodosEndereco();
	 }
	
	 public Endereco listarPorCep(Endereco endereco)
	 {
		 return conEndereco.pesquisarPorCep(endereco);
	 }
	 
	 public Endereco listarPorLogradouro(Endereco endereco)
	 {
		 return conEndereco.pesquisarPorLogradouro(endereco);
	 }
}
