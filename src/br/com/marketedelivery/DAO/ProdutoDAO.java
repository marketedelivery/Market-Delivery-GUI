package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.inject.Inject;

import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO  {
	
	@Inject 
	private EntityManager bd01Manager;
	@Inject @bd02
	private EntityManager bd02Manager;
    
	
    public ProdutoDAO( EntityManager em)
    {
        super(em);
        this.bd01Manager = em;
        this.bd02Manager = em;
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
    
    public Produto buscarPorMarca(String marca)
    {
        String consulta = "SELECT p FROM Produto p WHERE p.nome = :N";
        TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
        retorno.setParameter("N", marca);
        Produto resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
}
