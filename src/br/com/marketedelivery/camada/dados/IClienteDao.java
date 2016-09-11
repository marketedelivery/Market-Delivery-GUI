package br.com.marketedelivery.camada.dados;

import br.com.marketedelivery.classesbasicas.Cliente;

public interface IClienteDao extends IDAOGenerico<Cliente>
{
	public Cliente buscarClientePorCPF(String cpf_cnpj);
}
