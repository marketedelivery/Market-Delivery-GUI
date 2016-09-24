package br.com.marketedelivery.IDAO;

import br.com.marketedelivery.classesBasicas.Supermercado;

public interface ISupermercadoDao extends IDAOGenerico<Supermercado> 
{

	 public Supermercado buscarPorNome(String nome);
	 public Supermercado buscarPorCNPJ(String cnpj);
	 
}
