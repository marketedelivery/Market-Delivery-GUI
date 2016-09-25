package br.com.marketedelivery.IDAO;

import br.com.marketedelivery.classesBasicas.Cliente;

public interface IClienteDAO extends IDAOGenerico<Cliente>
{
	public Cliente buscarClientePorCPF(String cpf);
	public Cliente buscarClientePorNome(String nome);
}
