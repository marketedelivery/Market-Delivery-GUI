package br.com.marketedelivery.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.marketedelivery.IDAO.IClienteDAO;
import br.com.marketedelivery.classesBasicas.Cliente;



public class ClienteDAO extends DAOGenerico<Cliente> implements IClienteDAO
{
	private EntityManager manager;
	
	public ClienteDAO(EntityManager em) 
	{
		super(em);
		this.manager = em;
		// TODO Auto-generated constructor stub
	}
	
	public Cliente buscarClientePorCPF(String cpf)
    {
        String consulta = "SELECT c FROM Cliente c WHERE c.cpf = :N";
        TypedQuery<Cliente> retorno = getEntityManager().createQuery(consulta, Cliente.class);
        retorno.setParameter("N", cpf);
        Cliente resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
	
	public Cliente buscarClientePorNome(String nome)
    {
        String consulta = "SELECT c FROM Cliente c WHERE c.nome = :N";
        TypedQuery<Cliente> retorno = getEntityManager().createQuery(consulta, Cliente.class);
        retorno.setParameter("N", nome);
        Cliente resultado;
        try {
            resultado = retorno.getSingleResult();
            return resultado;

        } catch (Exception e) {
            return null;

        }
    }
}
