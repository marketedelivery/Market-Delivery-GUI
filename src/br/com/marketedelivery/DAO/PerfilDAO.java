package br.com.marketedelivery.DAO;

/*import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.IPerfilDAO;
import br.com.marketedelivery.classesBasicas.Perfil;

public class PerfilDAO extends DAOGenerico<Perfil> implements IPerfilDAO
{
    @SuppressWarnings("unused")
	private EntityManager manager;
    
    public PerfilDAO(EntityManager em)
    {
        super(em);
        this.manager = em;
    }
    public Perfil BuscarPorNome(String nome)
    {
        String consulta = "SELECT p FROM PERFIL p WHERE p.nome = :N";
        TypedQuery<Perfil> retorno = getEntityManager().createQuery(consulta, Perfil.class);
        retorno.setParameter("N", nome);
        Perfil resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
}
*/