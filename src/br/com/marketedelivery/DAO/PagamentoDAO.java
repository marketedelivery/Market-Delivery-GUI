package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;

import br.com.marketedelivery.IDAO.IPagamentoDAO;
import br.com.marketedelivery.classesBasicas.Pagamento;




public class PagamentoDAO extends DAOGenerico<Pagamento> implements IPagamentoDAO {
	
	@SuppressWarnings("unused")
	private EntityManager manager;
    
    public PagamentoDAO(EntityManager em)
    {
        super(em);
        this.manager = em;
    }
    /*
    public Pagamento buscarPorStatus(Status status)
    {
        String consulta = "SELECT s FROM Supermercado s WHERE s.nome = :N";
        TypedQuery<Pagamento> retorno = getEntityManager().createQuery(consulta, Pagamento.class);
        retorno.setParameter("N", nome);
        Pagamento resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }*/


}
