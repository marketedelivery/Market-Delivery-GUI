package br.com.marketedelivery.IDAO;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public interface IProdutoDAO extends IDAOGenerico<Produto>
{
	public Produto buscarPorNome(String nome);
	 public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado);
}
