package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO  {
	
	@SuppressWarnings("unused")
	private EntityManager manager;
    
    public ProdutoDAO(EntityManager em)
    {
        super(em);
        this.manager = em;
    }
    public Produto buscarPorNome(String nome)
    {
        String consulta = "SELECT p FROM Produto p WHERE p.nome = :N";
        TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
        retorno.setParameter("N", nome);
        Produto resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }


}
