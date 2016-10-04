package br.com.marketedelivery.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.ISupermercadoDAO;
import br.com.marketedelivery.classesBasicas.Produto;
import br.com.marketedelivery.classesBasicas.Supermercado;


public class SupermercadoDAO extends DAOGenerico<Supermercado> implements ISupermercadoDAO
{

	@SuppressWarnings("unused")
    private EntityManager manager;

    public SupermercadoDAO(EntityManager em) {
        super(em);
        this.manager = em;
    }

    public Supermercado buscarPorCNPJ(String cnpj) {
        String consulta = "SELECT c FROM Supermercado c WHERE c.cnpj = :N";
        TypedQuery<Supermercado> retorno = getEntityManager().createQuery(consulta, Supermercado.class);
        retorno.setParameter("N", cnpj);
        Supermercado resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;
        }
    }

    public Supermercado buscarPorNome(String nome) {
        String comandoSelect = "SELECT c FROM Supermercado c WHERE c.nome = :N ";
        TypedQuery<Supermercado> retorno = getEntityManager().createQuery(comandoSelect, Supermercado.class);
        retorno.setParameter("N", "%" + nome + "%");
        Supermercado resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

	
	public List<Produto> listaProtudoDoSupermercado(String nomeProduto, String supermercado) {
		String sql = "SELECT p.nome FROM Produto p JOIN Supermercado s";
		return null;
	}

	
}
