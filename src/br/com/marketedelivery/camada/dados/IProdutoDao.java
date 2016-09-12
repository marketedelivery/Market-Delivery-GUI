package br.com.marketedelivery.camada.dados;

import br.com.marketedelivery.classesbasicas.Produto;

public interface IProdutoDao extends IDAOGenerico<Produto>
{
	public Produto buscarProdutoPorCodigo(String codigo);
}
