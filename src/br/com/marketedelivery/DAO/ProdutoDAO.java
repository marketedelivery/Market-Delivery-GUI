package br.com.marketedelivery.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.IProdutoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;

public class ProdutoDAO extends DAOGenerico<Produto> implements IProdutoDAO  {
	
	private EntityManager manager;
	
    public ProdutoDAO( EntityManager em)
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
        finally 
        {
        	manager.close();
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
        finally 
        {
        	manager.close();
		}
    }
    
    public List<Produto> buscarProdutoPorSupermercado(Supermercado supermercado)
    {
    	int codigo = supermercado.getCodigo();
    	String consulta = "SELECT p FROM Produto p WHERE p.supermercado.codigo = :N";
        TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
        retorno.setParameter("N",codigo);
       
        try 
        {
        	List<Produto> resultado = retorno.getResultList();
            return resultado;

        } catch (Exception e) 
        {
            return null;

        }
        finally 
        {
        	manager.close();
		}
    }
    
    public Produto buscarPorTipo(String tipo)
    {
        String consulta = "SELECT p FROM Produto p WHERE p.tipo = :N";
        TypedQuery<Produto> retorno = getEntityManager().createQuery(consulta, Produto.class);
        retorno.setParameter("N", tipo);
        Produto resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
        finally 
        {
        	manager.close();
		}
    }
}
