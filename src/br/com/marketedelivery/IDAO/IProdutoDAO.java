package br.com.marketedelivery.IDAO;

import br.com.marketedelivery.classesBasicas.Produto;

public interface IProdutoDAO extends IDAOGenerico<Produto>
{
	public Produto buscarPorNome(String nome);
}
