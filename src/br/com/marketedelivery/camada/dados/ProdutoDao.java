package br.com.marketedelivery.camada.dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.camada.classesBasicas.Produto;


public class ProdutoDao extends DAOGenerico<Produto> implements IProdutoDao {
	private EntityManager manager;

	public ProdutoDao(EntityManager em) {
		super(em);
		this.manager = em;
		// TODO Auto-generated constructor stub
	}

	public Produto buscarProdutoPorCodigo(String codigo) {
		String consulta = "SELECT p FROM Produto c WHERE c.codigo = :N";
		TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
		retorno.setParameter("N", codigo);
		Produto resultado;
		try {
			resultado = retorno.getSingleResult();
			return resultado;

		} catch (Exception e) {
			return null;

		}
	}
}
