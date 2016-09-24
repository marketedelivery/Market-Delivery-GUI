package br.com.marketedelivery.camada.dados;

import br.com.marketedelivery.camada.classesBasicas.Cliente;

public interface IClienteDao extends IDAOGenerico<Cliente>
{
	public Cliente buscarClientePorCPF(String cpf_cnpj);
}
