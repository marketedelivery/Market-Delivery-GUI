package br.com.marketedelivery.controlador;

import java.util.List;

import br.com.marketedelivery.IDAO.IClienteDAO;
import br.com.marketedelivery.classesBasicas.Cliente;

public class ControladorCliente 
{
	private IClienteDAO clienteDAO;
	
	public void cadastrarCliente(Cliente cliente)
	{
		clienteDAO.inserir(cliente);
	}
	
	public void atualizarCliente(Cliente cliente)
	{
		clienteDAO.alterar(cliente);
	}
	
	public List<Cliente>listarCliente()
	{
		return clienteDAO.consultarTodos();
	}
	
	public Cliente listarPorCPF(Cliente cliente)
	{
		String cpf = cliente.getCpf();
		Cliente retorno = clienteDAO.buscarClientePorCPF(cpf); 
		return retorno;
	}
	
	public Cliente listarPorNome(Cliente cliente)
	{
		String nome = cliente.getNome();
		Cliente retorno = clienteDAO.buscarClientePorNome(nome);
		return retorno;
	}
}
