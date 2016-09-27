package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.IListaDeComprasDAO;
import br.com.marketedelivery.classesBasicas.ListaDeCompras;



public class ListaDeComprasDAO extends DAOGenerico<ListaDeCompras> implements IListaDeComprasDAO
{
	private EntityManager manager;
    
    public ListaDeComprasDAO(EntityManager em)
    {
        super(em);
        this.manager = em;
    }
    public ListaDeCompras buscarPorCodigo(int codigo)
    {
        String consulta = "SELECT l FROM ListaDeCompras l WHERE l.codigo = :N";
        TypedQuery<ListaDeCompras> retorno = getEntityManager().createQuery(consulta, ListaDeCompras.class);
        retorno.setParameter("N", codigo);
        ListaDeCompras resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
}
