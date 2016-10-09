package br.com.marketedelivery.IDAO;

import java.util.List;

import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public interface ISupermercadoDAO extends IDAOGenerico<Supermercado> 
{

	 public Supermercado buscarPorNome(String nome);
	 public Supermercado buscarPorCNPJ(String cnpj);
	 public Supermercado pesquisarPorCodigo(int codigo);
	 public List<Produto> listaProtudoDoSupermercado(String nomeProduto, String supermercado);
	 public List<Supermercado> listarProdutoPorSupermercado(Supermercado supermercado);
			
}
