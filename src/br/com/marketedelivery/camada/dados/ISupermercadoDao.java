package br.com.marketedelivery.camada.dados;

import br.com.marketedelivery.classesbasicas.Supermercado;

public interface ISupermercadoDao extends IDAOGenerico<Supermercado> {

	 public Supermercado buscarPorNome(String nome);
	 public Supermercado buscarPorCNPJ(String cnpj);
	 
}
