package br.com.marketedelivery.IFachada;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Cliente;
import br.com.marketedelivery.classesBasicas.Endereco;
import br.com.marketedelivery.classesBasicas.Supermercado;

public interface IFachada
{
	public void cadastrarCliente(Cliente cliente);
	public void atualizarCliente(Cliente cliente);
	public List<Cliente>listarTodosClientes();
	public Cliente listarPorNome(Cliente cliente);
	public Cliente listarPorCPF(Cliente cliente);
	
	public void cadastrarSupermercado(Supermercado supermercado);
	public void atualizarSupermercado(Supermercado supermercado);
	public List<Supermercado>listarSupermercado();
	public Supermercado listarPorCNPJ(Supermercado supermercado);
	public Supermercado listarPorNome(Supermercado supermercado);
	
	public void cadastrarEndereco(Endereco endereco);
	public void atualizarEndereco(Endereco endereco);
	public List<Endereco>listarEndereco();
	public Endereco listarPorCep(Endereco endereco);
	public Endereco listarPorLogradouro(Endereco endereco);
}
